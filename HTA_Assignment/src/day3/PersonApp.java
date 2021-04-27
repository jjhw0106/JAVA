package day3;

public class PersonApp {
	public static void main(String[] args) {
		Professor professor = new Professor("김도년", "kd@gmail.com", "010-2222-3333", "컴퓨터공학과", "교수");
		Student student = new Student("홍길동", "hong@gmail.com", "010-1111-2222", "컴퓨터공학과", 3);

		System.out.println("======교수======");
		professor.displayInfo();
		System.out.println("======학생======");
		student.displayInfo();

	}

}
