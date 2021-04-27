package interface_study;

public class Customer implements Buy, Sell {

	@Override
	public void sell() {
		System.out.println("Customer sell");
	}

	@Override
	public void buy() {
		System.out.println("Customer Buy");
	}

	public void order() { // 인터페이스에 구현이 되어 있음으로
						// Buy, Sell중 어느 인터페이스의 메서드를 가져다 쓸지 정해줘야 한다.
		Buy.super.order(); //아니면 직접 재정의 해줘도 된다.
	}
	public void sayHello() {
		System.out.println("Hello");
	}
}
