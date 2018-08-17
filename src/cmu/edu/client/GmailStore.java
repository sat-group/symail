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

package cmu.edu.client;

import java.util.ArrayList;
import java.util.Properties;
import java.util.List;

import javax.mail.Session;
import javax.mail.Store;

import cmu.edu.gmail.SyMailClient;
import cmu.edu.mail.Mail;

public class GmailStore {

	private static String host = "pop.gmail.com";
	private static String mailStoreType = "pop3s";
	private static String username;
	private static String password;
	private static Properties properties;
	private static boolean connected = false;
	private static Store store = null;
	private static Session session = null;

	public static List<Mail> mails = new ArrayList<>();

	public Store getStore() {
		return store;
	}
	
	public Session getSession() {
		return session;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}

	public GmailStore(String user, String pwd) {
		username = user;
		password = pwd;

		properties = SyMailClient.buildProperties("mail.pop3.host", "mail.pop3.port", "mail.pop3.starttls.enable",
				"mail.pop3s.ssl.trust", "995", "pop.gmail.com", "true");
		
		try {
			session = SyMailClient.createSession(properties);
			store = SyMailClient.createStore(session, mailStoreType, host, username, password);
			connected = true;
		} catch (javax.mail.MessagingException e) {
			// invalid password
			connected = false;
		}
	}

	public static void connect() {
		try {
			store = SyMailClient.createStore(session, mailStoreType, host, username, password);
			connected = true;
		} catch (javax.mail.MessagingException e) {
			// invalid password
			connected = false;
		}
	}

	public static boolean isConnected() {
		return connected;
	}

}
