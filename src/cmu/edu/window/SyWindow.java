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

import java.awt.Font;
import java.io.IOException;
import java.util.Vector;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

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
	
	public static javax.swing.JButton createButtonFont(String name, String font, int style, int size){
		javax.swing.JButton button = new javax.swing.JButton(name);
		java.awt.Font buttonFont = new java.awt.Font(font, style, size);
		button.setFont(buttonFont);
		return button;
	}
	
	public static javax.swing.JButton createButtonFontT(String name, java.awt.Font font){
		javax.swing.JButton button = new javax.swing.JButton(name);
		button.setFont(font);
		return button;
	}
	
	public static javax.swing.JCheckBox createCheckBoxFont(String name, String font, int style, int size){
		javax.swing.JCheckBox cbox = new javax.swing.JCheckBox(name);
		java.awt.Font buttonFont = new java.awt.Font(font, style, size);
		cbox.setFont(buttonFont);
		return cbox;
	}
	
	public static javax.swing.JCheckBox createCheckBoxFontT(String name, java.awt.Font font){
		javax.swing.JCheckBox cbox = new javax.swing.JCheckBox(name);
		cbox.setFont(font);
		return cbox;
	}
	
	public static java.awt.Dimension createDimension(int x, int y){
		java.awt.Dimension d = new java.awt.Dimension(x,y);
		return d;
	}
	
	public static javax.swing.JButton createButtonDimension(javax.swing.JButton bd, int x, int y){
		java.awt.Dimension d = new java.awt.Dimension(x,y);
		bd.setPreferredSize(d);
		return bd;
	}
	
	public static javax.swing.JButton createButtonFontDimension(String name, java.awt.Font font, int x, int y){
		javax.swing.JButton button = new javax.swing.JButton(name);
		button.setFont(font);
		java.awt.Dimension d = new java.awt.Dimension(x,y);
		button.setPreferredSize(d);
		return button;
	}
	
	// --- need to create tests 
	
	public static javax.swing.JScrollPane createScrollPane(java.awt.Component view, int v, int h, java.awt.Dimension d, boolean value){
		JScrollPane scroll = new JScrollPane(view, v, h);
		scroll.setEnabled(value);
		scroll.setPreferredSize(d);
		return scroll;
	}
	
	public static javax.swing.JScrollPane createScrollPane(java.awt.Component view, int v, int h, boolean value){
		JScrollPane scroll = new JScrollPane(view, v, h);
		scroll.setEnabled(value);
		return scroll;
	}
	
	public static javax.swing.JScrollPane createScrollPane(java.awt.Component view, int x, int y){
		JScrollPane scroll = new JScrollPane(view);
		java.awt.Dimension d = new java.awt.Dimension(x, y);
		scroll.setPreferredSize(d);
		return scroll;
	}
	
	public static JList<String> setJListProperties(JList<String> list, int width, int height, java.awt.Font font){
		list.setFixedCellWidth(width);
		list.setFixedCellHeight(height);
		list.setFont(font);
		return list;
	}
	
	public static JList<String> setJListProperties(JList<String> list, int width, int height){
		list.setFixedCellWidth(width);
		list.setFixedCellHeight(height);
		return list;
	}
	
	public static JList<String> setJListProperties(JList<String> list, java.awt.Font font){
		list.setFont(font);
		return list;
	}
	
	public static JComboBox<String> setJComboProperties(JComboBox<String> list, java.awt.Font font){
		list.setFont(font);
		return list;
	}
	
	
	public static javax.swing.JPanel buildGrid(int cols, int rows, int hgap, int vgap){
		javax.swing.JPanel panel = new javax.swing.JPanel();
		java.awt.GridLayout var_0 = new java.awt.GridLayout(rows, cols, hgap, vgap);
		panel.setLayout(var_0);
		return panel;
	}
	
	public static javax.swing.JLabel createLabel(String text){
		javax.swing.JLabel label = new javax.swing.JLabel();
		label.setText(text);
		return label;
	}
	
	public static javax.swing.JPanel buildGridFont(int cols, int rows, int hgap, int vgap, java.awt.Font font){
		javax.swing.JPanel panel = new javax.swing.JPanel();
		java.awt.GridLayout var_0 = new java.awt.GridLayout(rows, cols, hgap, vgap);
		panel.setLayout(var_0);
		panel.setFont(font);
		return panel;
	}
	
	public static javax.swing.JTextField createTextBuild(String text, int cols){
		javax.swing.JTextField jtext = new javax.swing.JTextField(text, cols);
		return jtext;
	}
	
	public static javax.swing.JTextField createTextBuild(int cols){
		javax.swing.JTextField jtext = new javax.swing.JTextField(cols);
		return jtext;
	}
	
	public static javax.swing.JTextField changeTextField(javax.swing.JTextField jtext, String text){
		jtext.setText(text);
		return jtext;
	}
	
	public static javax.swing.JTextArea createTextArea(java.awt.Font font, boolean wrap, boolean wrapstyle, java.awt.Color color){
		javax.swing.JTextArea area = new javax.swing.JTextArea();
		area.setFont(font);
		area.setLineWrap(wrap);
		area.setWrapStyleWord(wrapstyle);
		area.setBackground(color);
		return area;
	}
	
	public static java.awt.Color createColor(int r, int g, int b){
		java.awt.Color color = new java.awt.Color(r, g, b);
		return color;
	}
	
	public static javax.swing.JTable createTable(String[][] data, String[] columns, Font font){
		javax.swing.JTable  jt = new javax.swing.JTable(data, columns);
		jt.setFont(font);
		return jt;
	}
	
	public static javax.swing.JTable createTable(String[][] data, String[] columns, Font font, int selection){
		javax.swing.JTable  jt = new javax.swing.JTable(data, columns);
		jt.setFont(font);
		jt.setSelectionMode(selection);
		return jt;
	}
	
	public static javax.swing.table.DefaultTableModel createTableModel(String[][] data, String[] columns){
		javax.swing.table.DefaultTableModel dt = new javax.swing.table.DefaultTableModel(data, columns);
		return dt;
	}
	
	public static javax.swing.JTable createTableModel(javax.swing.JTable table, String[][] data, String[] columns){
		javax.swing.table.DefaultTableModel dt = new javax.swing.table.DefaultTableModel(data, columns);
		table.setModel(dt);
		return table;
	}
	
	

}
