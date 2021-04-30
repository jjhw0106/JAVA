package service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import app.TodoApp;
import dao.TodoDao;
import dao.UserDao;
import exception.TodoException;
import vo.Todo;
import vo.User;

import static utils.KeyboardUtils.readString;

public class TodoService {

	private TodoDao todoDao = new TodoDao();
	private UserDao userDao = new UserDao();
	private User loginedUser = null;

	/**
	 * 신규회원 가입하기
	 * 
	 * @param user 새 회원 정보
	 */
	public void 회원가입서비스(User user) {
		// 1. 아이디로 저장된 사용자정보를 조회한다.
		// 2. 사용자정보가 존재하면 TodoException 발생 - 이미 사용중인 아이디 입니다.
		// 3. User객체에 현재 날짜와 시간정보를 저장한다.
		// 4. UserDao객체의 insertUser메소드를 실행해서 사용자정보를 저장시킨다.

		if (userDao.getUserById(user.getId()) != null) {
			throw new TodoException("이미 사용중인 아이디입니다.");
		}

		user.setCreatedDate((new Date()));

		userDao.insertUser(user);
	}

	/**
	 * 로그인하기
	 * 
	 * @param id       아이디
	 * @param password 비밀번호
	 */
	public void 로그인서비스(String id, String password) {
		// 1. 아이디로 저장된 사용자 정보를 조회한다.
		// 2. 사용자정보가 존재하지 않으면 TodoException 발생 - 아이디 혹은 비밀번호가 올바르지 않습니다.
		// 3. 탈퇴한 사용자면 TodoException 발생 - 탈퇴처리된 사용자입니다.
		// 3. 비밀번호가 일치하지 않으면 TodoException 발생 - 아이디 혹은 비밀번호가 올바르지 않습니다.
		// 4. 조회된 사용자정보를 loginedUser에 저장
		User getUser = userDao.getUserById(id);
		if (getUser == null) {
			throw new TodoException("아이디 혹은 비밀번호가 올바르지 않습니다.");
		}
		if (getUser.getDeletedDate() != null) {
			throw new TodoException("탈퇴처리된 사용자입니다.");
		}
		if (!password.equals(getUser.getPassword())) {
			throw new TodoException("아이디 혹은 비밀번호가 올바르지 않습니다.");
		}

		loginedUser = getUser;
	}

	/**
	 * 로그아웃하기
	 */
	public void 로그아웃서비스() {
		loginedUser = null;
		// 1. loginedUser를 null로 초기화 시킨다.
	}

	/**
	 * 로그인 여부 반환하기
	 * 
	 * @return 로그인되어 있으면 true를 반환한다.
	 */
	public boolean 로그인여부제공서비스() {
		return loginedUser != null ? true : false;
	}

	/**
	 * 비밀번호 변경하기
	 * 
	 * @param oldPassword 이전 비밀번호
	 * @param password    새 비밀번호
	 */
	public void 비밀번호변경서비스(String oldPassword, String password) {
		// 1. 로그인여부제공서비스()를 실행해서 로그인되어 있지 않으면 TodoException 발생 - 로그인 후 사용가능한 서비스입니다.
		// 2. loginedUser의 비밀번호와 비밀번호가 일치하지 않으면 TodoException 발생 - 아이디 혹은 비밀번호가 올바르지
		// 않습니다.
		// 3. 새 비밀번호로 loginedUser의 비밀번호 변경
		if (!로그인여부제공서비스()) {
			throw new TodoException("로그인 후 사용가능한 서비스입니다.");
		}
		if (!loginedUser.getPassword().equals(oldPassword)) {
			throw new TodoException("아이디 혹은 비밀번호가 올바르지 않습니다.");
		}
		loginedUser.setPassword(password);
	}

	/**
	 * 탈퇴하기
	 */
	public void 회원탈퇴서비스(String password) {
		// 1. 로그인여부제공서비스()를 실행해서 로그인되어 있지 않으면 TodoException 발생 - 로그인 후 사용가능한 서비스입니다.
		// 2. loginedUser의 비밀번호와 비밀번호가 일치하지 않으면 TodoException 발생 - 아이디 혹은 비밀번호가 올바르지
		// 않습니다.
		// 3. loginedUser의 isDiabled를 true로 변경
		// 4. loginedUser의 deletedDate에 현재 날짜와 시간정보추가
	}

	/**
	 * 새 일정을 추가하기
	 * 
	 * @param todo 새 일정정보
	 */
	public void 새일정추가서비스(Todo todo) {
		// 1. 로그인여부제공서비스()를 실행해서 로그인되어 있지 않으면 TodoException 발생 - 로그인 후 사용가능한 서비스입니다.
		// 2. Todo객체의 상태를 등록상태로 설정한다.
		// 3. Todo객체의 작성자에 현재 로그인된 사용자의 아이디를 설정한다.
		// 3. Todo객체의 createdDate에 현재 날짜와 시간정보 설정
		// 4. TodoDao객체의 insertTodo를 실행시켜서 저장시킨다.
		if (loginedUser == null) {
			throw new TodoException("로그인 후 사용가능한 서비스입니다.");
		}
		todo.setStatus(Todo.TODO_STATUS_ADDED);
		todo.setCreatedDate(new Date());
		todo.setWriter(loginedUser);
		todoDao.insertTodo(todo);
	}

