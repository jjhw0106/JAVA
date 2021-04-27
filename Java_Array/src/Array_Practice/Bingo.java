package Array_Practice;

import java.util.Scanner;

public class Bingo {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		final int SIZE = 5;
		int[][] bingoArr = {

				{ 20, 30, 40, 20, 1 },

				{ 5, 7, 25, 21, 1 },

				{ 2, 3, 4, 5, 1 },

				{ 45, 77, 87, 22, 1 },

				{ 21, 99, 87, 11, 1 }

		};

		int xpos = 0;
		int ypos = 0;
		int count = 0;

		while (true)
		{
			int garo = 0;
			int sero = 0;

			for (int i = 0; i < SIZE; i++)
			{
				for (int j = 0; j < SIZE; j++)
				{
					System.out.print(bingoArr[i][j] + "\t");
				}
				System.out.println();
			}
			System.out.print("x좌표: ");
			xpos = sc.nextInt();

			System.out.print("y좌표: ");
			ypos = sc.nextInt();

			bingoArr[xpos][ypos] = 0;

			// 가로검사
			while (garo < SIZE)
			{
				for (sero = 0; sero < SIZE; sero++)
				{
					if (bingoArr[garo][sero] == 0)
						count++;
					else
					{
						count = 0;
						break;
					}
				}
				if (count == 5)
				{
					System.out.println("BINGO!!!");
					break;
				}
				garo++;
			}
			if (count == 5)
				break;

			// 세로검사
			sero = 0;
			while (sero < SIZE)
			{
				for (garo = 0; garo < SIZE; garo++)
				{
					if (bingoArr[garo][sero] == 0)
						count++;
					else
					{
						count = 0;
						break;
					}
				}
				if (count == 5)
				{
					System.out.println("BINGO!!!");
					break;
				}
				sero++;
			}
			if (count == 5)
				break;

			// 대각선체크
			garo = 0;
			sero = 0;
			while (garo < SIZE)
			{
				if (garo == sero && bingoArr[garo][sero] == 0)
					count++;
				else
				{
					count = 0;
					break;
				}
				garo++;
				sero++;
				if (count == 5)
				{
					System.out.println("BINGO!!!");
					break;
				}
			}
			if (count == 5)
				break;

			// 역대각선체크
			garo = 0;
			sero = 0;
			while (garo < SIZE)
			{
				sero = SIZE - 1 - garo;
				if (bingoArr[garo][sero] == 0)
					count++;
				else
				{
					count = 0;
					break;
				}
				garo++;
				if (count == 5)
				{
					System.out.println("BINGO!!!");
					break;
				}
			}
			if (count == 5)
				break;
		}

	}
}
