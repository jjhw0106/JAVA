package wrapper;

public class WrapperApp {
	public static void main(String[] args) {

//		오토박싱: 변수의 타입이 Wrapper클래스 타입일 때 자동으로 해당 기본자료형과 
//		대응되는 객체가 생성되고 그 객체에 값이 저장되는 것
		Integer a1 = 100;
		double a2 = 3.14;
		Boolean a3 = true;

//		오토언박싱: 변수의 타입이 기본자료형 타입일 때
//		Wrapper타입의 객체에서 기본자료형값만 가져오는 것
		int x1 = a1; // a1의 Wrapper객체에 대한 참조변수다.
//		a1이 참조하는 wrapper객체에 저장된 값만 가자ㅕ와서
//		변수 x1에 대입된다.

		double x2 = a2;
		boolean x3 = a3;
	}
}



