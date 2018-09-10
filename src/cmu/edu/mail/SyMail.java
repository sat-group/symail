package cmu.edu.mail;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Store;

public class SyMail {

	// assumes that store is connected
	public static Message[] getEmails(Store store, String inbox, int open) throws MessagingException {
		Folder emailFolder = store.getFolder(inbox);
		emailFolder.open(open);
		Message[] messages = emailFolder.getMessages();
		return messages;
	}
	
	public static Folder getEmailFolder(Store store, String inbox, int open) throws MessagingException {
		Folder emailFolder = store.getFolder(inbox);
		emailFolder.open(open);
		return emailFolder;
	}

	public static Message[] getEmailsConnectClose(Store store, String inbox, int open) throws MessagingException {
		store.connect();
		Folder emailFolder = store.getFolder(inbox);
		emailFolder.open(open);
		Message[] messages = emailFolder.getMessages();
		store.close();
		return messages;
	}
	
	
	

}
