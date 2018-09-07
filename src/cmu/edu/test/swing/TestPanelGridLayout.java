package cmu.edu.test.swing;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import cmu.edu.window.SyWindow;

public class TestPanelGridLayout {
	
	@Test
	public void test1() {
		javax.swing.JPanel gridPanel = SyWindow.buildGrid(3, 2, 10, 2);
		java.awt.GridLayout gl = (java.awt.GridLayout) gridPanel.getLayout();
		assertTrue(gl.getColumns() == 3 && gl.getRows() == 2 && gl.getHgap() == 10 && gl.getVgap() == 2);
	}


}
