package atm_v3;

public class User {
	private String id;
	private String name;
	private String pw;
	private int memberCode;

	public User() {
	}

	public User(String id, String name, String pw, int memberCode) {
		this.id = id;
		this.name = name;
		this.pw = pw;
		this.memberCode = memberCode;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public int getMemberCode() {
		return memberCode;
	}

	public void setMemberCode(int memberCode) {
		this.memberCode = memberCode;
	}

}
