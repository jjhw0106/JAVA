package Array_Practice;

import java.util.Scanner;

public class Apart_Cost {
	// 문제 1) 각층별 관리비 합 출력
	// 정답 1) 4400, 7100, 5400

	// 문제 2) 호를 입력하면 관리비 출력
	// 예 2) 입력 : 202 관리비 출력 : 2000

	// 문제 3) 관리비가 가장 많이 나온 집, 적게 나온 집 출력
	// 정답 3) 가장 많이 나온 집(201), 가장 적게 나온 집(303)

	// 문제 4) 호 2개를 입력하면 관리비 교체

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int[][] apt = {

				{ 101, 102, 103 },

				{ 201, 202, 203 },

				{ 301, 302, 303 }

		};

		int[][] pay = {

				{ 1000, 2100, 1300 },

				{ 4100, 2000, 1000 },

				{ 3000, 1600, 800 }

		};

		while (true)
		{

			for (int i = 0; i < 3; i++)
				for (int j = 0; j < 3; j++)
				{
					if (j % 3 == 0)
						System.out.println();
					System.out.print("[" + apt[i][j] + "-" + pay[i][j] + "]");
				}

			int sel = 0;
			System.out.print("\n문제 번호 입력: ");
			sel = scan.nextInt();
			if (sel == 1) // 문제 1) 각층별 관리비 합 출력
			{
				int[] paySum = new int[3];
				int aptFloor = 0;

				for (aptFloor = 0; aptFloor < 3; aptFloor++)
					for (int j = 0; j < 3; j++)
						paySum[aptFloor] += pay[aptFloor][j];

				for (int i = 0; i < 3; i++)
					System.out.println(paySum[i] + " ");
				System.out.println();
			}
			if (sel == 2) // 문제 2) 호를 입력하면 관리비 출력
			{
				System.out.print("호수: ");
				int aptNum = scan.nextInt();

				for (int i = 0; i < 3; i++)
					for (int j = 0; j < 3; j++)
						if (aptNum == apt[i][j])
						{
							System.out.print("관리비: " + pay[i][j]);
							break;
						}
				System.out.println();

			}
			if (sel == 3) // 문제 3) 관리비가 가장 많이 나온 집, 적게 나온 집 출력
			{
				int max = 0;
				int min = 10000000;
				int maxi = 0, maxj = 0;
				int mini = 0, minj = 0;
				for (int i = 0; i < 3; i++)
					for (int j = 0; j < 3; j++)
					{
						if (max <= pay[i][j])
						{
							max = pay[i][j];
							maxi = i;
							maxj = j;
						}
						if (min >= pay[i][j])
						{
							min = pay[i][j];
							mini = i;
							minj = j;
						}
					}
				System.out.print("관리비 가장 많은 집: " + apt[maxi][maxj]);
				System.out.println();
				System.out.print("관리비 가장 적은 집: " + apt[mini][minj]);
				System.out.println();
			}
			if (sel == 4) // 문제 4) 호 2개를 입력하면 관리비 교체
			{
				int aptNum1 = 0;
				int aptNum2 = 0;
				int temp = 0;

				int payi = 0;
				int payj = 0;
				System.out.println("관리비를 바꿀 2세대를 입력하세요.");
				System.out.print("1. ");
				aptNum1 = scan.nextInt();
				System.out.print("2. ");
				aptNum2 = scan.nextInt();

				int check = 1;

				if (check == 1)
				{
					for (int i = 0; i < 3; i++)
						for (int j = 0; j < 3; j++)
							if (aptNum1 == apt[i][j])
							{
								temp = pay[i][j];
								payi = i;
								payj = j;
								check = -1;
								break;
							}
				}
				check = 1;
				if (check == 1)
				{
					for (int i = 0; i < 3; i++)
						for (int j = 0; j < 3; j++)
							if (aptNum2 == apt[i][j])
							{
								pay[payi][payj] = pay[i][j];
								pay[i][j] = temp;
								check = -1;
								break;
							}

				}
				System.out.println();
			}

		}

	}
}
