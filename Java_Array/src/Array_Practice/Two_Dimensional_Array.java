package Array_Practice;

// 문제 1) 전체 합 출력
// 정답 1) 450

// 문제 2) 4의 배수만 출력
// 정답 2) 20 40 60 80 

// 문제 3) 4의 배수의 합 출력
// 정답 3) 200

// 문제 4) 4의 배수의 개수 출력
// 정답 4) 4

import java.util.Scanner;

public class Two_Dimensional_Array {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		// lv1, lv2에 쓰일 배열 초기화
		final int SIZE = 3;
		int[][] arr = new int[SIZE][SIZE];

		int k = 1;
		for (int i = 0; i < SIZE; i++)
		{
			for (int j = 0; j < SIZE; j++)
			{
				arr[i][j] = 10 * k;
				k += 1;
			}
		}

		// lv3에 쓰일 배열 초기화

		int[][] arr3 = { { 101, 102, 103, 104 }, { 201, 202, 203, 204 }, { 301, 302, 303, 304 } };

		int[] garo = new int[3];
		int[] sero = new int[4];

		while (true)
		{
			int lv = 0;
			System.out.println("lv입력: ");
			lv = scan.nextInt();

			// 2차원배열 기초문제 lv1
			while (lv == 1)
			{
				System.out.println("lv 1. ");
				System.out.print("메뉴를 선택하세요: ");
				int sel = scan.nextInt();

				if (sel == 1)
				{
					System.out.println("문제 1. 전체 합");
					int sum = 0;
					for (int i = 0; i < SIZE; i++)
					{
						for (int j = 0; j < SIZE; j++)
						{
							sum += arr[i][j];
						}
					}
					System.out.println("정답: " + sum);
					System.out.println();
				}

				if (sel == 2)
				{
					System.out.println("문제 2. 4의배수만 출력");
					int answer = 0;

					System.out.print("정답: ");
					for (int i = 0; i < SIZE; i++)
					{
						for (int j = 0; j < SIZE; j++)
						{
							if (arr[i][j] % 4 == 0 && arr[i][j] != 0)
							{
								answer = arr[i][j];
								System.out.print(answer + " ");
							}
						}
					}
					System.out.println();
					System.out.println();
				}
				if (sel == 3)
				{
					System.out.println("문제 3. 4의배수의 합 출력");
					int answer = 0;
					for (int i = 0; i < SIZE; i++)
					{
						for (int j = 0; j < SIZE; j++)
						{
							if (arr[i][j] % 4 == 0 && arr[i][j] != 0)
							{
								answer += arr[i][j];
							}
						}
					}
					System.out.println("정답: " + answer + " ");
					System.out.println();
				}
				if (sel == 4)
				{
					System.out.println("문제 4. 4의 배수의 개수 출력");
					int count = 0;
					for (int i = 0; i < SIZE; i++)
					{
						for (int j = 0; j < SIZE; j++)
						{
							if (arr[i][j] % 4 == 0 && arr[i][j] != 0)
								count++;

						}
					}
					System.out.println("정답: " + count + "개");
					System.out.println();
				}
				if (sel == 5)
				{
					System.out.println("lv1 끝~");
					lv = 0;

				}
			}

			// 2차원배열 기초문제 lv2
			while (lv == 2)
			{
				System.out.println("lv 2. ");
				System.out.print("메뉴를 선택하세요: ");
				int sel = scan.nextInt();

				int xpos = 0, ypos = 0;

				if (sel == 1)
				{
					System.out.println("문제 1. 인덱스 2개 입력받아서 값 출력"); // 행렬값이므로 x 값 하나, y값 하나
					System.out.print("x: ");
					xpos = scan.nextInt() - 1;
					System.out.print("y: ");
					ypos = scan.nextInt() - 1;

					System.out.print("값은: ");
					System.out.println(arr[xpos][ypos]);
					System.out.println();
				}
				if (sel == 2)
				{
					System.out.println("문제 2. 값을입력받아 인덱스 2개 출력");
					int value = 0;

					System.out.print("값 입력: ");
					value = scan.nextInt();
					for (int i = 0; i < SIZE; i++) // Q1. 만약 이차원 배열에 중복값 존재할 시 이중포문 한방에 나가고 싶을때는?? for문 중간에 if?
					{
						int check = -1; // A1. Good Tip!

						for (int j = 0; j < SIZE; j++)
							if (arr[i][j] == value)
							{
								xpos = i;
								ypos = j;
								check = 1;
							}
						if (check == 1)
							break;
					}

					System.out.println("정답: " + "[" + (xpos + 1) + "," + (ypos + 1) + "]");
					System.out.println();
				}
				if (sel == 3)
				{
					System.out.println("문제 3. 가장 큰 값의 인덱스 2개 출력");
					int max = arr[0][0];

					for (int i = 0; i < SIZE; i++)
						for (int j = 0; j < SIZE; j++)
						{
							if (max < arr[i][j])
							{
								max = arr[i][j];
								xpos = i;
								ypos = j;
							}
						}
					System.out.println("정답: " + "[" + (xpos + 1) + "," + (ypos + 1) + "]");
					System.out.println();
				}
				if (sel == 4)
				{
					System.out.println("문제 4. 값 2개를 입력받아서 교체");
					System.out.print("값 1: ");
					int value1 = scan.nextInt();
					System.out.print("값 2: ");
					int value2 = scan.nextInt();

					int xtemp = 0;
					int ytemp = 0;
					for (int i = 0; i < SIZE; i++)
						for (int j = 0; j < SIZE; j++)
							if (value1 == arr[i][j])
							{
								xtemp = i;
								ytemp = j;
							}

					for (int i = 0; i < SIZE; i++)
						for (int j = 0; j < SIZE; j++)
							if (value2 == arr[i][j])
							{
								arr[i][j] = value1;
								arr[xtemp][ytemp] = value2;
								xtemp = 0;
								ytemp = 0;
							}
					for (int i = 0; i < SIZE; i++)
						for (int j = 0; j < SIZE; j++)
						{
							if (j % SIZE == 0)
								System.out.println();
							System.out.print(" " + arr[i][j]);
						}
					System.out.println();
					System.out.println();
				}
			}

			// 2차원배열 기초문제 lv3
			while (lv == 3)
			{
				System.out.println("lv 3. ");
				System.out.print("메뉴를 선택하세요: ");
				int sel = scan.nextInt();

				if (sel == 1)
				{
					System.out.println("문제 1. 가로 합 출력");

					int garoIdx = 0;
					int[] garoSum = new int[3];
					
					while (garoIdx< 3) //Q. while문에선 후위연산자 사용x 
						{
						for (int j = 0; j < 4; j++)
							garoSum[garoIdx] += arr3[garoIdx][j];
						garoIdx++;
						}
					
					System.out.print("정답: ");
					for (garoIdx = 0; garoIdx < 3; garoIdx++)
						System.out.print(garoSum[garoIdx] + " ");
						
				}
				if (sel == 2)
				{
					System.out.println("문제 2. 세로 합 출력");

					int seroIdx = 0;
					int[] seroSum = new int[4];
					
					while (seroIdx < 4)
						{
						for (int i = 0; i < 3; i++)
							seroSum[seroIdx] += arr3[i][seroIdx];
						seroIdx++;
						}
					
					System.out.print("정답: ");
					for (seroIdx = 0; seroIdx < 4; seroIdx++)
						System.out.print(seroSum[seroIdx] + " ");
					
				}
			}
		}
	}
}
