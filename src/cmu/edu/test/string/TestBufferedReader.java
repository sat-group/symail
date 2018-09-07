package cmu.edu.test.string;

import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.File;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import cmu.edu.string.SyAddress;

public class TestBufferedReader {

	@Test
	public void test1() throws Exception {
		
		// create directory
		File dir = new File("synth-tmp");
		dir.mkdir();	
		
		// create file
		File file = new File("synth-tmp/f1.txt");
		FileUtils.writeStringToFile(file, "This is a test!");
		file.createNewFile();
				
		BufferedReader bufferedReader = SyAddress.createBufferedReader("synth-tmp/f1.txt");
		assertTrue(bufferedReader.readLine().equals("This is a test!"));
	}
	
}
