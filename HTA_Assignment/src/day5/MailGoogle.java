package day5;

public class MailGoogle implements Mail {
	@Override
	public void sendMail(String from, String to, String title, String text) {
		System.out.println("================================");
		System.out.println("구글로 메일 보냅니다");
		System.out.println("보내는곳" + from);
		System.out.println("받는 곳" + to);
		System.out.println("제목" + title);
		System.out.println("내용" + text);
		System.out.println("================================");
	}

}
