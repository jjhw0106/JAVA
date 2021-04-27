package mini_project;

import java.util.Scanner;
import java.util.Random;

public class Snake_Game {
	/*
	 * # 스네이크 게임
	 * 1. 10x10 배열을 0으로 채운다.
	 * 2. 스네이크는 1234로 표시한다.
	 * 3. 상하좌우로 이동이 가능하며, 꼬리가 따라온다.
	 * 4. 자기몸하고 부딪히면, 사망한다.
	 * 5. 랜덤으로 아이템을 생성해
	 *    아이템을 먹으면 꼬리 1개가 자란다.
	 * 6. 꼬리는 최대 8개까지 증가할 수 있다.
	 */

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		Random ran = new Random();
		int size = 10;
		final int ITEMNUM = 5;
		int item = 9;
		int[][] map = new int[size][size];

		int snake = 4;
		int[] x = new int[snake];
		int[] y = new int[snake];
//		int head[][] = new int[size][size];

		final String UP = "w";
		final String DOWN = "s";
		final String RIGHT = "d";
		final String LEFT = "a";
		String dirCheck = RIGHT;

		for (int i = 0; i < snake; i++) {
			x[i] = i + 3;
			y[i] = 5;
			map[y[i]][x[i]] = i + 1;
		}

		int tail = 1;

		int itemxPos = 0;
		int itemyPos = 0;

		for (int i = 0; i < ITEMNUM; i++) {
			itemxPos = ran.nextInt(size);
			itemyPos = ran.nextInt(size);
			if (map[itemyPos][itemxPos] != 0)
				continue;
			map[itemyPos][itemxPos] = item;
		}

		int dead = -1;
		while (true) {

			if (dead == 1)
				break;

			for (int i = 0; i < snake; i++) {
				map[y[i]][x[i]] = i + 1;
			}

//			뱀 출력
			System.out.println("x: " + x[snake - 1] + ", y: " + y[snake - 1]);
			System.out.println("길이: " + snake);
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println();
			for (int i = 0; i < snake; i++) {
				map[y[i]][x[i]] = 0;
			}

			System.out.print("1)left 2)right 3)up 4)down : ");
			String sel = scan.next();

			int[][] temp = null;

			// 이동
			int temCheck = 0;
			if (sel.equals(UP)) {

				// 획돌기 방지
				if (dirCheck.equals(DOWN))
					continue;

				// 가장자리
				if (y[snake - 1] == 0)
					continue;

				// 아이템일 경우
				if (map[y[snake - 1] - 1][x[snake - 1]] == item) {
					int tempX[] = x;
					int tempY[] = y;
					int tempMapX = x[snake - 1];
					int tempMapY = y[snake - 1] - 1;
					snake++;
					if (snake > 8)
						snake--;
					x = new int[snake];
					y = new int[snake];
					for (int i = 0; i < snake - 1; i++) {
						x[i] = tempX[i];
						y[i] = tempY[i];
					}
					x[snake - 1] = tempMapX;
					y[snake - 1] = tempMapY;
				}

				else { // 머리 & 꼬리 이동
					for (int i = 0; i < snake - 1; i++) {
						y[i] = y[i + 1];
					}

					y[snake - 1]--;
					for (int i = 0; i < snake - 1; i++)
						x[i] = x[i + 1];
					dirCheck = UP;
				}
			}

			else if (sel.equals(DOWN)) {
				if (dirCheck.equals(UP))
					continue;
				if (y[snake - 1] == size - 1)
					continue;
				dirCheck = DOWN;
				if (map[y[snake - 1] + 1][x[snake - 1]] == item) {
					int tempX[] = x;
					int tempY[] = y;
					int tempMapX = x[snake - 1];
					int tempMapY = y[snake - 1] + 1;
					snake++;
					if (snake > 8)
						snake--;
					x = new int[snake];
					y = new int[snake];
					for (int i = 0; i < snake - 1; i++) {
						x[i] = tempX[i];
						y[i] = tempY[i];
					}
					x[snake - 1] = tempMapX;
					y[snake - 1] = tempMapY;

				} else {
					for (int i = 0; i < snake - 1; i++) {
						y[i] = y[i + 1];
					}
					y[snake - 1]++;
					for (int i = 0; i < snake - 1; i++)
						x[i] = x[i + 1];

				}
			}

			else if (sel.equals(RIGHT)) {
				if (x[snake - 1] == size - 1)
					continue;
				if (dirCheck.equals(LEFT))
					continue;
				dirCheck = RIGHT;
				if (map[y[snake - 1]][x[snake - 1] + 1] == item) {
					int tempX[] = x;
					int tempY[] = y;
					int tempMapX = x[snake - 1] + 1;
					int tempMapY = y[snake - 1];
					snake++;
					if (snake > 8)
						snake--;
					x = new int[snake];
					y = new int[snake];
					for (int i = 0; i < snake - 1; i++) {
						x[i] = tempX[i];
						y[i] = tempY[i];
					}
					x[snake - 1] = tempMapX;
					y[snake - 1] = tempMapY;

				} else {
					for (int i = 0; i < snake - 1; i++) {
						y[i] = y[i + 1];
					}
					for (int i = 0; i < snake - 1; i++)
						x[i] = x[i + 1];
					x[snake - 1]++;

				}
			}

			else if (sel.equals(LEFT)) {
				if (x[snake - 1] == 0)
					continue;
				if (dirCheck.equals(RIGHT))
					continue;
				dirCheck = LEFT;
				if (map[y[snake - 1]][x[snake - 1] - 1] == item) {
					int tempX[] = x;
					int tempY[] = y;
					int tempMapX = x[snake - 1] - 1;
					int tempMapY = y[snake - 1];
					snake++;
					if (snake > 8)
						snake--;
					x = new int[snake];
					y = new int[snake];
					for (int i = 0; i < snake - 1; i++) {
						x[i] = tempX[i];
						y[i] = tempY[i];
					}
					x[snake - 1] = tempMapX;
					y[snake - 1] = tempMapY;

				} else {
					for (int i = 0; i < snake - 1; i++) {
						y[i] = y[i + 1];
					}
					for (int i = 0; i < snake - 1; i++)
						x[i] = x[i + 1];
					x[snake - 1]--;

				}
			}

			// 죽음

			for (int i = 0; i < snake - 1; i++)
				if (x[i] == x[snake - 1] && y[i] == y[snake - 1]) {
					System.out.println("you died");
					dead = 1;
				}

			System.out.println(map[y[snake - 1]][x[snake - 1]]);
			if (map[y[snake - 1]][x[snake - 1]] != 0) // q. why??
			{
				if (map[y[snake - 1]][x[snake - 1]] != item) {
					System.out.println("you died");
					break;
				}
			}
			if (map[y[snake - 1]][x[snake - 1]] == item) {

				int tempX[] = x;
				int tempY[] = y;
				int tempMapX = x[snake - 1];
				int tempMapY = y[snake - 1];

				snake++;
				if (snake > 8)
					snake--;
				x = new int[snake];
				x[snake - 1] = tempMapX;
				y = new int[snake];
				y[snake - 1] = tempMapY;

				for (int i = 0; i < snake - 1; i++) {
					x[i] = tempX[i];
					y[i] = tempY[i];
				}

			}
			if (map[y[snake - 1]][x[snake - 1]] != 0 && map[y[snake - 1]][x[snake - 1]] != 9) {
				System.out.println("you died");
				break;
			}

		}

	}

}

//메가 정답