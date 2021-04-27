package day2;

public class BookApp3 {
	public static void main(String[] args) {
		Book[] books = new Book[3];

		Event event1 = new Event("20%할인", "4월구매도서 할인행사", "4/1", "4/31", false);
		Event event2 = new Event("신규가입 할인", "4월 두번째 가입고객 할인", "4/5", "4/1", false);

		Gift gift1 = new Gift("머그컵", 3400);

		Book book1 = new Book(100, "이것이 자바다", "신용권", "한빛미디어", 35000, false, 0.15, event1, gift1);
		Book book2 = new Book(100, "이것이 자바다", "신용권", "한빛미디어", 35000, false, 0.15, event2, new Gift("책갈피", 1000));

		// Book3가 참조하는 Book객체에 정의된 setter 메소드를 사용해서 Book객체의 event, gift 멤버변수에
		// Event객체와 Gift객체의 주소값을 메소드의 매개변수로 전달
		Book book3 = new Book(130, "스프링 인 액션", "심재철", "한빛미디어", 34000, false, 0.1);
		book3.setEvent(new Event("특가할인", "추가구매 고객대상", "4/1", "4/15", false));
		book3.setGift(new Gift("별책부록", 3000));

		books[0] = book1;
		books[1] = book2;
		books[2] = book3;

		for (Book book : books) {
			System.out.println("=============================");
			System.out.println("책 번호: " + book.getNo());
			System.out.println("책 제목: " + book.getTitle());
			System.out.println("책 저자: " + book.getWriter());
			System.out.println("책 출판사: " + book.getPublisher());
			System.out.println("책 가격: " + book.getPrice());
			System.out.println("책 할인율: " + book.getDiscountRate());
			System.out.println("책 품절여부: " + book.isSoldOut());

			System.out.println("책 이벤트 제목: " + book.getEvent().getTitle());
			System.out.println("책 이벤트 상세내용: " + book.getEvent().getDescription());
			System.out.println("책 이벤트 시작일: " + book.getEvent().getStartDate());
			System.out.println("책 이벤트 종료일: " + book.getEvent().getEndDate());

			System.out.println("책 사은품 이름: " + book.getGift().getName());
			System.out.println("책 사은품 가격: " + book.getGift().getPrice());
		}
	}
}
