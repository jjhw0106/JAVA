package interface_study;

public interface Calc {
	double PI = 3.14;
	int ERROR = -999999999;// 에러는 integer범위에서 안쓸것같은 숫자를 씀

	int add(int num1, int num2);

	int substract(int num1, int num2);

	int times(int num1, int num2);

	int divide(int num1, int num2);

	default void description() {
		System.out.println("정수 계산기를 구현합니다.");
		myMethod();
	}

	static int total(int[] arr) {
		int total = 0;

		for (int i : arr) {
			total += i;
		}
		return total;
	}
	
	private void myMethod() {
		System.out.println("private method");
	}
}
