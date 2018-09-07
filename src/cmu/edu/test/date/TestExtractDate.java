package cmu.edu.test.date;

import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;

import org.junit.Test;

import cmu.edu.date.SyDate;
import cmu.edu.mail.Mail;

public class TestExtractDate {
	
	@Test
	public void test1() throws Throwable {
		
		LocalDateTime dt = LocalDateTime.of(2012,3,10,20,0);
		Mail mail = new Mail("title", "foo@gmail.com", "This is an email!", dt);
		String date = SyDate.extractDate(mail, "dd/MM/yyyy");
		assertTrue(date.equals("10/03/2012"));

	}

}
