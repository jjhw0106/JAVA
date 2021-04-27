package method_practice;

class TestReturn2 {
	int result;

	void plus1(int a, int b) {
		result = a + b;
	}

	int plus2(int a, int b) {
		return a + b;
	}
}

public class Return_2 {
	// 리턴의 사용방법 (2)
	// return 매서드를 사용하면 클래스내의 변수한개를 줄일수있다.
	// 굳이 쓰지않아도 프로그램 만드는데는 아무런지장이 없다.
	// 하지만 프로그래밍이 능숙해지면 자연히쓰게되는데
	// 리턴을 사용한 다른 사람이만든 프로그램등에 익숙해 지기위해서 억지로 연습을 해보겠다.

	// 리턴메서드 만드는법
	// 1) int ==> main 으로 보낼 자료형
	// 2) plus2(int a , int b) ==> 이름
	// 3) { return + 내보낼 값 } ==> 이값은 main 으로 보내진다.
	public static void main(String[] args) {
		TestReturn2 t2 = new TestReturn2();
		t2.plus1(5, 3);
		System.out.println(t2.result);
	}
}
