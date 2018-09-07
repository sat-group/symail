package cmu.edu.test.swing;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import cmu.edu.window.SyWindow;

public class TestCreateLabel {
	
	@Test
	public void test1() {
		javax.swing.JLabel output = SyWindow.createLabel("To");
		assertTrue(output.getText().equals("To"));		
	}


}
