package Array_Practice;

import java.util.Scanner;

public class Mini_Marble {

	/*
	 * # 미니마블 1. 플레이어는 p1과 p2 2명이다. 2. 번갈아가며 1~3 사이의 숫자를 입력해 이동한다. 3. 이동하다가 다음 플레이어와
	 * 같은 위치에 놓이게 되면, 상대 플레이어는 잡히게 되어 원점으로 되돌아간다. 4. 먼저 3바퀴를 돌면 이긴다.
	 * 
	 * [p2]1~3 입력 : 1 1 2 3 4 5 6 7 8 0 1 0 0 0 0 0 0 0 0 0 2 0 0 0 0
	 * 
	 * [p1]1~3 입력 : 3 [p1]이 p2를 잡았다! 1 2 3 4 5 6 7 8 0 0 0 0 1 0 0 0 2 0 0 0 0 0 0 0
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] game = new int[8];

		int[] player1 = { 0, 0, 0, 0, 0, 0, 0, 0 };
		int p1Lap = 0;
		int p1Pos = 0;

		int[] player2 = { 0, 0, 0, 0, 0, 0, 0, 0 };
		int p2Lap = 0;
		int p2Pos = 0;

		int move = 0;
		int turn = 1;
		int i;

		boolean run = true;

		while (run == true)
		{
			System.out.print("map:\t ");
			System.out.println("1 2 3 4 5 6 7 8");

			System.out.print("player1: ");
			for (i = 0; i < 8; i++)
				System.out.print(player1[i] + " ");
			System.out.println();
			player1[p1Pos] = 0;						//지나간 자리 다시 0으로 만들기 위해

			System.out.print("player2: ");
			for (i = 0; i < 8; i++)
				System.out.print(player2[i] + " ");
			System.out.println();
			player2[p2Pos] = 0;						//지나간 자리 다시 0으로 만들기 위해

			System.out.println("몇 칸 이동하시겠습니까?(1~3칸 이동가능)");

			
			//player 1
			if (turn == 1)
			{
				System.out.print("P1: ");
				move = scan.nextInt();
				p1Pos += move;
				if (p1Pos >= 7)
				{
					p1Pos -= 7;
					p1Lap++;
				}
				if(p1Pos == p2Pos)
					p2Pos=0;
				
				if(p1Lap>=3)
					break;
				player1[p1Pos] = 1;
				turn = 2;
			}

			//player 2
			if (turn == 2)
			{
				System.out.print("P2: ");
				move = scan.nextInt();
				if(move>3) break;
				p2Pos += move;
				if (p2Pos >= 7)
				{
					p2Pos -= 7;
					p2Lap++;
				}
				if(p1Pos == p2Pos)
					p1Pos=0;
				
				if(p2Lap>=3)
					break;
				player2[p2Pos] = 2;
				turn = 1;
			}
		}
				
		if(p1Lap==3)
			System.out.println("플레이어1이 승리");
		else if(p2Lap ==3)
			System.out.println("플레이어2가 승리");
	}

}
