package day3.abstraction;

public abstract class Chart {
	// 추출된 공통속성
	private String title;

	// 추출된 공통기능 - 추상메소드로 정의함.
	public abstract void draw();
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
