package mini_project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Sokoban_Maker {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Random ran = new Random();

		final int SIZE = 9;
		final int POINTER = 6;
		final int PLAYER = 2;
		final int WALL = 333324123;
		final int BALL = 4;
		final int GOAL = 5;

		final String UP = "w";
		final String DOWN = "s";
		final String LEFT = "a";
		final String RIGHT = "d";

		int pY = 0;
		int pX = 0;

		int[][] map = new int[SIZE][SIZE];
		int[][] maker = new int[SIZE][SIZE];

		File sMaker = new File("Maker.txt");
		maker[pY][pX] = PLAYER;

		while (true) {
			System.out.println("[1]소코반 메이커");
			System.out.println("[2]게임 시작하기(맵 불러오기)");
			System.out.println("[0]종료하기");

			int sel = sc.nextInt();

			if (sel == 1) {
				int mPointer[][] = new int[SIZE][SIZE];
				String choice = "";
				pY = 0;
				pX = 0;
				mPointer[pY][pX] = POINTER;
				map[pY][pX] = mPointer[pY][pX];
				while (true) {
					System.out.println("==================================================");
					for (int i = 0; i < SIZE; i++) {
						for (int j = 0; j < SIZE; j++) {
							if (i == pY && j == pX)
								System.out.print("★" + "\t");
							else if (map[i][j] == PLAYER)
								System.out.print("옷" + "\t");
							else if (map[i][j] == WALL)
								System.out.print("■" + "\t");
							else if (map[i][j] == GOAL)
								System.out.print("G" + "\t");
							else if (map[i][j] == BALL)
								System.out.print("●" + "\t");
							else
								System.out.print(("□" + "\t"));
						}
						System.out.println();
					}
					System.out.println("==================================================");
					System.out.println("1.player / 2.ball / 3.wall / 4.gaol / 5.save");
					choice = sc.next();
					if (choice.equals("1") || choice.equals("2") || choice.equals("3") || choice.equals("4")) {
						if (choice.equals("1")) {
							map[pY][pX] = PLAYER;
						} else if (choice.equals("2")) {
							map[pY][pX] = BALL;

						} else if (choice.equals("3")) {
							map[pY][pX] = WALL;

						} else if (choice.equals("4")) {
							map[pY][pX] = GOAL;
						}
					} else if (choice.equals(UP) || choice.equals(DOWN) || choice.equals(LEFT)
							|| choice.equals(RIGHT)) {
						int temp = 0;
						temp = map[pY][pX];

						int tempY = pY;
						int tempX = pX;
						if (choice.equals(UP))
							tempY--;
						else if (choice.equals(DOWN))
							tempY++;
						else if (choice.equals(LEFT)) {
							tempX--;
						} else if (choice.equals(RIGHT))
							tempX++;
						else if (choice.equals("p"))
							break;

						if (tempY < 0 || tempY > SIZE - 1)
							continue;
						if (tempX < 0 || tempX > SIZE - 1)
							continue;

						map[pY][pX] = temp;
						pY = tempY;
						pX = tempX;
//						map[pY][pX] = POINTER;

					} else if (choice.equals("5")) {
						FileWriter fw = null;
						String data[][] = new String[SIZE][SIZE];
						try {
							fw = new FileWriter(sMaker);
							for (int i = 0; i < SIZE; i++)
								for (int j = 0; j < SIZE; j++) {
									data[i][j] = String.valueOf(map[i][j]);
									fw.write(data[i][j]);
									fw.write("\n");
								}
							fw.close();
						} catch (Exception e) {
							e.printStackTrace();
						}
						System.out.println("저장되었습니다.");
						break;

					} // while end

				}
			}

			else if (sel == 2) {
				
				FileReader fr = null;
				BufferedReader br = null;
				
				if(sMaker.exists()) { // 파일이 존재하면 불러오기 시도
					try {
						fr = new FileReader(sMaker);
						br = new BufferedReader(fr);
						String data[][] = new String[SIZE][SIZE];
						for (int i = 0; i < SIZE; i++)
							for (int j = 0; j < SIZE; j++) {
								data[i][j] = br.readLine();
								map[i][j] = Integer.parseInt(data[i][j]);
							}
						fr.close();
						br.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
					
				}else {
					System.out.println("저장된 기록이 없습니다.");
				}

				System.out.println("==================================================");
				for (int i = 0; i < SIZE; i++) {
					for (int j = 0; j < SIZE; j++) {
//						if (i == pY && j == pX)
//							System.out.print("★" + "\t");
						if (map[i][j] == PLAYER)
							System.out.print("옷" + "\t");
						else if (map[i][j] == WALL)
							System.out.print("■" + "\t");
						else if (map[i][j] == GOAL)
							System.out.print("G" + "\t");
						else if (map[i][j] == BALL)
							System.out.print("●" + "\t");
						else
							System.out.print(("□" + "\t"));
					}
					System.out.println();
				}
				System.out.println("==================================================");
			}

			else if (sel == 0)
				break;
		}
	}
}