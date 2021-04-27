package megastudy_test4;

//start 1:15 둥 1:39
import java.util.Scanner;
import java.util.Random;

public class Lotto_1set {

	/*
	 * # 당첨복권 1셋트
	 * 1. 3이 연속으로 3번 등장하면 당첨복권이다.
	 * 2. 랜덤으로 5개의 복권을 생성하되,
	 *    당첨복권은 한 개만 생성되도록 설정한다.
	 */

	public static void main(String[] args) {
		Random ran = new Random();

//		당첨복권 번호 겟
//		당첨복권 생성(3이 연속)
//		당첨복권 아닌 번호는 3이 세번나오면 다시 돌리기

		int[][] lotto = new int[5][7];

		int check = ran.nextInt(5);
		int count = 0;

		// 복권 초기화(당첨복권 = check번째)
		while (count < lotto.length) {

			int num = 0;
			if (count != check) {
				for (int j = 0; j < 5; j++)
					if (lotto[count][j] == 3 || lotto[count][j + 1] == 3 || lotto[count][j + 2] == 3)
						continue;

				for (int j = 0; j < 7; j++) {
					num = ran.nextInt(10);
					lotto[count][j] = num;
				}
				count++;
			}

			else if (count == check) {
				int wIdx = ran.nextInt(5);
				for (int j = 0; j < 7; j++) {
					num = ran.nextInt(10);
					lotto[count][j] = num;
				}
				lotto[count][wIdx] = 3;
				lotto[count][wIdx + 1] = 3;
				lotto[count][wIdx + 2] = 3;
				count++;
			}
		}

		// 복권 출력
		for (int i = 0; i < lotto.length; i++) {
			for (int j = 0; j < 7; j++)
				System.out.print(lotto[i][j] + " ");
			System.out.println();
		}

		// 당첨 복권 조회
		for (int i = 0; i < lotto.length; i++) {
			for (int j = 0; j < 5; j++)
				if (lotto[i][j] == 3 && lotto[i][j + 1] == 3 && lotto[i][j + 2] == 3) {
					System.out.println(i + 1 + "번째 복권이 당첨입니다.");
				}
		}
	}
}
