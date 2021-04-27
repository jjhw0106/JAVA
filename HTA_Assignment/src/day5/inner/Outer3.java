package day5.inner;

public class Outer3 {
	private int x = 10;
	private static int y = 20;

	public void test1() {
		System.out.println("외부클래스의 인스턴스 메소드 test21() 실행");
	}

	static public void test2() {
		System.out.println("외부클래스의 정적 메소드 test1() 실행");
	}

	public void test3() {
		int a = 10;
		int b = 20;
		final int c = 30;

		// 로컬 내부 클래스
		// 외부 클래스의 모든 변수, 메소드 사용가능
		// but,내부클래스를 포함하고 있는 메소드의 변수 중
		// 값의 변경이 한번이라도 있는 변수는 사용 불가
		// 사용빈도 매우 낮음
		// final로 선언된 변수나, 메소드가 끝날 때 까지 값이 변하지 않는 것만 사용가능

		
		//원래는 메소드는 다른 메소드의 메소드 또는 변수를 사용할 수 없음
		//but
		class Inner {	//객체가 선언된 메소드 안에서만 생성 및 활용 할 수 있다.
						//외부클래스의 a,b,c가 test3메소드의 실행과 동시에 inner클래스 안으로 복사된다.
			public void innerMethod() {
				System.out.println("외부클래스의 인스턴스 변수" + x);
				System.out.println("외부클래스의 정적 변수" + Outer3.y);
				test1();
				Outer3.test2();

				System.out.println(a);
//				System.out.println(b); // inner클래스는 메소드 호출과 동시에 메모리에 로드되기 때문에, 
									   // 뒤에서 값이 변경되더라도 허락되지 않는다. 
				System.out.println(c);
			}
		}
		Inner inner = new Inner();
		inner.innerMethod();
		
		b=50;  
	}
}
