package atm;

import java.util.Scanner;

class Bank {
	UserManager uManager = new UserManager();
	AccountManager accManager = new AccountManager();
	FileManager fManager = new FileManager();

	Scanner sc = new Scanner(System.in);
	int log = -1;

	void login() {
		System.out.println("SIZE:" + UserManager.uList.size());
		System.out.print("ID: ");
		String id = sc.next();
		System.out.print("PW: ");
		String pw = sc.next();
		for (int i = 0; i < UserManager.uList.size(); i++) {
			if (id.equals(UserManager.uList.get(i).getId())) {
				if (pw.equals(UserManager.uList.get(i).getPw())) {
					System.out.println(UserManager.uList.get(i).getId() + "님 환영합니다.");
					log = i;
					break;
				}
			}
		}
		if (log == -1) {
			System.out.println("ID 또는 비밀번호를 확인하세요.");
		}
	}

	void logout() {
		System.out.println("로그아웃 하시겠습니까? y/n");
		String sel = sc.next();
		if (sel.equals("y"))
			log = -1;
	}

	void showMemberInf() {
		for (int i = 0; i < UserManager.uList.size(); i++)
			System.out.println(
					"ID: " + UserManager.uList.get(i).getId() + " " + "이름: " + UserManager.uList.get(i).getName());
	}

	void run() {
		if (fManager.file.exists()) {
			System.out.println("존재");
			fManager.load();
		}
		while (true) {
			// 로그인 전
			if (log == -1) {
				System.out.println("================ATM================");
				System.out.println("1. 회원가입 ");
				System.out.println("2. 로그인");
				System.out.println("3. 조 회");
				System.out.println("4. 저 장");
				System.out.println("5. 종 료");
				System.out.println("===================================");
				int sel = sc.nextInt();
				// 회원가입
				if (sel == 1) {
					uManager.join();
				}
				// 로그인
				else if (sel == 2) {
					login();
				}
				// 회원 조회
				else if (sel == 3) {
					showMemberInf();
				}
				// 저장하기
				else if (sel == 4) {
					fManager.save();
					System.out.println("Update");
				}
				// 종료
				else if (sel == 5) {
					break;
				}
			}
			// 로그인 후
			else {
				System.out.println("================ATM================");
				System.out.println(UserManager.uList.get(log).getName() + "님 로그인 중입니다.");
				System.out.println("1. 계좌개설");
				System.out.println("2. 계좌삭제");
				System.out.println("3. 계좌조회");
				System.out.println("4. 저 장");
				System.out.println("5. 로그아웃");
				System.out.println("6. 회원탈퇴");

				System.out.println("===================================");
				int sel = sc.nextInt();

				// 계좌 생성
				if (sel == 1) {
					if (UserManager.uList.get(log).accList.size() < 3) {
						Account temp = accManager.createAccount();
						UserManager.uList.get(log).accList.add(temp);
					} else {
						System.out.println("만들 수 있는 계좌는 최대 3개입니다.");
					}

				}
				// 계좌 삭제
				else if (sel == 2) {
				}
				// 계좌 조회
				else if (sel == 3) {
					for (int n = 0; n < UserManager.uList.get(log).accList.size(); n++) {
						int[] accNum = UserManager.uList.get(log).accList.get(n).getAccNum();
						System.out.print("계좌번호: ");
						for (int i = 0; i < 3; i++) {
							System.out.print(accNum[i]);
						}
						System.out.print("-");
						for (int i = 3; i < accNum.length; i++) {
							System.out.print(accNum[i]);
						}
						System.out.println(" (잔액: " + UserManager.uList.get(log).accList.get(n).getMoney() + ")");
					}
				}
				// 정보 저장
				else if (sel == 4) {
					fManager.save();
					System.out.println("Update");
				}
				// 로그아웃
				else if (sel == 5) {
					logout();
				}
				// 회원 탈퇴
				else if (sel == 6) {
					System.out.println("비밀번호를 입력하세요 ");
					String tempPw = sc.next();
					log = uManager.deleteMember(log, tempPw);
					fManager.save();
				}
			}
		}
	}
}
