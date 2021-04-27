package object;

public class ObjectApp1 {
	public static void main(String[] args) {
		Person p1 = new Person(10, "홍길동", "hong@gmail.com");
		Person p2 = new Person(10, "홍길동", "hong@gmail.com");
		Person p3 = p1;
		Person p4 = p2;

		// boolean equals(Object obj) 메소드
		// 객체자신과 obj가 동일한 객체인지 여부를 반환한다.
		boolean result1 = p1.equals(p2);
		boolean result2 = p2.equals(p1);
		boolean result3 = p1.equals(p3);
		boolean result4 = p2.equals(p4);
		System.out.println("p1이 p2랑 같니?" + result1);
		System.out.println("p2이 p1랑 같니?" + result2);
		System.out.println("p1이 p3랑 같니?" + result3);
		System.out.println("p2이 p4랑 같니?" + result4);
		//>> 객체의 값이아니라 주소를 비교한다.
	}
}
