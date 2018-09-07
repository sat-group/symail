package cmu.edu.test.swing;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import cmu.edu.window.SyWindow;

public class TestCreateButtonFontDimension {

	@Test
	public void test1() {

		java.awt.Font font = new java.awt.Font("serif", java.awt.Font.PLAIN, 14);
		javax.swing.JButton button = SyWindow.createButtonFontDimension("LOGIN", font, 10, 30);
		assertTrue(button.getText().equals("LOGIN") && button.getPreferredSize().getWidth() == 10
				&& button.getPreferredSize().getHeight() == 30 && button.getFont().getName().equals("serif")
				&& button.getFont().getStyle() == java.awt.Font.PLAIN && button.getFont().getSize() == 14);
	}
}
