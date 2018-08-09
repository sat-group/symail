public boolean test() throws Throwable {
	javax.swing.JPanel panel = new javax.swing.JPanel();
	javax.swing.JPanel gridPanel = buildGrid(panel, 1, 5);
	java.awt.GridLayout gl = (java.awt.GridLayout) gridPanel.getLayout();
	return (gl.getColumns() == 1 && gl.getRows() == 5);
}
