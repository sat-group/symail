package cmu.edu.test.swing;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import cmu.edu.window.SyWindow;

public class TestCreateJTextString {
	
	@Test
	public void test1() {
		javax.swing.JTextField jtext = SyWindow.createTextBuild("To",15);
		assertTrue(jtext.getColumns() == 15 && jtext.getText().equals("To"));		
	}

}
