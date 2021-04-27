package day5.inner;

public class Outer1 {

	private int x = 10;
	private static int y = 20;

	public void test1() {
		System.out.println("test1() 실행");
	}

	public static void test2() {
		System.out.println("static test2() 실행");
	}

	public Inner getInner() {
		return new Inner();
	}

	
	// static 키워드가 붙어있지 않기 때문에 외부클래스가 생성되어야만 사용할 수 있다.
	class Inner {
		public void innerMethod() {
			System.out.println("외부클래스의 인스턴스 변수" + x);
			System.out.println("외부클래스의 정적 변수" + Outer1.y);
			test1();
			Outer1.test2(); //static이기 때문에 Outer1(클래스명)을 붙인다.(안붙여도 실행은 됨)
		}
	}
}
