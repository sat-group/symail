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
import cmu.edu.composition.SyWindowComposition;
import cmu.edu.mail.Mail;
import cmu.edu.util.SyCryptoUtils;
import cmu.edu.util.SyFileUtils;
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
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
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

import org.apache.commons.io.FileUtils;

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

	// email list to be displayed
	private DefaultListModel<String> emailList = new DefaultListModel<>();
	private JList<String> emailsGUI = new JList<>();

	public SyInboxWindow(List<Mail> mails, GmailStore store, String username, String password) throws Exception {
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

	public void GmailCheck() {
		Font font = SyWindow.createFont("serif", Font.PLAIN, 18);
		JPanel panel = null;
		try {
			panel = SyWindowComposition.buildWarningWindow("./img/warning.png", "Cannot connect to Gmail.", font);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		Object[] options = { "OK" };
		JOptionPane.showOptionDialog(null, panel, "SyMail - ERROR", JOptionPane.OK_OPTION, JOptionPane.PLAIN_MESSAGE,
				null, options, null);
	}

	JsonSerializer<Address> serializer = new JsonSerializer<Address>() {
		@Override
		public JsonElement serialize(Address src, Type typeOfSrc, JsonSerializationContext context) {
			JsonObject jsonAddress = new JsonObject();
			jsonAddress.addProperty("Address", src.getAddress());

			return jsonAddress;
		}
	};

	public File saveEmailToDisk(String path, Mail mail) throws IOException {
		GsonBuilder gsonBuilder = new GsonBuilder().setPrettyPrinting();
		Gson customGson = gsonBuilder.create();
		gsonBuilder.registerTypeAdapter(Address.class, serializer);
		String result = customGson.toJson(mail);
		System.out.println("result = " + result);
		File file = SyFileUtils.writeToFile(path, result);
		return file;
	}

	public File[] getEmailFiles(String path) {
		File dir = new File(path);
		File[] files = dir.listFiles();
		return files;
	}

	public void loadEmails() throws Exception {
		decryptEmails();

		File[] files = getEmailFiles("tmp/");
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

	public void decryptEmails() throws Exception {
		String path = "db/" + username + "/mails/";
		File[] files = getEmailFiles(path);
		for (File file : files) {
			String filepath = "tmp/" + file.getName();
			SyCryptoUtils.decryptFile(file.getAbsolutePath(), filepath, password);
		}
	}

	public void cleanDirectory(File directory) throws IOException {
		FileUtils.cleanDirectory(directory);
	}

	public void encryptEmails(String path) throws Exception {
		File[] files = getEmailFiles("tmp/");
		for (File file : files) {
			String filepath = path + file.getName();
			SyCryptoUtils.encryptFile(file.getAbsolutePath(), filepath, password);
		}
	}

	private String getTextFromMessage(Message message) throws MessagingException, IOException {
		String result = "";
		if (message.isMimeType("text/plain")) {
			result = message.getContent().toString();
		} else if (message.isMimeType("multipart/*")) {
			MimeMultipart mimeMultipart = (MimeMultipart) message.getContent();
			result = getTextFromMimeMultipart(mimeMultipart);
		}
		return result;
	}

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
			store.connect();

		if (!gmail.isConnected()) {
			GmailCheck();
			return;
		}

		Folder emailFolder = gmail.getFolder("INBOX");
		emailFolder.open(Folder.READ_ONLY);
		Message[] messages = emailFolder.getMessages();
		for (int i = 0, n = messages.length; i < n; i++) {
			Message message = messages[i];
			String body = getTextFromMessage(message);
			Date date = message.getSentDate();
			LocalDateTime local = LocalDateTime.of(date.getYear() + 1900, date.getMonth() + 1, date.getDate(),
					date.getHours(), date.getMinutes());
			Mail mail = new Mail(message.getSubject(), message.getFrom()[0].toString(), body, local);
			mails.add(mail);
		}
		emailFolder.close();
	}

	public void saveAndExit() throws Exception {
		String mailDir = "db/" + username + "/mails/";
		if (!SyFileUtils.existDirectory(mailDir))
			SyFileUtils.createDirectory(mailDir);

		cleanDirectory(new File("tmp/"));
		cleanDirectory(new File(mailDir));

		// save emails to tmp directory
		saveEmails();

		// encrypt emails
		encryptEmails(mailDir);

		cleanDirectory(new File("tmp/"));

		System.exit(0);
	}

	public DefaultListModel<String> loadInboxMails(DefaultListModel<String> list) {
		list.clear();
		current.clear();
		for (Mail mail : mails) {
			list.addElement(mail.getTitle());
			current.add(mail);
		}
		return list;
	}

	public DefaultListModel<String> loadFavoriteMails(DefaultListModel<String> list) {
		list.clear();
		current.clear();
		for (Mail mail : mails) {
			if (mail.getFavorite()) {
				list.addElement(mail.getTitle());
				current.add(mail);
			}
		}
		return list;
	}

	public DefaultListModel<String> loadUnreadMails(DefaultListModel<String> list) {
		list.clear();
		current.clear();
		for (Mail mail : mails) {
			if (!mail.getRead()) {
				list.addElement(mail.getTitle());
				current.add(mail);
			}
		}
		return list;
	}

	public DefaultListModel<String> loadReminderEmails(DefaultListModel<String> list) {
		list.clear();
		current.clear();
		LocalDateTime now = LocalDateTime.now();

		for (Mail mail : mails) {
			LocalDateTime emailDate = mail.getSentDate();
			long days = Duration.between(now, emailDate).toDays();
			if (days > 1 && !mail.getReplied() && mail.getBody().contains("?")) {
				list.addElement(mail.getTitle());
				current.add(mail);
			}
		}
		return list;
	}

	@SuppressWarnings("unused")
	public JFrame buildInbox() throws IOException {
		JFrame inboxFrame = SyWindow.buildFrame(400, 480, "SyMail - Synthesized Mail Client");
		inboxFrame.setLocationRelativeTo(null);
		SyWindow.setFrameAttributes(inboxFrame, JFrame.EXIT_ON_CLOSE, false);

		// panel for the inbox window
		JPanel panel = SyWindow.buildBorder(5, 5, 5, 5);

		JPanel top = SyWindow.buildBorder(0, 0, 0, 0);
		SyWindow.buildGrid(top, 1, 2);

		// panel.add(iconPanel);

		// top of the inbox
		JPanel topButtons = SyWindow.buildBorder(0, 0, 0, 0);
		topButtons = SyWindow.buildGrid(topButtons, 3, 1);

		// image for the icon
		JPanel iconPanel = SyWindow.buildBorder(0, 0, 0, 0);
		JLabel icon = SyWindow.buildImage("./img/logo.png");
		top.add(icon);

		JButton compose = SyWindow.createButton("Compose");
		Font font = SyWindow.createFont("serif", Font.PLAIN, 18);
		compose.setFont(font);

//		JButton search = SyWindow.createButton("Search");
//		search.setFont(font);

		JButton sync = SyWindow.createButton("Sync Gmail");
		sync.setFont(font);

		JComboBox<String> inbox = new JComboBox<String>();
		inbox.addItem("Inbox");
		inbox.addItem("Favorite");
		inbox.addItem("Unread");
		inbox.addItem("Reminders");
		//inbox.addItem("Search");
		inbox.setFont(font);

		top.add(inbox);

		topButtons.add(compose);
		//topButtons.add(search);
		topButtons.add(sync);

		// middle of the inbox
		JPanel midPanel = new JPanel();

		// final DefaultListModel<String> listModel = new DefaultListModel<String>();
		loadInboxMails(emailList);
		emailsGUI = new JList<String>(emailList);

		emailsGUI.setFixedCellWidth(360);
		emailsGUI.setFixedCellHeight(20);
		emailsGUI.setFont(font);
		midPanel.add(emailsGUI);
		JScrollPane scroll = new JScrollPane(emailsGUI, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setEnabled(true);
		scroll.setPreferredSize(new Dimension(360, 200));
		midPanel.add(scroll);

		JPanel bottomButtons = SyWindow.buildBorder(0, 0, 0, 0);
		SyWindow.buildGrid(bottomButtons, 3, 1);
		JButton open = SyWindow.createButton("Open");
		open.setFont(font);
		JButton delete = SyWindow.createButton("Delete");
		delete.setFont(font);
//		JButton reply = SyWindow.createButton("Reply");
//		reply.setFont(font);
		bottomButtons.add(open);
		bottomButtons.add(delete);
		//bottomButtons.add(reply);

		JPanel closeButton = SyWindow.buildBorder(0, 0, 0, 0);
		SyWindow.buildGrid(closeButton, 1, 1);
		JButton close = SyWindow.createButton("Encrypt & Close");
		close.setFont(font);
		close.setPreferredSize(new Dimension(280, 30));
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
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

		inboxFrame.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(WindowEvent winEvt) {
				try {
					saveAndExit();
				} catch (Exception e) {
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
				if (!emailsGUI.isSelectionEmpty()) {
					Mail selected = current.get(emailsGUI.getSelectedIndex());
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
				if (inbox.getSelectedItem().toString().equals("Unread"))
					loadUnreadMails(emailList);

				if (inbox.getSelectedItem().toString().equals("Favorite"))
					loadFavoriteMails(emailList);

				if (inbox.getSelectedItem().toString().equals("Reminders"))
					loadReminderEmails(emailList);

				if (inbox.getSelectedItem().toString().equals("Inbox"))
					loadInboxMails(emailList);
			}
		});

		return inboxFrame;
	}

}
