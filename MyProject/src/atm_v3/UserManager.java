package atm_v3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserManager {

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private UserRepository repo;

	public void setRepo(UserRepository repo) {
		this.repo = repo;
	}

	/*
	 * 회원추가
	 */
	public void addUser(User user) {
		if (repo.getUserByID(user.getId()) == null) {
			System.out.println("회원가입을 축하합니다");
			repo.save(user);
		} else {
			System.out.println("아이디가 중복됩니다.");
		}
	}

	/*
	 * id로 회원찾기
	 */
	public User searchUserByID(String id) {
		return repo.getUserByID(id);
	}

	/*
	 * idx로 회원찾기
	 */
	public User searchUserByIdx(int log) {
		return repo.getUserByIdx(log);
	}

	/*
	 * 저장된 배열의 인덱스 찾기
	 */
	public int getLogIdx(String id) {
		return repo.getIdx(id);
	}

	/*
	 * pw변경
	 */
	public void updatePw(int log, User user) throws IOException {
		System.out.println("비밀번호를 바꾸시겠습니까?");
		System.out.print("Y/N : ");
		String sel = br.readLine();
		if (sel.equals("Y") || sel.equals("y")) {
			user.setPw(br.readLine());
		} else if (sel.equals("N") || sel.equals("n")) {
			repo.update(log, user);
		} else
			return;
	}

	/*
	 * 유저삭제
	 */
	public int deleteUser(int log, User user) throws IOException {
		System.out.print("비밀번호를 한번 더 입력하세요: ");
		String pw = br.readLine();
		if (pw.equals(user.getPw())) {
			repo.delete(log);
			return -1;
		} else {
			System.out.println("비밀번호가 틀렸습니다");
			return log;
		}
	}

}
