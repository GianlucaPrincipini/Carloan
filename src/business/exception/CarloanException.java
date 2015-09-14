package business.exception;

import presentation.gui.CarloanMessage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class CarloanException extends Exception {
	public CarloanException(){}
	public CarloanException(String message) {
		super(message);
	}
	public void showError() {
		CarloanMessage.showMessage(AlertType.ERROR, getMessage());
		return;
	}
}
