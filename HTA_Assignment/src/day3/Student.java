package day3;

public class Student extends Person {

	private int grade;
	private String dept;

	public Student() {
	}

	public Student(String name, int grade, String dept) {
		//
		super(name);// 부모가 setter를 제공하지 않을 때 상속 받아서 초기화를 하려면
					// 부모클래스에 생성자가 케이스 별로 생성되어 있어야 한다.
					// this.name=name; 도 가능하고 name이 private일 경우 setter를 쓰면 되지만,
					// setter를 제공하지 않는 클래스가 있을 수도 있다.
		//
		this.grade = grade;
		this.dept = dept;
	}

	public Student(String name, String email, String tel, String dept, int grade) {
		super(name, email, tel);
		this.grade = grade;
		this.dept = dept;
	}

	public int getGrade() {
		return grade;
	}

	public String getDept() {
		return dept;
	}

	@Override
	public void displayInfo() {
		super.displayInfo();
		System.out.println("학과: " + dept);
		System.out.println("학년: " + grade);
	}
}
