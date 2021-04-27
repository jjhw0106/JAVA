package step1_10;

import java.util.Scanner;

public class ATM_Level2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int dbAcc1 = 1111;
		int dbPw1 = 1234;
		int dbMoney1 = 50000;

		int dbAcc2 = 2222;
		int dbPw2 = 2345;
		int dbMoney2 = 70000;

		int logAcc;

		int log = -1; // -1(로그아웃), 1(acc1으로 로그인), 2(acc2로 로그인)

		boolean run = true;

		while (run) 
		{
			System.out.println("1. 로그인");
			System.out.println("2. 로그아웃");
			System.out.println("3. 조회");
			System.out.println("0. 종료");
			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt();

			
			// 로그인
			if (sel == 1 && log == -1) 
			{
				System.out.print("ID: ");
				logAcc = scan.nextInt();
				System.out.print("PW: ");
				int pw = scan.nextInt();

				if (logAcc == dbAcc1 && pw == dbPw1) {
					log = 1;
					System.out.println("계정1로 로그인하셨습니다.\n");
				} else if (logAcc == dbAcc2 && pw == dbPw2) {
					log = 2;
					System.out.println("계정2로 로그인하셨습니다.\n");
				} else
					System.out.println("아이디 또는 비밀번호를 확인하세요");
			}

			else if (sel == 1 && log == 1) 
			{
				System.out.println("로그인 되어있습니다.\n");
			}

			
			// 로그아웃
			if (sel == 2 && log == 1) 
			{
				System.out.println("로그아웃 되셨습니다\n");
				log = -1;
			}

			else if (sel == 2 && log == -1) 
			{
				System.out.println("로그아웃 상태입니다.\n");
			}
		
			
			// 조회
			if (sel == 3)
			{
				System.out.print("조회할 계좌의 번호를 입력하세요.  1. 계좌1,  2. 계좌2  :");
				int accSel = scan.nextInt();
				
				if(accSel == 1)
				{
					System.out.println("계좌1의 잔액은 "+ dbMoney1 + "원 입니다");
				}
				else if(accSel == 2)
				{
					System.out.println("계좌2의 잔액은 " + dbMoney2 + "원 입니다 ");
				}
			}

			
			
			// 종료
			if (sel == 0) 
			{
				System.out.println("프로그램이 종료되었습니다. \n");
				run = false;
			}

			
			// 로그인 시 행동질문
			if (log == 1 || log == 2) 
			{
				System.out.print("1. 입금");
				System.out.print("2. 출금");
				System.out.println("무슨 업무를 보시겠습니까?");

				int logMenu = scan.nextInt();

				
				// 입금
				if (logMenu == 1) 
				{
					System.out.print("입금할 금액을 입력하세요 : ");
					int deposit = scan.nextInt();
					if (log == 1) {
						dbMoney1 += deposit;
						System.out.println("계좌1의 잔고는 " + dbMoney1 + "원 입니다");
					} else if (log == 2) {
						dbMoney2 += deposit;
						System.out.println("계좌2의 잔고는 " + dbMoney2 + "원 입니다");
					}
				}

				// 출금
				if (logMenu == 2)
				{
					System.out.print("출금할 금액을 입력하세요 : ");
					int withdrawal = scan.nextInt();
					
					if(log == 1 && withdrawal > dbMoney1)
						System.out.println("잔고가 부족합니다.");
					else
						dbMoney1 -= withdrawal;
					
					if(log == 2 && withdrawal > dbMoney2)
						System.out.println("잔고가 부족합니다.");
					else
						dbMoney2 -= withdrawal;
				}
				
			}
		}

		scan.close();
	}

}
