         package day4;

public class UserManager {

	// 사용자정보 등록/ 삭제/ 변경/ 조회 기능을 제공하는 객체에 대한 표준(인터페이스)사용
	private UserRepository repo; // =>인터페이스 UserRepository에 의존한다(사용한다)

	public void setRepo(UserRepository repo) {
		this.repo = repo;
	}

	public UserManager() {
	}

	public UserManager(UserRepository repo) {
		this.repo = repo;
	}

	public void addNewUser(String id, String name) {
		User savedUser = repo.getUserById(id);
		if (savedUser != null) {
			System.out.println("동일한 아이디로 가입한 사용자가 존재합니다");
			return; // 반복문이 아니기에 break가 아님
		}
		User user = new User(id, name);
		repo.saveUser(user);
	}

	public void modifyUserInfo(User user) {
		User savedUser = repo.getUserById(user.getId());
		if (savedUser == null) {
			System.out.println("지정된 아이디의 사용자가 존재하지 않습니다");
			return;
		}
		repo.updateUser(user);
		System.out.println("###[" + user.getId() + "] 아이디의 사용자 정보가 변경되었습니다");
	}

	public void deleteUser(String id) {
		User savedUser = repo.getUserById(id);
		if (savedUser == null) {
			System.out.println("지정된 아이디의 사용자가 존재하지 않습니다");
			return;
		}
		repo.removeUser(id);
	}

	public User findUser(String id) {
		User savedUser = repo.getUserById(id);
		return savedUser;
	}

}
