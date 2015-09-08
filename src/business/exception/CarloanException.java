package business.exception;

public class CarloanException extends Exception {
	public CarloanException(){}
	public CarloanException(String message) {
		super(message);
	}
	public void showError() {
		return;
	}
}
