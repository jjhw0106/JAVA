package day4.multiple;

public interface Car {

	int MIN_SPEED = 0; // final 생략됨
	int MAX_HIGH_SPEED = 330;

	void drive();

	void stop();

	void speedUp();

	void speedDown();

}
