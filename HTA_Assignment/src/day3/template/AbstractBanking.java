package day3.template;

public abstract class AbstractBanking {
	private void before() {
		System.out.println("전처리작업 실시");
	}

	private void after() {
		System.out.println("후처리 작업 및 프로그램 종료");
	}

	public abstract void job();

	void process() {
		before();
		job();
		after();

	}

}
