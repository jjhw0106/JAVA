package generics;

public class BoxApp {
	public static void main(String[] args) {
		// 문자열을 저장하는 NormalBox와 GenericBox 만들기

		NormalBox box1 = new NormalBox();
		GenericBox<String> box2 = new GenericBox<String>();

		box1.setItem("라라라");
		Object obj = box1.getItem();
		System.out.println("첫번째 박스의 내용 출력");
		System.out.println("메시지: "+obj);
//		System.out.println("글자수: "+obj.length()+"글자수"); //obj가 스트링이아닌 오브젝트 타입이기 때문에 위에서 따로 
															  //스트링으로 형변환 해주어야 한다.
															  //만약 별도로 형변환이 안되는 클래스를 매개변수로 전달한다해도 
															  //에러검출을 하지 못한다 -> 심각한 문제 야기

		box2.setE("일이삼");
//		box2.setE(123); 	// 제네릭으로 타입을 한정해주었기 때문에 오류가 발생함
	}
}
