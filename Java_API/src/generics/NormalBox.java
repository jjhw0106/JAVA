package generics;


/*
 *  제네릭이 적용되어 있지 않는 박스 설계도
 *  	1. 타입안정성이 좋지 않다.
 *  	2. 저장된 객체가 Object로 형변환 되어서 저장된다.(실제로 저장된 객체를 참조하는 것이 아니라, 
 *  	   저장된 객체의 Object 객체를 참조한다.)
 *  	3. 저장된 객체를 꺼낼때마다 실제 저장된 탕입으로 형변환해야 한다.
 */
public class NormalBox {
	private Object item;

	public Object getItem() {
		return item;
	}

	public void setItem(Object item) {
		this.item = item;
	}
}
