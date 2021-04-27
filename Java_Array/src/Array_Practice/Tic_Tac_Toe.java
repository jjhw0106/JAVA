package Array_Practice;

import java.util.Scanner;
import java.util.Random;

public class Tic_Tac_Toe {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		Random ran = new Random();

		int turn = 1;
		int win = 0;
		int[] game = { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		int i = 0;
		int round = 0;
		boolean exit = true;

		while (exit == true)
		{
			int player = 0;
			int cpu = 0;
			round++;
			
			// 플레이어 턴
			if (turn == 1)
			{
				System.out.println();
				System.out.print("Player. 어디에 놓으시겠습니까? : ");
				player = scan.nextInt() - 1;
				if (game[player] == 0)
				{
					game[player] = 1;
					turn = 2;
				} else
					System.out.println("놓을 수 없습니다.");
			}

			// cpu 턴
			else if (turn == 2)
			{
				System.out.println();
				System.out.print("CPU. 어디에 놓으시겠습니까? : ");
				cpu = ran.nextInt(9);
				System.out.println(cpu);
				if (game[cpu] == 0)
				{
					game[cpu] = 2;
					turn = 1;
				}

			} 

			// 게임판.
			for (i = 0; i < 9; i++)
			{
				if (game[i] == 1)
					System.out.print(" ○ ");
				else if (game[i] == 2)
					System.out.print(" x ");
				else
					System.out.print(" □ ");

				if (i %3 == 2)
					System.out.println();
			}
			
			// 승리조건
			for (i = 0; i < 2; i++)
			{
				if (game[0 + 3 * i] == 1 && game[1 + 3 * i] == 1 && game[2 + 3 * i] == 1)
					win = 1;
				if (game[0 + 3 * i] == 2 && game[1 + 3 * i] == 2 && game[2 + 3 * i] == 2)
					win = 2;
			}

			for (i = 0; i < 2; i++)
			{
				if (game[0 + i] == 1 && game[3 + i] == 1 && game[6 + i] == 1)
					win = 1;
				if (game[0 + i] == 2 && game[3 + i] == 2 && game[6 + i] == 2)
					win = 2;
			}

			if (game[0] == 1 && game[4] == 1 && game[8] == 1)
				win = 1;
			else if (game[0] == 2 && game[4] == 2 && game[8] == 2)
				win = 2;

			if (game[2] == 1 && game[4] == 1 && game[6] == 1)
				win = 1;
			else if (game[2] == 2 && game[4] == 2 && game[6] == 2)
				win = 2;

			if (win == 1)
			{
				System.out.println();
				System.out.println("========플레이어 승리!!========");
				exit = false;
			}
			if (win == 2)
			{
				System.out.println("========cpu 승리!!========");
				exit = false;
			}

		}
	}
}
