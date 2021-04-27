package method_practice;

import java.util.Random;
import java.util.Scanner;

class GameFunc {
	Random ran = new Random();
	Scanner sc = new Scanner(System.in);
	final int SIZE = 5;
	int show[][] = new int[SIZE][SIZE];
	int showCnt = 0;
	int front[][] = new int[SIZE][SIZE];
	int back[][] = new int[SIZE][SIZE];
	int gameOver = -1;
	int answer = 1;

	// 카드 앞, 뒤 초기화
	void initialize() {
		int getNum[] = new int[2 * SIZE * SIZE];
		int getNumIdx = 0;
		for (int i = 0; i < 2 * SIZE * SIZE; i++) {
			getNum[i] = i + 1;
		}
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				front[i][j] = getNum[getNumIdx];
				back[i][j] = getNum[SIZE * SIZE + getNumIdx];
				getNumIdx++;
			}
		}

	}

	// 카드섞기
	void mix() {
		for (int i = 0; i < 50; i++) {
			int rNum1 = ran.nextInt(SIZE);
			int rNum2 = ran.nextInt(SIZE);

			int temp = front[0][0];
			front[0][0] = front[rNum1][rNum2];
			front[rNum1][rNum2] = temp;

			rNum1 = ran.nextInt(SIZE);
			rNum2 = ran.nextInt(SIZE);

			temp = back[0][0];
			back[0][0] = back[rNum1][rNum2];
			back[rNum1][rNum2] = temp;
		}

	}

	// 출력값 초기화
	void showInit() {
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				show[i][j] = front[i][j];
			}
		}
	}

	// 뒤집을 카드 선택
	void select() {
		int idxX;
		int idxY;

		while (true) {
			System.out.print("Y: ");
			idxY = sc.nextInt() - 1;
			System.out.print("X: ");
			idxX = sc.nextInt() - 1;

			if (show[idxY][idxX] != answer) {
				gameOver = 1;
				break;
			}

			if (idxY > SIZE || idxY < 0) {
				continue;
			}
			if (idxX > SIZE || idxX < 0) {
				continue;
			}

			answer++;
			if (show[idxY][idxX] == front[idxY][idxX]) {
				show[idxY][idxX] = back[idxY][idxX];
			} else if (show[idxY][idxX] == back[idxY][idxX]) {
				show[idxY][idxX] = 0;
				showCnt++;
			}
			break;
		}
	}

	// 화면 출력
	void show() {
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				if (show[i][j] != 0) {
					System.out.print(show[i][j] + " ");
				} else if (show[i][j] == 0) {
					System.out.print("■" + " ");
				}
			}
			System.out.println();
		}
	}

	void run() {
		initialize();
		mix();
		showInit();
		while (true) {
			if (gameOver == 1) {
				System.out.println("Game Over");
				break;
			}
			if (showCnt == SIZE * SIZE) {
				System.out.println("Game Clear");
				break;
			}
			show();
			System.out.println();
			select();
		}
		System.out.println("게임끝");
	}

}

public class OnetoFiftyGame {
	public static void main(String[] args) {
		GameFunc game = new GameFunc();
		game.run();
	}
}
