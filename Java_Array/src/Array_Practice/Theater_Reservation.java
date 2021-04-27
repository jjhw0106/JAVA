/*
 * # 영화관 좌석예매
 * 1. 사용자로부터 좌석번호(index)를 입력받아 예매하는 시스템이다.
 * 2. 예매가 완료되면 해당 좌석 값을 1로 변경한다.
 * 3. 이미 예매가 완료된 좌석은 재구매할 수 없다.
 * 4. 한 좌석당 예매 가격은 12000원이다.
 * 5. 프로그램 종료 후, 해당 영화관의 총 매출액을 출력한다.
 * 예)
 * seat = 0 0 0 0 0 0 0
 * 
 * 좌석선택 : 1
 * seat = 0 1 0 0 0 0 0
 * 
 * 좌석선택 : 3
 * seat = 0 1 0 1 0 0 0
 * 
 * 좌석선택 : 3
 * seat = 0 1 0 1 0 0 0
 * 이미 예매가 완료된 자리입니다.
 * ----------------------
 * 매출액 : 24000원
 */
package Array_Practice;

import java.util.Scanner;

public class Theater_Reservation {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int[] seat = new int[10];
		int i = 0;
		int sel = 0;
		int exit = 0;
		int cnt = 0;
		int total = 0;

		// 영화관 자리 초기화
		for (i = 0; i < 10; i++)
		{
			seat[i] = 0;
		}

		////////////////////////////// 자리 선택///////////////////////////////////////
		while (exit == 0)
		{
			int menu = 0;
			System.out.println("********** 메뉴를 고르세요. **********");
			System.out.println("1. 자리선택        2. 계산하기");
			menu = scan.nextInt();

			if (menu == 1)
			{
				// 빈좌석 안내
				System.out.println("빈 좌석은 다음과 같습니다");
				for (i = 0; i < 10; i++)
					System.out.print((i + 1 + " "));
				System.out.println();

				for (i = 0; i < 10; i++)
				{
					if (seat[i] == 0)
					{

						System.out.print("□ ");
					} else
					{
						System.out.print("■ ");
					}
				}

				// 좌석 선택

				System.out.println();
				System.out.print("몇번 자리를 선택하시겠습니까? : ");
				System.out.println();
				sel = scan.nextInt();
				if (seat[sel - 1] == 1)
					System.out.println("이미 예약된 자리입니다. ");
				else
				{
					System.out.println(" 예약 완료");
					seat[sel - 1] = 1;
					for (i = 0; i < 10; i++)
					{
						if (seat[i] == 0)
						{

							System.out.print("□ ");
						} else
						{
							System.out.print("■ ");
						}
					}
					System.out.println();
					System.out.println();
				}
			}

			else if (menu == 2)
			{
				exit = 1;
			}

		}
		/////////////////////////////// 자리선택///////////////////////////////////////

		// 계산하기

		for (i = 0; i < 10; i++)
			if (seat[i] == 1)
				cnt++;

		total += cnt * 12000;
		System.out.println("총 매출액은 " + total + "입니다.");

	}
}
