package day3.abstraction;

public class Reporter {

	//Chart 추상클래스를 구현한 다양한 차트객체를 참조할 참조변수
	private Chart chart;

	//Chart 추상클래스를 구현한 다양한 차트객체의 주소값을 전달받는 setter메소드
	public void setChart(Chart chart) {
		this.chart = chart;
	}

	public void createReport() {
		System.out.println(chart.getTitle());

		//다형성의 발현
		//chart 참조변수가 참조하는 객체에서 최종적으로 재정의한 draw메소드 실행
		chart.draw();
		
	}
}
