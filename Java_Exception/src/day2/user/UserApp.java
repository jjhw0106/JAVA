package day2.user;

import java.util.Scanner;

public class UserApp {
	public static void main(String[] args) {
		UserService service = new UserService();
		Scanner sc = new Scanner(System.in);
		while (true) {
			try {
				System.out.println("==========================================");
				System.out.println("1. 가입하기");
				System.out.println("2. 비밀번호변경");
				System.out.println("3. 회원탈퇴");
				System.out.println("4. 회원조회");
				System.out.println("0. 종료");
				System.out.println("==========================================");
				System.out.println("메뉴선택");
				int sel = sc.nextInt();
				System.out.println();

				if (sel == 1) {
					System.out.println("회원가입");
					System.out.print("아이디입력 > ");
					String id = sc.next();
					System.out.print("이름입력 > ");
					String name = sc.next();
					System.out.println("비밀번호 입력 > ");
					String password = sc.next();

					service.insertUser(new User(id, name, password));
					System.out.println("[안내] 회원가입이 완료되었습니다");

				} else if (sel == 2) {
					System.out.println("비밀번호 변경");
					System.out.print("아이디입력 > ");
					String id = sc.next();
					System.out.println("비밀번호 입력 > ");
					String password = sc.next();
					System.out.println("새 비밀번호 입력 > ");
					String newPassword = sc.next();
					service.changeUserPassword(id, password, newPassword);
					System.out.println("비밀번호가 변경되었습니다.");

				} else if (sel == 3) {
					System.out.println("회원탈퇴");

					System.out.println("아이디 입력 >");
					String id = sc.next();
					System.out.println("비밀번호 입력 >");
					String password = sc.next();

					service.deleteUserById(id, password); // 해당 메소드가 던진 예외를 받으면 catch블록으로 점프
					System.out.println("회원탈퇴가 완료되었습니다.");

				} else if (sel == 4) {
					System.out.print("조회할 id > ");
					String id = sc.next();
					if (service.getUserById(id) == null) {
						throw new UserNotFoundException(id);
					}
					System.out.println("id: " + service.getUserById(id).getId());
					System.out.println("pw: " + service.getUserById(id).getPassword());
					System.out.println("name: " + service.getUserById(id).getName());

				} else if (sel == 0) {
					break;
				}
			} catch (UserException e) {
				System.out.println("오류" + e); // 웹에서는 에러페이지가 사용자의 브라우져화면에 표시된다.

			}
			System.out.println();
			System.out.println();
		}
	}
}
