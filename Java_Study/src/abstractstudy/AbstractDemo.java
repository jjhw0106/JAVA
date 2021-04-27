package abstractstudy;

abstract class A {
	public abstract int b(); //abstract 키워드가 포함되어 있으면, 구체적 구현 못함.
							//추상메서드를 하나라도 갖고 있으면 클래스는 abstract가 된다.
							//abstract를 쓰는이유: 공통적으로 사용되는 부분은 구현을 해놓으나,
							//그때그떄 사용자의 구현을 필요로하는 부분이 있을 경우, 이 부분을 abstract로 선언하여
							//사용자의 구현을 강요한다.
							//상속받은 부분에서도 반복되는 부분은 상위 클래스에 구현 해놓음으로 반복을 최소화 할것
//->template pattern
	public void d() {
		System.out.println("world");
	}
}

class B extends A { //반드시 추상 클래스 속의 추상 메서드의 구체적 로직을 구현해 놓아야 한다.

	@Override
	public int b() {
		System.out.println("abstract b()는 반드시 상속을 받아야 한다.");//-> 상속을 강제함
		return 0;
	}

}

public class AbstractDemo {
	public static void main(String[] args) {
		B obj = new B();
	}
}
