package cmu.edu.test.file;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

import org.junit.Test;

import cmu.edu.util.SyFileUtils;

public class TestWriteCharsetFile {

	@Test
	public void test1() throws IOException {
		
		// create directory
		File dir = new File("synth-tmp");
		dir.mkdir();	
						
		Charset encoding = Charset.forName("ISO-8859-1");
						
		File file = SyFileUtils.writeFile("synth-tmp/f1.txt", "This is a test using Portuguese words: coração (heart)!", encoding);
		String output = SyFileUtils.readFile("synth-tmp/f1.txt", encoding);
		assertTrue(output.equals("This is a test using Portuguese words: coração (heart)!") && file.exists() && dir.exists());
	}
}
