package file_practice;

import java.util.Scanner;
import java.util.Random;

public class String_Compare {
	public static void main(String[] args) {
		/*
		 * # 문자열 비교
		 * . equals() 메서드 사용없이 문자의 일치여부 비교
		 * 예)
		 * 코끼리
		 * 입력 = 티라노사우루스
		 * 출력 = false
		 */
		Scanner sc = new Scanner(System.in);

		String word = "코끼리";

//		for (int i = 0; i < word.length(); i++) {
//			int num = word.charAt(i);
//			System.out.println(num);
//		}

		System.out.println(word);
		System.out.print("입력: ");
		String getStr = sc.next();
		int check = 0;
		for (int i = 0; i < getStr.length(); i++) {
			if (getStr.charAt(i) == word.charAt(i))
				check += 1;
			else {
				break;
			}
		}
		if (check == word.length())
			System.out.println("정답입니다.");
		else
			System.out.println("틀렸습니다.");
	}
}
