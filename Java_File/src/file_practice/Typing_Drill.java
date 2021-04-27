package file_practice;

import java.util.Scanner;
import java.util.Random;

public class Typing_Drill {

	/*
	 * # 타자연습 게임[2단계]
	 * 1. 문제를 섞는다.(shuffle)
	 * 2. 순서대로 문제를 출제하고, 문제를 다 맞추면 게임 종료
	 * 3. 단 문제를 출제할 때, 단어의 랜덤한 위치 한 곳만 *로 출력
	 * 예)
	 * 문제 : mys*l
	 * 입력 : mysql	<--- 정답을 맞추면, 다음 문제 제시
	 * 문제 : *sp
	 * 입력 : jsp
	 * ...
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random ran = new Random();

		String[] words = { "java", "mysql", "jsp", "spring" };

		// java
		// 0123
		// rIdx : 1
		// * /

//		int rIdx = ran.nextInt(words[0].length()); // 0-3
//		for (int i = 0; i < words[0].length(); i++) {
//			if (i == rIdx)
//				System.out.print("*");
//			else
//				System.out.print(words[0].charAt(i));
//		}
//		int[] temp = new int[words.length];

		// 2차 풀이 (substring이 아닌 charAt로 풀이)
//		순서 셔플
		int ranOrder = ran.nextInt(words.length);
		int ranIdx = ran.nextInt(words[ranOrder].length());

//		답 받기
		int check = -1;
		while (check == -1) {
			System.out.print("문제: ");
			for (int i = 0; i < words[ranOrder].length(); i++) {
				if (i == ranIdx)
					System.out.print("*");
				else {
					System.out.print(words[ranOrder].charAt(i));
				}
			}

			System.out.println("\n정답: ");
			String answer = sc.next();
			if (answer.equals(words[ranOrder]))
				check = 1;
		}
//		1차 풀이
//		// 문제 순서 셔플
//		for (int i = 0; i < words.length; i++) {
//			int idx = ran.nextInt(words.length);
//			temp[i] = idx;
//			for (int j = 0; j < i; j++) {
//				if (temp[j] == idx)
//					i--;
//			}
//		}
//
//		// 문제 출력
//		int count = 0;
//		while (count < words.length) {
//			int star = ran.nextInt(words[count].length());	//가릴 위치 랜덤
//			System.out.print(words[temp[count]].substring(0, star) + "*" + words[temp[count]].substring(star + 1));
//		
//			// 정답 입력
//			System.out.print("입력:");
//			String typing = sc.next();
//			if (typing.equals(words[temp[count]]))
//				count++;
//			else
//				continue;
//		}
//
//		System.out.println("다 맞추셨습니다.");

	}
}