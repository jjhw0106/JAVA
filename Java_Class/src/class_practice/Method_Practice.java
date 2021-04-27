package class_practice;

// String.parseint(), String.split(), print(); nextInt(); length(); ...

// 메서드: 기능단위로 반복되는 '코드를 재활용'하는 것

// 정의: 
// 자료형 함수명(){}
// ㄴ void : 리턴할 자료형이 정해지지 않은 경우
// ㄴ return이 존재함

class Test {
	void sayHello(String a) { // parameter(=매개변수) 설계
		System.out.printf("%s야, 안녕", a);
		// return;
	}

	int myNum(int a, int b) {
		int num = 100;
		num = a + b;
		return num;
	}

}

public class Method_Practice { // 1) 변수, 2)메서드
	public static void main(String[] args) {

		Test t = new Test();

		// 호출
		// 함수명();
		t.sayHello("호원"); // 소괄호 안 값 = argument() = 전달인자

		int getNum = t.myNum(100, 200);
		System.out.println(getNum);

	}
}
