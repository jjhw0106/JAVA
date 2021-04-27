package file_practice;

import java.util.Scanner;

public class My_Marble {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		/*
		 * # 나만의 마블
		 * 옷 □ □ □ □ 
		 * □ ■ ■ ■ □ 
		 * □ ■ ■ ■ □ 
		 * □ ■ ■ ■ □ 
		 * □ □ □ □ □
		 */

		// 마블판 초기화에 사용
		int size = 5;
		int xPos = 0;
		int yPos = 0;
		int num = 0;
		int way = 4;
		int[][] board = new int[size][size];

		// 유저 위치에 사용
		int uPos = 0;
		int dice = 0; // 주사위
		int round = -1; // 몇바퀴 돌았는지

		// 게임시작
		boolean run = true;
		while (run) {
			while (num < (size - 1) * (size - 1)) {

				// 보드 초기화
				for (int i = 1; i < size - 1; i++) {
					for (int j = 1; j < size - 1; j++) {
						board[i][j] = -1;
					}
				}

				if (num % (size - 1) == 0) {
					if (way == 4)
						way = 0;
					else
						way++;
				}
				if (way == 4) // 한바퀴만 돌리기 위해
					break;

				if (way == 0) {
					xPos++;
					num++;
					board[yPos][xPos] = num;
				} else if (way == 1) {
					yPos++;
					num++;
					board[yPos][xPos] = num;
				} else if (way == 2) {
					xPos--;
					num++;
					board[yPos][xPos] = num;
				} else if (way == 3) {
					yPos--;
					num++;
					if (num == (size - 1) * (size - 1)) // (0,0)이 0부터 시작하기 위해
						num = 0;
					board[yPos][xPos] = num;
				}
			}

			// 유저 위치
			uPos += dice;
			if (uPos >= (size - 1) * (size - 1) || uPos == 0)
				round++;
			if (uPos >= (size - 1) * (size - 1))
				uPos -= (size - 1) * (size - 1);

			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					if (board[i][j] == uPos)
						System.out.print("옷\t");
					else
						System.out.print(board[i][j] + "\t");
				}
				System.out.println();
			}
			System.out.println("몇칸 움직이겠습니까? (" + round + "바퀴)");
			dice = sc.nextInt();

		}
	}
}