package atm;

import java.util.ArrayList;
import java.util.Scanner;

class UserManager {
	static ArrayList<User> uList = new ArrayList<User>();
//	/*static*/ int userSize = uList.size();
	Scanner sc = new Scanner(System.in);

	int idCheck(String id) {
		int check = -1;
		for (int i = 0; i < uList.size(); i++) {
			if (id.equals(uList.get(i).getId())) {
				check = i;
				break;
			}
		}

		return check;
	}

	String getNewId() {
		String id = sc.next();
		return id;
	}

	String getNewPw() {
		String pw = sc.next();
		return pw;
	}

	String getName() {
		String name = sc.next();
		return name;
	}

	void addMember(String id, String pw, String name) {
		User temp = new User();
		temp.setId(id);
		temp.setPw(pw);
		temp.setName(name);
		uList.add(temp);
	}

	int deleteMember(int log, String pw) {
//		String tempPw = sc.next();
		if (pw.equals(uList.get(log).getPw())) {
			uList.remove(log);
			log = -1;
		} else {
			System.out.println("비밀번호가 틀렸습니다.");
		}
		return log;
	}

	void join() {
		System.out.print("ID: ");
		String id = getNewId();
		if (idCheck(id) == -1) {
			System.out.print("PW: ");
			String pw = getNewPw();
			System.out.println("이름을 입력하세요.");
			String name = getName();
			addMember(id, pw, name);
			System.out.println(id + "님 가입되셨습니다.");
		} else {
			System.out.println("중복된 id입니다.");
		}

	}
}