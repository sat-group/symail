package cmu.edu.test.file;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import cmu.edu.util.SyFileUtils;

public class TestExistFile {
	
	@Test
	public void test1() throws IOException {
		
		// create directory
		File dir = new File("synth-tmp");
		dir.mkdir();
		
		// create file
		File f = new File("synth-tmp/f1.txt");
		f.createNewFile();
		
		boolean r1 = SyFileUtils.existFile("synth-tmp/f1.txt");
		boolean r2 = SyFileUtils.existFile("synth-tmp/f2.txt");
		assertTrue(r1 == true && r2 == false);
	}


}
