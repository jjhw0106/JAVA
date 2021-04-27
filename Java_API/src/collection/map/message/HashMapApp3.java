package collection.map.message;

public class HashMapApp3 {
	public static void main(String[] args) {

		MessageNotification1 notification2 = new MessageNotification1();

		Customer c1 = new Customer("홍길동", new String[] { "sms", "mail" });
		Customer c2 = new Customer("이순신", new String[] { "katalk" });
		Customer c3 = new Customer("김유신", new String[] { "sms", "mail", "katalk" });

		System.out.println("=========메세지 발송=========");
		notification2.notice(c1, "홍보팀", "여름신상품 할인", "미리 여름 신상을 준비하세요");
		System.out.println("=========메세지 발송=========");
		notification2.notice(c2, "홍보팀", "여름신상품 할인", "미리 여름 신상을 준비하세요");
		System.out.println("=========메세지 발송=========");
		notification2.notice(c3, "홍보팀", "여름신상품 할인", "미리 여름 신상을 준비하세요");
	}
}
