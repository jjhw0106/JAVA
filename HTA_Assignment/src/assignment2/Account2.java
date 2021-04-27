package assignment2;

import java.util.Scanner;

public class Account2 {

	Scanner sc = new Scanner(System.in);

	private String depositor;
	private String pw;
	private long balance;

	public void showAccount() {
		System.out.println("예금주" + this.depositor);
		System.out.println("잔액" + this.balance);
	}

	public void deposit(long amount) {
		this.balance += amount;
	}

	public void withdraw(long amount, String password) {
		if (this.pw.equals(password)) {
			this.balance -= amount;
		} else {
			System.out.println("비밀번호가 틀렸습니다.");
		}
	}

	public void displayInfo() {
		System.out.println("예금주: " + this.depositor);
		System.out.println("잔액정보: " + this.balance);
	}

	public String getDepositor() {
		return depositor;
	}

	public void setDepositor(String depositor) {
		this.depositor = depositor;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public long getBalance() {
		return balance;
	}

	public void setBalance(long balance) {
		this.balance = balance;
	}

}
 