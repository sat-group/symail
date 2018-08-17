/**
 * BSD 3-Clause License
 *	
 *	
 *	Copyright (c) 2018, SyMail - SyPet 2.0, Ruben Martins
 *	All rights reserved.
 *	
 *	Redistribution and use in source and binary forms, with or without
 *	modification, are permitted provided that the following conditions are met:
 *	
 *	* Redistributions of source code must retain the above copyright notice, this
 *	  list of conditions and the following disclaimer.
 *	
 *	* Redistributions in binary form must reproduce the above copyright notice,
 *	  this list of conditions and the following disclaimer in the documentation
 *	  and/or other materials provided with the distribution.
 *	
 *	* Neither the name of the copyright holder nor the names of its
 *	  contributors may be used to endorse or promote products derived from
 *	  this software without specific prior written permission.
 *	
 *	THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 *	AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 *	IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 *	DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 *	FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 *	DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 *	SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 *	CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 *	OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 *	OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package cmu.edu.warning;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import cmu.edu.composition.SyWindowComposition;
import cmu.edu.window.SyWindow;

public class SyWarningWindow {

	public static void GmailFailure(String username) {
		Font font = SyWindow.createFont("serif", Font.PLAIN, 18);
		JPanel panel = null;
		;
		try {
			panel = SyWindowComposition.buildWarningWindow("./img/warning.png",
					"Invalid GMail address:" + username, font);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		Object[] options = { "OK" };
		JOptionPane.showOptionDialog(null, panel, "SyMail - ERROR", JOptionPane.OK_OPTION, JOptionPane.PLAIN_MESSAGE,
				null, options, null);

	}

	public static void InternetCheck() {
		Font font = SyWindow.createFont("serif", Font.PLAIN, 18);
		JPanel panel = null;
		try {
			panel = SyWindowComposition.buildWarningWindow("./img/warning.png", "No internet connection.", font);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		Object[] options = { "OK" };
		JOptionPane.showOptionDialog(null, panel, "SyMail - ERROR", JOptionPane.OK_OPTION, JOptionPane.PLAIN_MESSAGE,
				null, options, null);
	}

	public static void EmailFailure() {
		Font font = SyWindow.createFont("serif", Font.PLAIN, 18);
		JPanel panel = null;
		try {
			panel = SyWindowComposition.buildWarningWindow("./img/warning.png", "Email was not sent successfully.",
					font);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		Object[] options = { "OK" };
		JOptionPane.showOptionDialog(null, panel, "SyMail - ERROR", JOptionPane.OK_OPTION, JOptionPane.PLAIN_MESSAGE,
				null, options, null);
	}

	public static void PasswordCheck() {
		Font font = SyWindow.createFont("serif", Font.PLAIN, 18);
		JPanel panel = null;
		try {
			panel = SyWindowComposition.buildWarningWindow("./img/warning.png", "Wrong username/password.", font);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		Object[] options = { "OK" };
		JOptionPane.showOptionDialog(null, panel, "SyMail - ERROR", JOptionPane.OK_OPTION, JOptionPane.PLAIN_MESSAGE,
				null, options, null);
	}

}
