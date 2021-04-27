package day5.inner;

public class Outer2 {
	private int x = 10;
	/* private */static int y = 20;

	public void test1() {
		System.out.println("외부클래스의 인스턴스 메소드 test1() 실행");
	}

	public static void test2() {
		System.out.println("외부클래스의 정적 메소드 test2() 실행");
	}

	// 정적 내부 클래스
	// 외부 클래스의 객체 생성 전에도 정적 내부클래스로 객체 생성

	public static void test3() {
//		InstanceInner inner1 = new InstanceInner(); //정적 메소드에서는 정적 내부 클래스만 사용가능
		Inner inner2 = new Inner();
		inner2.innerMethod();
	}

	static class Inner {
		public void innerMethod() {
//			System.out.println("외부 클래스의 인스턴스 변수" + x); 
			// 변수 x가 static이아니기 때문에 x에 접근 불가
			System.out.println("외부 클래스의 정적 변수" + Outer2.y);
		}
	}
}
