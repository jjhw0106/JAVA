package day4.multiple;

public class AirconditionerIMPL implements AirConditioner {

	@Override
	public void tempDown() {
		System.out.println("온도 낮춘다");
	}

	@Override
	public void tempUp() {
		System.out.println("온도 높인다");

	}

}
