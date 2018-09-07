package cmu.edu.test.encryption;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import cmu.edu.util.SyCryptoUtils;

public class TestStringDecryptP {

	@Test
	public void test1() throws Throwable {
		
		java.lang.String password = "mysupersecretpassword";
		java.lang.String text = "qtAgNnuVEVxdFs9pebI0I3MZ+gAlDvAnq1OWESNqlwY=";
		java.lang.String protocol = "AES";
		java.security.Key key = cmu.edu.util.SyCryptoUtils.generateKey(password, "MD5", "AES");
		java.lang.String decrypted = SyCryptoUtils.decryptNoSalt(text, key, protocol, javax.crypto.Cipher.DECRYPT_MODE);
		
		String decoded = "This is a secret message";
		assertTrue(decrypted.equals(decoded));		
	}

}
