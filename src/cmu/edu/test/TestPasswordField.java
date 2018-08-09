package cmu.edu.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import cmu.edu.window.SyWindow;

public class TestPasswordField {
	
	@Test
	public void test1() throws Throwable {
		javax.swing.JPasswordField text = SyWindow.buildPasswordField("serif", java.awt.Font.PLAIN, 18);
		assertTrue(text.getFont().getStyle() == java.awt.Font.PLAIN &&
			        text.getFont().getName().equals("serif") &&
			        text.getFont().getSize() == 18);
	}

}
