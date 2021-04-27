package step1_10;

import java.util.Scanner;

public class Max_Number_Search {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int i = 0;
		int max = 0;
		
		// 숫자 입력
		while (i++ < 3)
		{
			System.out.print( i + "번째 숫자를 입력하세요: ");
			int num = scan.nextInt();
			
			if(num > max)
				max = num;
					
		}
	
		System.out.println("최대값은 " + max);		
	}
}
