package cmu.edu.test.swing;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import cmu.edu.window.SyWindow;

public class TestCreateButtonFontT {

	@Test
	public void test1() {

		java.awt.Font font = new java.awt.Font("serif", java.awt.Font.PLAIN, 14);
		javax.swing.JButton button = SyWindow.createButtonFontT("LOGIN", font);
		assertTrue(button.getText().equals("LOGIN") && button.getFont().getName().equals("serif")
				&& button.getFont().getStyle() == java.awt.Font.PLAIN && button.getFont().getSize() == 14);
	}

}
