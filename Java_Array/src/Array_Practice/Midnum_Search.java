package Array_Practice;

import java.util.Scanner;

public class Midnum_Search {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("숫자 입력: ");
		int num = sc.nextInt();
		int digit = 0;

		for (int i = 1000000; i > 1; i /= 10)
			if (num / i != 0)
			{
				digit = i;// 0이 몇개?
				break;
			}

		int find = 1; // count를 찾기 위한 변수
		int count = 1; // 몇자리 숫자인지를 표시하기 위한 변수
		while (true)
		{
			while (find != digit)
			{
				find *= 10;
				count++;
			}

			if ((count - 1) % 2 != 0)
			{
				System.out.println("짝수의 자리이다");
				break;
			}

			int[] ans = new int[count];

			while (count > 0)
			{
				int remain = num % 10;
				num /= 10;
				ans[count - 1] = remain;
				count--;
			}

			System.out.print(ans[ans.length / 2]);

			break;
		}

//
//		System.out.println(digit + "," + count);
//		if (count % 2 != 0)
//			System.out.println("짝수의 자리이다");
//		else
//		{
//			
//		}

		// 문제1) 1~백만 사이의 숫자를 입력받고 가운데 숫자 출력
		// (단 ! 짝수자리의 수는 짝수자리라고 출력)
		// 예) 123 ==> 2
		// 예) 1234 ==> 짝수의 자리이다
		// 예) 1 ==> 1
		// 예) 1234567 ==> 4

		// 힌트 자리수를 구하고 배열을 만든다음 하나씩 저장
		// 예) ==> 123 ==> 3 ==> arr[] = new int[3];

	}
}
