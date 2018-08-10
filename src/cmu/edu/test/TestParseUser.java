package cmu.edu.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import cmu.edu.address.SyAddress;

public class TestParseUser {
	
	@Test
	public void test1() {
		cmu.edu.mail.Address address = new cmu.edu.mail.Address("foo@gmail.com");
		java.lang.String username = SyAddress.parseUser(address, "@gmail.com", 0);
		assertTrue(username.equals("foo"));
	}


}
