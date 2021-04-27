package day1;

public class Student {
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int total;
	private int average;

	public Student() {
	}

	public Student(String name, int kor, int eng, int math) {
		
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.total = kor + eng + math;
		this.average = this.total / 3;
	}

	public String getName() {
		return name;
	}

	public int getKor() {
		return kor;
	}

	public int getEng() {
		return eng;
	}

	public int getMath() {
		return math;
	}

	public int getTotal() {
		return total;
	}

	public int getAverage() {
		return average;
	}

}
