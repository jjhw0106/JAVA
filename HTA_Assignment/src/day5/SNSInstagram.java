package day5;

public class SNSInstagram implements SNS {
	@Override
	public void post(String title, String writer, String content) {
		System.out.println("================================");
		System.out.println("게시글을 포스팅 합니다");
		System.out.println("제목 : " + title);
		System.out.println("글쓴이 : " + writer);
		System.out.println("내용 : " + content);
		System.out.println("================================");
	}
}
