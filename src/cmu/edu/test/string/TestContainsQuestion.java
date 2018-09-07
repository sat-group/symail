package cmu.edu.test.string;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import cmu.edu.string.SyAddress;

public class TestContainsQuestion {
	
	@Test
	public void test1() {
		cmu.edu.mail.Mail mail = new cmu.edu.mail.Mail("title","foo@gmail.com","This is an email!");
		boolean res = SyAddress.containsQuestion(mail, "?");
		assertTrue(res == false);
	}

	@Test
	public void test2() {
		cmu.edu.mail.Mail mail = new cmu.edu.mail.Mail("title","foo@gmail.com","This is an email?");
		boolean res = SyAddress.containsQuestion(mail, "?");
		assertTrue(res == true); 
	}
	
	@Test
	public void test3() {
		cmu.edu.mail.Mail mail = new cmu.edu.mail.Mail("title","foo@gmail.com","This is an email! Please reply?");
		boolean res = SyAddress.containsQuestion(mail, "?");
		assertTrue(res == true); 
	}

}
