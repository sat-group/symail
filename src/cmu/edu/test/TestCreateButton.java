package cmu.edu.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import cmu.edu.window.SyWindow;

public class TestCreateButton {
	
	@Test
	public void test1() {
		javax.swing.JButton button = SyWindow.createButton("LOGIN");
		assertTrue(button.getText().equals("LOGIN"));
	}

}
