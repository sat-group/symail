package cmu.edu.demo;

import org.simplejavamail.email.Email;
import org.simplejavamail.email.EmailBuilder;

public class ExampleMail {

//# packages: org.simplejavamail
//# return: org.simplejavamail.mailer.Mailer
//# hints:
public static  org.simplejavamail.mailer.Mailer buildMailer(java.lang.String localhost, java.lang.Integer port, java.lang.String username, java.lang.String password) throws Throwable {
	//#SyPet
}

// # //
public static boolean test1() throws Throwable{
	try {
		org.simplejavamail.mailer.Mailer ml = buildMailer("localhost", 3025, "muse@gmail.com", "password");
		if (ml.getServerConfig().getPassword().equals("password") &&
				ml.getServerConfig().getHost().equals("localhost") &&
				ml.getServerConfig().getPort() == 3025 &&
				ml.getServerConfig().getUsername().equals("muse@gmail.com"))
			return true;
	} catch (java.lang.Exception e) {
		return false;
	}
	return false;
}
// # //

//# packages: org.simplejavamail
//# return: org.simplejavamail.email.Email
//# hints: startingBlank from withPlainText withSubject
public static  org.simplejavamail.email.Email buildMail(java.lang.String from, java.lang.String to, java.lang.String title, java.lang.String body) throws Throwable {
//#SyPet
}

// # //
public static boolean test2() throws Throwable{
	try {
		org.simplejavamail.email.Email ml = buildMail("muse@gmail.com","ruben@gmail.com","Hello!","We should meet up!");
		if (ml.getSubject().equals("Hello!") &&
				ml.getPlainText().equals("We should meet up!") &&
				ml.getFromRecipient().getAddress().equals("muse@gmail.com") &&
				ml.getRecipients().get(0).getAddress().equals("ruben@gmail.com"))
			return true;
	} catch (java.lang.Exception e) {
		return false;
	}
	return false;
}
// # //


public static boolean testSendEmail() throws Throwable {
	boolean ok = true;
	com.icegreen.greenmail.util.ServerSetup setup = new com.icegreen.greenmail.util.ServerSetup(3025, "localhost","smtp");
	com.icegreen.greenmail.util.GreenMail greenMail = new com.icegreen.greenmail.util.GreenMail(setup);
	greenMail.setUser("muse@gmail.com", "password");
	greenMail.start();
	try {

	org.simplejavamail.email.Email email = buildMail("muse@gmail.com", "muse@gmail.com", "Hello!", "We should meet up!");
	org.simplejavamail.mailer.Mailer ml = buildMailer("localhost", 3025, "muse@gmail.com", "password");
	ml.sendMail(email);

		if (!greenMail.waitForIncomingEmail(1000, 1))
			ok = false;

		if (!(greenMail.getReceivedMessages().length == 1)
				|| !greenMail.getReceivedMessages()[0].getSubject().equals("Hello!"))
			ok = false;

	greenMail.stop();
} catch (java.lang.Exception e) {
	greenMail.stop();
	return false;
}

	return ok;
}

	public static void main(String args[]) throws Throwable {
		System.out.println("buildMailer [test1] = " + test1());
		System.out.println("buildMail [test2] = " + test2());
		System.out.println("testSendEmail = " + testSendEmail());
	}
}
