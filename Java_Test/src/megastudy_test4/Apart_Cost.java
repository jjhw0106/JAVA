package megastudy_test4;

import java.util.Scanner;

//start 12:29 end 1:03
public class Apart_Cost {
	public static void main(String[] args) {
		int[][] apt = { { 101, 102, 103 }, { 201, 202, 203 }, { 301, 302, 303 } };

		int[][] pay = { { 1000, 2100, 1300 }, { 4100, 2000, 1000 }, { 3000, 1600, 800 } };
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < apt.length; i++) {
			for (int j = 0; j < apt.length; j++) {
				System.out.print(apt[i][j] + " " + "[" + pay[i][j] + "] ");
			}
			System.out.println();
		}

		while (true) {

			System.out.print("문제 번호: ");
			int sel = sc.nextInt();

			if (sel == 1) {
				System.out.println("몇 층?");
				int floor = sc.nextInt() - 1;
				int sum = 0;

				for (int i = 0; i < pay.length; i++)
					sum += pay[floor][i];
				System.out.println(sum);
			}

			if (sel == 2) {
				System.out.println("몇 호?");
				int room = sc.nextInt();
				int check = -1;
				int xPos = 0;
				int yPos = 0;

				for (int i = 0; i < pay.length; i++)
					for (int j = 0; j < pay.length; j++)
						if (apt[i][j] == room) {
							xPos = i;
							yPos = j;
							check = 1;
						}

				if (check == -1) {
					System.out.println("방번호를 다시 입력하세요.");
					continue;
				}
				System.out.println(pay[xPos][yPos] + "원");

			}
			if (sel == 3) {
				int max = 0;
				for (int i = 0; i < pay.length; i++)
					for (int j = 0; j < pay.length; j++) {
						if (max < pay[i][j])
							max = pay[i][j];
					}

				int xPos = 0;
				int yPos = 0;
				for (int i = 0; i < pay.length; i++)
					for (int j = 0; j < pay.length; j++) {
						if (max == pay[i][j]) {
							xPos = i;
							yPos = j;
						}
					}
				System.out.print("관리비 가장 많은 집: ");
				System.out.println(apt[xPos][yPos]);

				int min = max;
				for (int i = 0; i < pay.length; i++)
					for (int j = 0; j < pay.length; j++) {
						if (min > pay[i][j])
							min = pay[i][j];
					}
				for (int i = 0; i < pay.length; i++)
					for (int j = 0; j < pay.length; j++) {
						if (min == pay[i][j]) {
							xPos = i;
							yPos = j;
						}
					}
				System.out.print("관리비 가장 적은 집: ");
				System.out.println(apt[xPos][yPos]);

			}
			if (sel == 4) {
				int room1 = 0;
				int room2 = 0;
				int x1 = 0;
				int y1 = 0;
				int x2 = 0;
				int y2 = 0;

				System.out.println("1번 방: ");
				room1 = sc.nextInt();
				for (int i = 0; i < apt.length; i++)
					for (int j = 0; j < apt.length; j++) {
						if (apt[i][j] == room1) {
							x1 = i;
							y1 = j;
						}
					}

				System.out.println("2번 방: ");
				room2 = sc.nextInt();
				for (int i = 0; i < apt.length; i++)
					for (int j = 0; j < apt.length; j++) {
						if (apt[i][j] == room2) {
							x2 = i;
							y2 = j;
						}
					}

				for (int i = 0; i < pay.length; i++)
					for (int j = 0; j < pay.length; j++) {
						int temp = pay[x1][y1];
						pay[x1][y1] = pay[x2][y2];
						pay[x2][y2] = temp;
					}

				for (int i = 0; i < apt.length; i++) {
					for (int j = 0; j < apt.length; j++) {
						System.out.print(apt[i][j] + " " + "[" + pay[i][j] + "] ");
					}
					System.out.println();
				}
			}
			if (sel == 5) {
				break;
			}
		}
		// 문제 1) 각층별 관리비 합 출력
		// 정답 1) 4400, 7100, 5400

		// 문제 2) 호를 입력하면 관리비 출력
		// 예 2) 입력 : 202 관리비 출력 : 2000

		// 문제 3) 관리비가 가장 많이 나온 집, 적게 나온 집 출력
		// 정답 3) 가장 많이 나온 집(201), 가장 적게 나온 집(303)

		// 문제 4) 호 2개를 입력하면 관리비 교체
	}
}