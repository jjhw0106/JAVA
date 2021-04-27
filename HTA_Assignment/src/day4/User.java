package day4;

public class User {
	String name;
	String id;
	String tel;

	public User(String id2, String name2) {
		this.id = id2;
		this.name = name2;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getTel() {
		return tel;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
//	@Override
//	public User getUserById(String id) {
//		return null;
//	}
//
//	@Override
//	public void removeUser(String id) {
//
//	}
//
//	@Override
//	public void saveUser(User user) {
//
//	}
//
//	@Override
//	public void updateUser(User user) {
//
//	}
}
