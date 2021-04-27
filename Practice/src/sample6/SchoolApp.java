package sample6;

import java.util.Scanner;

public class SchoolApp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SchoolRepo repo = new SchoolRepo();

		while (true) {
			System.out.println("=========================================");
			System.out.println("1.학생등록");
			System.out.println("2.전체학생 조회 ");
			System.out.println("3.과정등록 ");
			System.out.println("4.과정조회 ");
			System.out.println("5.과정신청 ");
			System.out.println("6.과정취소 ");
			System.out.println("7.신청과정조회");
			System.out.println("=========================================");
			System.out.print("메뉴 선택: ");
			int sel = sc.nextInt();
			if (sel == 1) {
				System.out.println("학생등록");
				// Q. 학번만 다시 입력하고 싶을 때
				System.out.print("학번: ");
				int no = sc.nextInt();
				System.out.print("이름: ");
				String name = sc.next();
				System.out.print("전공: ");
				String major = sc.next();
				System.out.print("학년: ");
				int grade = sc.nextInt();
				repo.addStudent(new Student(no, name, major, grade));
			} else if (sel == 2) {
				System.out.println("전체학생 조회");
				repo.displayAllStudent();
			}

			else if (sel == 3) {
				System.out.println("과목등록");
				System.out.print("과목번호");
				int no = sc.nextInt();
				System.out.println("과목명");
				String name = sc.next();
				System.out.println("과목 정원");
				int quota = sc.nextInt();
				repo.addCourse(new Course(no, name, quota));
			} else if (sel == 4) {
				System.out.println("전체과목 조회");
				repo.displayAllCourse();
			} else if (sel == 5) {
				System.out.print("과목 신청할 학생의 학번: ");
				int studentNo = sc.nextInt();
				System.out.print("신청과목 번호: ");
				int courseNo = sc.nextInt();
				repo.addRegistration(courseNo, studentNo);

			} else if (sel == 6) {
				System.out.println("수강철회");
				System.out.print("학번: ");
				int studentNo = sc.nextInt();
				System.out.print("철회할 과목번호");
				int courseNo = sc.nextInt();
				repo.cancelRegistration(studentNo, courseNo);

			} else if (sel == 7) {
				System.out.println("신청과목을 조회할 학생의 학번: ");
				int studentNo = sc.nextInt();
				repo.displayRegistration(studentNo);
			} else if (sel == 0) {
			}
//			System.err.println();
//			System.out.println();
//			System.out.println();
		}
	}
}
