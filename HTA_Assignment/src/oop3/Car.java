package oop3;

public class Car {
	String color;
	String size;

	public void drive() {
		System.out.println("차가 움직입니다.");
	}

	public void stop() {
		System.out.println("차가 정지합니다");

	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}
	
}
