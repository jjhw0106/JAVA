package object_study;

class Book implements Cloneable {//clone()메서드를 쓰기 위해 인터페이스 상속
	String title;
	String author;

	public Book(String title, String author) {
		this.title = title;
		this.author = author;
	}

	// toString 오버라이딩하기
	@Override
	public String toString() {
//		return super.toString();//원형
		return author + "," + title;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

}

public class ToStringTest /*extends Object*/ {
	public static void main(String[] args) throws CloneNotSupportedException {

		Book book = new Book("토지", "박경리");
		System.out.println(book);// 주소가 출력됨
		Book book2 = (Book) book.clone();
		System.out.println(book2);
		
		String str = new String("토지");
		System.out.println(str/*.toString()*/); // 문자열이 출력됨, str.toString()이 출력되는것

	}
}
