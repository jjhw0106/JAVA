package atm_v3;

public class Account {

	private String accountNumber;
	private String memberCode;

	public Account(String accountNumber, String memberCode) {
		this.accountNumber = accountNumber;
		this.memberCode = memberCode;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public String getMemberCode() {
		return memberCode;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode;
	}

}