	/**
	 * 나의 모든 일정을 조회하기
	 * 
	 * @return 일정 목록
	 */
	public List<Todo> 나의모든일정조회서비스() {
		// 1. 로그인여부제공서비스()를 실행해서 로그인되어 있지 않으면 TodoException 발생 - 로그인 후 사용가능한 서비스입니다.
		// 2. TodoDao객체에서 모든 일정정보를 조회한다.
		// 3. 로그인한 사용자가 작성자로 설정되어 있는 일정만 ArrayList에 담아서 반환한다.

		if (!로그인여부제공서비스()) {
			throw new TodoException("로그인 후 사용가능한 서비스입니다.");
		}

		ArrayList<Todo> myTodoList = new ArrayList<Todo>();
		for (Todo todo : todoDao.getTodos()) {
			if (todo.getWriter().equals(loginedUser)) {
				myTodoList.add(todo);
			}
		}
		return myTodoList;
	}

	/**
	 * 일정 상세정보 조회하기
	 * 
	 * @param no 일정번호
	 * @return 일정정보
	 */
	public Todo 일정상세조회서비스(int no) {
		// 1. 로그인여부제공서비스()를 실행해서 로그인되어 있지 않으면 TodoException 발생 - 로그인 후 사용가능한 서비스입니다.
		// 2. 일정번호에 해당하는 일정정보를 조회한다.
		// 3. 일정정보가 존재하지 않으면 TodoException 발생 - 일정번호에 해당하는 일정정보가 존재하지 않습니다.
		// 4. 일정정보 작성자와 로그인한 사용자가 일치하지 않으면 TodoException - 다른 사용자의 일정은 조회할 수 없습니다.
		// 5. 조회된 일정정보를 반환한다.

		return null;
	}

	/**
	 * 일정 제목, 내용을 변경하기
	 * 
	 * @param no    일정번호
	 * @param title 제목
	 * @param text  내용
	 */
	public void 일정변경서비스(int no, String title, String text) {
		// 1. 로그인여부제공서비스()를 실행해서 로그인되어 있지 않으면 TodoException 발생 - 로그인 후 사용가능한 서비스입니다.
		// 2. 일정번호에 해당하는 일정정보를 조회한다.
		// 3. 일정정보가 존재하지 않으면 TodoException 발생 - 일정번호에 해당하는 일정정보가 존재하지 않습니다.
		// 4. 일정정보 작성자와 로그인한 사용자가 일치하지 않으면 TodoException - 다른 사용자의 일정은 변경할 수 없습니다.
		// 5. 전달받은 정보로 조회된 일정정보의 제목과 내용을 변경한다.
	}

	/**
	 * 일정 완료처리 하기
	 * 
	 * @param no 일정번호
	 */
	public void 일정완료처리서비스(int no) {
		// 1. 로그인여부제공서비스()를 실행해서 로그인되어 있지 않으면 TodoException 발생 - 로그인 후 사용가능한 서비스입니다.
		// 2. 일정번호에 해당하는 일정정보를 조회한다.
		// 3. 일정정보가 존재하지 않으면 TodoException 발생 - 일정번호에 해당하는 일정정보가 존재하지 않습니다.
		// 4. 일정정보 작성자와 로그인한 사용자가 일치하지 않으면 TodoException - 다른 사용자의 일정은 변경할 수 없습니다.
		// 5. 조회된 일정정보의 상태를 완료상태로 변경한다.
		// 6. 조회된 일정정보의 완료일자를 현재날짜와 시간정보로 설정한다.
	}

	/**
	 * 일정 삭제하기
	 * 
	 * @param no 일정번호
	 */
	public void 일정삭제서비스(int no) {
		// 1. 로그인여부제공서비스()를 실행해서 로그인되어 있지 않으면 TodoException 발생 - 로그인 후 사용가능한 서비스입니다.
		// 2. 일정번호에 해당하는 일정정보를 조회한다.
		// 3. 일정정보가 존재하지 않으면 TodoException 발생 - 일정번호에 해당하는 일정정보가 존재하지 않습니다.
		// 4. 일정정보 작성자와 로그인한 사용자가 일치하지 않으면 TodoException - 다른 사용자의 일정은 삭제할 수 없습니다.
		// 5. 일정정보의 상태를 삭제로 변경하고, 삭제일을 현재 날짜와 시간으로 설정한다.
	}

	/**
	 * 프로그램 시작하기
	 */
	public void 프로그램시작서비스() {
		// 1. UserDao 객체의 loadData()를 실행해서 사용자정보를 db에 저장시킨다.
		// 2. TodoDao 객체의 loadData()를 실행해서 Todo정보를 db에 저장시킨다.

	}

	/**
	 * 프로그램 종료하기
	 */
	public void 프로그램종료서비스() {
		// 1. UserDao 객체의 saveData()를 실행해서 db에 저장된 사용자정보를 파일로 기록하게 한다.
		userDao.saveData();
		// 2. TodoDao 객체의 saveData()를 실행해서 db에 저장된 사용자정보를 파일로 기록하게 한다.

	}
}
