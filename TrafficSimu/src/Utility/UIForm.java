package Utility;

import javax.swing.JOptionPane;

/**
 * This class will return all types of dialog that are necessary for this program.
 * @author pichan vasantakitkumjorn
 *
 */

public final class UIForm {
	
	/**
	 * Show error message dialog.
	 * @param message
	 */
	public void errorMessage(String message) {
		JOptionPane.showMessageDialog(null,message);
	}
	/**
	 * Show input dialog and return user input.
	 * @param message
	 * @return String
	 */
	public String inputBox(String message) {
		String input = JOptionPane.showInputDialog(message);
		return input;
	}
	/**
	 * Show main and sub menu.
	 * @param message
	 */
	public void showMessage(String message) {
		JOptionPane.showMessageDialog(null,message);
		
	}
	/**
	 * Show exit menu and confirm with user.
	 * 
	 * @param message
	 * @return String.
	 */
	public String exitBox(String message) {
		String input = JOptionPane.showInputDialog(message);
		return input;
	}
}
