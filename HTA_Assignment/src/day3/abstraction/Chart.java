package day3.abstraction;

public abstract class Chart {
	// ����� ����Ӽ�
	private String title;

	// ����� ������ - �߻�޼ҵ�� ������.
	public abstract void draw();
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
