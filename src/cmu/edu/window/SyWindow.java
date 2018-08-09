package cmu.edu.window;

public class SyWindow {

	public static javax.swing.JFrame buildFrame(int width, int height, String title) {
		// *** [Begin] Code Synthesized by SyPet 2.0 ***
		javax.swing.JFrame var_0 = new javax.swing.JFrame(title);
		var_0.setSize(width, height);
		return var_0;
		// *** [End] Code Synthesized by SyPet 2.0 ***
	}

	public static javax.swing.JFrame setFrameAttributes(javax.swing.JFrame frame, int closeOperation,
			boolean resizable) {
		// *** [Begin] Code Synthesized by SyPet 2.0 ***
		frame.setDefaultCloseOperation(closeOperation);
		frame.setResizable(resizable);
		return frame;
		/// *** [End] Code Synthesized by SyPet 2.0 ***
	}

	public static javax.swing.JFrame setFrameVisible(javax.swing.JFrame frame, boolean visible) {
		// *** [Begin] Code Synthesized by SyPet 2.0 ***
		frame.setVisible(visible);
		return frame;
		// *** [End] Code Synthesized by SyPet 2.0 ***
	}

	public static javax.swing.JFrame setLocation(javax.swing.JFrame frame, int x, int y) {
		// *** [Begin] Code Synthesized by SyPet 2.0 ***
		frame.setLocation(x, y);
		return frame;
		// *** [End] Code Synthesized by SyPet 2.0 ***
	}

	public static javax.swing.JPanel buildBorder(int left, int right, int bottom, int top) {
		// *** [Begin] Code Synthesized by SyPet 2.0 ***
		javax.swing.border.EmptyBorder var_0 = new javax.swing.border.EmptyBorder(top, left, bottom, right);
		javax.swing.JPanel var_1 = new javax.swing.JPanel();
		var_1.setBorder(var_0);
		return var_1;
		// *** [End] Code Synthesized by SyPet 2.0 ***
	}

}
