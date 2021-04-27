package assignment2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class AccountApp2 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 계좌 초기화
		Account2 acc = new Account2();
		acc.setDepositor("정호원");
		acc.setPw("hta123");
		acc.setBalance(80000000);

		while (true) {
			System.out.println("===============HoBank===============");
			System.out.println("1. 조회");
			System.out.println("2. 입금");
			System.out.println("3. 출금");
			System.out.println("9. 종료");
			System.out.println("======================================");
			int sel = 0;
			sel = sc.nextInt();

			// 계좌 출력
			if (sel == 1) {
				acc.displayInfo();
			}

			// 입금
			else if (sel == 2) {
				try {
					System.out.print("입금할 금액: ");
//					long money = sc.nextLong();	//= 뭔가 sc에 찌꺼기가 남아서 27번 줄 nextInt에 영향을 주는 것 같음
					long money = Long.parseLong(br.readLine());

					// 예외처리땜빵(Q. Exception활용 어떻게?)
//					if (money >= 1000000000) {
//						System.out.println("금액을 확인하세요");
//						continue;
//					}
					////////////////////////////////////////////

					acc.deposit(money);
				} catch (Exception e) {
					System.out.println("금액을 확인하세요.");
					e.printStackTrace();
				}
			}

			// 출금
			else if (sel == 3) {
				System.out.println("비밀번호 입력: ");
				String pw = sc.next();
				System.out.println("출금할 금액: ");
				long withdraw = sc.nextLong();

				if (withdraw >= acc.getBalance()) {
					System.out.println("잔액이 부족합니다");
					continue;
				}
				acc.withdraw(withdraw, pw);

			}

			else if (sel == 9) {
				break;
			}
		}
	}
}
