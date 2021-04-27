package Array_Practice;

import java.util.Scanner;

public class Vector_Basic {
	public static void main(String[] args) {

		final int SIZE = 5;

		int count = 0;
		int[] score = null;
		int size = 0;

		while (true)
		{

			// 메뉴 출력
			System.out.println("[벡터 컨트롤러]");
			System.out.println("[1]추가");
			System.out.println("[2]삭제(인덱스)");
			System.out.println("[3]삭제(값)");
			System.out.println("[4]삽입");
			System.out.println("[0]종료");

			System.out.print("score배열은 ");

			// 배열 출력
			if (score != null)
			{ // 배열 널처리
				for (int i = 0; i < count; i++)
					System.out.print("[" + score[i] + "]" + " ");
				System.out.println();
				System.out.println("score배열의 길이는 " + size);
			} else
				System.out.println("값이 없습니다.");

			// 메뉴 선택
			System.out.print("메뉴 선택 : ");
			Scanner scan = new Scanner(System.in);
			int sel = scan.nextInt();

			// 추가
			if (sel == 1)
			{
				int input = 0;

				if (count == 0 && score == null)
					score = new int[count + 1];
				else if (count != 0 && score == null) // howzit? (카운트가 0으로 안떨어져서 0으로 만듬)
				{
					count = 0;
					score = new int[count + 1];
				} else if (count >= 1 && score != null)
				{

					int[] temp = score;
					score = new int[count + 1];
					for (int i = 0; i < count; i++)
						score[i] = temp[i];
				}
				System.out.print("추가할 값: ");
				input = scan.nextInt();
				score[count] = input;
				count++;

			}

			// 삭제(인덱스)
			else if (sel == 2)
			{
				if (score == null)
				{
					System.out.println("더이상 삭제할 수 없습니다.");
					continue;
				}
				System.out.println("삭제할 인덱스: ");
				int delIdx = scan.nextInt() - 1;

				if (delIdx > count - 1)
				{
					System.out.println("없는 인덱스입니다.");
					continue;
				}

				if (count == 1)
					score = null;
				else if (count > 1)
				{
					int[] temp = new int[count - 1];
					int tempIdx = 0;
					for (int i = 0; i < count; i++)
					{
						if (i != delIdx)
						{
							temp[tempIdx] = score[i];
							tempIdx++;
						}

					}
					score = temp;
					count--;
				}

			}

			// 삭제 (값)
			else if (sel == 3)
			{
				if (score == null)
				{
					System.out.println("더이상 삭제할 수 없습니다.");
					continue;
				}

				System.out.print("삭제할 값: ");
				int data = scan.nextInt();

				int delIdx = -1;
				for (int i = 0; i < count; i++)
					if (data == score[i])
					{
						delIdx = i;
						break;
					}

				System.out.println("삭제 인덱스는" + delIdx);
				if (count == 1)
					score = null;

				else if (count > 1)
				{
					int[] temp = new int[count - 1];
					int tempIdx = 0;
					for (int i = 0; i < count; i++)
					{
						if (i != delIdx)
						{
							temp[tempIdx] = score[i];
							tempIdx++;
						}
					}
					score = new int[count - 1];
					score = temp;
					count--;

				}
			}

			// 삽입 (첫 값과 마지막 값 사이에만 입력가능하게 구현)
			else if (sel == 4)
			{
				System.out.print("삽입할 값: ");
				int insert = scan.nextInt();
				System.out.print("삽입할 위치: ");
				int insertIdx = scan.nextInt() - 1;
				if (insertIdx < 0 || insertIdx >= count)
				{
					System.out.println("삽입할 수 없는 위치입니다.");
					continue;
				}

				if (insertIdx < count)
				{

					int[] temp = new int[count + 1];
					for (int i = 0; i < insertIdx; i++)
						temp[i] = score[i];
					for (int i = insertIdx + 1; i < count + 1; i++)
						temp[i] = score[i - 1];
					temp[insertIdx] = insert;
					score = temp;
				}
				count++;

			} else if (sel == 0)
			{
				break;
			}
			System.out.println();

			if (score == null)
				size = 0;
			else
				size = score.length;

		}
	}
}