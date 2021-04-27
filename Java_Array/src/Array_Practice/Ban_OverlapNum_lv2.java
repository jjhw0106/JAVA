package Array_Practice;

import java.util.Scanner;
import java.util.Random;

public class Ban_OverlapNum_lv2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Random ran = new Random();

		int[] arr = new int[5];
		int num = 0;
		int i = 0, j = 0;

		System.out.println("1");
		while (i < 5)
		{
			int check = 1;
			num = ran.nextInt(10);
			j = 0;
			while (j < i)
			{
				if (arr[j] == num)
				{
					System.out.println("3");
					check = -1;
				}
				j++;
			}

			if (check == 1)
			{
				System.out.println("4");
				arr[i] = num;
				i++;
			}
		}
		for (i = 0; i < 5; i++)
			System.out.print(arr[i]);
	}

}
