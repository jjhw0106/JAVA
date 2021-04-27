package sample5;

public class Student implements Comparable<Student> {
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
//		this.total = this.kor + this.eng + this.math;
//		this.average = total / 3;
	}

	String getName() {
		return name;
	}

	int getKor() {
		return kor;
	}

	int getEng() {
		return eng;
	}

	int getMath() {
		return math;
	}

	int getTotal() {
		return kor + eng + math;
	}

	int getAverage() {
		return getTotal() / 3;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public void setMath(int math) {
		this.math = math;
	}

	@Override
	public int compareTo(Student other) {
		return this.getTotal() - other.getTotal();
	}
}
