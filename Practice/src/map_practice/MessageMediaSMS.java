package map_practice;

public class MessageMediaSMS implements MessageMedia {
	@Override
	public void sendMessage(String from, String to, String title, String content) {
		System.out.println("SMS");
		System.out.println("보내는 사람 : " + from);
		System.out.println("받는 사람 : " + to);
		System.out.println("내용");
		System.out.println(content);
	}
}
