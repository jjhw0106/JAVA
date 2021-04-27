package day6;

public class penApp {
	public static void main(String[] args) {
		// new Pen(); 오류 - 인터페이스로 객체 생성할 수 없다.
		// - 인터페이스는 완전한 설계도가 아니다.

		// Pen 인터페이스의 추상메소드를 재정의한 익명 클래스로 익명객체 만들기
		new Pen() {
			public void draw() {

			}

			public void clear() {

			}
		};

	}
}
