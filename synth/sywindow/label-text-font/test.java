public boolean test() throws Throwable {
	javax.swing.JLabel label = new javax.swing.JLabel();
	javax.swing.JTextField username = new javax.swing.JTextField();
	java.awt.Font var_1 = new java.awt.Font("serif", java.awt.Font.PLAIN, 18);
	username.setFont(var_1);
	javax.swing.JLabel output = setTextFont(label, "[ Username ]", username);
	return (output.getText().equals("[ Username ]") &&
		output.getFont().getName().equals("serif") &&
		output.getFont().getStyle() == java.awt.Font.PLAIN &&
		output.getFont().getSize() == 18);
}
