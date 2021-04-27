package Innerclass;

import Innerclass.OutClass.InStaticClass;

class OutClass { // 외부클래스
	private int num = 10;
	private static int sNum = 20;
	private InClass inClass;

	public OutClass() {
		inClass = new InClass();
	}

	class InClass { // 내부클래스
		int iNum = 100;

		void inTest() {
			System.out.println(num); // outClass의 프라이빗 변수 사용가능
			System.out.println(sNum);
		}
	}

	public void usingInner() { // 프라이빗이므로 외부 클래스에서 InClass 객체의 메소드를 갖다 쓸 수 없음.
								// 그렇기 때문에 메서드를 따로 만들어서 사용한다.
		inClass.inTest();
	}

	static class InStaticClass { // outter클래스가 먼저 생성되지 않아도 사용가능하다(스태틱이므로)
		int inNum = 100;
		static int sInNum = 200;

		void inTest() {
			System.out.println(inNum);
			System.out.println(sInNum);
			System.out.println(sNum);
		}

		static void sTest() {
//			System.out.println(inNum);	//inNum은 클래스가 생성된 이후 생성된 변수이기 때문에 스태틱 메서드에서는 사용불가
			System.out.println(sInNum);
			System.out.println(sNum);
		}
	}

}

public class InnerTest {
	public static void main(String[] args) {
//		OutClass oc = new OutClass();
//		oc.usingInner();

		OutClass.InStaticClass.sTest();

	}
}
