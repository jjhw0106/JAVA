package atm_v2;

import java.io.File;
import java.util.Scanner;

class Bank {
	Scanner sc = new Scanner(System.in);

	AccountManager am = AccountManager.getInstance();
	UserManager um = UserManager.getInstance();
//	UserManager em = UserManager.getInstance(); //이걸 싱글톤이라 할 수 있는지?

	int log = -1;

	// 로그인
	void login() {
		System.out.print("ID: ");
		String id = sc.next();
		System.out.print("PW: ");
		String pw = sc.next();
		for (int i = 0; i < UserManager.uList.size(); i++) {
			if (id.equals(UserManager.uList.get(i).getId())) {
				if (pw.equals(UserManager.uList.get(i).getPw())) {
					log = i;
					break;
				}
			}
		}
		if (log == -1) {
			System.out.println("아이디 또는 비밀번호를 확인하세요");
		}
	}

	// 입금
	void deposit() {
		System.out.println("입금할 금액 입력");
		int money = sc.nextInt();
		System.out.println("입금할 계좌를 입력하세요");
		int accountNum = sc.nextInt();
		boolean check = false;
		int idx = 0;
		for (int i = 0; i < AccountManager.accList.size(); i++) {
			if (accountNum == AccountManager.arrToInt(AccountManager.accList.get(i).accNum)) {
				idx = i;
				check = true;
				break;
			}
		}
		if (check == false) {
			System.out.println("잘못된 계좌입니다.");
		} else if (check == true) {
			AccountManager.accList.get(idx).setMoney(AccountManager.accList.get(idx).getMoney() + money);
		}
	}

	// 출금
	void withdraw(int log) {
		System.out.println("출금할 금액");
		int money = sc.nextInt();
		System.out.println("출금할 계좌를 선택하세요");
		for (int i = 0; i < UserManager.uList.get(log).accountCnt(); i++) {
			System.out.println((i + 1) + ". " + AccountManager.arrToInt(UserManager.uList.get(log).accounts[i].accNum)
					+ "(잔액: " + UserManager.uList.get(log).accounts[i].getMoney() + ")");
		}

		while (true) {
			int sel = sc.nextInt();
			if (sel > UserManager.uList.get(log).accountCnt()) {
				continue;
			}
			if (UserManager.uList.get(log).accounts[sel - 1].getMoney() < money) {
				System.out.println("잔액이 부족합니다.");
			} else {
				int temp = UserManager.uList.get(log).accounts[sel - 1].getMoney() - money;
				UserManager.uList.get(log).accounts[sel - 1].setMoney(temp);
			}
			break;
		}
	}

	void run() {
		// 파일 존재 시 로드
		if (FileManager.file.exists()) {
			FileManager.load();
		}
		while (true) {
			// test
			System.out.println("전체계좌(확인용, 로드시 반영)");
			for (int i = 0; i < AccountManager.accList.size(); i++) {
				System.out.println(AccountManager.arrToInt(AccountManager.accList.get(i).accNum));
			}
			//
			System.out.println("==============ATM==============");
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.println("3. 회원조회");
			System.out.println("4. 저장");
			System.out.println("5. 입금");
			System.out.println("9. 종료");
			System.out.println("===============================");

			int sel = 0;
			sel = sc.nextInt();

			// 회원가입
			if (sel == 1) {
				System.out.print("ID: ");
				String id = sc.next();
				boolean check = um.idCheck(id);
				if (check == false) {
					System.out.print("PW: ");
					String pw = sc.next();
					System.out.print("사용자 이름: ");
					String name = sc.next();
					um.addUser(id, pw, name);
				} else {
					System.out.println("중복된 ID입니다.");
				}
			}
			// 로그인
			else if (sel == 2) {
				login();
			}
			// 조회
			else if (sel == 3) {
				for (int i = 0; i < UserManager.uList.size(); i++) {
					System.out.print("id: " + UserManager.uList.get(i).getId());
					System.out.print("이름: " + UserManager.uList.get(i).getName());
					System.out.print("비밀번호: " + UserManager.uList.get(i).getPw());
//					System.out.println("유저수: " + UserManager.uList.size());// 테스트
					System.out.println();
				}
			}
			// 저장
			else if (sel == 4) {
				FileManager.save();
			}
			// 입금
			else if (sel == 5) {
				deposit();
			}
			// 출금
			else if (sel == 6) {
				withdraw(log);
			}
			// 종료
			else if (sel == 9) {
				System.out.println("시스템 종료");
				break;
			}

			/////////// 로그인 후
			if (log != -1) {
				while (true) {
					if (log == -1) {
						break;
					}
					System.out.println(UserManager.uList.get(log).getId() + "님 접속  중입니다.");
					System.out.println("==============ATM==============");
					System.out.println("1. 계좌생성");
					System.out.println("2. 계좌삭제");
					System.out.println("3. 계좌조회");
					System.out.println("4. 저장");
					System.out.println("5. 입금");
					System.out.println("6. 출금");
					System.out.println("8. 로그아웃");
					System.out.println("9. 회원탈퇴");
					System.out.println("===============================");
					sel = sc.nextInt();

					// 계좌생성
					if (sel == 1) {
						int cnt = UserManager.uList.get(log).accountCnt();
						am.createAcc(cnt, log);

					}
					// 계좌삭제
					else if (sel == 2) {
						for (int i = 0; i < UserManager.uList.get(log).accountCnt(); i++) {
							System.out.println((i + 1) + ". "
									+ AccountManager.arrToInt(UserManager.uList.get(log).accounts[i].getAccNum()));
						}
						System.out.println("삭제할 계좌를 입력하세요");
						int accSel = sc.nextInt() - 1;
						am.deleteAcc(log, accSel);

					}
					// 계좌조회
					else if (sel == 3) {
						for (int i = 0; i < UserManager.uList.get(log).accountCnt(); i++) {
							System.out.print("계좌번호: ");
							for (int j = 0; j < 9; j++) {
								System.out.print(UserManager.uList.get(log).accounts[i].accNum[j]);
								if (j == 2) {
									System.out.print("-");
								}
							}
							System.out.println("(잔액: " + UserManager.uList.get(log).accounts[i].getMoney() + ")");
						}
					}
					// 저장
					else if (sel == 4) {
						FileManager.save();
					}
					// 입금
					else if (sel == 5) {
						deposit();
					}
					// 출금
					else if (sel == 6) {
						withdraw(log);
					}
					// 로그아웃
					else if (sel == 8) {
						System.out.println("로그아웃 하셨습니다");
						log = -1;
					}

					else if (sel == 9) {
					}
				}
			}
		}
	}
}
