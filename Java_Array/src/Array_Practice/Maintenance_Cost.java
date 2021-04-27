package Array_Practice;

import java.util.Scanner;
//문제 1) 각층별 관리비 합 출력
// 정답 1) 4400, 7100, 5400

// 문제 2) 호를 입력하면 관리비 출력
// 예    2) 입력 : 202	관리비 출력 : 2000

// 문제 3) 관리비가 가장 많이 나온 집, 적게 나온 집 출력
// 정답 3) 가장 많이 나온 집(201), 가장 적게 나온 집(303)

// 문제 4) 호 2개를 입력하면 관리비 교체

public class Maintenance_Cost {

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

				{ 3000, 1600, 800 } };

		while (true)
		{
			int sel = 0;
			System.out.print("문제 : ");
			sel = scan.nextInt();
			
			if (sel == 1)
			{
				System.out.println("문제 1. 층별 관리비");
				int floor = 0;
				int[] answer = new int[3];

				while (floor < 3)
				{
					for (int j = 0; j < 3; j++)
						answer[floor] += pay[floor][j];
					floor++;
				}
				System.out.println("정답: ");
				for (int i = 0; i < 3; i++)
					System.out.println(answer[i] + " ");

			}
		}

	}

}
