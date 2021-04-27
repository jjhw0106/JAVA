package wrapper;

public class WrapperClass2 {
	public static void main(String[] args) {
		// 오토박싱이 지원되기 때문에
		// 기본자료형 타입의 변수에 값을 대입하는 것과 Wrapper타입의 변수에 값을 대입하는 것이
		// 구분없이 사용할 수 있다
		String name = "홍길동";
		int age = 30;
		Double height = 180.4; // => Double height = new Double(180.4);
		double weight = 78.2;
		Boolean isMarried = false;
		Integer savedPoint = 10000;

		//오토언박싱이 지원되기 때문에
		//Wrapper타입의 배열에 기본자료형 값만 적어도 된다.
		Integer[] scores = { 100, 100, 80, 100, 50, 60, 70, 80, 50, 60 };

		int total1 = 0;
		for (Integer score : scores) {
			total1 += score; // 사칙연산자가 있는 경우 자동으로 오토언박싱 일어남.
		}
		int total2= 0;
		for (int score : scores) {
			total2 += score;
		}
	}
}