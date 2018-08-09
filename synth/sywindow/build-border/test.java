public boolean test() throws Throwable {
	javax.swing.JPanel panel = buildBorder(31, 32, 35, 36);
	javax.swing.border.EmptyBorder b = (javax.swing.border.EmptyBorder) panel.getBorder();
	int top = b.getBorderInsets().top;
	int bottom = b.getBorderInsets().bottom;
	int right = b.getBorderInsets().right;
	int left = b.getBorderInsets().left;
	return (top == 36 && bottom == 35 && left == 31 && right == 32);
}
