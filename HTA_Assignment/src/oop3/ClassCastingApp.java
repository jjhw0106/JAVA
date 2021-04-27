package oop3;

public class ClassCastingApp {
	public static void main(String[] args) {
		Panzer car1 = new Panzer();
		PoliceCar car2 = new Panzer();
		Car car3 = new Panzer();

		System.out.println("### Panzer 타입의 참조변수로 Panzer객체 참조하기");
		car1.setWeapon("기관총");
		car1.fireWeapon();
		car1.patrol();
		car1.setColor("파랑색");
		car1.drive();
		car1.stop();

		System.out.println("### PoliceCar 타입의 참조변수로 Panzer객체 참조하기");
		System.out.println("### ");
	}
}
