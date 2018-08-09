public boolean test() throws Throwable {
	javax.swing.JLabel image = buildImage("../img/logo.png");
	return (image.getIcon().getIconWidth() == 222 && 
		image.getIcon().getIconHeight() == 58);
}
