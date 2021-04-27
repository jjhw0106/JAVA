package Array_Practice;

import java.util.Scanner;

public class ArrayController_insert {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int[] arr = { 10, 20, 0, 0, 0 };
		int cnt = 2;

		boolean run = true;
		while (run)
		{
			System.out.println("[3]삽입");
			for (int i = 0; i < 5; i++)
			{
				System.out.print(" " + arr[i]);
			}

			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt();

			if (sel == 3)
			{

				System.out.print("삽입할 위치 입력 : ");
				int idx = scan.nextInt()-1;
				if (idx >= 5)
				{
					System.out.println("인덱스는 5번까지 있습니다");
				} else
				{
					int empty = -1;
					if (arr[idx] == 0)
						empty = 1;
					else
						empty = -1;

					if (empty == 1)
					{
						System.out.print("삽입할 값 입력 : ");
						int data = scan.nextInt();
						arr[idx] = data;
						cnt++;
					} else
						System.out.println("값이 있습니다");

					if (cnt == 5)
						System.out.println("다 찼습니다.");
				}
			}
		}
	}

}
