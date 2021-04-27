package oop2;

public class ColorPrinter extends Printer {

	@Override
	public void print() {
		System.out.println("컬러 출력");
	}

	@Override
	public void refill() {
		System.out.println("컬러 잉크 충전");
	}

}
