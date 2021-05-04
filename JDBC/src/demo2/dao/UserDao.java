package demo2.dao;

import demo2.vo.User;

/*
 * SAMPLE_USERS 테이블에 대한 CRUD 작업이 구현된 클래스다.
 * 
 */
public class UserDao {

	/*
	 * sample_users 테이블에 대한 CRUD작업이 구현된 클래스
	 */
	public void insertUser(User user) {

	}

	// 리드는 여러개, 한건 두가지 경우로 나뉜다
	/**
	 * sample_users 테이블에서 전달받은 아이디에 해당하는 user 객체 반환
	 * 
	 * @param userId
	 * @return
	 */
	public User getUserById(String userId) {
		return null;
	}

	/**
	 * 변경할 사용자정보를 전달받아서 SAMPLE_USERS 테이블의 사용자정보를 변경한다.
	 * 
	 * @param user
	 */
	public void updateUser(User user) {

	}

	/**
	 * 삭제할 사용자정보를 받아서 SAMPLE_USERS 테이블의 사용자정보를 삭제한다.
	 * 
	 * @param userId
	 */
	public void deleteUser(String userId) {

	}
}
