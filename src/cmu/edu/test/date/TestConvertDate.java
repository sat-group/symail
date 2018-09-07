package cmu.edu.test.date;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import cmu.edu.date.SyDate;

public class TestConvertDate {
	
	@Test
	public void test1() throws Throwable {
		
		java.util.Date date = new java.util.Date(2018-1900,1,20);
		com.icegreen.greenmail.util.GreenMail greenMail = new com.icegreen.greenmail.util.GreenMail();
		javax.mail.Session session = greenMail.getSmtp().createSession();
		javax.mail.Message message = new javax.mail.internet.MimeMessage(session);
		message.setSentDate(date);
		java.time.LocalDateTime localdate = SyDate.convertDate(message);
		assertTrue(localdate.getYear() == 2018 && localdate.getMonthValue()==2 && localdate.getDayOfMonth() == 20);
	}


}
