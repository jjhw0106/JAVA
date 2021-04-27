package Array_Practice;

import java.util.Scanner;
import java.util.Random;

// 번호 랜덤으로 생성
//		1p하나, 2p하나
//		중복된 숫자일 경우 다시 입력
//	답지에선 mark배열 만들어서 결과만 배열 저장

public class Bingo2 {
	public static void main(String[] args) {

		final int SIZE = 5;

		Scanner sc = new Scanner(System.in);
		Random ran = new Random();

		int value = 0;
		int[][] me = new int[SIZE][SIZE];
		int[][] you = new int[SIZE][SIZE];

		// me ////////////////////////////////////////
		int[] temp = new int[SIZE * SIZE];
		for (int i = 0; i < SIZE * SIZE; i++)
		{
			value = ran.nextInt(100) + 1;
			if (i == 0)
				temp[i] = value;
			else if (i > 0)
			{
				temp[i] = value;
				for (int j = 0; j < i; j++)
				{
					if (temp[j] == value)
					{
						i--;
						break;
					}
				}
			}

		}
		int n = 0;
		for (int i = 0; i < SIZE; i++)
			for (int j = 0; j < SIZE; j++)
			{
				me[i][j] = temp[n];
				n++;
			}

		// you ////////////////////////////////////////
		temp = new int[SIZE * SIZE];
		for (int i = 0; i < SIZE * SIZE; i++)
		{
			value = ran.nextInt(100) + 1;
			if (i == 0)
				temp[i] = value;
			else if (i > 0)
			{
				temp[i] = value;
				for (int j = 0; j < i; j++)
				{
					if (temp[j] == value)
					{
						i--;
						break;
					}
				}
			}

		}
		n = 0;
		for (int i = 0; i < SIZE; i++)
			for (int j = 0; j < SIZE; j++)
			{
				you[i][j] = temp[n];
				n++;
			}

////////////////////////////////////////
		while (true)
		{
			// 초기 화면--------------------------------------------------
			System.out.println("================ME================");
			for (int i = 0; i < SIZE; i++)
			{
				for (int j = 0; j < SIZE; j++)
					System.out.print(me[i][j] + "\t");
				System.out.println();
			}
			System.out.println("==================================");
			System.out.println();
			System.out.println("================YOU===============");
			for (int i = 0; i < SIZE; i++)
			{
				for (int j = 0; j < SIZE; j++)
					System.out.print(you[i][j] + "\t");
				System.out.println();
			}
			System.out.println("==================================");

//		ME턴(1)


			int turn = 1;
			int xpos;
			int ypos;
			while (true)
			{
				if (turn == 1)
				{
					xpos = 0;
					ypos = 0;
					System.out.println("Player ME");
					System.out.print("x좌표: ");
					xpos = sc.nextInt();
					System.out.print("y좌표: ");
					ypos = sc.nextInt();

					if (me[xpos][ypos] != 0)
					{
						me[xpos][ypos] = 0;
						turn = 0;
					}

					if (turn == 0)
						break;
				}

			}
			// 탐색
			int count = 0;
			int mwin = 0;
			// 가로
			while (mwin == 0 && xpos < SIZE)
			{
				for (int j = 0; j < SIZE; j++)
				{
					if (me[xpos][j] == 0)
						count++;
					else
					{
						count = 0;
						break;
					}

					if (count == SIZE)
					{
						mwin = 1;
						break;
					}
				}
				xpos++;

			}

			// 세로
			count = 0;
			while (mwin == 0 && ypos < SIZE)
			{
				for (int i = 0; i < SIZE; i++)
				{
					if (me[i][ypos] == 0)
						count++;
					else
					{
						count = 0;
						break;
					}

					if (count == SIZE)
					{
						mwin = 1;
						break;
					}
				}
				ypos++;

			}

			// 대각선
			xpos = 0;
			ypos = 0;
			count = 0;
			for (int i = 0; i < SIZE; i++)
			{
				if (me[xpos][ypos] == 0)
				{
					count++;
					xpos++;
					ypos++;
					if (count == SIZE)
					{
						mwin = 1;
						break;
					}
				} else
				{
					count = 0;
					break;
				}
			}

			// 역방 대각선
			count = 0;
			xpos = 0;
			ypos = 0;
			for (int i = 0; i < SIZE; i++)
			{

				if (me[xpos][SIZE - 1 - xpos] == 0)
				{
					count++;
					xpos++;
					if (count == SIZE)
					{
						mwin = 1;
						break;
					}
				}

				else
					break;

			}

			if (mwin == 1)
				System.out.println("BINGO!!");

			// you턴
			while (true)
			{
				if (turn == 0)
				{
					xpos = 0;
					ypos = 0;
					System.out.println("Player YOU");
					System.out.print("x좌표: ");
					xpos = sc.nextInt();
					System.out.print("y좌표: ");
					ypos = sc.nextInt();

					if (you[xpos][ypos] != 0)
					{
						you[xpos][ypos] = 0;
						turn = 1;
					}

					if (turn == 1)
						break;
				}
			}

			// 탐색
			count = 0;
			int ywin = 0;
			// 가로
			while (ywin == 0 && xpos < SIZE)
			{
				for (int j = 0; j < SIZE; j++)
				{
					if (you[xpos][j] == 0)
						count++;
					else
					{
						count = 0;
						break;
					}

					if (count == SIZE)
					{
						ywin = 1;
						break;
					}
				}
				xpos++;

			}

			// 세로
			count = 0;
			while (ywin == 0 && ypos < SIZE)
			{
				for (int i = 0; i < SIZE; i++)
				{
					if (you[i][ypos] == 0)
						count++;
					else
					{
						count = 0;
						break;
					}

					if (count == SIZE)
					{
						ywin = 1;
						break;
					}
				}
				ypos++;

			}

			// 대각선
			xpos = 0;
			ypos = 0;
			count = 0;
			for (int i = 0; i < SIZE; i++)
			{
				if (you[xpos][ypos] == 0)
				{
					count++;
					xpos++;
					ypos++;
					if (count == SIZE)
					{
						ywin = 1;
						break;
					}
				} else
				{
					count = 0;
					break;
				}
			}

			// 역방 대각선
			count = 0;
			xpos = 0;
			ypos = 0;
			for (int i = 0; i < SIZE; i++)
			{

				if (you[xpos][SIZE - 1 - xpos] == 0)
				{
					count++;
					xpos++;
					if (count == SIZE)
					{
						ywin = 1;
						break;
					}
				}

				else
					break;

			}
			if (ywin == 1)
				System.out.println("BINGO!!");
			System.out.println();
			System.out.println();

			// 승패
			if (mwin == 1 && ywin == 1)
			{
				System.out.println("DRAW!!!");
				break;
			}

			else if (mwin == 1 && ywin != 1)
			{
				System.out.println("ME WIN!!!");
				break;
			}

			else if (mwin != 1 && ywin == 1)
			{
				System.out.println("YOU WIN!!!");
				break;
			}

		}
	}
}