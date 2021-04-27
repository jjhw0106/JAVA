package exception;

public class IDFormatTest {

	private String userId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) throws IDFormatException {

		if (userId == null) {
			throw new IDFormatException("아이디는 null일 수 없습니다.");
		} else if (userId.length() < 8 || userId.length() > 20)
			throw new IDFormatException("아이디는 8자이상 20자이하로 쓰세요");

		this.userId = userId;
	}

	public static void main(String[] args) {
		IDFormatTest idTest = new IDFormatTest();

		String myId = "123456";

		try {
			idTest.setUserId(myId);
		} catch (IDFormatException e) {
			System.out.println(e);
		}
	}
}
