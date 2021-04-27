package oop2;

public class SmartPhone extends Phone {

	private String ip;
	private String emailAddress;

	public void web() {
		System.out.println("[" + ip + "] ip 주소로 인터넷을 사용합니다.");
	}

	public void mail() {
		System.out.println("[" +emailAddress+ "] 이메일 계정으로 메일을 주고받습니다.");
	}
}
