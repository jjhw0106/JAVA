package megastudy_practice;

import java.util.Scanner;

public class Array_Test3 {
	public static void main(String[] args) {
		
	

		int a[] = { 10, 20, 30, 40, 50 };
		int b[] = { 10, 20, 30, 40, 50 };

		while (true)
		{
			Scanner sc = new Scanner(System.in);
			System.out.println("문제: ");
			int sel = sc.nextInt();

			if (sel == 1)
				// 문제 1) 숫자를 하나 입력받고 아래 배열을 앞으로 하나씩 밀어낸후 맨뒤에 저장
				// 예) 60 ==> a[5] = {20,30,40,50,60};
				while (true)
				{
					System.out.println("추가할 숫자: ");
					int input = sc.nextInt();
					int[] temp = new int[a.length];

					for (int i = 1; i < a.length; i++) // Q. 중괄호 무조건 쓰는게 좋은지
						temp[i - 1] = a[i];

					a = temp;
					a[a.length - 1] = input;

					for (int i = 0; i < a.length; i++)
						System.out.print(a[i] + " ");
					System.out.println();
					// temp = null; -> 없어도 됨
					break;
				}

			if (sel == 2)
				// 문제 2) 숫자를 하나 입력받고 아래 배열을 뒤로 하나씩 밀어낸후 맨 앞에 저장
				// 예) 60 ==> b[5] = {60,10,20,30,40};
				while (true)
				{
					System.out.println("추가할 숫자: ");
					int input = sc.nextInt();
					int[] temp = new int[b.length];

					for (int i = 0; i < b.length - 1; i++)
					{	temp[i + 1] = b[i];
					System.out.println();
					}
					
					b = temp;
					b[0] = input;

					for (int i = 0; i < b.length; i++)
						System.out.print(b[i] + " ");
					System.out.println();

					break;
				}
			
			if (sel == 3)
				break;
		}
	}
}