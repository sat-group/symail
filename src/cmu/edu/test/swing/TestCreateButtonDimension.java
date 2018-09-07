package cmu.edu.test.swing;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import cmu.edu.window.SyWindow;

public class TestCreateButtonDimension {

	@Test
	public void test1() {
		
		javax.swing.JButton b1 = new javax.swing.JButton("LOGIN");
		javax.swing.JButton button = SyWindow.createButtonDimension(b1, 10, 30);
		assertTrue(button.getText().equals("LOGIN") &&
				   button.getPreferredSize().getWidth() == 10 && 
				   button.getPreferredSize().getHeight() == 30);
	}
}
