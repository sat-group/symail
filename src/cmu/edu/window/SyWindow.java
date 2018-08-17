/**
 * BSD 3-Clause License
 *	
 *	
 *	Copyright (c) 2018, SyMail - SyPet 2.0, Ruben Martins
 *	All rights reserved.
 *	
 *	Redistribution and use in source and binary forms, with or without
 *	modification, are permitted provided that the following conditions are met:
 *	
 *	* Redistributions of source code must retain the above copyright notice, this
 *	  list of conditions and the following disclaimer.
 *	
 *	* Redistributions in binary form must reproduce the above copyright notice,
 *	  this list of conditions and the following disclaimer in the documentation
 *	  and/or other materials provided with the distribution.
 *	
 *	* Neither the name of the copyright holder nor the names of its
 *	  contributors may be used to endorse or promote products derived from
 *	  this software without specific prior written permission.
 *	
 *	THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 *	AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 *	IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 *	DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 *	FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 *	DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 *	SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 *	CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 *	OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 *	OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package cmu.edu.window;

import java.io.IOException;

import javax.swing.JCheckBox;

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
	
	public static javax.swing.JLabel setTextFontComponent(javax.swing.JLabel label, String text, java.awt.Component component){
		// *** [Begin] Code Synthesized by SyPet 2.0 ***
		label.setText(text);
	    java.awt.Font var_0 = component.getFont();
	    label.setFont(var_0);
	    return label;
	 // *** [End] Code Synthesized by SyPet 2.0 ***
	}
	
	public static javax.swing.JLabel setTextFont(javax.swing.JLabel label, String text, java.awt.Font font){
		// *** [Begin] Code Synthesized by SyPet 2.0 ***
		label.setText(text);
	    label.setFont(font);
	    return label;
	 // *** [End] Code Synthesized by SyPet 2.0 ***
		
	}

}
