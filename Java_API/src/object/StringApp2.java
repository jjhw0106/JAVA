package object;

public class StringApp2 {
	public static void main(String[] args) {
		String str1 = "my String";
//	int length()
//	문자열의 길이 반환
		System.out.println(str1.length());

//	boolean isEmpty();
//	빈문자열("")인지 여부를 반환
		System.out.println(str1.isEmpty());

//	boolean contains(CharSequence s)
//	지정된 문자열을 포함하고 있는가?
		System.out.println(str1.contains("my"));
	}
}
