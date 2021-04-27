package oop3;

public class Panzer extends PoliceCar {

	String weapon;

	public void fireWeapon() {
		System.out.println("무기를 쏩니다.");
	}

	public String getWeapon() {
		return weapon;
	}

	public void setWeapon(String weapon) {
		this.weapon = weapon;
	}

}
