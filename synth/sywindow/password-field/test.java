public boolean test() throws Throwable {
	javax.swing.JPasswordField text = buildPasswordField("serif", java.awt.Font.PLAIN, 18);
	return (text.getFont().getStyle() == java.awt.Font.PLAIN &&
		text.getFont().getName().equals("serif") &&
		text.getFont().getSize() == 18);
}
