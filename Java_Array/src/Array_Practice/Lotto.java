package Array_Practice;

import java.util.Scanner;

public class Lotto {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int[] lotto = { 0, 7, 7, 0, 7, 0, 0 };
		int cnt = 0;
		int menu = 0;
		boolean exit = true;

		while (exit == true)
		{
			System.out.println("1. 결과 확인\n2. 종료");

			System.out.println("메뉴를 선택하세요: ");
			menu = scan.nextInt();

			if (menu == 1)
				for (int i = 0; i < 7; i++)
				{
					if (lotto[i] == 7 && lotto[i + 1] == 7 && lotto[i + 2] == 7)
					{
						System.out.println("당첨입니다.");

					}
				}
		
			else if (menu == 2)
			{
				System.out.println("종료");
				exit = false;
			}
		}
	}
}
