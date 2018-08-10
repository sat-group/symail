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

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import cmu.edu.address.SyAddress;
import cmu.edu.mail.Address;
import cmu.edu.window.SyWindow;
import cmu.edu.window.TextPrompt;

public class SyLoginWindow {
			
	public JFrame buildLogin() throws IOException {
		// login frame
		JFrame loginFrame = SyWindow.buildFrame(300, 400, "SyMail - Synthesized Mail Client");
		loginFrame = SyWindow.setLocation(loginFrame, 500, 200);
		loginFrame = SyWindow.setFrameAttributes(loginFrame, JFrame.EXIT_ON_CLOSE, false);
		
		// panel for the login window
		JPanel panel = SyWindow.buildBorder(35,30,35,30);
		panel = SyWindow.buildGrid(panel, 1, 5);
		
		// image for the icon
		JLabel icon = SyWindow.buildImage("./img/logo.png");
		panel.add(icon);
		
		// text for username
		JTextField username = SyWindow.buildTextField("serif", Font.PLAIN, 18);
		panel.add(username);
		
		// text for password
		JPasswordField password = SyWindow.buildPasswordField("serif", Font.PLAIN, 18);
		panel.add(password);
		
		// login button
		JButton login = SyWindow.createButton("LOGIN");
		Font font = SyWindow.createFont("serif", Font.PLAIN, 18);
		login.setFont(font);
		panel.add(login);
		
		// checkbox for offline mode
		JCheckBox cbox = SyWindow.createCheckBox("Offline mode");
		cbox.setFont(font);
		panel.add(cbox);
		
		TextPrompt logins = new TextPrompt("[Enter Username]", username);
		TextPrompt passwords = new TextPrompt("[Enter Password]", password);

		
		// add the panel to the login frame
		loginFrame.add(panel);
		
		login.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				Address address = new Address(username.getText());
				
				// check if the username is valid
				if (SyAddress.isValid(address, "@gmail.com")) {
					System.out.println("address is valid!");
					
					// check if the username exists
					if (cbox.isSelected()) {
						
						
					}
				} else {
					// Error message!
					System.out.println("Error!");
				}
							
			}
			
		});
		
		return loginFrame;
	}

}
