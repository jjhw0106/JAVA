package oop3;

//각각의 기능이 고유할 경우의 상속 양상
public class ClassCastingApp2 {
	public static void main(String[] args) {
		Car car1 = new Car();
		Car car2 = new PoliceCar();
		Car car3 = new Panzer();

		System.out.println("### Car타입의 참조변수로 Car객체 참조하기");
		car1.drive();
		car1.stop();
//		PoliceCar car12 = (PoliceCar) car1; // 런타임오류, car1이 참조하는 객체에 PoliceCar가 없음
//		car12.patrol();
//		String car13 = (String car1) //상속 관계가 아니기 때문에 오류

		System.out.println("### Car타입의 참조변수로 PoliceCar객체 참조하기");
		car2.drive();
		car2.stop();
//		PoliceCar car22 = (Panzer) car2;
//		car22.patrol();

		System.out.println("### Car타입의 참조변수로 Panzer객체 참조하기");
		car3.drive();
		car3.stop();
		PoliceCar car32 = (PoliceCar) car3;
		car32.patrol();
		Panzer car33 = (Panzer) car3;
//		Panzer car34 = (Panzer) car2;
//		car33.fireWeapon();

	}
}
