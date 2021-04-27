package method_practice;

import java.util.Scanner;

class SadariFunc {
	Scanner sc = new Scanner(System.in);
	int size = 5;
	int[][] ladder = { { 0, 0, 0, 0, 0 },

			{ 1, 2, 0, 1, 2 },

			{ 0, 1, 2, 0, 0 },

			{ 0, 0, 0, 1, 2 },

			{ 0, 1, 2, 0, 0 },

			{ 1, 2, 0, 0, 0 },

			{ 0, 0, 0, 1, 2 },

			{ 0, 0, 0, 0, 0 } };
	int y = 0;
	int x = 0;
	String reward[] = { "과자", "딸기", "포도", "사과", "감" };

	int numSel[] = new int[size];

	void rewardSet() {
	}

	void move() {
		while (true) {
			if (y == ladder.length) {
				break;
			}
			if (ladder[y][x] == 1) {
				x++;
				y++;
			} else if (ladder[y][x] == 0) {
				y++;
			} else if (ladder[y][x] == 2) {
				x--;
				y++;
			}
		}

	}

	void numSel() {
		System.out.print("번호 선택: ");
		int num = sc.nextInt() - 1;
		y = 0;
		x = num;
	}

	void getTem() {
		System.out.println(reward[x]);
	}

	void show() {
		for (int i = 0; i < size; i++)
			System.out.print("  " + "i");
		System.out.println();
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < ladder[i].length; j++) {
				if (ladder[i][j] == 0)
					System.out.print("  │");
				else if (ladder[i][j] == 1)
					System.out.print("  ├─");
				else if (ladder[i][j] == 2)
					System.out.print("─┤");
			}
			System.out.println();
		}

		System.out.println(ladder.length);
		for (int i = 0; i < reward.length; i++)
			System.out.print(reward[i] + "\t");
		System.out.println();
	}

	void run() {
		show();
		numSel();
		move();
		getTem();
	}
}

public class Sadari {
	public static void main(String[] args) {
		SadariFunc s = new SadariFunc();
		s.run();

	}
}
