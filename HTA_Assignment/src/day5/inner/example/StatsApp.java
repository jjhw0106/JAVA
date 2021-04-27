package day5.inner.example;

public class StatsApp {
	public static void main(String[] args) {
		StudentRepo repo1 = new StudentRepo();
		GameRepo repo2 = new GameRepo();

		// 학생 성적에 대한 총점, 평균을 제공하는 Stats 구현객체 얻기
		Stats stats1 = repo1.getStats();
		System.out.println(stats1.total());
		System.out.println(stats1.average());

		// 게임 기록에 대한 승리횟수, 승률을 제공하는 Stats 구현객체 얻기
		Stats stats2 = repo2.getStats();
		System.out.println(stats2.total());
		System.out.println(stats2.average() + "%");

	}
}
