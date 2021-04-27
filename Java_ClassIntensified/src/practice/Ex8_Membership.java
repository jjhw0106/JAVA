package practice;

import java.util.Scanner;

class Member {
	String id = "";
	String pw = "";
	String money = "";
	int memberIdx = 0;
}

class Management {
	final int MAXIMUM = 10;
	Scanner sc = new Scanner(System.in);
	Member m[] = new Member[MAXIMUM];
	int addIdx = 0; // q.이런식 변수 선언?(중복)

	void classInit() { // 제어문은 메서드 안에서만 사용할 수 있다.
		for (int i = 0; i < MAXIMUM; i++) {
			m[i] = new Member();
		}
	}

	// for 회원가입
	void getId() {
		System.out.print("ID를 입력하세요: ");
		m[this.addIdx].id = sc.next();
	}

	void getPw() {
		System.out.print("PW를 입력하세요: ");
		m[this.addIdx].pw = sc.next();
		m[this.addIdx].memberIdx = this.addIdx;
		this.addIdx++;
	}

	int checkMemberList() {

		int check = 1;

		for (int i = 0; i < this.addIdx; i++) {
			if (m[this.addIdx].id.equals(m[i].id)) {
				m[this.addIdx] = new Member();
				check = -1;
				break;
			}
		}
		return check;
	}

	// 명단 출력
	void memberShow() {
		for (int i = 0; i < MAXIMUM; i++) {
//			if (m[i].id != "")	//가입된 아이디만 표시
			System.out.println(m[i].id);
		}

	}

	// 회원 탈퇴
	void delete() {
		int check = -1;
		String id = sc.next();
		for (int i = 0; i < addIdx; i++) {
			if (id.equals(m[i].id)) {
				check = i;
				break;
			}
		}
		if (check == -1) {
			System.out.println("없는 아이디입니다.");
		}

		if (check != -1) {
			System.out.println("비밀번호를 입력하세요: ");
			String pw = sc.next();
			if (pw.equals(m[check].pw)) {
				System.out.println(m[check].id + "님 탈퇴되었습니다.");
				m[check].id = "";
				m[check].pw = "";
			} else {
				System.out.println("비밀번호가 틀렸습니다");
			}
		}
	}

	// 정렬 //데이터가 많아질 경우 끝까지 탐색할 필요 없도록
	void memberListLineUp() {
		Member temp[] = new Member[m.length];

		for (int i = 0; i < m.length; i++) {
			temp[i] = new Member();
		}

		int cnt = 0;
		for (int i = 0; i < this.addIdx; i++) {
			if (m[i].id != "") {
				temp[cnt] = m[i];
				cnt++;
			}
		}
		m = temp;
		this.addIdx = cnt;
	}

	void run() {
		classInit();
		while (true) {
			System.out.println("1. 회원가입");
			System.out.println("2. 회원명단");
			System.out.println("3. 회원탈퇴");
			System.out.println("4. 종 료");
			System.out.print("선택: ");
			int sel = sc.nextInt();

			// 회원 가입
			if (sel == 1) {
				if (this.addIdx == MAXIMUM) {// 임시로 3처리
					System.out.println("더 이상 가입할 수 없습니다.");
					continue;
				}
				getId();
				int check = checkMemberList();
				if (check == 1) {
					getPw();
				} else if (check == -1) {
					System.out.println("이미 있는 아이디입니다.");
				}
			}

			// 회원 명단
			else if (sel == 2) {
				System.out.println("======회원명단======");
				memberShow();
				System.out.println("=================");
			}

			// 회원 탈퇴
			else if (sel == 3) {
				System.out.print("삭제할 ID: ");
				delete();
				memberListLineUp();
			} else if (sel == 4) {
				break;
			}

		}
	}
}

public class Ex8_Membership {
	public static void main(String[] args) {
		Management manage = new Management();
		manage.run();
	}
}
