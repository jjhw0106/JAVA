package day2;

public class BookApp2 {
	public static void main(String[] args) {
		Book book1 = new Book(100, "자바의 정석", "남궁 성", "도우출판사", 35000, false, 0.15);
		Event event1 = new Event("동영상 강의 특가", "구매고객에게 저자의 동영상 강의를 제공합니다", "4월 1일", "4월 15일", false);
		Gift gift1 = new Gift("책받침", 500);
		
		//book1이 참조하는 Book 객체의 event 멤버변수에 event1이 참조하는 Event 객체의 주소값을 전달함.
		book1.setEvent(event1);
		//book1이 참조하는 Book 객체의 gift 멤버변수에 gift1이 참조하는 Gif객체의 주소값을 전달함.
		book1.setGift(gift1);
	}
}
