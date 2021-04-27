package day3.template;

import java.util.Scanner;

public class ATMApp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ATM atm = new ATM();
		Deposit deposit = new Deposit();
		Withdraw withdraw = new Withdraw();

		while (true) {
			System.out.println("================ATM================");
			System.out.println("1.입금  2.출금  9.종료");

			int sel = sc.nextInt();
			// 입금
			if (sel == 1) {
				atm.setBanking(deposit);
				atm.runBanking();
			}
			// 출금
			else if (sel == 2) {
				atm.setBanking(withdraw);
				atm.runBanking();
			}
			// 종료
			else if (sel == 9) {
				break;
			}
			System.out.println("=====================================");
		}

	}

}
