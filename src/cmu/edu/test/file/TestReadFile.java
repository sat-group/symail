package cmu.edu.test.file;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import cmu.edu.util.SyFileUtils;

public class TestReadFile {

	@SuppressWarnings("deprecation")
	@Test
	public void test1() throws IOException {
		
		// create directory
		File dir = new File("synth-tmp");
		dir.mkdir();	
						
		File file = SyFileUtils.writeToFile("synth-tmp/f1.txt","This is a test!");
		String output = FileUtils.readFileToString(file);
		assertTrue(output.equals("This is a test!") && file.exists() && dir.exists());
	}
	
}
