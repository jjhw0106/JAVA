package megastudy_test4;

import java.util.Random;
import java.util.Scanner;

//start 3: 35 end 
import java.util.Scanner;
import java.util.Random;

public class Bingo {
	public static void main(String[] args) {

		Random ran = new Random();
		Scanner sc = new Scanner(System.in);

		final int SIZE = 5;
		int[][] bingo1 = new int[SIZE][SIZE];
		int[][] bingo2 = new int[SIZE][SIZE];

//		빙고판1,2 초기화(랜덤으로), 1차원 배열에 먼저 중복값 없게 저장한 후 빙고판에 넣기

//		빙고1 초기화
		int[] temp = new int[SIZE * SIZE];
		for (int i = 0; i < SIZE * SIZE; i++) {
			temp[i] = ran.nextInt(50);
			for (int j = 0; j < i; j++)
				if (temp[j] == temp[i])
					i--;
		}

		int k = 0;
		for (int i = 0; i < SIZE; i++)
			for (int j = 0; j < SIZE; j++) {
				bingo1[i][j] = temp[k];
				k++;
			}

//		빙고2 초기화
		temp = new int[SIZE * SIZE];
		for (int i = 0; i < SIZE * SIZE; i++) {
			temp[i] = ran.nextInt(50);
			for (int j = 0; j < i; j++)
				if (temp[j] == temp[i])
					i--;
		}

		k = 0;
		for (int i = 0; i < SIZE; i++)
			for (int j = 0; j < SIZE; j++) {
				bingo2[i][j] = temp[k];
				k++;
			}

		while (true) {
//		빙고판 출력
			System.out.println("빙고1. ");
			for (int i = 0; i < SIZE; i++) {
				for (int j = 0; j < SIZE; j++) {
					System.out.print(bingo1[i][j] + "\t");
				}
				System.out.println();
			}
			System.out.println();
			System.out.println("빙고2. ");
			for (int i = 0; i < SIZE; i++) {
				for (int j = 0; j < SIZE; j++) {
					System.out.print(bingo2[i][j] + "\t");
				}
				System.out.println();
			}
//		숫자 부르기
			System.out.println();
			System.out.print("숫자는: ");
			int call = sc.nextInt();

//		빙고판 1체크-> 해당 숫자 -1
			for (int i = 0; i < SIZE; i++) {
				for (int j = 0; j < SIZE; j++) {
					if (bingo1[i][j] == call)
						bingo1[i][j] = -1;
				}
			}
//		빙고판 2체크-> 해당 숫자 -1
			for (int i = 0; i < SIZE; i++) {
				for (int j = 0; j < SIZE; j++) {
					if (bingo2[i][j] == call)
						bingo2[i][j] = -1;
				}
			}

			int win1 = 0;
			int win2 = 0;
//		빙고판 1검사 -> 가로, 세로, 대각, 역대각
			// 가로
			int pos = 0;
			int count = 0;
			while (pos < SIZE) {
				for (int j = 0; j < SIZE; j++)
					if (bingo1[pos][j] == -1) {
						count++;
					}

					else
						count = 0;
				pos++;
				if (count == 5)
					win1 = 1;
			}

			pos = 0;
			count = 0;
			while (pos < SIZE) {
				for (int j = 0; j < SIZE; j++)
					if (bingo2[pos][j] == -1) {
						count++;
					}

					else
						count = 0;
				pos++;
				if (count == 5)
					win2 = 1;
			}

			if (win1 == 1 && win2 == 1) {
				System.out.println("무승부");
				break;
			} else if (win1 != 1 && win2 == 1) {
				System.out.println("P2 승리");
				break;
			} else if (win1 == 1 && win2 != 1) {
				System.out.println("P1 승리");
				break;
			}

			// 세로
			pos = 0;
			count = 0;
			while (pos < SIZE) {
				for (int j = 0; j < SIZE; j++)
					if (bingo1[j][pos] == -1) {
						count++;
					}

					else
						count = 0;
				pos++;
				if (count == 5)
					win1 = 1;
			}

			pos = 0;
			count = 0;
			while (pos < SIZE) {
				for (int j = 0; j < SIZE; j++)
					if (bingo2[j][pos] == -1) {
						count++;
					}

					else
						count = 0;
				pos++;
				if (count == 5)
					win2 = 1;
			}

			// 대각선
			pos = 0;
			count = 0;
			while (pos < SIZE) {
				for (int j = 0; j < SIZE; j++)
					if (bingo1[j][j] == -1) {
						count++;
					}

					else
						count = 0;
				pos++;
				if (count == 5)
					win1 = 1;
			}

			pos = 0;
			count = 0;
			while (pos < SIZE) {
				for (int j = 0; j < SIZE; j++)
					if (bingo2[j][j] == -1) {
						count++;
					}

					else
						count = 0;
				pos++;
				if (count == 5)
					win2 = 1;
			}

			// 역대각선
			pos = 0;
			count = 0;
			while (pos < SIZE) {
				for (int j = 0; j < SIZE; j++)
					if (bingo1[j][SIZE - 1 - j] == -1) {
						count++;
					}

					else
						count = 0;
				pos++;
				if (count == 5)
					win1 = 1;
			}

			pos = 0;
			count = 0;
			while (pos < SIZE) {
				for (int j = 0; j < SIZE; j++)
					if (bingo2[j][SIZE - 1 - j] == -1) {
						count++;
					}

					else
						count = 0;
				pos++;
				if (count == 5)
					win2 = 1;
			}

			if (win1 == 1 && win2 == 1) {
				System.out.println("무승부");
				break;
			} else if (win1 != 1 && win2 == 1) {
				System.out.println("P2 승리");
				break;
			} else if (win1 == 1 && win2 != 1) {
				System.out.println("P1 승리");
				break;
			}

//		빙고판 2검사 -> 가로, 세로, 대각, 역대각
//		
//		p1,p2 count로 승패 결정
		}

	}
}
