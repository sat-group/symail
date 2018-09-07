package cmu.edu.test.date;

import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;

import org.junit.Test;

import cmu.edu.date.SyDate;
import cmu.edu.mail.Mail;

public class TestGetDays {
	
	@Test
	public void test1() throws Throwable {
		
		int diff = 2;
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime dt = LocalDateTime.of(now.getYear(), now.getMonthValue(), now.getDayOfMonth()-diff, now.getHour(), now.getMinute());
		Mail mail = new Mail("title", "foo@gmail.com", "This is an email!", dt);
		long days = SyDate.getDays(mail);
		assertTrue(days == diff);

	}

}
