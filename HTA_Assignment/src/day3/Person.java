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
		System.out.println("이름: " + getName());
		System.out.println("이메일: " + getEmail());
		System.out.println("번호: "+getTel());
		
	}

	public void tempMethod() {
		System.out.println("슈퍼메소드");
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
