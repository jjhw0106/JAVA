package oop2;

public class Phone {
	private String tel;


	public void call() {
		System.out.println("전화 겁니다");
	}

	public void receive() {
		System.out.println("전화 받습니다.");
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
}
