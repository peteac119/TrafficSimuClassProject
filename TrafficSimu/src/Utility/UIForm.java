package Utility;

import javax.swing.JOptionPane;

public final class UIForm {

	
	public void errorMessage(String message) {
		JOptionPane.showMessageDialog(null,message);
		
	}

	public String inputBox(String message) {
		String input = JOptionPane.showInputDialog(message);
		return input;
	}

	public void showMessage(String message) {
		JOptionPane.showMessageDialog(null,message);
		
	}

	public String exitBox(String message) {
		String input = JOptionPane.showInputDialog(message);
		return input;
	}
}
