package sample6;

public class Registration {
	private int courseNo;
	private int studentNo;

	public Registration() {
	}

	public Registration(int courseNo, int studentNo) {
		super();
		this.courseNo = courseNo;
		this.studentNo = studentNo;
	}

	public int getCourseNo() {
		return courseNo;
	}

	public void setCourseNo(int courseNo) {
		this.courseNo = courseNo;
	}

	public int getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(int studentNo) {
		this.studentNo = studentNo;
	}

}
