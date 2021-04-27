package collection.map.message;

public class Customer {
	private String name;
	private String[] messages;

	public Customer() {
	}

	public Customer(String name, String[] messages) {
		this.name = name; // 고객명
		this.messages = messages; // 메시지수신동의 종류, sms, kakao, email
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String[] getMessages() {
		return messages;
	}

	public void setMessages(String[] messages) {
		this.messages = messages;
	}

}
