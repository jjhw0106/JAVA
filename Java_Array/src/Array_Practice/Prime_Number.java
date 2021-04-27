package Array_Practice;

import java.util.Scanner;

public class Prime_Number {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		/*
		 * # 소수 찾기[3단계]
		 * 1. 숫자를 한 개 입력받는다.
		 * 2. 입력받은 숫자보다 큰 첫 번째 소수를 출력한다.
		 * 
		 * 예) Enter Number ? 1000
		 *    1000보다 큰 첫번재 소수는 1009
		 * 예) Enter Number ? 500
		 *    500보다 큰 첫번째 소수는 503
		 */

		System.out.print("Enter Number ? ");
		int number = sc.nextInt();
		int div = number - 1;
		int answer = number + 1;
		int check = -1;
		int count = 0;

		while (true)
		{
			count = 0;
			for (int i = 1; i < answer; i++)
				if (answer % i == 0)
					count++;

			if (count > 2)
				answer++;
			else
				break;
		}

		System.out.println(answer);
	}
}