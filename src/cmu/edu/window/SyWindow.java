package cmu.edu.window;

import java.io.IOException;

import javax.swing.JCheckBox;
import javax.swing.text.JTextComponent;

public class SyWindow {

	public static javax.swing.JFrame buildFrame(int width, int height, String title) {
		// *** [Begin] Code Synthesized by SyPet 2.0 ***
		javax.swing.JFrame var_0 = new javax.swing.JFrame(title);
		var_0.setSize(width, height);
		return var_0;
		// *** [End] Code Synthesized by SyPet 2.0 ***
	}

	public static javax.swing.JFrame setFrameAttributes(javax.swing.JFrame frame, int closeOperation,
			boolean resizable) {
		// *** [Begin] Code Synthesized by SyPet 2.0 ***
		frame.setDefaultCloseOperation(closeOperation);
		frame.setResizable(resizable);
		return frame;
		/// *** [End] Code Synthesized by SyPet 2.0 ***
	}

	public static javax.swing.JFrame setFrameVisible(javax.swing.JFrame frame, boolean visible) {
		// *** [Begin] Code Synthesized by SyPet 2.0 ***
		frame.setVisible(visible);
		return frame;
		// *** [End] Code Synthesized by SyPet 2.0 ***
	}

	public static javax.swing.JFrame setLocation(javax.swing.JFrame frame, int x, int y) {
		// *** [Begin] Code Synthesized by SyPet 2.0 ***
		frame.setLocation(x, y);
		return frame;
		// *** [End] Code Synthesized by SyPet 2.0 ***
	}

	public static javax.swing.JPanel buildBorder(int left, int right, int bottom, int top) {
		// *** [Begin] Code Synthesized by SyPet 2.0 ***
		javax.swing.border.EmptyBorder var_0 = new javax.swing.border.EmptyBorder(top, left, bottom, right);
		javax.swing.JPanel var_1 = new javax.swing.JPanel();
		var_1.setBorder(var_0);
		return var_1;
		// *** [End] Code Synthesized by SyPet 2.0 ***
	}

	public static javax.swing.JPanel buildGrid(javax.swing.JPanel panel, int cols, int rows) {
		// *** [Begin] Code Synthesized by SyPet 2.0 ***
		java.awt.GridLayout var_0 = new java.awt.GridLayout(rows, cols);
		panel.setLayout(var_0);
		return panel;
		// *** [End] Code Synthesized by SyPet 2.0 ***
	}

	public static javax.swing.JLabel buildImage(String path) throws IOException {
		// *** [Begin] Code Synthesized by SyPet 2.0 ***
		javax.swing.ImageIcon var_0 = new javax.swing.ImageIcon(path);
		javax.swing.JLabel var_1 = new javax.swing.JLabel(var_0);
		return var_1;
		// *** [End] Code Synthesized by SyPet 2.0 ***
	}

	public static javax.swing.JTextField buildTextField(String font, int style, int size) {
		// *** [Begin] Code Synthesized by SyPet 2.0 ***
		javax.swing.JTextField var_0 = new javax.swing.JTextField();
		java.awt.Font var_1 = new java.awt.Font(font, style, size);
		var_0.setFont(var_1);
		return var_0;
		// *** [End] Code Synthesized by SyPet 2.0 ***
	}

	public static javax.swing.JPasswordField buildPasswordField(String font, int style, int size) {
		// *** [Begin] Code Synthesized by SyPet 2.0 ***
		javax.swing.JPasswordField var_0 = new javax.swing.JPasswordField();
		java.awt.Font var_1 = new java.awt.Font(font, style, size);
		var_0.setFont(var_1);
		return var_0;
		// *** [End] Code Synthesized by SyPet 2.0 ***
	}

	public static javax.swing.JButton createButton(String name) {
		// *** [Begin] Code Synthesized by SyPet 2.0 ***
		javax.swing.JButton var_0 = new javax.swing.JButton(name);
		return var_0;
		// *** [End] Code Synthesized by SyPet 2.0 ***
	}

	public static java.awt.Font createFont(String font, int style, int size) {
		// *** [Begin] Code Synthesized by SyPet 2.0 ***
		java.awt.Font var_0 = new java.awt.Font(font, style, size);
		return var_0;
		// *** [End] Code Synthesized by SyPet 2.0 ***
	}

	public static javax.swing.JCheckBox createCheckBox(String text) {
		// *** [Begin] Code Synthesized by SyPet 2.0 ***
		JCheckBox var_0 = new JCheckBox(text);
		return var_0;
		// *** [End] Code Synthesized by SyPet 2.0 ***
	}
	
	public static javax.swing.JLabel setTextFont(javax.swing.JLabel label, String text, java.awt.Component component){
		// *** [Begin] Code Synthesized by SyPet 2.0 ***
		label.setText(text);
	    java.awt.Font var_0 = component.getFont();
	    label.setFont(var_0);
	    return label;
	 // *** [End] Code Synthesized by SyPet 2.0 ***
		
	}

}
