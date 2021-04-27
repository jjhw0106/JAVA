package atm_v2;

public class User {

	Account[] accounts = new Account[3];

	private String name;
	private String id;
	private String pw;

	public User(String id, String pw, String name) {
		this.id = id;
		this.pw = pw;
		this.name = name;
	}

	int cnt = 0;

	int accountCnt() {
		cnt = 0;
		for (int i = 0; i < accounts.length; i++) {
			if (accounts[i] != null) {
				cnt++;
			}
		}
		return cnt;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

//	public int[] getAccounts(int i) {
//		return accounts[i];
//	}
//
//	public void setAccounts(int[] accounts, int cnt) {
//		this.accounts[cnt] = accounts;
//	}

}
