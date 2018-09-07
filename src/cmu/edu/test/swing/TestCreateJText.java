package cmu.edu.test.swing;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import cmu.edu.window.SyWindow;

public class TestCreateJText {
	
	@Test
	public void test1() {
		javax.swing.JTextField jtext = SyWindow.createTextBuild(15);
		assertTrue(jtext.getColumns() == 15);		
	}

}
