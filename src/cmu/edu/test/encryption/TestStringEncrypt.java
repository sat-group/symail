package cmu.edu.test.encryption;

import static org.junit.Assert.assertTrue;

import org.encryptor4j.util.TextEncryptor;
import org.junit.Test;

import cmu.edu.util.SyCryptoUtils;

public class TestStringEncrypt {

	@Test
	public void test1() throws Throwable {
		
		String text = "This is a secret message";
		String password = "mysupersecretpassword";
				
		String encrypted = SyCryptoUtils.encrypt(text, password);
		TextEncryptor te = new TextEncryptor(password);
		String decrypted = te.decrypt(encrypted);
		assertTrue(decrypted.equals("This is a secret message"));		
	}
	
}
