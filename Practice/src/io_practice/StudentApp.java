package io_practice;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentApp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StudentService service = new StudentService();

		while (true) {
			System.out.println("-------------------------------------------");
			System.out.println("1. 전체조회");
			System.out.println("2. 추가");
			System.out.println("3. 검색");
			System.out.println("4. 삭제");
			System.out.println("5. 석차");
			System.out.println("0. 종료");
			System.out.println("-------------------------------------------");
			System.out.print("메뉴를 선택하세요: ");
			System.out.println();
			int sel = sc.nextInt();
			try {
				if (sel == 1) {
					System.out.println("[전체 학생 정보 조회]");
					ArrayList<Student> students = service.getAllStudentList();
					if (students.isEmpty()) {
						System.out.println("[안내] 등록된 학생정보가 없습니다.");
					} else {
						System.out.println("학생명\t총점\t평균");
						for (Student student : students) {
							System.out.print(student.getName() + "\t");
							System.out.print(student.getTotal() + "\t");
							System.out.print(student.getAverage());
							System.out.println();
						}
					}
				} else if (sel == 2) {
					System.out.println("[학생정보 추가]");
					System.out.print("이름 입력 > ");
					String name = sc.next();
					System.out.print("국어점수 입력 > ");
					int kor = sc.nextInt();
					System.out.print("영어점수 입력 > ");
					int eng = sc.nextInt();
					System.out.print("수학점수 입력 > ");
					int math = sc.nextInt();

					Student student = new Student(name, kor, eng, math);
					service.addNewStudent(student);
				} else if (sel == 3) {
				} else if (sel == 4) {
				} else if (sel == 5) {
				} else if (sel == 0) {
					service.saveAllStudentsData();
					System.out.println("프로그램 종료");
					break;
				}
			} catch (Exception e) {
			}
		}
	}
}
