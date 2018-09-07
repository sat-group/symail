package cmu.edu.test.swing;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import cmu.edu.window.SyWindow;

public class TestChangeJText {
	
	@Test
	public void test1() {
		javax.swing.JTextField jtext = new javax.swing.JTextField(15);
		javax.swing.JTextField jtext2 = SyWindow.changeTextField(jtext, "To");
		assertTrue(jtext2.getColumns() == 15 && jtext.getText().equals("To"));		
	}

}
