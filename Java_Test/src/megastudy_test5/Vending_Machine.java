package megastudy_test5;

import java.util.Scanner;

public class Vending_Machine {
	// 식권 자판기 프로그램
	// 1) 관리자 2) 사용자
	// 관리자 ==> 1) 식권충전 2) 잔돈 충전 3)뒤로가기
	// 사용자 ==> 1) 구입 ==> ==> 입금 금액 입력 ==> 구매 매수 입력 ==> 잔돈출력
	// 2)뒤로가기
	// 조건 ) 예) 잔돈이 7600원이다. 5000원권이 없으면 1000원짜리 7장출력
	// 화면
	// 식권 가격 : 3200원
	// 식권 : ??매 (매진시 매진)
	// 50000원 : ?? 매 // 10000원 : ?? 매 // 5000원 : ?? 매
	// 1000원 : ?? 매 // 500원 : ?? 개 // 100원 : ?? 개

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int[] money = { 50000, 10000, 5000, 1000, 500, 100 };
		int[] charges = { 1, 1, 1, 1, 5, 10 };

		int[][] extra = new int[money.length][2]; // 0에는 money, 1에는 매수
		int sum = 0;

		for (int i = 0; i < money.length; i++) {
			extra[i][0] = money[i];
			extra[i][1] = charges[i];
		}

		int tickets = 5; // 식권 개수
		int price = 3200; // 식권 가격
		int priceSum = 0;

		while (true) {

			System.out.println("===============");
			System.out.println("잔돈");
			System.out.print("50000: " + extra[0][1]);
			System.out.println();
			System.out.print("10000: " + extra[1][1]);
			System.out.println();
			System.out.print("5000: " + extra[2][1]);
			System.out.println();
			System.out.print("1000: " + extra[3][1]);
			System.out.println();
			System.out.print("500: " + extra[4][1]);
			System.out.println();
			System.out.println("100: " + extra[5][1]);
			System.out.println("===============");
			System.out.println("[1]관리자");
			System.out.println("[2]사용자");

			System.out.print("메뉴 선택 : ");
			int sel = sc.nextInt();

			if (sel == 1) {
				while (true) {

					System.out.println("1)식권충전");
					System.out.println("2)잔돈충전");
					System.out.println("3)뒤로가기");

					System.out.print("메뉴 선택 : ");

					int choice = sc.nextInt();
					if (choice == 1) {
						tickets = 5;
					} else if (choice == 2) {
						for (int i = 0; i < extra.length; i++) {
							extra[i][1] = charges[i];
						}
					} else if (choice == 3) {
						break;
					}
				}

			} else if (sel == 2) {
				while (true) {
					System.out.println("1)구입");
					System.out.println("2)뒤로가기");
//					System.out.println("===============");
//					System.out.println("잔돈");
//					System.out.print("50000: " + extra[0][1]);
//					System.out.println();
//					System.out.print("10000: " + extra[1][1]);
//					System.out.println();
//					System.out.print("5000: " + extra[2][1]);
//					System.out.println();
//					System.out.print("1000: " + extra[3][1]);
//					System.out.println();
//					System.out.print("500: " + extra[4][1]);
//					System.out.println();
//					System.out.println("100: " + extra[5][1]);
//
//					System.out.println("===============");
					System.out.print("메뉴 선택 : ");
					for (int i = 0; i < money.length; i++)
						sum += extra[i][0] * extra[i][1];

//					얼마입금?->몇장 살거?->입금-몇장*가격->
//					잔돈 계산->잔돈 출력

					int choice = sc.nextInt();
					if (choice == 1) {
						if (tickets <= 0) {
							System.out.println("매진");
							continue;
						}

						System.out.println("입금");
						int pay = sc.nextInt();

						if (pay > sum) {
							System.out.println("잔돈이 모자릅니다");
							continue;
						}

						if (pay % 100 != 0) {
							System.out.println("100원 이상 투입하세요");
							continue;
						}

						System.out.println("몇 장 사시겠습니까?");
						int num = sc.nextInt();
						if (num > tickets) {
							System.out.println("티켓이 모자랍니다");
							continue;
						}
						tickets -= num;
						int temp = pay - (num * price);
						if (temp < 0) {
							System.out.println("금액이 모자릅니다.");
							continue;
						}
						System.out.println("거스름돈은 " + temp + "입니다");
						while (temp > 0) {
							if (temp >= 50000) {
								if (extra[0][1] != 0) {
									temp -= 50000;
									extra[0][1] -= 1;
									continue;
								}
							}

							if (temp >= 10000) {
								if (extra[1][1] != 0) {
									temp -= 10000;
									extra[1][1] -= 1;
									continue;
								}
							}
							if (temp >= 5000) {
								if (extra[2][1] != 0) {
									temp -= 5000;
									extra[2][1] -= 1;
									continue;
								}
							}
							if (temp >= 1000) {
								if (extra[3][1] != 0) {
									temp -= 1000;
									extra[3][1] -= 1;
									continue;
								}
							}
							if (temp >= 500) {
								if (extra[4][1] != 0) {
									temp -= 500;
									extra[4][1] -= 1;
									continue;
								}
							}
							if (temp >= 100) {
								if (extra[5][1] != 0) {
									temp -= 100;
									extra[5][1] -= 1;
									continue;
								}
							}

						}
						System.out.println("남은 잔돈: " + temp);
					} else if (choice == 2) {
						break;
					}
				}
			}
		}
	}

}
