package Innerclass;

class Outer {
	int outNum = 100;
	static int sNum = 200;

	Runnable getRunnable(final int i) { // Runnable을 반환하는 메서드

		final int num = 100;
		class MyRunnable implements Runnable {
			@Override
			public void run() {

				// 지역변수는 해당 메서드가 호출돼서 끝날 때 까지만 유효하다=>그러나,
				// myRunnable이 종료되고 나서도 run() 메서드는 언제든지 호출될 수 있다.
				// 그렇기 때문에 로컬변수인 아래의 num, i 는 사용 못한다.
				// 또한 내부클래스를 갖는 메서드이 멤버들은 상수처리 된다.(final)->안써도 됨
				// 따라서, 참조는 되지만 수정은 안됨.
				System.out.println(outNum);
				System.out.println(Outer.sNum);
			}
		}

		return new MyRunnable();
	}
}

public class LocalInnerClassTest {
	public static void main(String[] args) {
		Outer outer = new Outer();
		Runnable runnable = outer.getRunnable(10);
		runnable.run();
	}
}
