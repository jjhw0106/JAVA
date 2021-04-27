package day4.multiple;

import oop3.Car;

public class Morning extends AbstractCar implements AirBag, AirConditioner {

	// 운행
	@Override
	public void speedUp() {
		int currentSpeed = getCurrentSpeed();
		currentSpeed += 3;
		if (currentSpeed >= MAX_HIGH_SPEED) {
			currentSpeed = MAX_HIGH_SPEED;
		}
		setCurrentSpeed(currentSpeed);
	}

	@Override
	public void speedDown() {
		int currentSpeed = getCurrentSpeed();
		currentSpeed -= 3;
		if (currentSpeed <= MIN_SPEED) {
			currentSpeed = 0;
		}
		setCurrentSpeed(currentSpeed);
	}

	// 에어백
	@Override
	public void expansion() {

	}

	// 에어컨
	@Override
	public void tempDown() {

	}

	@Override
	public void tempUp() {

	}
}
