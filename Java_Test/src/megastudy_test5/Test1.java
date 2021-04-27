package megastudy_test5;

//5분
public class Test1 {

	public static void main(String[] args) {
		String data = "123/46";

		// 위 수의 합을 구하시요 .

		int sum = 0;
		int num1 = 0;
		int num2 = 0;

		String[] arr = data.split("/");// q. +는 사용x??

		num1 = Integer.parseInt(data.substring(0, 3));
		num2 = Integer.parseInt(data.substring(4));
		sum = num1 + num2;
		System.out.println(sum);
	}
}