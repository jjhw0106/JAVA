package oop3;

public class ClassCastingApp3 {
	public static void main(String[] args) {
		Car[] carList = new Car[5];
		carList[0] = new Car();
		carList[1] = new Panzer();
		carList[2] = new FireTruck();
		carList[3] = new PoliceCar();
		carList[4] = new Panzer();

		// 꺼냈는데 car일 경우 드라이브만,
		// 장갑차면 무기쏘기
		// 경찰차면 순찰

		for (Car car : carList) {
			System.out.println("### car참조변수가 참조하는 객체 주요기능 확인");
			car.drive();
			car.stop();

			if (car instanceof FireTruck) {
				FireTruck x = (FireTruck) car;
				x.suppressFire(); 
			}
			if (car instanceof PoliceCar) {
				PoliceCar x = (PoliceCar) car;
				x.patrol();
			}
			if (car instanceof Panzer) {
				Panzer x = (Panzer) car;
				x.fireWeapon();
			}

//			System.out.println(car instanceof Car);
//			System.out.println(car instanceof FireTruck);
//			System.out.println(car instanceof PoliceCar);
//			System.out.println(car instanceof Panzer);
//			System.out.println("==========");
		}
	}
}
