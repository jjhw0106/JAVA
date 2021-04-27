package day5;

public class EventNotification { // 인터페이스에 의존

	private Mail mail;
	private Messenger messenger;
	private SNS sns;

	public void setMail(Mail mail) {
		this.mail = mail;
	}

	public void setMessenger(Messenger messenger) {
		this.messenger = messenger;
	}

	public void setSns(SNS sns) {
		this.sns = sns;
	}

	public void notice(String from, String to, String title, String content) {
		mail.sendMail(from, to, title, content);
		messenger.send(to, from, content);
		sns.post(title, from, content);
	}
}
