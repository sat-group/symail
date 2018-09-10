/**
 * BSD 3-Clause License
 *	
 *	
 *	Copyright (c) 2018, SyMail - SyPet 2.0, Ruben Martins
 *	All rights reserved.
 *	
 *	Redistribution and use in source and binary forms, with or without
 *	modification, are permitted provided that the following conditions are met:
 *	
 *	* Redistributions of source code must retain the above copyright notice, this
 *	  list of conditions and the following disclaimer.
 *	
 *	* Redistributions in binary form must reproduce the above copyright notice,
 *	  this list of conditions and the following disclaimer in the documentation
 *	  and/or other materials provided with the distribution.
 *	
 *	* Neither the name of the copyright holder nor the names of its
 *	  contributors may be used to endorse or promote products derived from
 *	  this software without specific prior written permission.
 *	
 *	THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 *	AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 *	IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 *	DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 *	FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 *	DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 *	SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 *	CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 *	OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 *	OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package cmu.edu.inbox;

import cmu.edu.client.GmailStore;
import cmu.edu.compose.SyComposeWindow;
import cmu.edu.composition.SyWindowComposition;
import cmu.edu.date.SyDate;
import cmu.edu.mail.Mail;
import cmu.edu.mail.MailList;
import cmu.edu.mail.SyMail;
import cmu.edu.open.SyOpenWindow;
import cmu.edu.string.SyAddress;
import cmu.edu.util.SyCryptoUtils;
import cmu.edu.util.SyFileUtils;
import cmu.edu.warning.SyWarningWindow;
import cmu.edu.mail.Address;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Store;
import javax.mail.internet.MimeMultipart;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import cmu.edu.window.SyWindow;

public class SyInboxWindow {

	private List<Mail> mails = new ArrayList<>();;
	private List<Mail> current = new ArrayList<>();;
	private GmailStore store;
	private String username;
	private String password;
	private String[] columns = new String[] { "Date", "From", "Title" };
	private String[][] data;

	// email list to be displayed
	private DefaultListModel<String> emailList = new DefaultListModel<>();
	private JTable emailTable;

	public SyInboxWindow(List<Mail> mails, GmailStore store, String username, String password) throws Throwable {
		this.username = username;
		this.password = password;
		this.mails = mails;
		current.addAll(mails);
		this.store = store;

		// read mails from disk
		loadEmails();

		// read mails from gmail
		readGmail();
	}

	
	/*** Json functionalities
	 */
	
	JsonSerializer<Address> serializer = new JsonSerializer<Address>() {
		@Override
		public JsonElement serialize(Address src, Type typeOfSrc, JsonSerializationContext context) {
			JsonObject jsonAddress = new JsonObject();
			jsonAddress.addProperty("Address", src.getAddress());

			return jsonAddress;
		}
	};
	
	/*** File functionalities
	 */
	public File saveEmailToDisk(String path, Mail mail) throws IOException {
		GsonBuilder gsonBuilder = new GsonBuilder().setPrettyPrinting();
		Gson customGson = gsonBuilder.create();
		gsonBuilder.registerTypeAdapter(Address.class, serializer);
		File file = SyFileUtils.classToJson(path, mail, customGson);
		return file;
	}

	public void loadEmails() throws Throwable {
		decryptEmails();

		File[] files = SyFileUtils.listFiles("tmp/");
		for (File file : files) {
			// from json to class
			GsonBuilder gsonBuilder = new GsonBuilder().setPrettyPrinting();
			Gson customGson = gsonBuilder.create();
			gsonBuilder.registerTypeAdapter(Address.class, serializer);
			BufferedReader bufferedReader = new BufferedReader(new FileReader(file.getAbsolutePath()));
			Mail mail = customGson.fromJson(bufferedReader, Mail.class);
			mails.add(mail);
		}
	}

	public void saveEmails() throws IOException {
		int id = 1;
		for (Mail mail : mails) {
			String path = "tmp/email" + id + ".mail";
			saveEmailToDisk(path, mail);
			id++;
		}
	}

	public void decryptEmails() throws Throwable {
		String path = "db/" + username + "/mails/";
		if (!SyFileUtils.existDirectory(path))
			SyFileUtils.createDirectory(path);

		File[] files = SyFileUtils.listFiles(path);
		for (File file : files) {
			String filepath = "tmp/" + file.getName();
			SyCryptoUtils.decryptFile(file.getAbsolutePath(), filepath, password);
		}
	}

	public void encryptEmails(String path) throws Throwable {
		File[] files = SyFileUtils.listFiles("tmp/");
		for (File file : files) {
			String filepath = path + file.getName();
			SyCryptoUtils.encryptFile(file.getAbsolutePath(), filepath, password);
		}
	}
	
	public void saveAndExit() throws Throwable {
		String mailDir = "db/" + username + "/mails/";
		if (!SyFileUtils.existDirectory(mailDir))
			SyFileUtils.createDirectory(mailDir);

		if (!SyFileUtils.existDirectory("tmp/"))
			SyFileUtils.createDirectory("tmp/");
		
		SyFileUtils.cleanDirectory("tmp/");
		SyFileUtils.cleanDirectory(mailDir);

		// save emails to tmp directory
		saveEmails();

		// encrypt emails
		encryptEmails(mailDir);

		SyFileUtils.cleanDirectory("tmp/");
		System.exit(0);
	}
	
	/*** Email client functionalities
	 */

	// FIXME: simplify this code ; try other libraries
	private String getTextFromMessage(Message message) throws MessagingException, IOException {
		String result = "";
		if (message.isMimeType("text/plain")) {
			result = message.getContent().toString();
		} else if (message.isMimeType("text/html")) {
			String html = message.getContent().toString();
			result = org.jsoup.Jsoup.parse(html).text();
		} else if (message.isMimeType("multipart/*")) {
			System.out.println("text is multipart!");
			MimeMultipart mimeMultipart = (MimeMultipart) message.getContent();
			result = getTextFromMimeMultipart(mimeMultipart);
		}
		return result;
	}

	// FIXME: simplify this code ; try other libraries
	private String getTextFromMimeMultipart(MimeMultipart mimeMultipart) throws MessagingException, IOException {
		String result = "";
		int count = mimeMultipart.getCount();
		for (int i = 0; i < count; i++) {
			BodyPart bodyPart = mimeMultipart.getBodyPart(i);
			if (bodyPart.isMimeType("text/plain")) {
				result = result + bodyPart.getContent();
				break; // without break same text appears twice in my tests
			} else if (bodyPart.isMimeType("text/html")) {
				String html = (String) bodyPart.getContent();
				result = result + org.jsoup.Jsoup.parse(html).text();
			} else if (bodyPart.getContent() instanceof MimeMultipart) {
				result = result + getTextFromMimeMultipart((MimeMultipart) bodyPart.getContent());
			}
		}
		return result;
	}

	public void readGmail() throws MessagingException, IOException {
		Store gmail = store.getStore();
		if (!gmail.isConnected())
			gmail.connect();

		if (!gmail.isConnected()) {
			SyWarningWindow.GmailCheck();
			return;
		}

		try {
			Folder folderMessages = SyMail.getEmailFolder(gmail, "INBOX", Folder.READ_ONLY);
			Message[] messages = folderMessages.getMessages();
			for (int i = 0, n = messages.length; i < n; i++) {
				Message message = messages[i];
				String body = getTextFromMessage(message);
				LocalDateTime local = SyDate.convertDate(message);
				Mail mail = new Mail(message.getSubject(), message.getFrom()[0].toString(), body, local);
				mails.add(mail);
			}
			folderMessages.close();
			gmail.close();
		} catch (Exception e1) {
			SyWarningWindow.EmailReadFailure();
		}
	}

	/*** load information into UI
	 */
	
	public String[][] loadData(ArrayList<MailList> ml) {
		data = new String[ml.size()][3];
		for (int r = 0; r < ml.size(); r++) {
			data[r][0] = ml.get(r).getDate();
			data[r][1] = ml.get(r).getFrom();
			data[r][2] = ml.get(r).getTitle();
		}
		return data;
	}

	public String[][] loadInboxMails(DefaultListModel<String> list) {
		list.clear();
		current.clear();
		ArrayList<MailList> maillist = new ArrayList<>();
		for (Mail mail : mails) {
			list.addElement(mail.getTitle());
			current.add(mail);
			MailList ml = SyDate.convertMail(mail, "MM/dd/yyyy");
			maillist.add(ml);
		}
		data = loadData(maillist);
		return data;
	}

	public String[][] loadFavoriteMails(DefaultListModel<String> list) {
		list.clear();
		current.clear();
		ArrayList<MailList> maillist = new ArrayList<>();
		for (Mail mail : mails) {
			if (mail.getFavorite()) {
				list.addElement(mail.getTitle());
				current.add(mail);
				MailList ml = SyDate.convertMail(mail, "MM/dd/yyyy");
				maillist.add(ml);
			}
		}
		data = loadData(maillist);
		return data;
	}

	public String[][] loadUnreadMails(DefaultListModel<String> list) {
		list.clear();
		current.clear();
		ArrayList<MailList> maillist = new ArrayList<>();
		for (Mail mail : mails) {
			if (!mail.getRead()) {
				list.addElement(mail.getTitle());
				current.add(mail);
				MailList ml = SyDate.convertMail(mail, "MM/dd/yyyy");
				maillist.add(ml);
			}
		}
		data = loadData(maillist);
		return data;
	}

	public String[][] loadReminderEmails(DefaultListModel<String> list) {
		list.clear();
		current.clear();
		ArrayList<MailList> maillist = new ArrayList<>();
		for (Mail mail : mails) {
			long days = SyDate.getDays(mail);
			if (days > 1 && !mail.getReplied() && SyAddress.containsQuestion(mail, "?")) {
				list.addElement(mail.getTitle());
				current.add(mail);
				MailList ml = SyDate.convertMail(mail, "MM/dd/yyyy");
				maillist.add(ml);
			}
		}
		data = loadData(maillist);
		return data;
	}
	
	/*** Main functionalities
	 */

	@SuppressWarnings("unused")
	public JFrame buildInbox() throws IOException {
		JFrame inboxFrame = SyWindow.buildFrame(400, 480, "SyMail - Synthesized Mail Client");
		inboxFrame.setLocationRelativeTo(null);
		SyWindow.setFrameAttributes(inboxFrame, JFrame.EXIT_ON_CLOSE, false);

		// panel for the inbox window
		JPanel panel = SyWindow.buildBorder(5, 5, 5, 5);
		JPanel top = SyWindow.buildBorder(0, 0, 0, 0);
		SyWindow.buildGrid(top, 1, 2);

		// top of the inbox
		JPanel topButtons = SyWindow.buildBorder(0, 0, 0, 0);
		topButtons = SyWindow.buildGrid(topButtons, 3, 1);

		// image for the icon
		JPanel iconPanel = SyWindow.buildBorder(0, 0, 0, 0);
		JLabel icon = SyWindow.buildImage("./img/logo.png");
		top.add(icon);

		Font font = SyWindow.createFont("serif", Font.PLAIN, 18);
		JButton compose = SyWindow.createButtonFontT("Compose", font);
		JButton sync = SyWindow.createButtonFontT("Sync Gmail", font);

		JComboBox<String> inbox = new JComboBox<String>();
		inbox.addItem("Inbox");
		inbox.addItem("Favorite");
		inbox.addItem("Unread");
		inbox.addItem("Reminders");
		SyWindow.setJComboProperties(inbox, font);

		top.add(inbox);

		topButtons.add(compose);
		topButtons.add(sync);

		// middle of the inbox
		JPanel midPanel = new JPanel();
		Font fontsmall = SyWindow.createFont("serif", Font.PLAIN, 14);

		// create email table with data
		data = loadInboxMails(emailList);
		emailTable = SyWindow.createTable(data, columns, fontsmall, ListSelectionModel.SINGLE_SELECTION);
		midPanel.add(emailTable);

		Dimension scrollDimension = SyWindow.createDimension(360, 200);
		JScrollPane scroll = SyWindow.createScrollPane(emailTable, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS, scrollDimension, true);
		midPanel.add(scroll);

		JPanel bottomButtons = SyWindow.buildBorder(0, 0, 0, 0);
		SyWindow.buildGrid(bottomButtons, 3, 1);
		JButton open = SyWindow.createButtonFontT("Open", font);
		JButton delete = SyWindow.createButtonFontT("Delete", font);
		bottomButtons.add(open);
		bottomButtons.add(delete);

		JPanel closeButton = SyWindow.buildBorder(0, 0, 0, 0);
		SyWindow.buildGrid(closeButton, 1, 1);
		JButton close = SyWindow.createButtonFontDimension("Encrypt & Close", font, 280, 30);
		closeButton.add(close);

		panel.add(top);
		panel.add(topButtons);
		panel.add(midPanel);
		panel.add(bottomButtons);
		panel.add(closeButton);
		inboxFrame.add(panel);

		// listeners
		close.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					saveAndExit();
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}
		});

		open.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (emailTable.getSelectedRow() > -1) {
					Mail selected = current.get(emailTable.getSelectedRow());
					selected.setRead(true);
					SyOpenWindow openWindow = new SyOpenWindow(store, selected);
					try {
						JFrame openFrame = openWindow.buildOpen();
						SyWindow.setFrameVisible(openFrame, true);
						inbox.setSelectedItem("Inbox");
						loadInboxMails(emailList);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});

		compose.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SyComposeWindow compose = new SyComposeWindow(store, "", "");
				try {
					JFrame composeFrame = compose.buildCompose();
					SyWindow.setFrameVisible(composeFrame, true);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});

		inboxFrame.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(WindowEvent winEvt) {
				try {
					saveAndExit();
				} catch (Throwable e) {
					e.printStackTrace();
				}
			}
		});

		sync.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					readGmail();
					inbox.setSelectedItem("Inbox");
					loadInboxMails(emailList);
				} catch (MessagingException | IOException e1) {
					e1.printStackTrace();
				}
			}
		});

		delete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (emailTable.getSelectedRow() > -1) {
					Mail selected = current.get(emailTable.getSelectedRow());
					mails.remove(selected);
					current.remove(selected);
					loadInboxMails(emailList);
					inbox.setSelectedItem("Inbox");
				}
			}
		});

		inbox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (inbox.getSelectedItem().toString().equals("Unread")) {
					data = loadUnreadMails(emailList);
					emailTable = SyWindow.createTableModel(emailTable, data, columns);
				}

				if (inbox.getSelectedItem().toString().equals("Favorite")) {
					data = loadFavoriteMails(emailList);
					emailTable = SyWindow.createTableModel(emailTable, data, columns);
				}

				if (inbox.getSelectedItem().toString().equals("Reminders")) {
					data = loadReminderEmails(emailList);
					emailTable = SyWindow.createTableModel(emailTable, data, columns);
				}

				if (inbox.getSelectedItem().toString().equals("Inbox")) {
					data = loadInboxMails(emailList);
					emailTable = SyWindow.createTableModel(emailTable, data, columns);
				}
			}
		});

		return inboxFrame;
	}
}
