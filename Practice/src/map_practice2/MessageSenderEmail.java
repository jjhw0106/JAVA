package map_practice2;

public class MessageSenderEmail implements MessageSender {
	@Override
	public void sendMessage(String from, String to, String title, String content) {
		System.out.println("Email 발송");
		System.out.println("제목: " + title);
		System.out.println("보내는 사람: " + from);
		System.out.println("받는 사람: " + to);
		System.out.println("내용: " + content);
	}
}
