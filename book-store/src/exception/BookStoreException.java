package exception;

@SuppressWarnings("serial")
public class BookStoreException extends RuntimeException {

	public BookStoreException(String message) {
		super(message);
	}
}
