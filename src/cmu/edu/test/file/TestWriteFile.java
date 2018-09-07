package cmu.edu.test.file;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import cmu.edu.util.SyFileUtils;

public class TestWriteFile {
	
	@SuppressWarnings("deprecation")
	@Test
	public void test1() throws IOException {
		
		// create directory
		File dir = new File("synth-tmp");
		dir.mkdir();	
		
		// create file
		File file = new File("synth-tmp/f1.txt");
		FileUtils.writeStringToFile(file, "This is a test!");
		file.createNewFile();
				
		String output = SyFileUtils.readFromFile("synth-tmp/f1.txt");
		assertTrue(output.equals("This is a test!") && file.exists() && dir.exists());
	}

}
