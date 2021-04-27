package day2.game;

public class Unit {
	private String name;
	private int life;

	public Unit() {
	}

	public void attack() {
		System.out.println("공격/상대 HP 1감소");
	}

	public void deffend() {
		System.out.println("방어/상대 공격력 -1의 피해");
	}

	public void move() {
		System.out.println("이동");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}
}
