public boolean test() throws Throwable {
	javax.swing.JCheckBox cbox = createCheckBox("Offline mode");
	return (cbox.getText().equals("Offline mode"));
}
