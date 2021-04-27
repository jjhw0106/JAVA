package day5.inner;

public class Outer2App {
	public static void main(String[] args) {
		// 외부클래스에 대한 객체 생성없이 정적 내부 클래스를 사용할 수 있음 (by static)
		Outer2.Inner inner = new Outer2.Inner();
		inner.innerMethod();
		
		
		// 아래의 정적변수, 정적메소드처럼 정적내부클래스로 객체 생성할 수 있다.
		System.out.println("정적변수:"+ Outer2.y );
		Outer2.test2();
	}
}
