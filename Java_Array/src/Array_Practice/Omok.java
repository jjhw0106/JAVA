package Array_Practice;

import java.util.Scanner;

public class Omok {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		final int SIZE = 10;
		int[][] map = new int[SIZE][SIZE];

		for (int i = 0; i < SIZE; i++)
			for (int j = 0; j < SIZE; j++)
				map[i][j] = 0;

		int check = 0;
		int turn = 0;

		boolean winP1 = false;
		boolean winP2 = false;

		// 입력
//		p1 좌표입력
//		p2 좌표입력
		// 게임시작
		System.out.println("======게임시작======");
		while (true) {
			for (int i = 0; i < SIZE; i++) {
				for (int j = 0; j < SIZE; j++) {
					if (map[i][j] == 0)
						System.out.print("º" + " ");
					else if (map[i][j] == 1)
						System.out.print("●" + " ");
					else if (map[i][j] == 2)
						System.out.print("○" + " ");
				}
				System.out.println();
			}

			if (winP1 == true) {
				System.out.println("플레이어1  승리!!");
				break;
			} else if (winP2 == true) {
				System.out.println("플레이어2  승리!!");
				break;
			}

			turn++;
			if (turn % 2 == 1) {
				System.out.println("Player 1");
				System.out.print("p1x: ");
				int p1x = sc.nextInt();
				System.out.print("p1y: ");
				int p1y = sc.nextInt();
				map[p1x][p1y] = 1;
			}

			else if (turn % 2 == 0) {
				System.out.println("Player 2");
				System.out.print("p2x: ");
				int p2x = sc.nextInt();
				System.out.print("p2y: ");
				int p2y = sc.nextInt();
				map[p2x][p2y] = 2;
			}

			// 체크
			// 가로 map[i][j]==map[i][j+1] -> check ++;
			// 세로 map[i][j]==map[i+1][j] -> check ++;

			// 가로
			check = 1;
			for (int i = 0; i < SIZE - 1; i++)
				for (int j = 0; j < SIZE - 1; j++)
					if (map[i][j] != 0 && map[i][j] == map[i][j + 1]) {
						check++;
						if (check == 5) {
							if (turn % 2 == 1)
								winP1 = true;
							else if (turn % 2 == 0)
								winP2 = true;
						}
					} else
						check = 1;

			// 세로
			check = 1;
			for (int i = 0; i < SIZE - 1; i++)
				for (int j = 0; j < SIZE - 1; j++)
					if (map[j][i] != 0 && map[j][i] == map[j + 1][i]) {
						check++;
						if (check == 5) {
							if (turn % 2 == 1)
								winP1 = true;
							else if (turn % 2 == 0)
								winP2 = true;
						}
					} else
						check = 1;

			// 대각선
			for (int i = 0; i < SIZE - 4; i++) {
				for (int j = 0; j < SIZE - 4; j++)
					if (map[i][j] != 0 && map[i][j] == map[i + 1][j + 1]
							&& map[i][j] == map[i + 2][j + 2]
							&& map[i][j] == map[i + 3][j + 3]
							&& map[i][j] == map[i + 4][j + 4]) {

						if (turn % 2 == 1)
							winP1 = true;
						else if (turn % 2 == 0)
							winP2 = true;
					}
			}

			// 역 대각선
			for (int i = 0; i < SIZE - 4; i++) {
				for (int j = 0; j < SIZE - 4; j++)
					if (map[SIZE - 1 - i][j] != 0 && map[SIZE - 1 - i][j] == map[SIZE - 2 - i][j + 1]
							&& map[SIZE - 1 - i][j] == map[SIZE - 3 - i][j + 2]
							&& map[SIZE - 1 - i][j] == map[SIZE - 4 - i][j + 3]
							&& map[SIZE - 1 - i][j] == map[SIZE - 5 - i][j + 4]) {

						if (turn % 2 == 1)
							winP1 = true;
						else if (turn % 2 == 0)
							winP2 = true;
					}

			}
		}

	}
}
