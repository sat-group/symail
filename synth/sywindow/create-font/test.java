public boolean test() throws Throwable {
	java.awt.Font font = createFont("serif",java.awt.Font.PLAIN, 14);
	return (font.getName().equals("serif") &&
		font.getStyle() == java.awt.Font.PLAIN &&
		font.getSize() == 14);
}
