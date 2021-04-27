package atm_v3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ATMApp {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		UserManager userManager = new UserManager();

		UserRepository repo = new UserArrayRepository();
		userManager.setRepo(repo);

		int log = -1;
		while (true) {
			User user = new User();
			System.out.println("=================ATM=================");

			if (log == -1) {
				System.out.println("1. 회원가입");
				System.out.println("2. 로그인");
				System.out.println("3. 회원조회");
				System.out.println("9. 종료");
				System.out.println("=======================================");
				System.out.print("번호를 눌러주세요: ");
				int sel = sc.nextInt();
				if (sel == 1) {
					System.out.print("ID: ");
					user.setId(br.readLine());
					System.out.println(user.getId());
					if (repo.getUserByID(user.getId()) != null) { // ??
						System.out.println("아이디를 확인하세요");
						continue;
					}
					System.out.print("PW: ");
					user.setPw(br.readLine());
					System.out.println("이름: ");
					user.setName(br.readLine());
					userManager.addUser(user);
				}

				else if (sel == 2) {
					System.out.print("ID: ");
					String id = br.readLine();
					System.out.println("PW: ");
					String pw = br.readLine();

					User temp = userManager.searchUserByID(id);

					if (temp != null && temp.getPw().equals(pw)) {
						log = userManager.getLogIdx(id);
					} else {
						System.out.println("아이디 또는 비밀번호를 확인하세요");
						continue;
					}

				} else if (sel == 3) {
					int idx = 0;
					while (true) {
						user = repo.getUserByIdx(idx++);
						if (user == null) {
							break;
						}
						System.out
								.println(user.getId() + "(" + user.getName() + ")" + ", 고유번호: " + user.getMemberCode());
					}
				} else if (sel == 9) {
					System.out.println("종료");
					break;
				}
			} else {
				System.out.println(repo.getUserByIdx(log).getName() + "님 환영합니다.");
				System.out.println("1. 계좌조회");
				System.out.println("2. 계좌생성");
				System.out.println("3. 로그아웃");
				System.out.println("4. 회원탈퇴");
				System.out.println("9. 종료");
				System.out.println("=======================================");
				System.out.print("번호를 눌러주세요: ");
				int sel = sc.nextInt();
				if (sel == 1) {
				} else if (sel == 2) {
				} else if (sel == 3) {
					log = -1;
				} else if (sel == 4) {
					log = userManager.deleteUser(log, repo.getUserByIdx(log));
				} else if (sel == 5) {
				}
			}
		}
	}
}
