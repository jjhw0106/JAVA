package day3.abstraction;

public class ReporterApp {
	public static void main(String[] args) {
		BasicChart chart1 = new BasicChart();
		chart1.setTitle("1/4�б� ������Ȳ");
		LineChart chart2 = new LineChart();
		chart2.setTitle("2/4�б� ��������");

		Reporter reporter = new Reporter();

		// ��ü�� ����
		reporter.setChart(chart1);
		// ���� ����
		reporter.createReport();

	}
}
