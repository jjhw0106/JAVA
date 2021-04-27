package Kakao;

/* 1. 비밀 지도(난이도: 하)

네오는 평소 프로도가 비상금을 숨겨놓는 장소를 알려줄 비밀지도를 손에 넣었다. 그런데 이 비밀지도는 숫자로 암호화되어 있어 위치를 확인하기 위해서는 암호를 해독해야 한다.
다행히 지도 암호를 해독할 방법을 적어놓은 메모도 함께 발견했다.
1.지도는 한 변의 길이가 n인 정사각형 배열 형태로, 각 칸은 “공백”(“ “) 또는 “벽”(“#”) 두 종류로 이루어져 있다.
2.전체 지도는 두 장의 지도를 겹쳐서 얻을 수 있다. 각각 “지도 1”과 “지도 2”라고 하자. 지도 1 또는 지도 2 중 어느 하나라도 벽인 부분은 전체 지도에서도 벽이다.
     지도 1과 지도 2에서 모두 공백인 부분은 전체 지도에서도 공백이다.
3.“지도 1”과 “지도 2”는 각각 정수 배열로 암호화되어 있다.
4.암호화된 배열은 지도의 각 가로줄에서 벽 부분을 1, 공백 부분을 0으로 부호화했을 때 얻어지는 이진수에 해당하는 값의 배열이다.
네오가 프로도의 비상금을 손에 넣을 수 있도록, 비밀지도의 암호를 해독하는 작업을 도와줄 프로그램을 작성하라. */

import java.util.Random;
import java.util.Scanner;

public class HiddenMap {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Random ran = new Random();

		int round = 0;

		int n = 0; // 한 변의 크기
		int[][] arr1 = new int[10][10];
		int[][] arr2 = new int[10][10];
		int[][] treasure = new int[10][10];

		int[] num = new int[40];

		int i = 0;
		int j = 0;

		System.out.print("지도의 크기는 ");
		n = scan.nextInt();

		System.out.println("지도1.");

		for (i = 0; i < n; i++)
			num[i] = scan.nextInt();

		for (i = 0; i < n; i++)
			for (j = 0; j < n; j++)
			{
				arr1[i][n - 1 - j] = num[i] % 2;
				num[i] = num[i] / 2;
			}
		for (i = 0; i < n; i++)
		{
			for (j = 0; j < n; j++)

			{
				System.out.print(arr1[i][j]);
			}
			System.out.println();
		}

		System.out.println("지도2.");

		for (i = 0; i < n; i++)
			num[i] = scan.nextInt();

		for (i = 0; i < n; i++)
			for (j = 0; j < n; j++)
			{
				arr2[i][n - 1 - j] = num[i] % 2;
				num[i] = num[i] / 2;
			}
		for (i = 0; i < n; i++)
		{
			for (j = 0; j < n; j++)

			{
				System.out.print(arr2[i][j]);
			}
			System.out.println();
		}

		// 보물지도
		System.out.println("보물지도. ");
		for (i = 0; i < n; i++)
		{
			for (j = 0; j < n; j++)

			{
				treasure[i][j] = arr1[i][j] | arr2[i][j];
				if(treasure[i][j]==1)
					System.out.print("# ");
				else
					System.out.print(" ");
			}
			System.out.println();
		}

	}

}
