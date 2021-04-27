package file_practice;

public class Snail {
	public static void main(String[] args) {

		int size = 5;
		int[][] map = new int[size][size];

		int cnt = size; // 증가되는 숫자 개수
		int check = 1; // 개수 줄이기 위한 기준
		int num = 1;

		int dir = -1; // 맨 첫 줄 초기화 위해 -1로 초기화

		int xPos = 0;
		int yPos = 0;

//		아이디어
//		한방향으로 cnt만큼 num가 채워짐
//		같은 거리가 두번씩 반복됨
//		10-9-9-8-8-7-7...1-1
//		->체크가 2가 될때마다 cnt--		//***
//		cnt만큼 숫자 채우고 방향전환			//***

		while (num < size * size + 1) {
//			for (int i = 0; i < size; i++) {
//				for (int j = 0; j < size; j++)
//					System.out.print(map[i][j] + "\t");
//				System.out.println();
//			}
			if (check == 2) {
				cnt--;
				check = 0;
			}

			// 첫 줄 초기화
			if (dir == -1) {
				int tempIdx = 0;
				for (int i = 0; i < cnt; i++) {
					map[yPos][xPos + i] = num;
					num++;
					tempIdx = xPos + i;
				}
				dir += 2; // 바로 아래쪽 숫자 채우기 위해 +2
				xPos = tempIdx;
				check++;
			}

			// 달팽이 안쪽 채우기////
			else if (dir == 0) {
				int tempIdx = 0;
				for (int i = 0; i < cnt; i++) {
					map[yPos][xPos + i + 1] = num;
					num++;
					tempIdx = xPos + i + 1;
				}
				dir++;
				xPos = tempIdx;
				check++;
			}

			else if (dir == 1) {
				int tempIdx = 0;
				for (int i = 0; i < cnt; i++) {
					map[yPos + i + 1][xPos] = num;
					num++;
					tempIdx = yPos + i + 1;
				}
				dir++;
				yPos = tempIdx;
				check++;
			}

			else if (dir == 2) {
				int tempIdx = 0;
				for (int i = 0; i < cnt; i++) {
					map[yPos][xPos - i - 1] = num;
					num++;
					tempIdx = xPos - i - 1;
				}
				dir++;
				xPos = tempIdx;
				check++;
			}

			else if (dir == 3) {
				int tempIdx = 0;
				for (int i = 0; i < cnt; i++) {
					map[yPos - i - 1][xPos] = num;
					num++;
					tempIdx = yPos - i - 1;
				}
				yPos = tempIdx;
				dir = 0;
				check++;
			}
		}
		/////////////////////////////////////

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++)
				System.out.print(map[i][j] + "\t");
			System.out.println();
		}
	}
}

//메가스터디 정답
//		int size = 5;
//		int[][] map = new int[5][5];
//		boolean[][] check = new boolean[5][5];
//
//		int x = 0;
//		int y = 0;
//		int num = 1;
//		int dir = 1; // 1(오른쪽) 2(하) 3(왼쪽) 4(상)
//
//		map[y][x] = num;
//		check[y][x] = true;
//
//		for (int i = 0; i < 24; i++) {
//
//			int yy = y;
//			int xx = x;
//
//			if (dir == 1) {
//				xx = xx + 1;
//			} else if (dir == 2) {
//				yy = yy + 1;
//			} else if (dir == 3) {
//				xx = xx - 1;
//			} else if (dir == 4) {
//				yy = yy - 1;
//			}
//
//			if (size <= xx || xx < 0 || size <= yy || yy < 0 || check[yy][xx] == true) {
//				dir = dir + 1;
//
//				yy = y;
//				xx = x;
//
//				if (dir == 5) {
//					dir = 1;
//				}
//
//				if (dir == 1) {
//					xx = xx + 1;
//				} else if (dir == 2) {
//					yy = yy + 1;
//				} else if (dir == 3) {
//					xx = xx - 1;
//				} else if (dir == 4) {
//					yy = yy - 1;
//				}
//			}
//
//			num = num + 1;
//
//			y = yy;
//			x = xx;
//
//			map[y][x] = num;
//			check[y][x] = true;
//
//			System.out.println("y =  " + y + ", x = " + x);
//
//		}
//
//		for (int i = 0; i < 5; i++) {
//			for (int j = 0; j < 5; j++) {
//				System.out.print(map[i][j] + "\t");
//			}
//			System.out.println();
//		}
//		System.out.println();
//
//		for (int i = 0; i < 5; i++) {
//			for (int j = 0; j < 5; j++) {
//				System.out.print(check[i][j] + "\t");
//			}
//			System.out.println();
//		}
//		System.out.println();
//
//	}
//}
