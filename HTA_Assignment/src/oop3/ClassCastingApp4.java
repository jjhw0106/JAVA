package oop3;

public class ClassCastingApp4 {
	public static void main(String[] args) {
		Car car1 = new Car();
		FireTruck car2 = new FireTruck();
		PoliceCar car3 = new PoliceCar();
		Panzer car4 = new Panzer();

		System.out.println("### drive/stop 기능 테스트 하기");
		testDriveAndStop(car1);
		testDriveAndStop(car2);
		testDriveAndStop(car3);
		testDriveAndStop(car4);

		System.out.println("### 순찰기능 테스트하기");
		testPatrol(car3);
		testPatrol(car4);

		System.out.println("무기성능 테스트");
		testFireWeapon(car4);
	}

	// 차량의 운전, 정지 기능을 테스트하는 메소드
	public static void testDriveAndStop(Car car) { // 변수타입 넷 다 Ok
		car.drive();
		car.stop();
	}

	// 순찰기능을 테스트하는 메소드
	public static void testPatrol(PoliceCar car) { // 변수타입 policeCar, Panzer Ok
		car.patrol();
	}

	public static void testFireWeapon(Panzer car) {
		// 무기발사기능을 테스트하는 메소드
		car.fireWeapon();
	}
}
	