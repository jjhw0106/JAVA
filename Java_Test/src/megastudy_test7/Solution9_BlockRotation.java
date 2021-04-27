package megastudy_test7;

import java.util.Scanner;
// 문제)  아래 명령어를 입력받을때마다 block배열을 회전해보세요

/*
 * 예) 1) left_turn
 * 4 8 12 16
 * 3 7 11 15
 * 2 6 10 14
 * 1 5 9  13
 */

// 1) left_turn 2)right_turn

class Rotate {
	int size;
	int line[][];

	public Rotate(int size) {
		this.size = size;
	}

	int[][] getTemp(int block[][]) {
		line = new int[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < block.length; j++) {
				line[i][j] = block[i][j];// line[i]=block[i]로 초기화 시 에러났음. (block의 주소를 참조하여 동시에 바뀜)
			}
		}
		return line;
	}
}

public class Solution9_BlockRotation {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int block[][] = {

				{ 1, 2, 3, 4 },

				{ 5, 6, 7, 8 },

				{ 9, 10, 11, 12 },

				{ 13, 14, 15, 16 },

		};
		int size = block.length;
		Rotate r = new Rotate(size);
		while (true) {
			int line[][] = r.getTemp(block);
			for (int i = 0; i < block.length; i++) {
				for (int j = 0; j < block.length; j++) {
					System.out.print(block[i][j] + "\t");
				}
				System.out.println();
			}
			System.out.println("라인");
			for (int i = 0; i < block.length; i++) {
				for (int j = 0; j < block.length; j++) {
					System.out.print(line[i][j] + "\t");
				}
				System.out.println();
			}
			System.out.println("회전방향: ");
			int sel = sc.nextInt();
			if (sel == 1) {
				int idx = 0;
				for (int k = 0; k < size; k++) {
					for (int i = 0; i < line.length; i++) {
						block[i][idx] = line[idx][size - i - 1];
					}
					idx++;
				}
			} else if (sel == 2) {
				int idx = 0;

				for (int k = 0; k < size; k++) {
					for (int i = 0; i < line.length; i++) {
						block[i][size - idx - 1] = line[idx][i];
					}
					idx++;
				}
			}
		}

	}
}
