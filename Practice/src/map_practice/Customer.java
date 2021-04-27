package map_practice;

public class Customer {
	private String name;
	private String[] messages;

	public Customer() {
	}

	public Customer(String name, String[] messages) {
		this.name = name;
		this.messages = messages;
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
