package day4.multiple;

public abstract class AbstractCar implements Car {

	private int currentSpeed;

	public int getCurrentSpeed() {
		return currentSpeed;
	}

	public void setCurrentSpeed(int currentSpeed) {
		this.currentSpeed = currentSpeed;
	}

	@Override
	public void drive() {
		System.out.println("차량을 운전합니다");
	}

	@Override
	public void stop() {
		System.out.println("차량을 멈춥니다");
	}
}
