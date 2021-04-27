package map_practice2;

import java.util.HashMap;

public class Notification {

	HashMap<String, MessageSender> mapMessenger = new HashMap<String, MessageSender>();

	public Notification() {
		mapMessenger.put("kakao", new MessageSenderKakao());
		mapMessenger.put("sms", new MessageSenderSMS());
		mapMessenger.put("mail", new MessageSenderEmail());
	}

	public void notice(Customer customer, String to, String title, String content) {
		String messageType[] = customer.getMessanger();
		for (String type : messageType) {
			MessageSender sender = mapMessenger.get(type);
		}
	}
}
