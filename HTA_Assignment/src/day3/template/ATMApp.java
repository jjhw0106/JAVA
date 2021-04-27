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
			System.out.println("1.�Ա�  2.���  9.����");

			int sel = sc.nextInt();
			// �Ա�
			if (sel == 1) {
				atm.setBanking(deposit);
				atm.runBanking();
			}
			// ���
			else if (sel == 2) {
				atm.setBanking(withdraw);
				atm.runBanking();
			}
			// ����
			else if (sel == 9) {
				break;
			}
			System.out.println("=====================================");
		}

	}

}
