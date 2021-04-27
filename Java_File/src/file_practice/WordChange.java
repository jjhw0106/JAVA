package file_practice;

import java.util.Scanner;

public class WordChange {
	/*
	 * # 단어 교체하기(replace)
	 * 1. text변수 문장 속에서 변경하고 싶은 단어를 입력받아,
	 * 2. 교체해주는 기능을 구현한다.
	 * 예)
	 * 		Life is too short.
	 * 		변경하고 싶은 단어입력 : Life
	 * 		바꿀 단어입력 : Time
	 * 
	 * 		Time is too short.
	 */

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String text = "Life is too short.";
		String[] arr = text.split(" ");

		boolean run = true;

		while (run) {

			System.out.println(text);

			System.out.print("변경하고 싶은 단어를 입력하세요 : ");
			String word = sc.next();

			int check = 0;
			for (int i = 0; i < arr.length; i++)
				if (arr[i].equals(word)) {
					System.out.print("무슨단어로 바꾸시겠습니까: ");
					String newWord = sc.next();
					arr[i] = newWord;
					run = false;
					check = 1;
					break;
				}

				else {
					check = -1;
				}
			if(check == -1)
			System.out.println("없는 단어입니다");

		}
		text = "";
		for (int i = 0; i < arr.length; i++)
			text += arr[i] + " ";
		System.out.println(text);

	}
}
