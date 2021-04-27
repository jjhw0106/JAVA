package inheritance;

public class OverridingTest {
	public static void main(String[] args) {
		Customer customerLee = new Customer(10010, "이순신");
		customerLee.bonusPoint = 10000;

		VIPCustomer customerKim = new VIPCustomer(10020, "김유신");
		customerKim.bonusPoint = 10000;

		Customer customerPark = new VIPCustomer(10030, "박범계");
		customerPark.bonusPoint = 10000;

		int priceLee = customerLee.calcPrice(10000);
		int priceKim = customerKim.calcPrice(10000);
		int pricePark = customerPark.calcPrice(10000);
		System.out.println(customerLee.showCustomerInfo() + "지불금액은 " + priceLee);
		System.out.println(customerKim.showCustomerInfo() + "지불금액은 " + priceKim);
		System.out.println(customerPark.showCustomerInfo() + "지불금액은 " + pricePark);// 인스턴스의 타입인 VIPC와 같다.
																//주의점. 자동완성에는 customer의 메서드라고 나오지만 실제론 인스턴스의 메서드임.
	}
}
