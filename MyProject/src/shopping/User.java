package shopping;

import java.util.ArrayList;

class User {

	private String id;
	private String pw;
	private String name;
//	ArrayList<Basket> basketList = new ArrayList<Basket>();
//	int itemCnt = basketList.size();

	public User(String id, String pw, String name) {
		this.id = id;
		this.pw = pw;
		this.name = name;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

}
