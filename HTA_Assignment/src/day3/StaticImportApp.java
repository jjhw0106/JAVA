package day3;

import static java.lang.Math.*;

public class StaticImportApp {
	public static void main(String[] args) {
//		double value1 = Math.random();
//		double value2 = Math.random();
//		long value3 = Math.round(12.34);
//		double value4 = Math.floor(1.6);

		// static으로 임포트하면 위처럼 안해도 된다.
		System.out.println("임의의 수 : " + random());
		System.out.println("반올림된 값(3.2): " + round(3.2));
		System.out.println("반올림된 값(3.7): " + round(3.7));
		System.out.println("바닥값 "+ floor(3.9));
		System.out.println("천장값 "+ ceil(3.1));
	}
}
