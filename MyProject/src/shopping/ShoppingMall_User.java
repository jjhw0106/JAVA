package shopping;

class ShoppingMall_User {
	ItemManager im = ItemManager.getInstance();
	int log = -1;

	void login(String id, String pw) {
		for (int i = 0; i < UserManager.userList.size(); i++) {
			if (id.equals(UserManager.userList.get(i).getId()) && pw.equals(UserManager.userList.get(i).getPw())) {
				log = i;
				System.out.println(UserManager.userList.get(log).getName() + "님 로그인 되었습니다.");
			}
		}
	}

	void logout() {
		System.out.println("로그아웃 되었습니다.");
		log = -1;
	}

	void run() {
		if (FileManager.categoryFile.exists()) {
			FileManager.cateLoad();
		}
		if (FileManager.userFile.exists()) {
			FileManager.userLoad();
		}
		while (true) {
			if (log != -1) {
				System.out.println(UserManager.userList.get(log).getName() + "님 로그인 중입니다.");
				System.out.println("==========Shopping Mall==========");
				System.out.println("1. 쇼핑하기");
				System.out.println("2. 장바구니");
				System.out.println("3. 로그아웃");
				System.out.println("4. 회원탈퇴");
				System.out.println("9. 뒤로가기");
				System.out.println("=================================");
				int sel = Function.sc.nextInt();
				if (sel == 1) {
				} else if (sel == 2) {
				} else if (sel == 3) {
					logout();
				} else if (sel == 4) {
					UserManager.userRemove(log);
				} else if (sel == 9) {
					break;
				}
			} else {
				System.out.println("==========Shopping Mall==========");
				System.out.println("1. 회원가입");
				System.out.println("2. 로그인");
				System.out.println("9. 뒤로가기");
				System.out.println("=================================");
				int sel = Function.sc.nextInt();
				if (sel == 1) {
					UserManager.userAdd();
				} else if (sel == 2) {
					System.out.print("ID:");
					String id = Function.getStr();
					System.out.print("PW:");
					String pw = Function.getStr();
					login(id, pw);
				} else if (sel == 3) {

				} else if (sel == 9) {
					break;
				}
			}
		}
	}
}
