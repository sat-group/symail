package cmu.edu.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import cmu.edu.window.SyWindow;

public class TestPanelBorder {
	
	@Test
	public void test1() {
		javax.swing.JPanel panel = SyWindow.buildBorder(31, 32, 35, 36);
		javax.swing.border.EmptyBorder b = (javax.swing.border.EmptyBorder) panel.getBorder();
		int top = b.getBorderInsets().top;
		int bottom = b.getBorderInsets().bottom;
		int right = b.getBorderInsets().right;
		int left = b.getBorderInsets().left;
		assertTrue(top == 36 && bottom == 35 && left == 31 && right == 32);
	}

}
