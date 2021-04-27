package day4.multiple;

public class Sonata extends AbstractCar {

	AirBag a = new AirBagIMPL(); // 에어백 구현체가 조립
	AirConditioner b = new AirconditionerIMPL();

	Navigation c; // 네비게이션 구현체가 조립
	BackCamera d; // 후방카메라 구현체가 조립

	@Override
	public void speedUp() {
		// TODO Auto-generated method stub

	}

	@Override
	public void speedDown() {
		// TODO Auto-generated method stub

	}

}
