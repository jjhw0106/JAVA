package Array_Practice;

import java.util.Scanner;
import java.util.Random;

//*** MEGA TIP
// 현재 위치(유저) 활용해서 짜보기
// 공, 유저, 골 등 초기화 시->소코반의 좌표로 초기화
// 각각의 X,Y좌표 활용해서 그림만 바꾸는게 아닌 데이터 변경

public class Sokoban {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Random ran = new Random();

		final int SIZE = 10;
		final int WAY = 0;
		final int WALL = 1;
		final int BALL = 2;
		final int USER = 3;
		final int GOAL = 9;

		final int UP = 8;
		final int DOWN = 5;
		final int LEFT = 4;
		final int RIGHT = 6;

		int[][] sokoban = new int[SIZE][SIZE];

		int xpos = 0;
		int ypos = 0;

		// 소코반 초기화
		for (int i = 0; i < SIZE; i++)
			for (int j = 0; j < SIZE; j++)
				sokoban[i][j] = WAY;

		// 유저 위치 입력
		int uxPos;
		int uyPos;
		while (true) {
			System.out.println("유저 좌표 입력");
			System.out.print("X 좌표: ");
			xpos = sc.nextInt();
			System.out.print("Y 좌표: ");
			ypos = sc.nextInt();
			if (xpos < SIZE && ypos < SIZE) {
				sokoban[ypos][xpos] = USER;
				uyPos = ypos;
				uxPos = xpos;
				break;
			}
		}

		// 벽 개수받아서 초기화
		xpos = 0;
		ypos = 0;
		int wNum;
		while (true) {
			System.out.print("벽의 개수: ");
			wNum = sc.nextInt();
			if (wNum < SIZE * SIZE - 15)
				break;
			else
				System.out.println("벽의 개수는 최대" + ((SIZE * SIZE) - 15) + "개");
		}

		int count = 0;
		while (count < wNum) {
			int wY = ran.nextInt(SIZE); // KEY POINT!!!!!!!!
			int wX = ran.nextInt(SIZE);

			if (sokoban[wY][wX] == WAY) {
				sokoban[wY][wX] = WALL;
				count++;
			}
		}

		// 공 위치(벽과 유저가 아닌 곳)
		count = 0;
		int byPos = 0;
		int bxPos = 0;
		while (count == 0) {
			byPos = ran.nextInt(SIZE - 2) + 1;
			bxPos = ran.nextInt(SIZE - 2) + 1;
			if (sokoban[byPos][bxPos] == WAY) {
				sokoban[byPos][bxPos] = BALL;
				count = 1;
			}
		}

		// 목적지
		count = 0;
		int gyPos = 0;
		int gxPos = 0;
		while (count == 0) {
			int gY = ran.nextInt(SIZE);
			int gX = ran.nextInt(SIZE);
			if (sokoban[gY][gX] == WAY) {
				sokoban[gY][gX] = GOAL;
				count = 1;
				gyPos = gY;
				gxPos = gX;
			}
		}

/////////////////////////////////////// 게임시작///////////////////////////////////////////

