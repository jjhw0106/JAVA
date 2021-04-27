package Array_Practice;

import java.util.Scanner;

public class Value_Exchange {
	// 문제 1) 인덱스 2개를 입력받아 값 교체하기
	// 예 1) 인덱스1 입력 : 1
	// 인덱스2 입력 : 3
	// {10, 40, 30, 20, 50}

	// 문제 2) 값 2개를 입력받아 값 교체하기
	// 예 2) 값1 입력 : 40
	// 값2 입력 : 20
	// {10, 20, 30, 40, 50}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// 문제1. 인덱스로 자리바꾸기

		int menu = 0;
		int i = 0;

		System.out.println("1. 인덱스로 자리바꾸기, 2. 값으로 자리바꾸기, 3. 학번으로 성적바꾸기");
		System.out.println("선택하세요: ");
		menu = scan.nextInt();

		if (menu == 1)
		{
			int[] arr = { 10, 20, 30, 40, 50 };
			int[] temp = { 10, 20, 30, 40, 50 };

			int idx1 = 0;
			int idx2 = 0;

			System.out.println("인덱스 2개를 입력하세요");
			System.out.print("인덱스1 : ");
			idx1 = scan.nextInt() - 1;

			System.out.print("인덱스2 : ");
			idx2 = scan.nextInt() - 1;

			temp[idx2] = arr[idx1];
			temp[idx1] = arr[idx2];

			for (i = 0; i < 5; i++)
				arr[i] = temp[i];

			System.out.print("arr는 ");
			for (i = 0; i < 5; i++)
				System.out.print(" " + arr[i]);
			System.out.println();
		}
		// 문제2. 값으로 자리바꾸기

		if (menu == 2)
		{
			int[] arr = { 10, 20, 30, 40, 50 };
			int[] temp = { 10, 20, 30, 40, 50 };

			int value1 = 0;
			int value2 = 0;

			System.out.println("값 2개를 입력하세요");
			System.out.print("값1 : ");
			value1 = scan.nextInt();
			System.out.print("값2 : ");
			value2 = scan.nextInt();

			for (i = 0; i < 5; i++)
			{
				if (arr[i] == value1)
					temp[i] = value2;
				else if (arr[i] == value2)
					temp[i] = value1;
			}
			for (i = 0; i < 5; i++)
				arr[i] = temp[i];

			System.out.print("arr는 ");
			for (i = 0; i < 5; i++)
				System.out.print(" " + arr[i]);
			System.out.println();
		}

		// 문제 3. 학번으로 점수바꾸기
		if (menu == 3)
		{
			int[] stNum = { 1001, 1002, 1003, 1004, 1005 };
			int[] score = { 87, 11, 45, 98, 23 };
			int[] temp = { 87, 11, 45, 98, 23 };

			int student1 = 0;
			int student2 = 0;

			int st1Idx = 0;
			int st2Idx = 0;

			System.out.println("점수를 바꿀 학생의 학번을 입력하세요 ");
			System.out.print("학생1 : ");
			st1Idx = scan.nextInt()-1;
			System.out.print("학생2 : ");
			st2Idx = scan.nextInt()-1;

			for (i = 0; i < 5; i++)
				if (stNum[i] == student1)
					st1Idx = i;
				else if (stNum[i] == student2)
					st2Idx = i;

			temp[st2Idx] = score[st1Idx];
			temp[st1Idx] = score[st2Idx];
			for (i = 0; i < 5; i++)
				score[i]=temp[i];
			
			System.out.println("바뀐 점수는 ");
			for (i = 0; i < 5; i++)
				System.out.print(" " + score[i]);

		}
	}
}
