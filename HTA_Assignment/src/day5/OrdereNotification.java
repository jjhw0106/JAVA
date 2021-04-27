package day5;

public class OrdereNotification { // 주문내역 : => sns에 올리지 않고 메일과 메신저로 보낸다
	private Mail mail;
	private Messenger messenger;

	public void setMail(Mail mail) {
		this.mail = mail;
	}

	public void setMessenger(Messenger messenger) {
		this.messenger = messenger;
	}

	public void noticeOrderInfo(String from, String to, String title, String content) {
		mail.sendMail(from, to, title, content);
		messenger.send(from, to, content);

	}
}
