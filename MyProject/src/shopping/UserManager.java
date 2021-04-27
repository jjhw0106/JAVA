package shopping;

import java.util.ArrayList;

class UserManager {
	private UserManager() {

	}

	public static UserManager uInstance = new UserManager();

	public static UserManager getuInstance() {
		return uInstance;
	}

	static ArrayList<User> userList = new ArrayList<User>();

	// 유저 추가
	static void userAdd() {
		System.out.println("ID입력: ");
		String id = Function.getStr();
		String pw;
		String name;
		// 중복검사
		int size = userList.size();
		String tempList[] = new String[size];
		for (int i = 0; i < size; i++) {
			tempList[i] = userList.get(i).getId();
		}
		if (Function.duplicationCheck(id, tempList) == true) {
			pw = Function.getStr();
			name = Function.getStr();
			User temp = new User(id, pw, name);
			userList.add(temp);
			FileManager.userSave();
		} else {
			System.out.println("중복된 id입니다.");
		}
	}

	// 유저 삭제
	static void userRemove(int log) {
		System.out.println("비밀번호를 입력하세요");
		String pw = Function.sc.next();
		if (pw.equals(userList.get(log).getPw())) {
			System.out.println("삭제 완료");
			userList.remove(log);
		} else {
			System.out.println("비밀번호가 틀렸습니다.");
		}
	}
	// 장바구니
}
