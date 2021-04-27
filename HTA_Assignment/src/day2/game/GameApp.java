package day2.game;

public class GameApp {
	public static void main(String[] args) {
		Marine unit1 = new Marine();
		Firebat unit2 = new Firebat();
		Ghost unit3 = new Ghost();
		BattleCruiser unit4 = new BattleCruiser();

		System.out.println("### Marine객체의 공격");
		unit1.attack();
		unit1.move();

		System.out.println("### Firebat객체의 공격");
		unit2.attack();
		unit2.move();

		System.out.println("### Ghost객체의 공격");
		Unit unit5 = new Ghost();
		unit5.attack();
		unit5.move();
		((Ghost) unit5).skill();
	}
}
