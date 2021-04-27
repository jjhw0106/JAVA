package map_practice;

import java.util.HashMap;

public class Notification {
	HashMap<String, MessageMedia> messageMedia = new HashMap<String, MessageMedia>();

	public Notification() {
		messageMedia.put("kakao", new MessageMediaKakaoTalk());
		messageMedia.put("sms", new MessageMediaSMS());
		messageMedia.put("mail", new MessageMediaEMail());
	}

	public void notice(Customer customer, String from, String title, String content) {
		String[] messageTypes = customer.getMessages();
		for (String messageType : messageTypes) {
			MessageMedia media = messageMedia.get(messageType);
			media.sendMessage(from, customer.getName(), title, content);
		}
	}
}
