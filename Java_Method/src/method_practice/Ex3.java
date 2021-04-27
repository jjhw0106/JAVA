package method_practice;

import java.util.Random;
import java.util.Scanner;

class Test3 {
	Random ran = new Random();
	Scanner sc = new Scanner(System.in);

	void getRan(int num[]) {
		for (int i = 0; i < num.length; i++) {
			num[i] = ran.nextInt(100) + 1;
			System.out.print(num[i] + " ");
		}
		System.out.println();

	}

	void averageScore(int score[]) {
		int sum = 0;
		int average = 0;
		for (int i = 0; i < score.length; i++)
			sum += score[i];
		System.out.print("총점: " + sum);
		System.out.println("평균: " + sum / score.length);
	}

	void passCheck(int score[]) {
		int cnt = 0;
		for (int i = 0; i < score.length; i++)
			if (score[i] >= 60) {
				cnt++;
			}
		System.out.println("합격자: " + cnt + "명");
	}

	void getIdx(int score[], int idx) {
		System.out.println("점수: " + score[idx]);
	}

	void scoreForIdx(int score[], int getNum) {
		for (int i = 0; i < score.length; i++)
			if (score[i] == getNum)
				System.out.println("idx: " + i);
	}

	int hakbunForScore(int scores[], int hakbuns[], int hakbun) {
		int idx = -1;
		while (true) {
			for (int i = 0; i < hakbuns.length; i++)
				if (hakbuns[i] == hakbun) {
					idx = i;
					break;
				}
			if (idx == -1) {
				System.out.println("잘못된 학번입니다.");
				break;
			}
			System.out.println(hakbun + "의 점수: " + scores[idx]);
			break;
		}
		return idx;
	}

	void theFirst(int scores[], int hakbuns[]) {
		int max = scores[0];
		int maxIdx = 0;
		for (int i = 0; i < scores.length; i++)
			if (max < scores[i]) {
				max = scores[i];
				maxIdx = i;
			}
		System.out.println(hakbuns[maxIdx] + "의 점수는" + scores[maxIdx]);
	}
}

public class Ex3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Test3 test = new Test3();

		int[] hakbuns = { 1001, 1002, 1003, 1004, 1005 };
		int[] scores = new int[5];

		// 문제1) scores배열에 1~100점 사이의 랜덤 정수를 5개 저장
		// 예 1) 87, 11, 92, 14, 47
		test.getRan(scores);

		// 문제2) 전교생의 총점과 평균 출력
		// 예 2) 총점(251) 평균(50.2)
		test.averageScore(scores);

		// 문제3) 성적이 60점 이상이면 합격. 합격생 수 출력
		// 예 3) 2명
		test.passCheck(scores);

		// 문제4) 인덱스를 입력받아 성적 출력
		// 정답4) 인덱스 입력 : 1 성적 : 11점
		System.out.print("idx입력: ");
		int idx = sc.nextInt();
		test.getIdx(scores, idx);

		// 문제5) 성적을 입력받아 인덱스 출력
		// 정답5) 성적 입력 : 11 인덱스 : 1
		System.out.print("점수입력: ");
		int score = sc.nextInt();
		test.scoreForIdx(scores, score);

		// 문제6) 학번을 입력받아 성적 출력
		// 정답6) 학번 입력 : 1003 성적 : 45점
		// 문제7) 학번을 입력받아 성적 출력
		// 단, 없는학번 입력 시 예외처리
		// 예 7)
		// 학번 입력 : 1002 성적 : 11점
		// 학번 입력 : 1000 해당학번은 존재하지 않습니다.
		while (true) {
			System.out.println("학번입력: ");
			int hakbun = sc.nextInt();
			int returnVal = test.hakbunForScore(scores, hakbuns, hakbun);
			if (returnVal != -1)
				break;
		}

		// 문제8) 1등학생의 학번과 성적 출력
		// 정답8) 1004번(98점)
		test.theFirst(scores, hakbuns);
	}

}
