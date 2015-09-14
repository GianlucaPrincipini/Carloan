package business.exception;

public class UnmodifiableEntityException extends IntegrityException {
	public UnmodifiableEntityException(String string) {
		super(string);
	}

}
