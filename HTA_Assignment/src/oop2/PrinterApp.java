package oop2;

public class PrinterApp {
	public static void main(String[] args) {
		Printer p1 = new Printer();
		p1.print();
		p1.refill();

		System.out.println("================");
		ColorPrinter p2 = new ColorPrinter();
		p2.print();
		p2.refill();
		System.out.println("================");
		LaserPrinter p3 = new LaserPrinter();
		p3.print();
		p3.refill();
		System.out.println("================");
		LaserPrinter p4 = new LaserColorPrinter();
		p4.print();
		p4.refill();

		System.out.println("================");
		Printer p5 = new LaserPrinter();
//		p5.outside(); => 에러, Printer 객체의 밖의 메소드이므로 사용 불가
		LaserPrinter p6 = (LaserPrinter) p5;
		p6.print();

	}
}
