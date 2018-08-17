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

package cmu.edu.gmail;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import com.sun.mail.smtp.SMTPTransport;

public class SyMailClient {

	public static java.util.Properties buildProperties(String mailhost, String mailport, String mailttls,
			String mailtrust, String portnumber, String host, String option) {

		Properties properties = new Properties();
		properties.put(mailhost, host);
		properties.put(mailport, portnumber);
		properties.put(mailttls, option);
		properties.put(mailtrust, host);

		return properties;
	}

	public static javax.mail.Session createSession(java.util.Properties properties) throws MessagingException {
		Session emailSession = Session.getDefaultInstance(properties);
		return emailSession;
	}

	public static javax.mail.Store createStore(javax.mail.Session emailSession, String store, String host, String user,
			String password) throws MessagingException {
		Store gmailStore = emailSession.getStore(store);
		gmailStore.connect(host, user, password);
		return gmailStore;
	}

	public static javax.mail.Store createStore(java.util.Properties properties, String store, String host, String user,
			String password) throws MessagingException {
		Session emailSession = Session.getDefaultInstance(properties);
		// Store gmailStore = emailSession.getStore("pop3s");
		Store gmailStore = emailSession.getStore(store);
		gmailStore.connect(host, user, password);
		return gmailStore;
	}

	public static void sendEmail(String host, String user, String pwd, String to, String subject, String body,
			Transport tp, Session session) throws Exception {

		Message v2 = new MimeMessage(session);
		InternetAddress v3 = new InternetAddress(to);
		v2.setRecipient(RecipientType.TO, v3);
		v2.setSubject(subject);
		v2.setContent(body, "text/html");
		Address[] v5 = v2.getAllRecipients();
		tp.connect(host, user, pwd);
		tp.sendMessage(v2, v5);
	}
	
	public static Message buildMessage(Session session, String to, String subject, String body) throws AddressException, MessagingException {
		Message message = new MimeMessage(session);
		message.setRecipients(RecipientType.TO, InternetAddress.parse(to));
		message.setSubject(subject);
		message.setContent(body, "text/html");
		return message;
 		
	}

	public static int sendEmail(String host, String user, String pwd, Message message, SMTPTransport transport) throws Exception  {
			transport.connect(host, user, pwd);
			transport.sendMessage(message, message.getAllRecipients());
			int code = transport.getLastReturnCode();
			transport.close();
			return code;
	}

}
