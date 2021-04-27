package map_practice2;

public class Customer {
	private String name;
	private String[] messenger;
	
	public Customer() {}
	public Customer(String name, String messanger[]) {
		this.name = name;
		this.messenger = messanger;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String[] getMessanger() {
		return messenger;
	}
	public void setMessanger(String[] messanger) {
		this.messenger = messanger;
	}
	
	
	
}
