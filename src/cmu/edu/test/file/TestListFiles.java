package cmu.edu.test.file;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import cmu.edu.util.SyFileUtils;

public class TestListFiles {

	@Test
	public void test1() throws IOException {

		// create directory
		File dir = new File("synth-tmp");
		dir.mkdir();

		// create file
		File file = new File("synth-tmp/f1.txt");
		file.createNewFile();

		File file2 = new File("synth-tmp/f2.txt");
		file2.createNewFile();

		File[] files = SyFileUtils.listFiles("synth-tmp");
		boolean r1 = false;
		boolean r2 = false;
		for (File f : files) {
			if (f.getName().equals("f1.txt"))
				r1 = true;
			if (f.getName().equals("f2.txt"))
				r2 = true;
		}
		assertTrue(dir.exists() && r1 && r2 && files.length == 2);
	}

}
