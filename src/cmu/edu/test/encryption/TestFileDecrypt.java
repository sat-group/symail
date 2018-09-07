package cmu.edu.test.encryption;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.encryptor4j.util.FileEncryptor;
import org.junit.Test;

import cmu.edu.util.SyCryptoUtils;
import cmu.edu.util.SyFileUtils;

public class TestFileDecrypt {
	
	@Test
	public void test1() throws Throwable {
		
		// create directory
		File dir = new File("synth-tmp");
		dir.mkdir();
		
		// create file
		File f = new File("synth-tmp/f1.txt");
		FileUtils.writeStringToFile(f, "This is a test!");
		String password = "mysupersecretpassword";
		
		FileEncryptor fe = new FileEncryptor(password);
		File f2 = new File("synth-tmp/f2.txt");
		fe.encrypt(f, f2);
		
		File f3 = SyCryptoUtils.decryptFile("synth-tmp/f2.txt","synth-tmp/f3.txt",password);
		String output = FileUtils.readFileToString(f3);
				
		boolean r1 = SyFileUtils.existFile("synth-tmp/f1.txt");
		boolean r2 = SyFileUtils.existFile("synth-tmp/f2.txt");
		boolean r3 = SyFileUtils.existFile("synth-tmp/f3.txt");
		
		assertTrue(r1 == true && r2 == true && r3 == true && output.equals("This is a test!"));
	}


}
