package class_practice;

import java.util.Scanner;

class Ex06 {
	int[] answer = { 1, 3, 4, 2, 5 }; // 시험답안
	int[] hgd = new int[5]; // 학생답안

	int cnt = 0; // 정답 맞춘 개수
	int score = 0; // 성적
}

public class Class_Ex6 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Ex06 omr = new Ex06();
		/*
		 * # OMR카드 : 클래스 + 변수
		 * 1. 배열 answer는 시험문제의 정답지이다.
		 * 2. 배열 hgd에 1~5 사이의 랜덤 숫자 5개를 저장한다.
		 * 3. answer와 hgd 값을 비교해 정오표를 출력한다.
		 * 4. 한 문제당 20점이다.
		 * 예)
		 * answer = {1, 3, 4, 2, 5}
		 * hgd    = {1, 1, 4, 4, 3}
		 * 정오표     = {O, X, O, X, X}
		 * 성적        = 40점
		 */
		int myAnswer;
		int cntA = 0;
		for (int i = 0; i < omr.answer.length; i++) {
			System.out.println((cntA + 1) + "번 정답입력: ");
			myAnswer = sc.nextInt();
			if (myAnswer <= 0 || myAnswer > 5) {
				i--;
				continue;
			}
			omr.hgd[cntA] = myAnswer;
			cntA++;
		}

		String aCheck[] = new String[omr.hgd.length];
		for (int i = 0; i < omr.answer.length; i++)
			if (omr.answer[i] == omr.hgd[i]) {
				omr.cnt++;
				omr.score = 20 * omr.cnt;
				aCheck[i] = "O";
			} else
				aCheck[i] = "X";
		for (int i = 0; i < aCheck.length; i++)
			System.out.print(aCheck[i] + " ");
		System.out.println();
		System.out.println("성적은: " + omr.score);

	}
}
