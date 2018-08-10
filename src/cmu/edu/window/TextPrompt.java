package cmu.edu.window;

import java.awt.BorderLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JLabel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;
import javax.swing.text.JTextComponent;

public class TextPrompt extends JLabel implements FocusListener, DocumentListener {

	private static final long serialVersionUID = 1L;
	private JTextComponent component;
	private Document document;

	private boolean showPromptOnce;
	private int focusLost;

	public TextPrompt(String text, JTextComponent component) {
		this.component = component;
		document = component.getDocument();

		SyWindow.setTextFont(this, text, component);

		component.addFocusListener(this);
		document.addDocumentListener(this);

		component.setLayout(new BorderLayout());
		component.add(this);
		checkForPrompt();
	}

	/**
	 * Check whether the prompt should be visible or not. The visibility will change
	 * on updates to the Document and on focus changes.
	 */
	private void checkForPrompt() {
		// Text has been entered, remove the prompt
		if (document.getLength() > 0) {
			setVisible(false);
			return;
		}

		// Prompt has already been shown once, remove it
		if (showPromptOnce && focusLost > 0) {
			setVisible(false);
			return;
		}

		// Check the Show property and component focus to determine if the
		// prompt should be displayed.
		if (component.hasFocus()) {
			setVisible(true);

		}
	}

	// Implement FocusListener
	public void focusGained(FocusEvent e) {
		checkForPrompt();
	}

	public void focusLost(FocusEvent e) {
		focusLost++;
		checkForPrompt();
	}

	// Implement DocumentListener
	public void insertUpdate(DocumentEvent e) {
		checkForPrompt();
	}

	public void removeUpdate(DocumentEvent e) {
		checkForPrompt();
	}

	public void changedUpdate(DocumentEvent e) {
	}
}