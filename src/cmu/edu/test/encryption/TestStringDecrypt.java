package cmu.edu.test.encryption;

import static org.junit.Assert.assertTrue;

import org.encryptor4j.util.TextEncryptor;
import org.junit.Test;

import cmu.edu.util.SyCryptoUtils;

public class TestStringDecrypt {

	@Test
	public void test1() throws Throwable {
		
		String text = "This is a secret message";
		String password = "mysupersecretpassword";
				
		TextEncryptor te = new TextEncryptor(password);
		String encrypted = te.encrypt(text);
		String decrypted = SyCryptoUtils.decrypt(encrypted, password);
		assertTrue(decrypted.equals("This is a secret message"));		
	}
	
}
