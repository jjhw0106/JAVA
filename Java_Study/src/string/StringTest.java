package string;

public class StringTest {
	public static void main(String[] args) {

		String str1 = new String("abc");
		String str2 = new String("abc");
		System.out.println(str1 == str2);// 각기 다른 객체이기 때문에 다른 주소다(heap)
		
		String str3 = "abc";
		String str4 = "abc";
		System.out.println(str3 == str4);// 상수풀에서 가져오기 때문에 주소가 같다
	}
}
