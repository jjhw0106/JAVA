package exception;

@SuppressWarnings("serial")
public class OrderException extends BookStoreException {

	public OrderException(String message) {
		super(message);
	}
}
