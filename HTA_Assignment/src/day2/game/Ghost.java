package day2.game;

public class Ghost extends Unit {
	@Override
	public void attack() {
		System.out.println("핵폭탄");
	}

	@Override
	public void move() {
		System.out.println("클로킹 기능을 이용해서 이동");
	}

	public void skill() {
		System.out.println("락다운");
	}
}
