package cmu.edu.test.file;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import cmu.edu.util.SyFileUtils;

public class TestCreateDirectory {
	
	@Test
	public void test1() throws IOException {
		
		// create directory
		File dir = new File("synth-tmp");
		FileUtils.cleanDirectory(dir);
		
		File dir2 = SyFileUtils.createDirectory("synth-tmp");
		assertTrue(dir2.isDirectory());
	}

}
