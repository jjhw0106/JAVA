package inheritance;

public class CustomerTest {
	public static void main(String[] args) {
		Customer ncust= new Customer(10010,"이순신");
//		VIPCustomer vcust= new VIPCustomer();
		Customer vcust= new VIPCustomer(10020,"김유신");//묵시적 형변환, 
										  //가리킬 수 있는 범위는 Customer에 한정된다.
										  //그러나, 메모리는 VIPCustomer만큼 할당된
//		ncust.customerName = "이순신";
//		ncust.customerID = 10010;
		ncust.bonusPoint = 1000;
		
//		vcust.customerName = "김유신";
//		vcust.customerID = 10020;
		vcust.bonusPoint = 10000;
		
		System.out.println(ncust.showCustomerInfo());
		System.out.println(vcust.showCustomerInfo());

		
	}
}
