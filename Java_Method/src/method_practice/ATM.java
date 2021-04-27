package method_practice;

//System.out.println("1.회원가입");	

//System.out.println("2.회원탈퇴");
//System.out.println("3.로그인");
//System.out.println("4.로그아웃");
//System.out.println("5.입금하기");
//System.out.println("6.이체하기");
import java.util.Scanner;

class ATMFunc {
	Scanner sc = new Scanner(System.in);

	String[] ids = { "1111", "2222", "3333", "", "" };
	String[] pws = { "1234", "2345", "3456", "", "" };
	int[] balance = { 87000, 34000, 17500, 0, 0 };

	int log = -1;
	String id = "";
	String pw = "";
 
	// 회원가입
	void join() {
		while (true) {
			int idCnt = 0;
			for (int i = 0; i < ids.length; i++) {
				if (ids[i] != "") {
					idCnt++;
				}
			}
			if (idCnt == ids.length) {
				System.out.println("더 이상 가입할 수 없습니다");
				break;
			}

			System.out.print("ID: ");
			String getId = sc.next();
			int check = -1;
			int getIdx = 0;
			for (int i = 0; i < ids.length; i++) {
				if (getId.equals(ids[i])) {
					check = 1;
				}
			}
			for (int i = 0; i < ids.length; i++) {
				if (ids[i].equals("")) {
					getIdx = i;
					System.out.println("idx" + getIdx);
					break;
				}
			}

			if (check == 1) {
				System.out.println("존재하는 ID입니다");
			} else if (check == -1) {
				System.out.print("PW를 입력하세요: ");
				pws[getIdx] = sc.next();
				ids[getIdx] = getId;
				break;
			}
		}

	}

	// 회원탈퇴
	void deleteInf() {
		if (balance[log] != 0)
			System.out.println("금액이 남아있습니다.");
		else {
			System.out.println("정말 삭제하시겠습니까? y/n");
			String dId = sc.next();
			if (dId.equals("y")) {
				System.out.print("비밀번호: ");
				String dPw = sc.next();
				if (dPw.equals(pws[log])) {
					ids[log] = "";
					log = -1;
				}
			}
		}
	}

	// 로그인
	void logIn() {
		System.out.print("ID: ");
		String getId = sc.next();
		System.out.print("PW: ");
		String getPw = sc.next();
		for (int i = 0; i < ids.length; i++) {
			if (getId.equals(ids[i]) && getPw.equals(pws[i])) {
				this.log = i;
				System.out.println(ids[this.log] + "님 환영합니다. ");
			}
		}
		if (log == -1) {
			System.out.println("ID또는 PW를 확인하세요.");
		}

	}

	// 로그아웃
	void logOut() {
		this.log = -1;
	}

	void deposit() {
		System.out.print("입금할 금액: ");
		int money = sc.nextInt();
		balance[log] += money;
	};

	// 이체하기
	void transfer() {
		System.out.println("누구에게 보내시겠습니까? ");
		String account = sc.next();
		int getIdx = -1;
		for (int i = 0; i < ids.length; i++) {
			if (account.equals(ids[i])) {
				getIdx = i;
				break;
			}
		}
		if (getIdx == -1)
			System.out.println("잘못된 계좌입니다.");
		else {
			System.out.print("이체할 금액: ");
			int money = sc.nextInt();
			if (money > balance[log]) {
				System.out.println("잔액이 부족합니다.");
			} else {
				balance[log] -= money;
				balance[getIdx] += money;
			}
		}

	}

	// 회원정보
	void memberInf() {
		for (int i = 0; i < ids.length; i++) {
			if (ids[i] != "")
				System.out.println(ids[i] + " : " + balance[i] + "원");
		}
	}

	void run() {
		System.out.println("======ATM======");
		while (true) {
			if (this.log != -1) {
				System.out.println(ids[log] + "님 접속 중" + "(잔액: " + balance[this.log] + "원)");
				System.out.println("1. 입금하기");
				System.out.println("2. 이체하기");
				System.out.println("3. 회원탈퇴");
				System.out.println("4. 로그아웃");
				int sel = sc.nextInt();
				if (sel == 1) {
					deposit();
				} else if (sel == 2) {
					transfer();
				} else if (sel == 3) {
					deleteInf();
				} else if (sel == 4) {
					logOut();
				}
			}

			else if (this.log == -1) {
				System.out.println("1. 로그인");
				System.out.println("2. 회원가입");
				System.out.println("3. 회원목록");
				System.out.println("4. 종 료");
				int sel = sc.nextInt();
				if (sel == 1) {
					logIn();
				} else if (sel == 2) {
					join();
				} else if (sel == 3) {
					memberInf();
				} else if (sel == 4)
					break;
			}
		}

	}

}

public class ATM {
	public static void main(String[] args) {
		ATMFunc e = new ATMFunc();
		e.run();
	}

}
