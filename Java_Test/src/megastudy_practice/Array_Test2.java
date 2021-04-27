package megastudy_practice;

import java.util.Scanner;

public class Array_Test2 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int sel = 0;
 
		while (true)
		{

			System.out.println("문제 : ");
			sel = sc.nextInt();

			if (sel == 1)
			{
				// 문제1) 인덱스(방번호)를 입력하면 값출력
				// int a[5] = { 10,20,30,40,50 };
				// 예) 3 ==> 40
				while (true)
				{ 

					int[] a = { 10, 20, 30, 40, 50 };
					int room = 0;
					int idx = 0;
					System.out.println("idx : ");
					idx = sc.nextInt();
					System.out.println("정답: " + a[idx]);
					break;
				}
			}

			else if (sel == 2)
			{
				// 문제2) 아래배열중 가장큰값 출력
				// int b[5] = { 12,54,23,87,1 };
				// 예) 87
				while (true)
				{
					int[] b = { 12, 54, 23, 87, 1 };
					int max = b[0];

					for (int i = 0; i < b.length; i++)
						if (max < b[i])
							max = b[i];

					System.out.println("정답: " + max);
					break;
				}

			}

			else if (sel == 3)
			{
				// 문제3) 아래 배열중 홀수의 개수 출력
				// int c[5] = { 12,54,23,87,1 };
				// 예) 홀수의 개수 : 3
				while (true)
				{
					int c[] = { 12, 54, 23, 87, 2 };
					int oddCnt = 0;

					for (int i = 0; i < c.length; i++)
					{
						if (c[i] % 2 == 1)
							oddCnt++;
					}
					System.out.println("정답은: " + oddCnt);
					break;
				}

			}

			else if (sel == 4)
			{
				// 문제4) 아래배열을 거꾸로 저장
				// int d[5] = { 1,2,3,4,5 };
				// int e[5] = { 0,0,0,0,0 };
				// 예) e[5] = {5,4,3,2,1};
				while (true)
				{

					int d[] = { 1, 2, 3, 4, 5 };
					int e[] = { 0, 0, 0, 0, 0 };

					for (int i = 0; i < d.length; i++)
					{
						e[i] = d[d.length - 1 - i];

					}

					System.out.print("정답은: ");
					for (int i = 0; i < d.length; i++)
						System.out.print(e[i] + " ");
					System.out.println();
					break;
				}

			}
		}
	}
}
