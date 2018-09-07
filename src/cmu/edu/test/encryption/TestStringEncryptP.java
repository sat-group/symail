package cmu.edu.test.encryption;

import static org.junit.Assert.assertTrue;

import java.security.Key;

import javax.crypto.Cipher;

import org.junit.Test;

import cmu.edu.util.SyCryptoUtils;

public class TestStringEncryptP {
	
	@Test
	public void test1() throws Throwable {
		
		String text = "This is a secret message";
		String password = "mysupersecretpassword";
		String encoded = "qtAgNnuVEVxdFs9pebI0I3MZ+gAlDvAnq1OWESNqlwY=";
		String protocol = "AES";
		Key key = SyCryptoUtils.generateKey(password, "MD5", "AES");
				
		String encrypted = SyCryptoUtils.encryptNoSalt(text, key, protocol, Cipher.ENCRYPT_MODE);
		
		assertTrue(encrypted.equals(encoded));		
	}

}
