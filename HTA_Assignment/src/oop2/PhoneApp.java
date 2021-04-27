package oop2;

public class PhoneApp {

	public static void main(String[] args) {
//		Phone galaxy21 = new SmartPhone();
		Phone phone = new Phone();
		phone.setTel("010-1111-2222");
		phone.call();

		FeaturePhone featurePhone = new FeaturePhone();
		featurePhone.setTel("010-3333-3333");
		featurePhone.setPixel(7000000);
		featurePhone.call();
		featurePhone.takePicture();

		SmartPhone smartPhone = new SmartPhone();
		smartPhone.setTel("010-6666-6668");
		smartPhone.call();
	}

}
