package cmu.edu.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import cmu.edu.window.SyWindow;

public class TestPanelGrid {
	
	@Test
	public void test1() {
		javax.swing.JPanel panel = new javax.swing.JPanel();
		javax.swing.JPanel gridPanel = SyWindow.buildGrid(panel, 1, 5);
		java.awt.GridLayout gl = (java.awt.GridLayout) gridPanel.getLayout();
		assertTrue(gl.getColumns() == 1 && gl.getRows() == 5);
	}

}
