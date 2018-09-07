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

package cmu.edu.login;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import cmu.edu.inbox.SyInboxWindow;
import cmu.edu.client.GmailStore;
import cmu.edu.mail.Address;
import cmu.edu.string.SyAddress;
import cmu.edu.util.SyCryptoUtils;
import cmu.edu.util.SyFileUtils;
import cmu.edu.util.SyInternet;
import cmu.edu.warning.SyWarningWindow;
import cmu.edu.window.SyWindow;
import cmu.edu.window.TextPrompt;

public class SyLoginWindow {

	private GmailStore gmail = null;

	public void inboxScreen(String username, String password) throws Throwable {
		try {
			assert (gmail != null);
			SyInboxWindow inbox = new SyInboxWindow(new ArrayList<>(), gmail, username, password);
			JFrame inboxFrame = inbox.buildInbox();
			SyWindow.setFrameVisible(inboxFrame, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unused")
	public JFrame buildLogin() throws IOException {
		// login frame
		final JFrame loginFrame = SyWindow.buildFrame(300, 350, "SyMail - Synthesized Mail Client");
		loginFrame.setLocationRelativeTo(null); // centers the frame
		SyWindow.setFrameAttributes(loginFrame, JFrame.EXIT_ON_CLOSE, false);

		// panel for the login window
		JPanel panel = SyWindow.buildBorder(35, 30, 35, 30);
		panel = SyWindow.buildGrid(panel, 1, 4);

		// image for the icon
		JLabel icon = SyWindow.buildImage("./img/logo.png");
		panel.add(icon);

		// text for username
		JTextField username = SyWindow.buildTextField("serif", Font.PLAIN, 18);
		panel.add(username);

		// text for password
		JPasswordField password = SyWindow.buildPasswordField("serif", Font.PLAIN, 18);
		panel.add(password);

		// font
		Font font = SyWindow.createFont("serif", Font.PLAIN, 18);

		// login button
		JButton login = SyWindow.createButtonFontT("LOGIN", font);
		panel.add(login);

		// checkbox for offline mode
		//JCheckBox cbox = SyWindow.createCheckBoxFontT("Offline mode", font);
		//panel.add(cbox);

		// have some default text
		TextPrompt logins = new TextPrompt("[Enter Username]", username);
		TextPrompt passwords = new TextPrompt("[Enter Password]", password);

		// add the panel to the login frame
		loginFrame.add(panel);

		login.addActionListener(new ActionListener() {

			@SuppressWarnings({ "static-access", "deprecation" })
			@Override
			public void actionPerformed(ActionEvent e) {

				Address address = new Address(username.getText());
				String user = SyAddress.parseUser(address, "@gmail.com", 0);
				String userdirectory = "db/" + user;

				// check if the username is valid
				if (SyAddress.isValid(address, "@gmail.com")) {

//					if (cbox.isSelected()) {
//						// check if the username exists
//						String pwdfile = userdirectory + "/" + user + ".pwd";
//						if (SyFileUtils.existFile(pwdfile)) {
//							try {
//								String encryptedFromFile = SyFileUtils.readFromFile(pwdfile);
//								String decryptedFromFile = SyCryptoUtils.decrypt(encryptedFromFile, password.getText());
//
//								if (decryptedFromFile.equals(password.getText())) {
//									// goto next screen
//									loginFrame.dispose();
//									inboxScreen(user, password.getText());
//								} else {
//									SyWarningWindow.PasswordCheck();
//								}
//
//							} catch (Throwable e1) {
//								SyWarningWindow.PasswordCheck();
//							}
//
//						} else {
//							SyWarningWindow.PasswordCheck();
//						}
//
//					} else {
						// check connection to the internet

						try {
							java.net.Socket socket = SyInternet.createSocket("smtp.gmail.com", 587);
							if (SyInternet.canReachGmail(socket).contains("smtp.gmail.com")) {
								// check if username/password is valid
								gmail = new GmailStore(user, password.getText());
								if (gmail.isConnected()) {
									// username/password is correct

									// encrypt password
									String encrypted = SyCryptoUtils.encrypt(password.getText(), password.getText());

									// check if user already exists
									if (!SyFileUtils.existDirectory(userdirectory)) {
										// create directory
										SyFileUtils.createDirectory(userdirectory);
									}

									// save password to disk
									String pwddir = userdirectory + "/" + user + ".pwd";
									SyFileUtils.writeToFile(pwddir, encrypted);

									// goto next screen
									loginFrame.dispose();
									inboxScreen(user, password.getText());

								} else {
									SyWarningWindow.PasswordCheck();
								}

							} else {
								// no internet connection
								SyWarningWindow.InternetCheck();
							}

						} catch (Throwable e1) {
							// no internet connection
							SyWarningWindow.InternetCheck();
						}

				} else {
					SyWarningWindow.GmailFailure(username.getText());
				}
			}

		});

		return loginFrame;
	}

}
