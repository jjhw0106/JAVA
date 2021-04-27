package Array_Practice;

import java.util.Scanner;
import java.util.Random;

public class OneToFifty {
	public static void main(String[] args) {
		final int SIZE = 25;
		final int SROOT = 5;
		Scanner scan = new Scanner(System.in);
		Random ran = new Random();

		int count = 0;
		int finput = 0;
		int binput = 0;
		int[] front = new int[SIZE];
		for (int i = 0; i < SIZE; i++)
			front[i] = 0;
		int[] back = new int[SIZE];
		for (int i = 0; i < SIZE; i++)
			back[i] = 0;

		int inputIdx = 0;
		while (true)
		{
			int check = 1;
			finput = ran.nextInt(SIZE) + 1;
			binput = ran.nextInt(SIZE) + (SIZE + 1);

			// front 초기화
			if (inputIdx < SIZE)
			{
				// System.out.println(inputIdx);
				for (int i = 0; i < SIZE; i++)
					if (front[i] == finput)
					{
						check = -1;
						break;
					}
				if (check == 1)
				{
					front[count] = finput;
					count++;
					inputIdx++;
				}
				if (count >= SIZE)
				{
					count = 0;
					// break;
				}
			}
			// back 초기화
			else if (inputIdx >= SIZE)
			{
				// System.out.println(inputIdx);
				for (int i = 0; i < SIZE; i++)
					if (back[i] == binput)
					{
						check = -1;
						break;
					}
				if (check == 1)
				{
					back[count] = binput;
					count++;
					inputIdx++;
				}
				if (count >= SIZE)
					break;
			}
		}

		// board (실제 게임화면) 초기화
		double[] board = new double[SIZE];
		for (int i = 0; i < SIZE; i++)
			board[i] = front[i];

		// 게임 구현
		int answer = 1;
		inputIdx = 0; // front와 back을 나누기 위해서 사용
		while (true)
		{
			// 출력
			for (int i = 0; i < SIZE; i++)
			{
				if (board[i] == 0)
					System.out.print("□\t");
				else
				{
					System.out.printf("%.0f\t", board[i]);
					if (i % SROOT == (SROOT - 1))
						System.out.println();
				}
			}

			// 답 입력
			int sel = 0;
			System.out.print("입력: ");
			sel = scan.nextInt();

			// front -> back으로 뒤집기
			if (inputIdx < SIZE)
				if (board[sel - 1] == answer)
				{
					board[sel - 1] = back[sel - 1];
					answer++;
				} else
				{
					System.out.println("Game Over!!");
					break;
				}

			// back -> "□"로 뒤집기
			else if (inputIdx >= SIZE)
				if (board[sel - 1] == answer)
				{
					board[sel - 1] = 0; // Q. 문자로 how?
					answer++;
				} else
				{
					System.out.println("Game Over!!");
					break;
				}
			inputIdx++;

			if (inputIdx >= 2 * SIZE)
			{
				System.out.println("Game Clear!!");
				break;
			}
		}

		scan.close();
	}

}
