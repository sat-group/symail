package cmu.edu.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import cmu.edu.window.SyWindow;

public class TestCreateCheckBox {
	
	@Test
	public void test1() {
		javax.swing.JCheckBox cbox = SyWindow.createCheckBox("Offline mode");
		assertTrue(cbox.getText().equals("Offline mode"));		
	}


}
