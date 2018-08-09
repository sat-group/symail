public boolean test1() throws Throwable {
	javax.swing.JFrame frame = buildFrame(350, 250, "foo");
	return (frame.getWidth() == 350 &&
		frame.getHeight() == 250 && 
		frame.getTitle().equals("foo"));
}

public boolean test2() throws Throwable {
	javax.swing.JFrame frame = buildFrame(750, 150, "bar");
	return (frame.getWidth() == 750 &&
		frame.getHeight() == 150 && 
		frame.getTitle().equals("bar"));
}

public boolean test() throws Throwable {
	return test1() && test2();
}
