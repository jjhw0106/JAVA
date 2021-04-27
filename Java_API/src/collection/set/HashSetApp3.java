package collection.set;

import java.util.HashSet;

public class HashSetApp3 {
	public static void main(String[] args) {
		HashSet<Contact> contacts = new HashSet<Contact>();

		// Integer, String, Double 등등은 값이 같으면 같은 해시코드를 갖도록 hashCode, equals가 재정의 되어 있어서
		// 알아서 합쳐주나, 그 외 임의의 객체들은 각기 다른 객체이기 때문에 합쳐치지 않는다.
		// -> hashCode, equals 재정의 해주어야 한다.
		contacts.add(new Contact("홍길동", "010-1111-1111", "hong@gmail.com"));
		contacts.add(new Contact("홍길동", "010-1234-1111", "hong@gmail.com"));
		contacts.add(new Contact("홍길동", "010-1111-1111", "hong@gmail.com"));

		for (Contact contact : contacts) {
			System.out.println(contact);
		}
		
		
	}
}
