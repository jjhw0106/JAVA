package day5.inner;

import day5.inner.Outer1.Inner;

public class Outer1App {
	public static void main(String[] args) {
		Outer1 outer = new Outer1();

		Inner inner = outer.getInner();
		inner.innerMethod();
	}
}
