package day4.markup;

public class SecretAccount extends Account implements UnCopiable {

	private int secretKey;

	public SecretAccount() {

	}

	public SecretAccount(String name, long balance, int password, int secretKey) {
		super(name, balance, password);
		this.secretKey = secretKey;
	}

	public int getSecretKey() {
		return secretKey;
	}

	public void setSecretKey(int secretKey) {
		this.secretKey = secretKey;
	}
}
