package day5;

import com.sun.nio.sctp.Notification;

public class NotificationApp {
	public static void main(String[] args) {

		EventNotification event = new EventNotification();
		OrdereNotification order = new OrdereNotification();

		MailGoogle gmail = new MailGoogle();
		MessengerKakao kakao = new MessengerKakao();
		MessengerLine line = new MessengerLine();
		SNSInstagram insta = new SNSInstagram();
		SNSFacebook facebook = new SNSFacebook();

		// EventNotification 객체에 mail, messenger, sns구현객체의 주소값 전달
		event.setMail(gmail);
		event.setMessenger(kakao);
		event.setSns(insta);

		// ordernotification객체에 mail, messenger 전달
		order.setMail(gmail);
		order.setMessenger(line);

		event.notice("홍보팀", "우수고객", "4월 우수", "구매감사");
	}
}
