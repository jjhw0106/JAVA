package exception;

@SuppressWarnings("serial")
public class TodoException extends RuntimeException {

	public TodoException(String message) {
		super(message);
	}
	public TodoException(Throwable cause) {
		super(cause);
	}
	public TodoException(String message, Throwable cause) {
		super(message, cause);
	}
}
