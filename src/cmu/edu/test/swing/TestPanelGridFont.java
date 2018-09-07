package cmu.edu.test.swing;

import static org.junit.Assert.assertTrue;

import java.awt.Font;

import org.junit.Test;

import cmu.edu.window.SyWindow;

public class TestPanelGridFont {

	@Test
	public void test1() {
		java.awt.Font font = new java.awt.Font("serif", Font.PLAIN, 14);
		javax.swing.JPanel gridPanel = SyWindow.buildGridFont(3, 2, 10, 2, font);
		java.awt.GridLayout gl = (java.awt.GridLayout) gridPanel.getLayout();
		assertTrue(gl.getColumns() == 3 && gl.getRows() == 2 && gl.getHgap() == 10 && gl.getVgap() == 2
				&& gridPanel.getFont().getName().equals("serif")
				&& gridPanel.getFont().getStyle() == java.awt.Font.PLAIN && gridPanel.getFont().getSize() == 14);
	}

}
