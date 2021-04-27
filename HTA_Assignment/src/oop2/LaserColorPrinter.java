package oop2;

public class LaserColorPrinter extends LaserPrinter {	
	// 프린터가 아닌, 레이저 프린터를 상속받은 이유 => 충전 기능이 들어갈 경우 충전제가 다를 수 있다. 
	// 이 떄 프린터를 상속받았다면, refill()까지 재정의를 해야 하지만, 레이저 프린터를 상속받아옴으로써 재정의를 줄일 수 있다.
							

	@Override
	public void print() {
		System.out.println("레이저 컬러 출력");
	}
}
