package megastudy_test7;

import java.util.Random;
import java.util.Scanner;

class Game2048 {
	Scanner sc = new Scanner(System.in);
	Random ran = new Random();
	int size = 4;
	int map[][] = new int[size][size];
	int mapIdx = 0;
	int score = 0;

	final String LEFT = "a";
	final String RIGHT = "d";
	final String UP = "w";
	final String DOWN = "s";

	void getTwo() {
		while (true) {

			int y = ran.nextInt(size);
			int x = ran.nextInt(size);
			if (map[y][x] != 0) {
				continue;
			} else {
				map[y][x] = 2;
				break;
			}
		}
	}

	void show() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				System.out.print(map[i][j] + "\t");
			}
			System.out.println();
		}
	}

	
	//map에서 0이 아닌 숫자 뽑아내기
	int[] noZeroPick(int n, String dir) {
		int cnt = 0;
		int[] temp = new int[4];

		if (dir.equals("d") || dir.equals("a")) {
			for (int j = 0; j < size; j++) {
				if (map[n][j] != 0) {
					temp[cnt] = map[n][j];
					cnt++;
				}
			}
		} else if (dir.equals("w") || dir.equals("s")) {
			for (int j = 0; j < map.length; j++) {
				if (map[j][n] != 0) {
					temp[cnt] = map[j][n];
					cnt++;
				}
			}
		}
		int pick[] = new int[cnt];
		for (int i = 0; i < pick.length; i++) {
			pick[i] = temp[i];
		}
		return pick;
	}

	//뽑아낸 숫자 라인 별 합치기
	//(위쪽, 왼쪽)
	int[] sumLine(int pick[], String dir) {
		if (dir.equals("w") || dir.equals("a")) {
			for (int i = 0; i < pick.length - 1; i++) {
				if (pick[i] == pick[i + 1]) {
					pick[i] += pick[i + 1];
					score += pick[i + 1];
					pick[i + 1] = 0;
				}
			}
		}
		//(아래쪽, 오른쪽)
		else if (dir.equals("s") || dir.equals("d")) {
			for (int i = pick.length - 1; i > 0; i--) {
				if (pick[i] == pick[i - 1]) {
					pick[i] += pick[i - 1];
					score += pick[i - 1];
					pick[i - 1] = 0;
				}
			}
		}

		int[] line = pick;
		return line;
	}

	//합친 숫자 방향에 맞춰 재정렬
	int[] lineOrder(int line[], String dir) {
		int[] orderedLine = new int[size];
		if (dir.equals("w") || dir.equals("a")) {
			int idx = 0;
			for (int i = 0; i < line.length; i++) {
				if (line[i] != 0) {
					orderedLine[idx] = line[i];
					idx++;
				}
			}
		} else if (dir.equals("s") || dir.equals("d")) {
			int idx = size - 1;
			for (int i = line.length - 1; i >= 0; i--) {
				if (line[i] != 0) {
					orderedLine[idx] = line[i];
					idx--;
				}
			}
		}
		return orderedLine;
	}

	//map[][]에 정렬된 라인 대입
	void mapMatch(int orderedLine[], String dir) {

		if (dir.equals("a") || dir.equals("d")) {
			for (int i = 0; i < size; i++) {
				map[mapIdx][i] = orderedLine[i];
			}
		} else if (dir.equals("w") || dir.equals("s")) {
			for (int i = 0; i < size; i++) {
				map[i][mapIdx] = orderedLine[i];
			}
		}
		mapIdx++;
	}

	//맵에 몇개 놓여있는지 cnt(게임 오버 조건 위해 생성)
	int mapNumCnt() {
		int cnt = 0;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (map[i][j] != 0) {
					cnt++;
				}
			}
		}

		return cnt;

	}

	//mapNumCnt가 맵 전체 사이즈 보다 작거나, 맵 전체 사이즈와 같지만 합칠 수 있는 숫자가 남아 있으면 진행
	boolean gameOver() {
		boolean gameOver = true;
		int mapNumCnt = mapNumCnt();
		if (mapNumCnt < size * size) {
			gameOver = false;
		}
		if (mapNumCnt == size * size) {
			for (int i = 0; i < map.length - 1; i++) {
				for (int j = 0; j < map.length - 1; j++) {
					if (map[i][j] == map[i + 1][j] || map[i][j] == map[i][j + 1])
						gameOver = false;
				}
			}
		}
		return gameOver;
	}

	void run() {
		for (int i = 0; i < 2; i++) {
			getTwo();
		}
		String dir;
		while (true) {
			System.out.println("점수: " + score);
			System.out.println("===========================");
			show();
			System.out.println("===========================");
			System.out.print("방향선택: ");
			dir = sc.next();
			for (int i = 0; i < size; i++) {
				int pick[] = noZeroPick(i, dir);
				int line[] = sumLine(pick, dir);
				int orderedLine[] = lineOrder(line, dir);
				mapMatch(orderedLine, dir);
				// test
//				for (int j = 0; j < pick.length; j++)	
//					System.out.print("제로픽: " + pick[j]);
//				System.out.println();
//				for (int j = 0; j < line.length; j++)	
//					System.out.print("라인: "+line[j]);
//				System.out.println();
//				for (int j = 0; j < orderedLine.length; j++)	
//					System.out.print("오더라인: " + orderedLine[j]);
//				System.out.println();
				////////////////////////
			}
			mapIdx = 0;
			boolean gameOver = gameOver();

			if (gameOver == true) {
				System.out.println("Game Over");
				break;
			}

			int mapNumCnt = mapNumCnt();
			if (mapNumCnt == size * size)
				continue;

			getTwo();

		}
	}
}

public class Solution8_Game2048 {
	public static void main(String[] args) {
		Game2048 game = new Game2048();
		game.run();
	}
}
