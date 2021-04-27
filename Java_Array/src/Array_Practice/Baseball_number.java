package Array_Practice;

import java.util.Scanner;
import java.util.Random;

public class Baseball_number {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		Random ran = new Random();

		int[] me = new int[3];
		int[] com = { 1, 4, 7 };
		int strike = 0;
		int ball = 0;
		int round=0;
		int i = 0;
		int j = 0;

		for (i = 0; i < 3; i++)
		{

			System.out.print(com[i] + " ");
		}
		System.out.println();
		while (strike < 3)
		{
			System.out.println("========"+(round+1)+" 라운드" + "=========");
			round++;
			i = 0;
			strike=0;
			ball =0;
			while (i < 3)
			{

				int check = 1;
				System.out.print(i + 1 + " 구: ");
				int pitch = scan.nextInt();

				j = 0;
				while (j < i)
				{
					if (me[j] == pitch)
					{
						System.out.println("중복된 숫자입니다.");
						check = -1;
					}
					j++;
				}
				if (check == 1)
				{
					me[i] = pitch;
					i++;
				}

			}

			for (i = 0; i < 3; i++)
				for (j = 0; j < 3; j++)
				{
					if (me[i] == com[j] && i == j)
						strike++;
					else if (me[i] == com[j] && i != j)
						ball++;
				}

			System.out.print(strike + "스트라이크 ");
			System.out.println(ball + "볼");

		}
	}
}
