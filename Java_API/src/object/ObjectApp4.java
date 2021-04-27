package object;

public class ObjectApp4 {
	public static void main(String[] args) {

		Person p1 = new Person(10, "홍길동", "hong@gmail.com");
		Person p2 = new Person(20, "홍길동", "hong@gmail.com");

		// p1참조변수의 주소값과 p2참조변수의 주소값이 같은지 비교
		System.out.println(p1.hashCode() == p2.hashCode());
		// boolean equals(Object obj)로 p1과 p2가 참조하는 객체가 같은 객체인지 비교
		System.out.println(p1.equals(p2));
		System.out.println(p1.getName().equals(p2.getName()));

	}
}
