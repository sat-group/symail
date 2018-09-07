package cmu.edu.test.swing;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import cmu.edu.window.SyWindow;

public class TestCreateCheckBoxFont {

	@Test
	public void test1() {
		javax.swing.JCheckBox cbox = SyWindow.createCheckBoxFont("Offline mode", "serif", java.awt.Font.PLAIN, 14);
		assertTrue(cbox.getText().equals("Offline mode") && cbox.getFont().getName().equals("serif")
				&& cbox.getFont().getStyle() == java.awt.Font.PLAIN && cbox.getFont().getSize() == 14);
	}

}
