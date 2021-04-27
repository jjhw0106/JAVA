package megastudy_test7;

import java.util.Scanner;

 class Game {
	int line[] = new int[3];

	void printLine() {
		for (int i = 0; i < line.length; i++) {
//			if (line[i] == 1) {
//				System.out.print("O ");
//			} else if (line[i] == 2) {
//				System.out.print("X ");
//			} else if (line[i] == 0) {
//				System.out.print("ㅁ ");
//			}
			System.out.print(line[i]);
		}
	}
}

class Play {
	Scanner sc = new Scanner(System.in);
	Game g[] = new Game[3];

	int turn = 0;

	void gameInit() {
		for (int i = 0; i < 3; i++) {
			g[i] = new Game();
		}
	}

	void selPos() {
		while (true) {
			System.out.print("y: ");
			int getYPos = sc.nextInt() - 1;
			if (getYPos > 2 || getYPos < 0) {
				System.out.println("다시 입력하세요");
				continue;
			}
			System.out.print("x: ");
			int getXPos = sc.nextInt() - 1;
			if (getXPos > 2 || getXPos < 0) {
				System.out.println("다시 입력하세요");
				continue;
			}
			if (g[getYPos].line[getXPos] != 0) {
				System.out.println("이미 놓여진 자리입니다.");
				continue;
			}

			g[getYPos].line[getXPos] = this.turn % 2 + 1;
			this.turn++;
			break;
		}
	}

	int winner() {
		int winner = 0;
		for (int i = 0; i < 3; i++) {
			if (g[i].line[0] == g[i].line[1]) {
				if (g[i].line[0] == g[i].line[2]) {
					winner = g[i].line[0];
					break;
				}
			}
		}
		for (int i = 0; i < 3; i++) {
			if (g[0].line[i] == g[1].line[i]) {
				if (g[0].line[i] == g[2].line[i]) {
					winner = g[0].line[i];
					break;
				}
//					System.out.println(g[0].line[i]);
//					System.out.println(g[1].line[i]);
//					System.out.println(g[2].line[i]);
			}
		}
		for (int i = 0; i < 3; i++) {
			if (g[0].line[0] == g[1].line[1]) {
				if (g[0].line[0] == g[2].line[2]) {
					winner = g[0].line[0];
					break;
				}
			}
		}
		for (int i = 0; i < 3; i++) {
			if (g[0].line[2] == g[1].line[1]) {
				if (g[0].line[2] == g[2].line[0]) {
					winner = g[0].line[2];
					break;
				}
			}
		}
		// 아래 문장 질문(for문으로 묶었더니 오류-인풋: 11,22,12,32,31,23,21)
//		int winner = 0;
//		for (int i = 0; i < 3; i++) {
//			if (g[i].line[0]!=0&&g[i].line[0] == g[i].line[1]) {
//				if (g[i].line[0] == g[i].line[2]) {
//					winner = g[i].line[0];
//					break;
//				}
//			} else if (g[0].line[i]!=0&&g[0].line[i] == g[1].line[i]) {
//				if (g[0].line[i] == g[2].line[i]) {
//					winner = g[0].line[i];
//					break;
//				}
//			} else if (g[0].line[0]!=0&&g[0].line[0] == g[1].line[1]) {
//				if (g[0].line[0] == g[2].line[2]) {
//					winner = g[0].line[0];
//					break;
//				}
//			} else if (g[0].line[2] == g[1].line[1]) {
//				if (g[0].line[2] == g[2].line[0]) {
//					winner = g[0].line[2];
//					break;
//				}
//			}
//		}
		return winner;
	}

	void run() {
		gameInit();
		int cnt = 0;
		int winner = 0;
		while (true) {
			for (int i = 0; i < g.length; i++) {
				g[i].printLine();
				System.out.println();
			}
			if (cnt == 9 || winner != 0) {
				break;
			}
			System.out.println("플레이어 " + (turn % 2 + 1) + "차례");
			selPos();
			cnt++;
			winner = winner();
		}
		if (winner == 0) {
			System.out.println("무승부");
		} else {
			System.out.println(winner + "승리");
		}
	}
}

public class Solution5_TicTacToe {
	public static void main(String[] args) {
		Play p = new Play();

		p.run();
	}
}
