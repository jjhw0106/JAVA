package file_practice;

import java.util.Scanner;

public class Word_Searching {
	/*
	 * # 단어 검색
	 * 1. 단어를 입력받아 text변수 문장 속에 해당 단어가 있는지 검색한다.
	 * 2. 단어가 존재하면 true
	 *    단어가 없으면 false를 출력한다.
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		final int NUMBER = 5;

		int cnt = NUMBER;

		int num = sc.nextInt();

		System.out.println("문장 입력");
		String text = sc.nextLine(); // next()-> 띄어쓰기 x nextLine()-> 한줄 통으로 받음}
		System.out.println(text);
		String[] arr = text.split(" ");

		System.out.print("찾을 단어: ");
		String word = sc.next();

		int check = -1;
		for (int i = 0; i < arr.length; i++)
			if (arr[i].equals(word)) {
				check = 1;
				break;
			} else
				check = -1;
		if (check == 1)
			System.out.println(true);
		else
			System.out.println(false);

	}
}
