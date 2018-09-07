package cmu.edu.test.swing;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import cmu.edu.window.SyWindow;

public class TestDimension {
	
	@Test
	public void test1() {
		java.awt.Dimension d = SyWindow.createDimension(5, 10);
		assertTrue(d.getWidth() == 5 && d.getHeight() == 10);		
	}


}
