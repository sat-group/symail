package cmu.edu.test.swing;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import cmu.edu.window.SyWindow;

public class TestCreateCheckBoxFontT {

	@Test
	public void test1() {
		
		java.awt.Font font = new java.awt.Font("serif", java.awt.Font.PLAIN, 14);
		javax.swing.JCheckBox cbox = SyWindow.createCheckBoxFontT("Offline mode", font);
		assertTrue(cbox.getText().equals("Offline mode") && cbox.getFont().getName().equals("serif")
				&& cbox.getFont().getStyle() == java.awt.Font.PLAIN && cbox.getFont().getSize() == 14);
	}

}
