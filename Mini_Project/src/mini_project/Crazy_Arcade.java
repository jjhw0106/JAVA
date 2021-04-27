package mini_project;

import java.util.Scanner;
import java.util.Random;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;

public class Crazy_Arcade {

	public static void main(String[] args) {

		Random ran = new Random();
		Scanner sc = new Scanner(System.in);

		final int SIZE = 7;

		final String UP = "w";
		final String DOWN = "s";
		final String LEFT = "a";
		final String RIGHT = "d";
		final String FIRE = "j";
		final String EXPLODE = "k";

		final int ROAD = 0;
		final int WALL = 3;
		final int PLAYER = 2;
		final int BOMB = 9;
		final int ITEM = 4;

//		final int ALIVE = 1;
		final int DEATH = -1;

		// 유저
//		int life = ALIVE;
		int uX = 0;
		int uY = 0;
//		int death = -1;

		// 폭탄
		int inventory = 2;
		int[][][] bPos = new int[SIZE][SIZE][inventory];
		int[][][] bTemp = null;
		int bIdx = 0;// 폭탄 인덱스
		int dIdx = 0;// 터질 폭탄 인덱스
		int bCnt = 0;
		int power = 1;// 폭탄 파워
//			int byPos = 0;
//			int bxPos = 0;
		// 맵 초기화
		int[][] user = new int[SIZE][SIZE];
		user[uY][uX] = PLAYER;

		int map[][][] = new int[2][SIZE][SIZE];

		// 길&아이템 깔기
		for (int i = 0; i < SIZE; i++)
			for (int j = 0; j < SIZE; j++) {
				map[0][i][j] = ROAD;

			}

		// 벽 깔기
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				int wInstall = ran.nextInt(2);
				if (wInstall == 1)
					map[1][i][j] = WALL;

				map[1][0][0] = user[uY][uX];
				map[1][0][1] = ROAD;
				map[1][1][0] = ROAD;
				map[1][1][1] = ROAD;

			}
		}
		// 아이템깔기
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				if (map[1][i][j] == WALL) {
					int itemDrop = ran.nextInt(2);
					if (itemDrop == 1)
						map[0][i][j] = ITEM;
				}
			}
		}
		int[] bomb = new int[inventory];

		while (true) {
//			폭탄개수
			System.out.println("폭탄: " + inventory);
			System.out.println("설치된 폭탄 수: " + bCnt);
			// 맵 출력
			for (int i = 0; i < SIZE; i++) {
				for (int j = 0; j < SIZE; j++) {
					if (map[1][i][j] == WALL)
						System.out.print("■" + "\t");
					else if (map[1][i][j] == PLAYER && map[0][i][j] == BOMB)
						System.out.print("●" + "\t");
					else if (map[0][i][j] == BOMB && map[1][i][j] == ROAD)
						System.out.print("＠" + "\t");
					else if (map[1][i][j] == PLAYER)
						System.out.print("○" + "\t");
					else if (map[1][i][j] == ROAD && map[0][i][j] == ITEM)
						System.out.print("§" + "\t");
					else if (map[1][i][j] == DEATH)
						System.out.print("X" + "\t");
					else
						System.out.print("□" + "\t");
				}
				System.out.println();
			}

			if (map[1][uY][uX] == DEATH)
				break;
			// 폭탄 개수
			int bEnd = inventory - 1;
			bTemp = bPos;
			bPos = new int[SIZE][SIZE][inventory];
			for (int i = 0; i < bTemp[0][0].length; i++)
				for (int j = 0; j < SIZE; j++)
					for (int k = 0; k < SIZE; k++)
						bPos[j][k][i] = bTemp[j][k][i];

			// 이동 & 아이템 먹기
			System.out.println("이동: ");
			String move = sc.next();
			if (move.equals(UP)) {
				if (uY == 0 || map[1][uY - 1][uX] == WALL || map[0][uY - 1][uX] == BOMB)
					continue;
				if (map[0][uY - 1][uX] == ITEM) {
					map[1][uY][uX] = ROAD;
					uY--;
					inventory++;
					map[0][uY][uX] = 0;
					map[1][uY][uX] = PLAYER;
				} else {
					map[1][uY][uX] = ROAD;
					uY--;
					map[1][uY][uX] = PLAYER;
				}
			}

			else if (move.equals(DOWN)) {
				if (uY == SIZE - 1 || map[1][uY + 1][uX] == WALL || map[0][uY + 1][uX] == BOMB)
					continue;
				if (map[0][uY + 1][uX] == ITEM) {
					map[1][uY][uX] = ROAD;
					uY++;
					inventory++;
					map[0][uY][uX] = 0;
					map[1][uY][uX] = PLAYER;
				} else {
					map[1][uY][uX] = ROAD;
					uY++;
					map[1][uY][uX] = PLAYER;
				}
			}

			else if (move.equals(LEFT)) {
				if (uX == 0 || map[1][uY][uX - 1] == WALL || map[0][uY][uX - 1] == BOMB)
					continue;
				if (map[0][uY][uX - 1] == ITEM) {
					map[1][uY][uX] = ROAD;
					uX--;
					inventory++;
					map[0][uY][uX] = 0;
					map[1][uY][uX] = PLAYER;
				} else {
					map[1][uY][uX] = ROAD;
					uX--;
					map[1][uY][uX] = PLAYER;
				}

			}

			else if (move.equals(RIGHT)) {
				if (uX == SIZE - 1 || map[1][uY][uX + 1] == WALL || map[0][uY][uX + 1] == BOMB)
					continue;
				if (map[0][uY][uX + 1] == ITEM) {
					map[1][uY][uX] = ROAD;
					uX++;
					inventory++;
					map[0][uY][uX] = 0;
					map[1][uY][uX] = PLAYER;
				} else {
					map[1][uY][uX] = ROAD;
					uX++;
					map[1][uY][uX] = PLAYER;
				}
			}

			// 예외상황
//				같은 자리에 폭탄 두번놀때 ->ok
//	 			폭탄 바로옆에 붙어있을때 
//				범위 안에 사람 있을 떄 ->한 칸일 경우는 구현
//				폭발 범위도 추가해볼것

			// 폭탄 설치

			else if (move.equals(FIRE)) {
				if (bCnt == inventory || map[0][uY][uX] == BOMB)
					continue;
//					int byPos = uY;
//					int bxPos = uX;
				bPos[uY][uX][bIdx] = BOMB;
				map[0][uY][uX] = bPos[uY][uX][bIdx];
				bIdx++;
				System.out.println(bIdx);
				bCnt++;
				if (bIdx == inventory)
					bIdx = 0;

			}
			// 폭발
			else if (move.equals(EXPLODE)) {
				if (bCnt == 0)
					continue;
				int byPos = 0;
				int bxPos = 0;
				for (int i = 0; i < SIZE; i++) // 폭탄 좌표 받기
					for (int j = 0; j < SIZE; j++) {
						if (bPos[i][j][dIdx] == BOMB) {
							byPos = i;
							bxPos = j;
						}
					}

				bPos[byPos][bxPos][dIdx] = 0;
				map[0][byPos][bxPos] = bPos[byPos][bxPos][dIdx];
				dIdx++;
				if (dIdx == inventory)
					dIdx = 0;
				bCnt--;

				if (map[1][byPos][bxPos] == 0)
					map[0][byPos][bxPos] = 0;
				map[1][byPos][bxPos] = 0;

				if (byPos != 0) { // for 테두리 예외처리
					if (map[1][byPos - power][bxPos] == 0 && map[0][byPos - power][bxPos] != BOMB)// 벽이 없을 경우, 연쇄폭발 X
						map[0][byPos - power][bxPos] = 0; // 아이템 없애기
					map[1][byPos - power][bxPos] = 0; // 벽 깨기
				}

				if (byPos != SIZE - 1) {
					if (map[1][byPos + power][bxPos] == 0 && map[0][byPos + power][bxPos] != BOMB)
						map[0][byPos + power][bxPos] = 0;
					map[1][byPos + power][bxPos] = 0;
				}

				if (bxPos != 0) {
					if (map[1][byPos][bxPos - power] == 0 && map[0][byPos][bxPos - power] != BOMB)
						map[0][byPos][bxPos - power] = 0;
					map[1][byPos][bxPos - power] = 0;
				}

				if (bxPos != SIZE - 1) {
					if (map[1][byPos][bxPos + power] == 0 && map[0][byPos][bxPos + power] != BOMB)
						map[0][byPos][bxPos + power] = 0;
					map[1][byPos][bxPos + power] = 0;
				}

				if (map[1][uY][uX] == 0)
					map[1][uY][uX] = DEATH;

//					if (uY >= byPos - power && uY <= byPos + power)
//						if (uX >= bxPos - power && uX <= bxPos + power)
//							life = DEATH;
//					bx가 0일때
//					by가 size-1
//					bx가 size-1
//					by는 0,bx는 size-1
//					bx는0, bx는 size-1
//					by,bx가 0
//					by,bx가 size-1

			}

		} //// while
		System.out.println("YOU DIED");
	}
}


