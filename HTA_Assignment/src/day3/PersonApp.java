package day3;

public class PersonApp {
	public static void main(String[] args) {
		Professor professor = new Professor("�赵��", "kd@gmail.com", "010-2222-3333", "��ǻ�Ͱ��а�", "����");
		Student student = new Student("ȫ�浿", "hong@gmail.com", "010-1111-2222", "��ǻ�Ͱ��а�", 3);

		System.out.println("======����======");
		professor.displayInfo();
		System.out.println("======�л�======");
		student.displayInfo();

	}

}
