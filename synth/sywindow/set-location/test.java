public boolean test() throws Throwable {
	javax.swing.JFrame frame = new javax.swing.JFrame("title");
	frame = setLocation(frame, 200, 300);
	return (frame.getLocation().getX() == 200 &&
		frame.getLocation().getY() == 300 && 
		frame.getTitle().equals("title"));
}
