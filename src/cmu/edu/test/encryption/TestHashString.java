package cmu.edu.test.encryption;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import cmu.edu.util.SyCryptoUtils;

public class TestHashString {

	@Test
	public void test1() throws Throwable {
		
		String password = "mysupersecretpassword";
		String hashpassword = "117a520adbd19eff51100215aa7a7fbf";
		String hash = "MD5";
				
		String decrypted = SyCryptoUtils.hashTextString(password, hash);
		assertTrue(decrypted.equals(hashpassword));
	}

	
}
