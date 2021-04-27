package day4;

public class UserManagerApp {
	public static void main(String[] args) {
		// UserRepository의 구현객체 생성하기
		UserArrayRepository arrayRepo = new UserArrayRepository();

		// UserManager객체 생성
		UserManager userManager = new UserManager();
		// setter 이용해서 UserRepository구현 객체를 UserManager의 repo변수에 전달
		userManager.setRepo(arrayRepo);

		// 조회
		System.out.println("###아이디로 사용자 조회하기");
		User user1 = userManager.findUser("hong");
		if (user1 != null) {
			System.out.println(user1.getId() + ", " + user1.getName());
		} else {
			System.out.println("사용자가 존재하지 않습니다");
		}

		// 등록
		System.out.println("신규사용자 등록");
		userManager.addNewUser("Park", "박혁거세");

		System.out.println("아이디로 사용자 조회하기");
		User user2 = userManager.findUser("Park");
		if (user2 != null) {
			System.out.println(user2.getId() + ", " + user2.getName());
		} else {
			System.out.println("사용자가 존재하지 않습니다");
		}

		// 업데이트

		// 삭제

		// setter 메소드를 이용해서 UserRepository구현객체를 UserManager의 repo변수에 전달하기
		userManager.setRepo(null);

		// UserManager객체 생성, 생성자 메소드를 이용해서 UserRepository구현객체를 UserManager의
		// repo 변수에 전달하기
//		UserManager userManager2 = new UserManager(null);
	}
}
