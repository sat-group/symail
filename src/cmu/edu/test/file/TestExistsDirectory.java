package cmu.edu.test.file;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import cmu.edu.util.SyFileUtils;

public class TestExistsDirectory {
	
	@Test
	public void test1() throws IOException {
		
		// create directory
		File dir = new File("synth-tmp");
		dir.mkdir();
		
		File dir2 = new File("synth-tmp2");
		dir2.delete();
				
		boolean r1 = SyFileUtils.existDirectory("synth-tmp");
		boolean r2 = SyFileUtils.existDirectory("synth-tmp2");
		assertTrue(r1 == true && r2 == false);
	}

}