		int clear = 0;
		while (clear == 0) {
			System.out.println("유저위치: " + "[" + uyPos + "]" + "[" + uxPos + "]");
			System.out.println("공위치: " + "[" + byPos + "]" + "[" + bxPos + "]");

			// 소코반 출력
			for (int i = 0; i < SIZE; i++) {
				for (int j = 0; j < SIZE; j++) {
					if (sokoban[i][j] == WAY)
						System.out.print("□" + "\t");
					else if (sokoban[i][j] == WALL)
						System.out.print("■" + "\t");
					else if (sokoban[i][j] == BALL)
						System.out.print("◎" + "\t");
					else if (sokoban[i][j] == USER)
						System.out.print("옷" + "\t");
					else if (sokoban[i][j] == GOAL)
						System.out.print("★" + "\t");
				}
				System.out.println();
			}

			// MOVE
			System.out.print("이동: ");
			int go = sc.nextInt();
			// if ((go == 4 && uxPos != 0) || (go == 4 && uxPos - 1 != WALL)) Q. 안되는?
			if (go == LEFT) {
				if (uxPos == 0)
					continue;
				else if (sokoban[uyPos][uxPos - 1] == BALL) {
					if (sokoban[byPos][bxPos - 1] == WALL || bxPos == 0)
						continue;
					else {
						sokoban[uyPos][uxPos] = WAY;
						sokoban[uyPos][uxPos - 1] = USER;
						uxPos -= 1;
						bxPos -= 1;
						sokoban[byPos][bxPos] = BALL;

					}
				} else if (sokoban[uyPos][uxPos - 1] == WALL)
					continue;
				else {
					sokoban[uyPos][uxPos] = WAY;
					sokoban[uyPos][uxPos - 1] = USER;
					uxPos -= 1;
				}
			}

			if (go == RIGHT) {
				if (uxPos == SIZE - 1)
					continue;
				else if (sokoban[uyPos][uxPos + 1] == BALL) {
					if (sokoban[byPos][bxPos + 1] == WALL || bxPos == SIZE - 1)
						continue;
					else {
						sokoban[uyPos][uxPos] = WAY;
						sokoban[uyPos][uxPos + 1] = USER;
						sokoban[byPos][bxPos + 1] = BALL;
						uxPos += 1;
						bxPos += 1;
					}
				} else if (sokoban[uyPos][uxPos + 1] == WALL)
					continue;
				else {
					sokoban[uyPos][uxPos] = WAY;
					sokoban[uyPos][uxPos + 1] = USER;
					uxPos += 1;
				}
			}

			if (go == UP) {
				if (uyPos == 0)
					continue;
				else if (sokoban[uyPos - 1][uxPos] == BALL) {
					if (sokoban[byPos - 1][bxPos] == WALL || byPos == 0)
						continue;
					else {
						sokoban[uyPos][uxPos] = WAY;
						sokoban[uyPos - 1][uxPos] = USER;
						sokoban[byPos - 1][bxPos] = BALL;
						uyPos -= 1;
						byPos -= 1;
					}
				} else if (sokoban[uyPos - 1][uxPos] == WALL)
					continue;
				else {
					sokoban[uyPos][uxPos] = WAY;
					sokoban[uyPos - 1][uxPos] = USER;
					uyPos -= 1;
				}
			}

			if (go == DOWN) {
				if (uyPos == SIZE - 1)
					continue;
				else if (sokoban[uyPos + 1][uxPos] == BALL) {
					if (sokoban[byPos + 1][bxPos] == WALL || byPos == SIZE - 1)
						continue;
					else {
						sokoban[uyPos][uxPos] = WAY;
						sokoban[uyPos + 1][uxPos] = USER;
						sokoban[byPos + 1][bxPos] = BALL;
						uyPos += 1;
						byPos += 1;
					}
				} else if (sokoban[uyPos + 1][uxPos] == WALL)
					continue;
				else {
					sokoban[uyPos][uxPos] = WAY;
					sokoban[uyPos + 1][uxPos] = USER;
					uyPos += 1;
				}
			}

			// Clear
			int goalX = 0;
			int goalY = 0;
			for (int i = 0; i < SIZE; i++)
				for (int j = 0; j < SIZE; j++)
					if (sokoban[gyPos][gxPos] == BALL)
						clear = 1;

			if (clear == 1) {
				System.out.println("Game Clear!!");
				break;
			}
		}
	}
}

