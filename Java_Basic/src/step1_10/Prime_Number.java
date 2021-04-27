package step1_10;

import java.util.Scanner;

public class Prime_Number {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int primeNum = 0;
		int num = 1;
		int cnt = 0;

		primeNum = scan.nextInt();
		
		while (num <= primeNum)
		{
			if (primeNum % num == 0)
			{
				cnt++;
			}
			num++;
		}
		
		if(cnt == 2)
			System.out.println(primeNum +"는 소수입니다 ");
		else
			System.out.println(primeNum +"는 소수가 아닙니다 ");
	}
}
