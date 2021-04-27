package exception;

public class AutoCloseTest {
	public static void main(String[] args) {
		try (AutoCloseObj obj = new AutoCloseObj()) {
			throw new Exception();// 강제로 예외발생시키기
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
