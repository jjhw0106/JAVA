package oop2;

public class FeaturePhone extends Phone {

	private int pixel;

	public void takePicture() {
		System.out.println("[" + pixel + "]화소의 화질로 사진을 찍습니다.");
	}

	public int getPixel() {
		return pixel;
	}

	public void setPixel(int pixel) {
		this.pixel = pixel;
	}

}
