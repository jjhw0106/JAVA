package day2.user;

import java.util.ArrayList;
import java.util.Iterator;

import jdk.jshell.spi.ExecutionControl.UserException;

public class UserService {

	ArrayList<User> users = new ArrayList<User>();

	public UserService() {
		users.add(new User("hong", "홍길동", "1234"));
		users.add(new User("kim", "김유신", "1234"));
		users.add(new User("lee", "이순신", "1234"));
		users.add(new User("kang", "강감찬", "1234"));
		users.add(new User("ryu", "유관순", "1234"));
	}

	// 새 사용자 등록기능
	// 동일한 아이디 존재시 UserAlreadyExistException을 던짐
	public void insertUser(User user) {
		if (getUserById(user.getId()) != null) {
			throw new UserAlreadyExistException(user.getId());
		}
		users.add(user);
	}

	// 아이디를 전달받아 해당 아이디로 가입한 사용자를 반환하는 기능
	// 아이디에 해당하는 사용자가 존재하지 않으면 UserNotFoundException을 던짐
	public User getUserById(String userId) {
		for (User u : users) {
			if (u.getId().equals(userId)) {
				return u;
			}
		}
		return null;
	}

	// 아이디, 이전 비밀번호, 새 비밀번호를 전달받아서 비밀번호를 변경하는 기능
	// 아이디에 해당하는 사용자가 존재하지 않으면 UserNotFoundException을 던짐
	// 비밀번호가 일치하지 않으면 PasswordException 던짐
	public void changeUserPassword(String userId, String oldPassword, String newPassword) {
		User savedUser = getUserById(userId);
		if (savedUser == null)
			throw new UserNotFoundException(userId + "존재하지 않습니다.");
		if (!savedUser.getPassword().equals(oldPassword))
			throw new PasswordMismatchException(oldPassword + "가 잘못 입력되어있습니다.");
		savedUser.setPassword(newPassword);
	}

	// 아이디를 전달받아서 해당 아이디로 가입한 사용자를 삭제하는 기능
	// 없으면 UserNotFoundException
	public void deleteUserById(String userId, String password) {
		User savedUser = getUserById(userId);
		if (savedUser == null) { // 아이디에 해당하는 사용자 정보가 존재하지 않는다면
			throw new UserNotFoundException(userId); // 예외 던지고 메소드 종료
		}
		if (!savedUser.getPassword().equals(password)) {
			throw new PasswordMismatchException(password);
		}
		Iterator<User> iter = users.iterator();
		while (iter.hasNext()) {
			User user = iter.next();
			if (user.getId().equals(userId)) {
				iter.remove();
				break;
			}
		}

	}

//
//	public User findUserByID1(String id) {
//		for (User user : users) {
//			if (user.getId().equals(id))
//				return user;
//		}
//		return null;
//	}
//
//	public User findUserByID2(String id) {
//		for (User user : users) {
//			if (user.getId().equals(id))
//				return user;
//		}
//		throw new UserNotFoundException("[" + id + "]" + "를 찾을 수 없습니다."); // 예외는 반환값이 없어도 된다.
//																			// 보통 null, 예외던지기, false를 사용해서 예외처리 한다
//	}
//
//	public void changePassword1(String id, String oldPwd, String newPwd) {
//		User user = findUserByID1(id);
//		if (user != null) {
//			if (user.getPassword().equals(oldPwd)) {
//				user.setPassword(newPwd);
//			} else {
//				System.out.println("비밀번호가 일치하지 않습니다.");
//			}
//		} else {
//			System.out.println("아이디와 일치하늕 사용자가 존재하지 않습니다.");
//		}
//	}
//
//	public void changePassword2(String id, String oldPwd, String newPwd) {
//		User user = findUserByID2(id); // 값 찾지 못할 시, 예외발생, 메소드 종료
//		if (!user.getPassword().equals(oldPwd)) // 비밀번호가 일치하지 않으면,
//			throw new PasswordMismatchException(newPwd); // 예외발생, 메소드 종료
//	}
}
