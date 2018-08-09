public boolean test() throws Throwable {
	javax.swing.JFrame frame = new javax.swing.JFrame("title");
	frame = setFrameVisible(frame, true);
	return (frame.isVisible() == true &&
			frame.getTitle().equals("title")); 
}
