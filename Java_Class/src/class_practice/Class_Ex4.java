package class_practice;

import java.util.Random;
import java.util.Scanner;

class Ex04 {
	int[] hakbuns = { 1001, 1002, 1003, 1004, 1005 };
	int[] scores = new int[5];
}

public class Class_Ex4 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// 문제1) scores배열에 1~100점 사이의 정수를 5개 저장
		// 예 1) 87, 11, 92, 14, 47
		Ex04 e = new Ex04();
		e.scores[0] = 87;
		e.scores[1] = 11;
		e.scores[2] = 92;
		e.scores[3] = 14;
		e.scores[4] = 47;

		// 문제2) 전교생의 총점과 평균 출력
		// 예 2) 총점(251) 평균(50.2)

		int sum = 0;
		for (int i = 0; i < e.hakbuns.length; i++)
			sum += e.scores[i];
		System.out.println("총점: " + sum + "," + "평균: " + sum / e.hakbuns.length);

		// 문제3) 성적이 60점 이상이면 합격. 합격생 수 출력
		// 예 3) 2명

		int cnt = 0;
		for (int i = 0; i < e.hakbuns.length; i++)
			if (e.scores[i] >= 60)
				cnt++;

		System.out.println("합격생:" + cnt);
		// 문제4) 인덱스를 입력받아 성적 출력
		// 정답4) 인덱스 입력 : 1 성적 : 11점
		System.out.print("idx: ");
		int idx = sc.nextInt();
		System.out.println(e.scores[idx]);

		// 문제5) 성적을 입력받아 인덱스 출력
		// 정답5) 성적 입력 : 11 인덱스 : 1
		System.out.print("성적: ");
		int score = sc.nextInt();
		for (int i = 0; i < e.scores.length; i++)
			if (score == e.scores[i]) {
				idx = i;
				break;
			}
		System.out.println("idx: " + idx);

		// 문제6) 학번을 입력받아 성적 출력
		// 정답6) 학번 입력 : 1003 성적 : 45점

		// 문제7) 학번을 입력받아 성적 출력
		// 단, 없는학번 입력 시 예외처리
		// 예 7)
		// 학번 입력 : 1002 성적 : 11점
		// 학번 입력 : 1000 해당학번은 존재하지 않습니다.
		int getHB;
		int checkHB = -1;
		while (checkHB != 1) {
			System.out.print("학번: ");
			getHB = sc.nextInt();
			for (int i = 0; i < e.scores.length; i++) {
				if (e.hakbuns[i] == getHB) {
					checkHB = 1;
					break;
				}
			}
			for (int i = 0; i < e.scores.length; i++)
				if (e.hakbuns[i] == getHB)
					System.out.println(e.hakbuns[i] + "의 점수는: " + e.scores[i]);
		}
		// 문제8) 1등학생의 학번과 성적 출력
		// 정답8) 1004번(98점)
		int high = e.scores[0];
		int highIdx = 0;
		for (int i = 0; i < e.scores.length; i++)
			if (high < e.scores[i]) {
				high = e.scores[i];
				highIdx = i;
			}
		System.out.println("학번: " + e.hakbuns[highIdx] + "점수: " + high);

	}

}
