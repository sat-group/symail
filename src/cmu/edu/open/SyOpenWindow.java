package cmu.edu.open;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BorderFactory;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import cmu.edu.client.GmailStore;
import cmu.edu.compose.SyComposeWindow;
import cmu.edu.mail.Mail;
import cmu.edu.window.SyWindow;

public class SyOpenWindow {

	// Private variables of the GUI components
	private JTextField to;
	private JTextField subject;
	private JTextField favoriteText;
	private JTextArea body;
	private GmailStore gmail;
	
	private String toName;
	private String subjectName;
	private String bodyName;
	private boolean favoriteOption;
	private Mail mail;

	public SyOpenWindow(GmailStore gmail, Mail mail) {

		this.gmail = gmail;
		this.mail = mail;
		toName = mail.getAddress().getAddress();
		subjectName = mail.getTitle();
		bodyName = mail.getBody();
		favoriteOption = mail.getFavorite();
	}
	
	@SuppressWarnings("unused")
	public JFrame buildOpen() throws IOException {
		// JPanel for the text fields
		JFrame openFrame = SyWindow.buildFrame(450, 600, "SyMail - Synthesized Mail Client");
		openFrame.setLocationRelativeTo(null);
		SyWindow.setFrameAttributes(openFrame, JFrame.DO_NOTHING_ON_CLOSE, false);

		JPanel tfPanel = new JPanel(new GridLayout(4, 2, 10, 2));

		JPanel top = SyWindow.buildBorder(0, 0, 0, 0);
		SyWindow.buildGrid(top, 1, 2);
		JPanel iconPanel = SyWindow.buildBorder(0, 0, 0, 0);
		JLabel icon = SyWindow.buildImage("./img/logo.png");
		top.add(icon);

		Font font = new Font("Serif", Font.PLAIN, 18);

		tfPanel.add(new JLabel("  From:  "));
		tfPanel.setFont(font);
		to = new JTextField(15);
		to.setText(toName);
		to.setEditable(false);
		tfPanel.add(to);

		tfPanel.add(new JLabel("  Subject:  "));
		//FIXME: synthesize JTextField 
		subject = new JTextField(15);
		subject.setText(subjectName);
		subject.setEditable(false);
		tfPanel.add(subject);
		
		tfPanel.add(new JLabel("  Favorite:  "));
		favoriteText = new JTextField(15);
		if (favoriteOption)
			favoriteText.setText("Yes");
		else  
			favoriteText.setText("No");
		favoriteText.setEditable(false);
		tfPanel.add(favoriteText);

		//FIXME: synthesize JTextArea
		body = new JTextArea();
		body.setFont(font);
		body.setLineWrap(true);
		body.setWrapStyleWord(true);
		// light blue
		// FIXME: synthesize color
		body.setBackground(new Color(204, 238, 241));
		body.setEditable(false);
		body.setText(bodyName);

		//FIXME: synthesize JScrollPane
		// Wrap the JTextArea inside a JScrollPane
		JScrollPane tAreaScrollPane = new JScrollPane(body);
		//FIXME: synthesize empty border
		tAreaScrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		tAreaScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		JPanel panelButtons = SyWindow.buildBorder(5, 5, 5, 5);
		SyWindow.buildGrid(panelButtons, 2, 1);
		
		JButton favorite = SyWindow.createButton("Favorite");
		if (favoriteOption)
			favorite.setText("Unfavorite");
		favorite.setFont(font);
		
		JButton reply = SyWindow.createButtonFontT("Reply", font);		
		JButton delete = SyWindow.createButtonFontT("Delete", font);
		JButton close = SyWindow.createButtonFontT("Close", font);

		panelButtons.add(favorite);
		panelButtons.add(reply);
		panelButtons.add(delete);
		panelButtons.add(close);

		top.add(tfPanel);

		openFrame.add(top, BorderLayout.NORTH);
		openFrame.add(tAreaScrollPane, BorderLayout.CENTER);
		openFrame.add(panelButtons, BorderLayout.SOUTH);
		
		favorite.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!favoriteOption) {
					favorite.setText("Unfavorite");
					favoriteOption = true;
					mail.setFavorite(true);
					favoriteText.setText("Yes");
				} else {
					favorite.setText("Favorite");
					favoriteOption = false;
					mail.setFavorite(false);
					favoriteText.setText("No");
				}
				
			}
		});
		
		close.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				openFrame.dispose();
			}
		});
		
		delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mail.setDeleted(true);
				openFrame.dispose();
			}
		});
		
		reply.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String title = "[Re:] " + subjectName;
				SyComposeWindow compose = new SyComposeWindow(gmail, toName, title);
				try {
					JFrame composeFrame = compose.buildCompose();
					SyWindow.setFrameVisible(composeFrame, true);
					mail.setReplied(true);
					openFrame.dispose();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}
		});
			
		return openFrame;
	}

}
