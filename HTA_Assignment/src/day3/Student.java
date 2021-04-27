package day3;

public class Student extends Person {

	private int grade;
	private String dept;

	public Student() {
	}

	public Student(String name, int grade, String dept) {
		//
		super(name);// �θ� setter�� �������� ���� �� ��� �޾Ƽ� �ʱ�ȭ�� �Ϸ���
					// �θ�Ŭ������ �����ڰ� ���̽� ���� �����Ǿ� �־�� �Ѵ�.
					// this.name=name; �� �����ϰ� name�� private�� ��� setter�� ���� ������,
					// setter�� �������� �ʴ� Ŭ������ ���� ���� �ִ�.
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
		System.out.println("�а�: " + dept);
		System.out.println("�г�: " + grade);
	}
}
