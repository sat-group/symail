package cmu.edu.test.mail;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import com.icegreen.greenmail.junit.GreenMailRule;
import com.icegreen.greenmail.user.GreenMailUser;
import com.icegreen.greenmail.util.GreenMail;
import com.icegreen.greenmail.util.GreenMailUtil;
import com.icegreen.greenmail.util.ServerSetup;
import com.icegreen.greenmail.util.ServerSetupTest;
import com.sun.mail.smtp.SMTPTransport;

import cmu.edu.gmail.SyMailClient;

public class TestSendEmail {
	
    private GreenMail greenMail;
    
    
    @Before
    public void startMailServer() {
        ServerSetup setup = new ServerSetup(3025,"localhost","smtp");
        greenMail = new GreenMail(setup);
        greenMail.start();
    }

    @After
    public void stopMailServer() {
        greenMail.stop();
    }

    @Test
    public void testPledgeReminder()
                throws Exception {
    	
    	greenMail.setUser("test@excaple.com", "password");
    
        String mailText = "Hallo World";
        String mailSubject = "Hallo";
        String mailTo = "test@excaple.com";


		Session session = greenMail.getSmtp().createSession();
		System.out.println("session = " + session.getProperties());
		Message message = SyMailClient.buildMessage(session, mailTo, mailSubject,
				mailText);
		
		System.out.println("message = " + message.getContentType());
		System.out.println("message = " + message.getSubject());
		System.out.println("message = " + message.getAllRecipients()[0]);
		System.out.println("message = " + message.getContent());

		
		Transport tp = session.getTransport("smtp");
		SMTPTransport transport = (SMTPTransport) tp;
		//transport.send(message);
		//transport.connect(host, user, pwd);
		transport.connect("test@excaple.com", "password");
		//transport.connect("smtp://utcs@localhost", );
		transport.sendMessage(message, message.getAllRecipients());
		int code = transport.getLastReturnCode();
		transport.close();
		System.out.println("code = " + code);
		//Transport.send(message);
       
        assertTrue(greenMail.waitForIncomingEmail(5000, 1));
        Message[] messages = greenMail.getReceivedMessages();
        assertEquals(1, messages.length);
        assertEquals(mailSubject, messages[0].getSubject());       
        String body = GreenMailUtil.getBody(messages[0]).replaceAll("=\r?\n", "");
        assertEquals(mailText, body);       
    }

}
