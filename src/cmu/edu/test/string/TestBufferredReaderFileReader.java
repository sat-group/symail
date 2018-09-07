package cmu.edu.test.string;

import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import cmu.edu.string.SyAddress;

public class TestBufferredReaderFileReader {
	
	@Test
	public void test1() throws Exception {
		
		// create directory
		File dir = new File("synth-tmp");
		dir.mkdir();	
		
		// create file
		File file = new File("synth-tmp/f1.txt");
		FileUtils.writeStringToFile(file, "This is a test!");
		file.createNewFile();
				
		FileReader reader = new FileReader(file);
		BufferedReader bufferedReader = SyAddress.createBufferedReaderFileReader(reader);
		assertTrue(bufferedReader.readLine().equals("This is a test!"));
	}

}
