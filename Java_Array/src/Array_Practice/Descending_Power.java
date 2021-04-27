package Array_Practice;

import java.util.Scanner;
import java.util.Random;

public class Descending_Power {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int[] score = { 10, 50, 30, 40, 80, 70 };
		int max = 0;
		int cnt = 0;
		int checkNum = 0;
		int maxIdx = 0;

		while (cnt < 6)
		{
			max = 0;
			for (int i = cnt; i < 6; i++)
				if (max <= score[i])
				{
					max = score[i];
					maxIdx = i;
				}

			System.out.println("맥스는" + max);
			for (int i = 0; i < 6; i++)
				System.out.print(score[i] + " ");
			System.out.println();

			int temp = score[cnt];
			score[cnt] = max;
			score[maxIdx] = temp;

			cnt++;
		}

	}

}
