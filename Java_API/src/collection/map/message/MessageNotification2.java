package collection.map.message;

import java.util.HashMap;

public class MessageNotification2 {
	HashMap<String, MessageSender> messageSenders = new HashMap<String, MessageSender>();

	public MessageNotification2() {
		messageSenders.put("sms", new SmsMessageSender());
		messageSenders.put("katalk", new KakaoTalkMessageSender());
		messageSenders.put("mail", new EmailMessageSender());
	}

	public void notice(Customer customer, String from, String title, String content) {
		String[] messageTypes = customer.getMessages();
		for (String messageType : messageTypes) {
			MessageSender sender = messageSenders.get(messageType);
			sender.sendMessage(from, customer.getName(), title, content);
		}
	}
}
