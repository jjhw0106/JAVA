package object;

public class ObjectApp2 {
	public static void main(String[] args) {
		Person p1 = new Person(10, "홍길동", "hong@gmail.com");
		Person p2 = new Person(20, "김유신", "kim@gmail.com");

		// String toString
		// 객체에 대한 간단한 문자열을 반환한다
		System.out.println(p1); //실제 주소값이 아닌 toString의 반환값이다
		System.out.println(p2);
		System.out.println(p1.toString());
		System.out.println(p2.toString());
	}
}
