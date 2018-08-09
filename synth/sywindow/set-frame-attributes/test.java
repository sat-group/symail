public boolean test() throws Throwable {
	javax.swing.JFrame frame = new javax.swing.JFrame("title");
	frame = setFrameAttributes(frame, javax.swing.JFrame.EXIT_ON_CLOSE, false);
	return (frame.getDefaultCloseOperation() == javax.swing.JFrame.EXIT_ON_CLOSE &&
			frame.isResizable() == false &&
			frame.getTitle().equals("title")); 
}
