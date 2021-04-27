package method_practice;

import java.util.Scanner;

/*
 * # OMR카드 : 클래스 + 메서드
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

class OmrFunc {
	Scanner sc = new Scanner(System.in);
	int rightAnswer[] = { 5, 3, 2, 2, 4 };
	int cnt = rightAnswer.length;

	int[] myAnswer = new int[cnt];
	int[] check = new int[cnt];

	void getAnswer() {
		for (int i = 0; i < cnt; i++) {
			{
				System.out.print((i + 1) + "번 입력: ");
				int ans = sc.nextInt();
				myAnswer[i] = ans;
			}

		}
	}

	void checkAnswer() {

		for (int i = 0; i < cnt; i++) {
			if (rightAnswer[i] == myAnswer[i])
				check[i] = 1;
			else
				check[i] = 0;
		}
	}

	void showAnswer() {
		for (int i = 0; i < cnt; i++) {
			if (check[i] == 1)
				System.out.print("O" + " ");
			else
				System.out.print("X" + " ");
		}
	}

	void run() {
		getAnswer();
		checkAnswer();
		showAnswer();
	}
}

public class Omr {
	public static void main(String[] args) {
		OmrFunc e = new OmrFunc();
		e.run();
	}
}
