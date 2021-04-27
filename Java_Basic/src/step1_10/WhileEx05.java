package step1_10;

import java.util.Scanner;

public class WhileEx05 {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int price1 = 8700;
		int price2 = 6200;
		int price3 = 1500;
		int total = 0;
		int pay;
		int extra;

		int choose1 = 0;
		int choose2 = 0;
		int choose3 = 0;

		int sel = 0;

		// 메뉴선택 및 가격계산
		{
			int num = 0;
			while (num != 5)
			{
				num++;
				System.out.print("메뉴 선택 : ");
				sel = scan.nextInt();

				if (sel == 1) {
					price1 += price1 * choose1;
					choose1++;
				} else if (sel == 2) {

					price2 += price2 * choose2;
					choose2++;
				} else if (sel == 3) {
					price3 += price3 * choose3;
					choose3++;
				} else
					System.out.println("메뉴를 다시 입력해주세요.");
			}
		}
		
		// 현금 입력
		{
			System.out.print("얼마를 내시겠습니까? ");
			pay = scan.nextInt();
		}

		// 총금액 계산
		{
			total = price1 + price2 + price3;
		}
				
		// 잔돈 계산
		{
			extra = pay - total; 
		}
		
		System.out.println("=== 롯데리아 ===");
		System.out.println("1.불고기 버거 : " + price1 + "원");
		System.out.println("2.새우    버거 : " + price2 + "원");
		System.out.println("3.콜         라 : " + price3 + "원");
		System.out.println("4.총   금   액 : " + total);
		System.out.println("5.잔    	 돈 :" + extra);

	}
}
