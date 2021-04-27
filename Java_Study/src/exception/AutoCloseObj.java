package exception;

public class AutoCloseObj implements AutoCloseable {
	public static void main(String[] args) {

	}

	@Override
	public void close() throws Exception {
		System.out.println("close()가 호출되었습니다.");
	}
}
