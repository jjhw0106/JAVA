package atm_v3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class UserArrayRepository implements UserRepository {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private ArrayList<User> userList = new ArrayList<User>();

	public ArrayList<User> getUserList() {
		return userList;
	}

	public void setUserList(ArrayList<User> userList) {
		this.userList = userList;
	}

	int hashCode = 1;

	// 기본 데이터
	public UserArrayRepository() {
		userList.add(new User("j0001", "Jeong", "1111", hashCode++));
		userList.add(new User("j0002", "Kim", "2222", hashCode++));
		userList.add(new User("j0003", "Hong", "3333", hashCode++));
		userList.add(new User("j0004", "Park", "4444", hashCode++));
	}

	/*
	 * 유저저장
	 */
	@Override
	public void save(User user) {
		user.setMemberCode(hashCode++);
		userList.add(user);
	}

	/*
	 * 저장된 인덱스 받아오기
	 */
	@Override
	public int getIdx(String id) {
		int idx = -1;
		for (int i = 0; i < userList.size(); i++) {
			if (id.equals(userList.get(i).getId()))
				idx = i;
		}
		return idx;
	}

	/*
	 * id로 유저객체반환
	 */
	@Override
	public User getUserByID(String id) {
		for (User targetUser : userList) {
			if (targetUser.getId().equals(id))
				return targetUser;
		}
		return null;
	}

	/*
	 * idx로 유저객체반환
	 */
	@Override
	public User getUserByIdx(int idx) {
		if (idx >= userList.size())
			return null;
		return userList.get(idx);
	}

	/*
	 * 유저업데이트
	 */
	@Override
	public void update(int log, User user) {
		userList.set(log, user);
	}

	/*
	 * 유저삭제
	 */
	@Override
	public void delete(int log) {
		userList.remove(log);
	}

}
