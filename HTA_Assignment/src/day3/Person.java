package day3;

public class Person {
	private String name;
	private String email;
	private String tel;

	public Person() {
	}

	public Person(String name) {
		this.name = name;
	}

	public Person(String name, String email, String tel) {
		this.name = name;
		this.email = email;
		this.tel = tel;

	}
	
	public void displayInfo() {
		System.out.println("�̸�: " + getName());
		System.out.println("�̸���: " + getEmail());
		System.out.println("��ȣ: "+getTel());
		
	}

	public void tempMethod() {
		System.out.println("���۸޼ҵ�");
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getTel() {
		return tel;
	}

}
