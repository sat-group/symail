package cmu.edu.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import cmu.edu.window.SyWindow;

public class TestPanelImage {
	
	@Test
	public void test1() throws Throwable {
		javax.swing.JLabel image = SyWindow.buildImage("./img/logo.png");
		assertTrue (image.getIcon().getIconWidth() == 222 && 
				image.getIcon().getIconHeight() == 58);
	}

}
