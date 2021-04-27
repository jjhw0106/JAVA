package method_practice;

import java.util.Scanner;

class TttFunc {

	Scanner sc = new Scanner(System.in);
	final int PLAYER1 = 1;
	final int PLAYER2 = 2;

	int board[] = new int[9];
	int getNum = 0;
	int turn = 1;
	int winner = 0;

	void board() {

	}

	void show() {
		System.out.println("=======");
		for (int i = 0; i < 9; i++) {

			if (board[i] == PLAYER1)
				System.out.print("O");
			else if (board[i] == PLAYER2)
				System.out.print("X");
			else
				System.out.print("ㅁ");
			if (i % 3 == 2)
				System.out.println();
		}
		System.out.println("=======");
	}

	void input() {
		while (true) {
			getNum = sc.nextInt() - 1;
			if (board[getNum] != 0)
				System.out.println("이미 놓은 자리입니다");
			else {
				board[getNum] = turn;
				break;
			}
		}
	}

	void winCheck() {
		for (int i = 0; i < 3; i++) {
			if (board[i * 3] != 0 && board[i * 3] == board[i * 3 + 1] && board[i * 3] == board[i * 3 + 2]) {
				winner = turn;
				System.out.println(1);
			}
			if (board[i] != 0 && board[i] == board[i + 3] && board[i] == board[i + 6]) {
				winner = turn;
				System.out.println(2);
			}
			if (board[0] != 0 && board[0] == board[4] && board[0] == board[8]) {
				winner = turn;
				System.out.println(3);
			}
			if (board[2] != 0 && board[2] == board[4] && board[2] == board[6]) {
				winner = turn;
				System.out.println(4);
			}
		}
	}

	void turnChange() {
		if (turn == 1)
			turn = 2;
		else if (turn == 2)
			turn = 1;
	}

	void run() {
		while (true) {
			if (winner != 0) {
				show();
				break;
			}
			show();
			if (turn == PLAYER1) {
				System.out.print("p1: ");
				input();
				winCheck();

			} else if (turn == PLAYER2) {
				System.out.print("p2: ");
				input();
				winCheck();
			}
			if (winner == 0)
				turnChange();
		}
		System.out.println(winner + "가 이겼습니다");
	}
}

public class TicTacToe {
	public static void main(String[] args) {
		TttFunc t = new TttFunc();
		t.run();
	}
}
