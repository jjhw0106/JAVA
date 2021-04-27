package oop2;

public class LaserPrinter extends Printer {
	@Override
	public void print() {
		System.out.println("레이저로 흑백 출력");
	}
	
	@Override
	public void refill() {
		System.out.println("토너 교체");
	}
	
	public void outside() {
		System.out.println("??");
	}
}
