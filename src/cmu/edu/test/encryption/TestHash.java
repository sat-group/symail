package cmu.edu.test.encryption;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import cmu.edu.util.SyCryptoUtils;

public class TestHash {
	
	@Test
	public void test1() throws Throwable {
		
		String password = "mysupersecretpassword";
		String hash = "MD5";
				
		byte[] decrypted = SyCryptoUtils.hashText(password, hash);
		byte[] output = new byte[] {17,122,82,10,-37,-47,-98,-1,81,16,2,21,-86,122,127,-65};
		boolean ok = true;
		for (int p = 0; p < decrypted.length; p++) {
			if (decrypted[p] != output[p]) {
				ok = false;
				break;
			}
		}
		assertTrue(ok);
	}

}
