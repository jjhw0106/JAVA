package Array_Practice;

import java.util.Scanner;

public class Character_Move_lv2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int i;
		int move = 0;
		int idx = 0;
		int[] game = { 0, 0, 1, 0, 0, 2, 0, 0, 1, 0};

		boolean run = true;
		while (run == true)
		{

			// 캐릭터 위치
			for (i = 0; i < 10; i++)
			{
				if (game[i] == 2)
					idx = i;
				if (game[i] == 0)
					System.out.print("_ ");
				else if (game[i] == 1)
					System.out.print("▧ ");
				else if (game[i] == 2)
					System.out.print("옷");
			}
			System.out.println();
			// 캐릭터 이동
			move = scan.nextInt();
			for (i = 0; i < 10; i++)
			{
				if (move == 2 && idx == 9) //목표점 도달했을 때 예외처리					
					break;
				else if (move == 2 && game[idx + 1] != 1) 
				{

					game[idx] = 0;
					game[idx + 1] = 2;
					break;
				} 
				else if (move == 2 && game[idx + 1] == 1)
				{
					System.out.println("벽이 있습니다.");
					break;
				}

				if (idx == 0 && move == 1) // 시작점 도달했을 때 예외처리
				{
					System.out.print("앞으로 나아가세요\n");
					break;
				} else if (move == 1 && game[idx - 1] != 1)
				{
					game[idx] = 0;
					game[idx - 1] = 2;
					break;
				} else if (move == 1 && game[idx - 1] == 1)
				{
					System.out.println("벽이 있습니다. ");
					break;
				}
				if (move == 3)
				{
					game[idx + 1] = 0;
					game[idx - 1] = 0;
				}

			}
			if (idx == 9)
			{
				System.out.print("Stage Clear!!");
				break;
			}
		}
	}
}
