package day5;

public class MessengerKakao implements Messenger {
	@Override
	public void send(String from, String to, String text) {
		System.out.println("================================");
		System.out.println("카톡을 보냅니다");
		System.out.println("보내는 사람: " + from);
		System.out.println("받는 사람" + to);
		System.out.println("내용: " + text);
		System.out.println("================================");
	}

}
