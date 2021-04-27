
package lamda;

interface PrintString {
	void showString(String str);
}

public class TestLamda {
	public static void main(String[] args) {
		PrintString ps = str -> System.out.println(str);
		ps.showString("이것이 람다다");
		MyString(ps);
		PrintString test = returnString();
	}

	public static void MyString(PrintString p) {
		p.showString("이것이");
		p.showString("진정한");
		p.showString("람다다");
	}
	
	public static PrintString returnString() {
		return s->System.out.println(s + "!!!");
	}
}
