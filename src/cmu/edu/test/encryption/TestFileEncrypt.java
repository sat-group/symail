package cmu.edu.test.encryption;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.encryptor4j.util.FileEncryptor;
import org.junit.Test;

import cmu.edu.util.SyCryptoUtils;
import cmu.edu.util.SyFileUtils;

public class TestFileEncrypt {
	
	@SuppressWarnings("deprecation")
	@Test
	public void test1() throws Throwable {
		
		// create directory
		File dir = new File("synth-tmp");
		dir.mkdir();
		
		// create file
		File f = new File("synth-tmp/f1.txt");
		FileUtils.writeStringToFile(f, "This is a test!");
		String password = "mysupersecretpassword";
		
		File f2 = SyCryptoUtils.encryptFile("synth-tmp/f1.txt", "synth-tmp/f2.txt", password);
		File f3 = new File("synth-tmp/f3.txt");
		
		FileEncryptor fe = new FileEncryptor(password);
		fe.decrypt(f2, f3);
		String output = FileUtils.readFileToString(f3);
				
		boolean r1 = SyFileUtils.existFile("synth-tmp/f1.txt");
		boolean r2 = SyFileUtils.existFile("synth-tmp/f2.txt");
		boolean r3 = SyFileUtils.existFile("synth-tmp/f3.txt");
		
		assertTrue(r1 == true && r2 == true && r3 == true && output.equals("This is a test!"));
	}


}
