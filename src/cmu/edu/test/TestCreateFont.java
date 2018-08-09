package cmu.edu.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import cmu.edu.window.SyWindow;

public class TestCreateFont {
	
	@Test
	public void test1() {
		java.awt.Font font = SyWindow.createFont("serif",java.awt.Font.PLAIN, 14);
		assertTrue(font.getName().equals("serif") &&
				   font.getStyle() == java.awt.Font.PLAIN &&
				   font.getSize() == 14);		
	}


}
