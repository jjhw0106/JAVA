package Array_Practice;
//int test1[] = {1,2,3,2,1};		

//int test2[] = {1,3,4,4,2};
//int test3[] = {1,1,1,2,1};
//// 위 배열에서 중복안된숫자를 제거하시요 
//// 1) {1,2,1,2}
//// 2) {4,4}
//// 3) {1,1,1,1}

import java.util.Scanner;

public class Only_OverlapNum {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		final int SIZE = 5;
		// int test1[] = { 1, 2, 3, 2, 1 };
		// int test[] = { 1, 3, 4, 4, 2 };
		int test1[] = { 1, 3, 1, 2, 1 };

		int target = 0;
		int count = 0;

		target = test1[count];
		int rmIdx = 0;
		int check = -1;
		int[] remain = new int[SIZE];

		while (count < 5)
		{
			int[] temp = null;
			check = -1;
			for (int i = 0; i < SIZE; i++)
				if (count != i && test1[count] == test1[i])
					check = 1;

			if (check == 1)
			{
				remain[rmIdx] = test1[count];
				temp = remain;
				remain = temp;
				rmIdx++;
			}
			count++;
		}

		for (int i = 0; i < rmIdx; i++)
			System.out.println(remain[i]);
	}
}

// 중복이 되면 체크 = 1
// 중복 안되면 체크 = -1

// 위 배열에서 중복안된숫자를 제거하시요
// 1) {1,2,1,2}
// 2) {4,4}
// 3) {1,1,1,1}

//		int size = test.length;
//		int ans = 0;
//		int[] temp = new int[size];
//
//		for (int i = 0; i < size; i++)
//		{
//			temp[ans] = test[i];
//			int check = -1;
//			for (int j = 0; j < size; j++)
//			{
//				if (i != j && temp[ans] == test[i])
//					check = 1;
//			}
//			if (check == 1)
//			{
//				ans++;
//			}
//			
//
//		}
//		for (int i = 0; i < ans; i++)		{
//			System.out.println(temp[i]);
//		}
//
//	}
//}
