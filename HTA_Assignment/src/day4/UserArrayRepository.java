package day4;

public class UserArrayRepository implements UserRepository {
	private User db[] = new User[100];
	private int position = 0;

	public UserArrayRepository() {
		db[position++] = new User("hong", "홍길동");
		db[position++] = new User("Kim", "김유신");
		db[position++] = new User("Lee", "이순신");

	}

	@Override
	public void saveUser(User user) {
		db[position++] = user;
	}

	@Override
	public void removeUser(String id) {
		// 구현
	}

	@Override
	public void updateUser(User user) {
		// 구현해보기
	}

	@Override
	public User getUserById(String id) {
		User user = null;

		for (User item : db) {
			if (item == null) {
				break;
			}
			if (item.getId().equals(id)) {
				user = item;
				break;
			}
		}
		return user;
	}
}
