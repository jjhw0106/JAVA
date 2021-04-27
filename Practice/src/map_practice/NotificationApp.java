package map_practice;

public class NotificationApp {

	public static void main(String[] args) {
		Notification notification = new Notification();

		System.out.println("==================");
		notification.notice(new Customer("홍길동", new String[] { "kakao", "sms", "mail" }), "gov", "재난문자", "의왕시 코로나 환자 발생");
		System.out.println("==================");
		notification.notice(new Customer("김태촌", new String[] { "sms" }), "gov", "재난문자", "의왕시 코로나 환자 발생");
		System.out.println("==================");
		notification.notice(new Customer("정호원", new String[] { "kakao" }), "gov", "재난문자", "의왕시 코로나 환자 발생");
		System.out.println("==================");

	}
}
