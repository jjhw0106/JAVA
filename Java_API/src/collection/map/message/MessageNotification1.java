package collection.map.message;

public class MessageNotification1 {
	private KakaoTalkMessageSender katalk = new KakaoTalkMessageSender();
	private EmailMessageSender email = new EmailMessageSender();
	private SmsMessageSender sms = new SmsMessageSender();

	public void notice(Customer customer, String from, String title, String content) {
		String[] messageTypes = customer.getMessages();

		// map 없이 구현 => 메신저 추가 되면 if문이 늘어남
		for (String messageType : messageTypes) {
			if ("sms".equals(messageType)) {
				sms.sendMessage(from, customer.getName(), title, content);
			} else if ("katalk".equals(messageType)) {
				katalk.sendMessage(from, customer.getName(), title, content);
			} else if ("mail".equals(messageType)) {
				email.sendMessage(from, customer.getName(), title, content);
			}
		}
	}
}
