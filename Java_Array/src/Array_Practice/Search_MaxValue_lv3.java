
//MAX에 인덱스 사용해서 다시 짜볼것
package Array_Practice;

import java.util.Scanner;
import java.util.Random;

public class Search_MaxValue_lv3 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Random ran = new Random();

		int[] arr = new int[5];

		int max = 0;
		int answer = 0;
		int arrSum = 0;
		int i;
		boolean run = true;

		// 배열 랜덤으로 초기화
		for (i = 0; i < 5; i++)
		{
			arr[i] = ran.nextInt(200);
			arrSum += arr[i];
		}

		// 최대값 입력받기
		while (run == true)
		{

			for (i = 0; i < 5; i++)
			{
				System.out.print(arr[i] + " ");
			}
			
			// 최대값 max 고르기
			for (i = 0; i < 5; i++)
			{
				if (arr[i] > max)
					max = arr[i];
			}

			
			
			System.out.println("max값은: " + max);
			System.out.print("최대값을 입력하세요: ");
			answer = scan.nextInt();

			
			// 입력값이 max값과 일치하는지 확인, 맞을 시 해당 arr값 0으로
			for (i = 0; i < 5; i++)
			{
				if (answer == max && max == arr[i])
				{
					arr[i] = 0;
					max = 0;
					break;
				}
			}
			
			// 예외처리
			if (answer != max && max != 0)
				System.out.println("다시입력하세요");
			// 프로그램 종료 조건 (arr가 모두 0일때)
			else
			{
				arrSum -= answer;
				if (arrSum == 0)
					run = false;
			}
			
		}
		System.out.println("프로그램 종료.");

	}

}
