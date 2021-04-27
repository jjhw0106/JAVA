package inheritance;

class Customer {
	protected int customerID;
	protected String customerName;
	protected String customerGrade;
	int bonusPoint;
	double bonusRatio;

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerGrade() {
		return customerGrade;
	}

	public void setCustomerGrade(String customerGrade) {
		this.customerGrade = customerGrade;
	}

	public Customer(int customerID, String customerName) {
		this.customerID = customerID;
		this.customerName = customerName;
		customerGrade = "SILVER";
		bonusRatio = 0.01;
	}

	public int calcPrice(int price) {
		bonusPoint += price * bonusRatio;
		return price;
	}

	public String showCustomerInfo() {
		return customerName + "님의 등급은 " + customerGrade + "이며 적립된 보너스 포인트는 " + bonusPoint + "점 입니다.";
	}
}

class VIPCustomer extends Customer {
	double salesRatio;
	protected int agentID;

	public VIPCustomer(int customerID, String customerName) {
//		super(); // 상위 클래스의 기본생성자를 참조함, 생략 시 자동 생성
		super(customerID, customerName);// 기본 생성자 제공하지 않을 경우 명시적으로 상위클래스 생성자 선언
		customerGrade = "VIP";
		bonusRatio = 0.05;
		salesRatio = 0.1;
	}

	// 오버라이딩
	@Override // 애노테이션
	public int calcPrice(int price) {
		bonusPoint += price * bonusRatio;
		return price - (int) (price * salesRatio);
	}

}
