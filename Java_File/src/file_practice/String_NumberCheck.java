package file_practice;

import java.util.Scanner;

public class String_NumberCheck {
	/*
	 * # 문자열 속 숫자검사
	 * 예) adklajsiod
	 * 	  문자만 있다.
	 * 예) 123123
	 *    숫자만 있다.
	 * 예) dasd12312asd
	 *    문자와 숫자가 섞여있다.
	 */

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("입력 : ");
		String text = sc.next();

		int checkNum = 0;
		int checkChar = 0;

		int[] check = new int[text.length()];
		for (int i = 0; i < text.length(); i++)
			check[i] = text.charAt(i);

//		System.out.println(check[1]);
		for (int i = 0; i < text.length(); i++) {
			if ((int) check[i] > 47 && (int) check[i] < 58) {
				checkNum = 1;
			}

			else
				checkChar = 1;
		}

		if (checkNum == 1 && checkChar == 1)
			System.out.println("문자 숫자 섞여있다");
		else if (checkNum == 1 && checkChar != 1)
			System.out.println("숫자만");
		else if (checkNum != 1 && checkChar == 1)
			System.out.println("문자만");
	}
}
