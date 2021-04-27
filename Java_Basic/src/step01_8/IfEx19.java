package step01_8;

import java.util.Random;
import java.util.Scanner;

public class IfEx19 {
	public static void main(String[] args) {
		Random ran = new Random();
		Scanner scan = new Scanner(System.in);

		int num1 = ran.nextInt(10) + 1;
		int num2 = ran.nextInt(10) + 1;
		int optr = ran.nextInt(4) + 1;
		int answer;
		int result = 0;

		if (optr == 1) {
			result = num1 + num2;
		}
		if (optr == 2) {
			result = num1 - num2;
		}
		if (optr == 3) {
			result = num1 * num2;
		}
		if (optr == 4) {
			result = num1 % num2;
		}
		System.out.printf("%.1f\n",3.141592);
		System.out.println(num1 + " ? " + num2 + " = " + result);
		System.out.println("1) +\n2) -\n3) *\n4) %");
		System.out.print("정답을 입력하세요: ");
		answer = scan.nextInt();

		if (answer == optr)
			System.out.println("정답");
		else
			System.out.println("오답");
	}
}
