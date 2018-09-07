package cmu.edu.test.file;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import cmu.edu.util.SyFileUtils;

public class TestReadCharsetFile {
	
	@Test
	public void test1() throws IOException {
		
		// create directory
		File dir = new File("synth-tmp");
		dir.mkdir();	
						
		Charset encoding = Charset.forName("ISO-8859-1");
		File file = new File("synth-tmp/f1.txt");
		FileUtils.write(file, "This is a test using Portuguese words: coração (heart)!", encoding);
						
		String output = SyFileUtils.readFile("synth-tmp/f1.txt", encoding);
		System.out.println("output = " + output);
		assertTrue(output.equals("This is a test using Portuguese words: coração (heart)!") && file.exists() && dir.exists());
	}

}
