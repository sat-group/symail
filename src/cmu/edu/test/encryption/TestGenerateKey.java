package cmu.edu.test.encryption;

import static org.junit.Assert.assertTrue;

import java.security.Key;

import org.junit.Test;

import cmu.edu.util.SyCryptoUtils;

public class TestGenerateKey {

	@Test
	public void test1() throws Throwable {
		
		String password = "mysupersecretpassword";
		String hash = "MD5";
	    String protocol = "AES";
		Key key = SyCryptoUtils.generateKey(password, hash, protocol);
		byte[] output = new byte[] {17,122,82,10,-37,-47,-98,-1,81,16,2,21,-86,122,127,-65};
		boolean ok = true;
		for (int p = 0; p < key.getEncoded().length; p++) {
			if (key.getEncoded()[p] != output[p]) {
				ok = false;
				break;
			}
		}
		assertTrue(key.getAlgorithm().equals(protocol) && ok);
	}

	
}
