package Array_Practice;

import java.util.Scanner;

public class ArrayController_Delete {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int[] arr = { 10, 20, 30, 40, 50 };
		int cnt = 5;

		boolean run = true;
		while (run)
		{

			System.out.println("[2]삭제");
			for (int i = 0; i < 5; i++)
			{
				System.out.print(" " + arr[i]);
			}
			System.out.println();

			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt();

			if (sel == 2)
			{
				int delIdx = -1;
				int tempIdx = 0;
				int[] temp = new int[cnt];
				System.out.print("삭제할 값 입력 : ");
				int data = scan.nextInt();

				for (int i = 0; i < 5; i++)
					if (arr[i] == data)
						delIdx = i;

				if (delIdx == -1)
				{
					System.out.println("없는 숫자입니다.");
				}

				else
				{

					for (int i = 0; i < 5; i++)
						if (i != delIdx)
						{
							temp[tempIdx] = arr[i];
							tempIdx++;
						}

					arr = temp;

				}
			}

		}

	}

}