package Innerclass;

class Outer2 {
	int outNum = 100;
	static int sNum = 200;

	Runnable getRunnable(final int i) {	//클래스의 이름을 생략해줌
		//익명이너클래스는 인터페이스나, 추상클래스의 생성을 바로 할 수 있음.//클래스 상속, 생성 할 필요 없이

		final int num = 100;
		return new Runnable() {
			@Override
			public void run() {
				System.out.println(outNum);
				System.out.println(Outer2.sNum);
			}
		};
	}
}

public class AnonymousInnerClass {
	public static void main(String[] args) {
		Outer2 outer = new Outer2();
		Runnable runnable = outer.getRunnable(10);
		runnable.run();
	}
}
