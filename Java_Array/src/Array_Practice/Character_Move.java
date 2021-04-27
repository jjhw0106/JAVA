package Array_Practice;

import java.util.Scanner;

public class Character_Move {
	public static void main(String[] args) {

		/*
		 * # 숫자이동[1단계] 1. 숫자2는 캐릭터이다. 2. 숫자1을 입력하면, 캐릭터가 왼쪽으로 숫자2를 입력하면, 캐릭터가 오른쪽으로
		 * 이동한다. 3. 단, 좌우 끝에 도달했을 때, 예외처리를 해야한다.
		 */
		Scanner scan = new Scanner(System.in);

		int[] game = { 0, 0, 0, 0, 2, 0, 0, 0 };
		int idx = 0;
		int i;
		int move = 0;
		boolean exit = true;

		for (i = 0; i < 8; i++)
		{
			if (game[i] == 2)
				System.out.print("■ ");
			else
				System.out.print("□ ");
			if (game[i] != 0)
				idx = i;
		}

		while (exit == true)
		{
			int temp = 0;

			System.out.println();
			System.out.print("이동: ");
			move = scan.nextInt();

			// 후퇴
			if (move == 1 && idx > 0)
			{
				temp = game[idx];
				game[idx] = 0;
				game[idx - 1] = temp;
				idx--;
			}

			// 마지노선
			else if (idx == 0)
			{
				System.out.println("앞으로 나아가세요");
				idx = 0;
			}

			// 전진
			if (move == 2 && idx < 7)
			{

				temp = game[idx];
				game[idx] = 0;
				game[idx + 1] = temp;
				idx++;
			}

			// 위치 출력
			for (i = 0; i < 8; i++)
			{
				if (game[i] == 2)
					System.out.print("■ ");
				else
					System.out.print("□ ");
			}

			// 도착
			if (idx == 7)
			{
				System.out.println("\nStage Clear!!");
				exit = false;
			}

		}

	}
}
