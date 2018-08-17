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

package cmu.edu.ui;

import java.util.ArrayList;

import javax.swing.JFrame;

import cmu.edu.client.GmailStore;
import cmu.edu.compose.SyComposeWindow;
import cmu.edu.inbox.SyInboxWindow;
import cmu.edu.login.SyLoginWindow;
import cmu.edu.open.SyOpenWindow;
import cmu.edu.util.SyFileUtils;
import cmu.edu.window.SyWindow;

public class SyMail {
	
	public static void main(String args[]) throws Throwable {
		
		if (!SyFileUtils.existDirectory("tmp/"))
			SyFileUtils.createDirectory("tmp/");
		
		// frame for the login window
		SyLoginWindow login = new SyLoginWindow();
		JFrame loginFrame = login.buildLogin();
		loginFrame = SyWindow.setFrameVisible(loginFrame, true);
		
//		String username = "muse.program.synthesis";
//		String password = "utcmu2018";
//		
//		GmailStore gmail = new GmailStore(username,password);
//		SyInboxWindow inbox = new SyInboxWindow(new ArrayList<>(), gmail, username, password);
//		JFrame inboxFrame = inbox.buildInbox();
//		SyWindow.setFrameVisible(inboxFrame, true);
//		gmail.getStore().close();
		
//		GmailStore gmail = new GmailStore(username,password);
//		SyComposeWindow compose = new SyComposeWindow(gmail);
//		JFrame composeFrame = compose.buildCompose();
//		SyWindow.setFrameVisible(composeFrame, true);
		
//		GmailStore gmail = new GmailStore(username,password);
//		SyOpenWindow open = new SyOpenWindow(gmail, "rubengmartins@gmail.com", "testing", "This is a message", false);
//		JFrame openFrame = open.buildOpen();
//		SyWindow.setFrameVisible(openFrame, true);
		
		
		
	}

}
