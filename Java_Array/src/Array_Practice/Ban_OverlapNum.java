package Array_Practice;

import java.util.Random;
import java.util.Scanner;

public class Ban_OverlapNum { 

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Random ran = new Random();

		int arr[] = new int[5];
		int check[] = { 0, 0, 0, 0, 0 };
		int i = 0;
		boolean exit = true;

		System.out.print("중복되지 않은 숫자 5개를 입력하세요: ");
		while (exit == true)
		{

			for (i = 0; i < 5; i++)
			{
				arr[i] = scan.nextInt();
				check[arr[i] - 1] += 1;
				if (check[arr[i] - 1] >= 2)
				{
					System.out.println("중복된 숫자입니다.");
					exit = false;
					break;
				}
			}
			exit = false;
		}

		System.out.print("check: \t ");
		for (i = 0; i < 5; i++)
			System.out.print(check[i]);

		System.out.println();

		System.out.print("arr: \t ");
		for (i = 0; i < 5; i++)
			System.out.print(arr[i]);
	}

}
