package megastudy_test4;

import java.util.Scanner;

//start 5:45 ~ end 5:56
public class Sukcha {
	public static void main(String[] args) {
		String[] name = { "홍길동", "김영", "자바킹", "민병철", "메가맨" };
		int[] score = { 87, 42, 100, 11, 98 };

		int idx = 0;
		int max = score[0];
		int count = 0;

		while (count < score.length) {
			for (int i = count; i < score.length; i++) {
				if (max < score[i]) {
					idx = i;
					break;
				}
			}

			int stemp = score[count];
			score[count] = score[idx];
			score[idx] = stemp;

			String ntemp = name[count];
			name[count] = name[idx];
			name[idx] = ntemp;

			count++;
		}

		for (int i = 0; i < score.length; i++) {
			System.out.print(score[i] + " " + name[i]);
			System.out.println();
		}

	}
}
