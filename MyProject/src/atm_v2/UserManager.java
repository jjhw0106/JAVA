package atm_v2;

import java.util.ArrayList;

class UserManager {
	final static int MAX_ACC_CNT = 3;

	private UserManager() {
	}

	public static UserManager uInstance = new UserManager();

	public static UserManager getInstance() {
		return uInstance;
	}

	static ArrayList<User> uList = new ArrayList<User>();

	// 유저 리스트에 유저 추가
	void addUser(String id, String pw, String name) {
		User temp = new User(id,pw,name);
//		temp.setId(id);
//		temp.setPw(pw);
//		temp.setName(name);
		uList.add(temp);
	}

	// 아이디 중복체크
	boolean idCheck(String id) {
		boolean check = false;
		for (int i = 0; i < uList.size(); i++) {
			if (id.equals(uList.get(i).getId())) {
				check = true;
				break;
			} else {
				check = false;
			}
		}
		return check;

	}

	void deleteUser(int log) {
		uList.remove(log);
	}
}
