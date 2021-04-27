package day3.template;

public abstract class AbstractBanking {
	private void before() {
		System.out.println("��ó���۾� �ǽ�");
	}

	private void after() {
		System.out.println("��ó�� �۾� �� ���α׷� ����");
	}

	public abstract void job();

	void process() {
		before();
		job();
		after();

	}

}
