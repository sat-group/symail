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

package cmu.edu.compose;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.swing.BorderFactory;

import com.sun.glass.ui.TouchInputSupport;
import com.sun.mail.smtp.SMTPTransport;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import cmu.edu.client.GmailStore;
import cmu.edu.gmail.SyMailClient;
import cmu.edu.warning.SyWarningWindow;
import cmu.edu.window.SyWindow;

public class SyComposeWindow {

	// Private variables of the GUI components
	private JTextField to;
	private JTextField subject;
	private JTextArea body;
	private GmailStore gmail;
	
	private String toName;
	private String toTitle;

	public SyComposeWindow(GmailStore gmail) {

		this.gmail = gmail;
		toName = "";
		toTitle = "";

	}
	
	public SyComposeWindow(GmailStore gmail, String to, String title) {
		this.gmail = gmail;
		toName = to;
		toTitle = title;
	}

	@SuppressWarnings("unused")
	public JFrame buildCompose() throws IOException {
		
		boolean replying = !toName.equals("");
		
		// JPanel for the text fields
		JFrame composeFrame = SyWindow.buildFrame(450, 600, "SyMail - Synthesized Mail Client");
		composeFrame.setLocationRelativeTo(null);
		SyWindow.setFrameAttributes(composeFrame, JFrame.EXIT_ON_CLOSE, false);

		JPanel tfPanel = new JPanel(new GridLayout(3, 2, 10, 2));

		JPanel top = SyWindow.buildBorder(0, 0, 0, 0);
		SyWindow.buildGrid(top, 1, 2);
		JPanel iconPanel = SyWindow.buildBorder(0, 0, 0, 0);
		JLabel icon = SyWindow.buildImage("./img/logo.png");
		top.add(icon);

		Font font = new Font("Serif", Font.PLAIN, 18);

		tfPanel.add(new JLabel("  To:  "));
		tfPanel.setFont(font);
		to = new JTextField(15);
		tfPanel.add(to);
		if (replying)
			to.setText(toName);
		
		tfPanel.add(new JLabel("  Subject:  "));
		subject = new JTextField(15);
		tfPanel.add(subject);
		if (replying)
			subject.setText(toTitle);

		body = new JTextArea();
		body.setFont(font);
		body.setLineWrap(true);
		body.setWrapStyleWord(true);
		// light blue
		body.setBackground(new Color(204, 238, 241)); 
		
		// Wrap the JTextArea inside a JScrollPane
		JScrollPane tAreaScrollPane = new JScrollPane(body);
		tAreaScrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		tAreaScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		JPanel panelButtons = SyWindow.buildBorder(5, 5, 5, 5);
		SyWindow.buildGrid(panelButtons, 2, 1);

		JButton send = SyWindow.createButton("Send");
		send.setFont(font);

		JButton close = SyWindow.createButton("Close");
		close.setFont(font);

		panelButtons.add(send);
		panelButtons.add(close);

		top.add(tfPanel);

		composeFrame.add(top, BorderLayout.NORTH);
		composeFrame.add(tAreaScrollPane, BorderLayout.CENTER);
		composeFrame.add(panelButtons, BorderLayout.SOUTH);

		send.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// Session session = gmail.getSession();
				try {

					Properties props = System.getProperties();
					props.put("mail.smtp.auth", "true");
					props.put("mail.smtp.starttls.enable", "true");
					props.put("mail.smtp.port", "587");

					Session session = Session.getDefaultInstance(props);
					Transport tp = session.getTransport("smtps");
					SMTPTransport transport = (SMTPTransport) tp;
					
//					SyMailClient.sendEmail("smtp.gmail.com", gmail.getUsername(), gmail.getPassword(), to.getText(),
//							subject.getText(), body.getText(), tp, session);

					Message message = SyMailClient.buildMessage(session, to.getText(), subject.getText(),
							body.getText());
					int result = SyMailClient.sendEmail("smtp.gmail.com", gmail.getUsername(), gmail.getPassword(),
							message, transport);
					if (result != 250) {
						// if result is different than 250 then it failed
						SyWarningWindow.EmailFailure();
					} else {
						composeFrame.dispose();
					}					

				} catch (Exception e1) {
					SyWarningWindow.EmailFailure();
				}

			}
		});

		close.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				composeFrame.dispose();
			}
		});

		return composeFrame;
	}

}
