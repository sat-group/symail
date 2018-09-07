package cmu.edu.test.swing;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import cmu.edu.window.SyWindow;

public class TestCreateButtonFont {

	@Test
	public void test1() {
		
		javax.swing.JButton button = SyWindow.createButtonFont("LOGIN", "serif", java.awt.Font.PLAIN, 14);
		assertTrue(button.getText().equals("LOGIN") &&
				   button.getFont().getName().equals("serif") && 
				   button.getFont().getStyle() == java.awt.Font.PLAIN && 
				   button.getFont().getSize() == 14);
	}
}
