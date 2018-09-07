package cmu.edu.test.file;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import cmu.edu.util.SyFileUtils;

public class TestCleanDirectory {
	
	@Test
	public void test1() throws IOException {
		
		// create directory
		File dir = new File("synth-tmp");
		dir.mkdir();	
		
		// create file
		File file = new File("synth-tmp/f1.txt");
		file.createNewFile();
				
		File dir2 = SyFileUtils.cleanDirectory("synth-tmp");
		File[] files = dir2.listFiles();
		assertTrue(dir2.exists() && files.length == 0);
	}

}
