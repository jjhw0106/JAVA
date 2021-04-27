package object;

public class ObjectApp3 {
	public static void main(String[] args) {

		Person p1 = new Person(10, "홍길동", "hong@gmail.com");
		Person p2 = new Person(20, "김유신", "kim@gmail.com");
		Person p3 = new Person(10, "김유신", "kim@gmail.com");
		// int hashCode()
		// 객체의 주소값을 사용해서 고유한 값을 생성한 값
		// 서로 다른 객체는 절대로 같은 값을 가질 수 없으나,
		// 해쉬코드를 재정의하면 로직에 따라 같은 해쉬코드를 가질 수도 있다.
		System.out.println(p1.hashCode());
		System.out.println(p2.hashCode());
		System.out.println(p3.hashCode());

	}
}
