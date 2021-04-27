package step01_8;

import java.util.Scanner;

public class ATM_Level1 {
	public static void main(String[] arags) {
		Scanner getNum = new Scanner(System.in);
		
		
		int myAcc = 1234;
		int myMoney = 8700;
		
		int yourAcc = 4321;
		int yourMoney = 12000;
		
		int accAddress;
		int howMuch;
	
		
		System.out.print("어디로 보낼지 입력하세요: ");
		accAddress = getNum.nextInt();
		
		if (accAddress == yourAcc)
			{			
				System.out.print("얼마를 보내시겠습니까?: ");
				howMuch = getNum.nextInt();
					if(howMuch<=myMoney)
					{
						myMoney -= howMuch;
						yourMoney +=howMuch;
					}
					else
					{
						System.out.println("잔액이 부족합니다");
						System.out.println("이체불가");
					}

			}
		
		
		else
			{
				System.out.println("계좌번호를 확인하세요");
				System.out.println("이체불가");
			}
		
		
		
		System.out.println("myMoney =" + myMoney + "원");
		System.out.println("yourMoney =" + yourMoney + "원");
		
		getNum.close();
		
	}
	
}
