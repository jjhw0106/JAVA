package practice;

import java.util.Scanner;

class Tic {
	int sel = 0;
	int line[] = new int[3];

	void show() {
		for (int i = 0; i < line.length; i++)
			if (line[i] == 0) {
				System.out.print("■" + " ");
			} else if (line[i] == 1) {
				System.out.print("O" + " ");
			} else if (line[i] == 2) {
				System.out.print("X" + " ");
			}
		System.out.println();
	}

}

public class Ex5_TicTacToe {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Tic t[] = new Tic[3];
		for (int i = 0; i < t.length; i++) {
			t[i] = new Tic();
		}
		int turn = 1;
		while (true) {

			for (int i = 0; i < t.length; i++) {
				t[i].show();
			}
			System.out.println("y,x입력 ");
			int yPos = sc.nextInt();
			int xPos = sc.nextInt();
			if (yPos < 0 || yPos > 2)
				continue;
			if (xPos < 0 || xPos > 2)
				continue;
			t[yPos].line[xPos] = turn;
			turn = turn % 2 + 1;
		}

	}
}
