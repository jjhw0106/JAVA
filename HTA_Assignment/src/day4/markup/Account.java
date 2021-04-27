package day4.markup;

public class Account {

	private String name;
	private long balance;
	private int password;

	public Account() {

	}

	public Account(String name, long balance, int password) {
		super();
		this.balance = balance;
		this.name = name;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public long getBalance() {
		return balance;
	}

	public int getPassword() {
		return password;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBalance(long balance) {
		this.balance = balance;
	}

	public void setPassword(int password) {
		this.password = password;
	}

}