//								메가스터디 정답
//import java.util.Random;
//import java.util.Scanner;
//
//public class day1306_소코반암기 {
//
//	public static void main(String[] args) {
//		Scanner scan = new Scanner(System.in);
//		Random ran = new Random();
//		
//		final int SIZE = 7;
//		final int PLAYER = 2;
//		final int BALL = 3;
//		final int GOAL = 7;
//		final int WALL = 9;
//		
//		int[][] map = new int[SIZE][SIZE];
//		
//		int wallCount = 0;
//		int pY = 0;
//		int pX = 0;
//		int ballY = 0;
//		int ballX = 0;
//		int goalY = 0;
//		int goalX = 0;
//		
//		// 벽 설치
//		System.out.print(">>>설치할 벽의 개수를 입력하세요 : ");
//		wallCount = scan.nextInt();
//		
//		int temp = wallCount;
//		while(temp != 0) {
//			int rY = ran.nextInt(SIZE);
//			int rX = ran.nextInt(SIZE);
//			
//			if(map[rY][rX] == 0) {
//				map[rY][rX] = WALL;
//				temp = temp - 1;
//			}
//		}
//		
//		// 공 설치
//		while(true) {
//			int rY = ran.nextInt(SIZE - 2) + 1;
//			int rX = ran.nextInt(SIZE - 2) + 1;
//			
//			if(map[rY][rX] == 0) {
//				map[rY][rX] = BALL;
//				ballY = rY;
//				ballX = rX;
//				break;
//			}
//		}
//		
//		// 골대 설치
//		while(true) {
//			int rY = ran.nextInt(SIZE);
//			int rX = ran.nextInt(SIZE);
//			
//			if(map[rY][rX] == 0) {
//				map[rY][rX] = GOAL;
//				goalY = rY;
//				goalX = rX;
//				break;
//			}
//		}
//		
//		// 화면 출력
//		for(int i=0; i<SIZE; i++) {
//			for(int j=0; j<SIZE; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
//		
//		// 플레이어 배치
//		while(true) {
//			System.out.println(">>>플레이어의 위치를 선택하세요.");
//			System.out.print("y좌표 입력 : ");
//			pY = scan.nextInt();
//			
//			System.out.print("x좌표 입력 : ");
//			pX = scan.nextInt();
//			
//			if(map[pY][pX] == 0) {
//				map[pY][pX] = PLAYER;
//				break;
//			}
//		}
//		
//		// 게임 시작
//		while(true) {
//			// 화면 출력
//			System.out.println("---------------");
//			for(int i=0; i<SIZE; i++) {
//				for(int j=0; j<SIZE; j++) {
//					if(map[i][j] == PLAYER) {
//						System.out.print("옷 ");
//					}else if(map[i][j] == WALL) {
//						System.out.print("벽 ");
//					}else if(map[i][j] == GOAL) {
//						System.out.print("골 ");
//					}else if(map[i][j] == BALL) {
//						System.out.print("공 ");
//					}else {
//						System.out.print(map[i][j] + " ");
//					}
//				}
//				System.out.println();
//			}
//			System.out.println("---------------");
//			
//			// 골대에 공을 넣으면 게임 종료
//			if(ballY == goalY && ballX == goalX) {
//				System.out.println("게임종료");
//				break;
//			}
//			
//			System.out.print("상(1)하(2)좌(3)우(4) 입력 : ");
//			int move = scan.nextInt();
//		
//			// 현재위치 저장하기
//			int yy = pY;
//			int xx = pX;
//			
//			if(move == 1) { yy = yy - 1; }
//			else if(move == 2) { yy = yy + 1; }
//			else if(move == 3) { xx = xx - 1; }
//			else if(move == 4) { xx = xx + 1; }
//			
//			// 예외처리
//			if(SIZE <= xx || xx < 0) continue;
//			if(SIZE <= yy || yy < 0) continue;
//			if(map[yy][xx] != 0 && map[yy][xx] != BALL) continue;
//			
//			// 공을 만나면
//			if(map[yy][xx] == BALL) {
//				int yyy = ballY;
//				int xxx = ballX;
//				if(move == 1) { yyy = yyy - 1; }
//				else if(move == 2) { yyy = yyy + 1; }
//				else if(move == 3) { xxx = xxx - 1; }
//				else if(move == 4) { xxx = xxx + 1; }
//
//				// 예외처리
//				if(SIZE <= xxx || xxx < 0) continue;
//				if(SIZE <= yyy || yyy < 0) continue;
//				if(map[yyy][xxx] != 0 && map[yyy][xxx] != GOAL) continue;
//				
//				// 공 이동시키기
//				map[ballY][ballX] = 0;
//				ballY = yyy;
//				ballX = xxx;
//				map[ballY][ballX] = BALL;
//			}
//			
//			// 캐릭터 이동시키기
//			map[pY][pX] = 0;
//			pY = yy;
//			pX = xx;
//			map[pY][pX] = PLAYER;
//			
//		}
//	}
//
//}
