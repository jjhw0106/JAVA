package practice2;

import java.util.Scanner;

class Subject {
	String name;
	int score;
}

class Student {
	Subject[] subjects;
	String name;
}

public class ArrayController {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Student[] st = new Student[3];
		// # 학생 추가 삭제 컨트롤러
		// => 컨트롤러를 완성해 아래 3개의 정보를 추가하시오.
		// 김철수 : 과목3개 수학 50 국어50 영어 60
		// 이만수 : 과목2개 수학 20 국어 30
		// 이영희 : 과목1개 수학 100

		int count = 0; // 학생 수

		while (true) {
			for (int i = 0; i < count; i++) {
				System.out.print(st[i].name + "학생: ");
				if (st[i].subjects != null) {
					for (int j = 0; j < st[i].subjects.length; j++) {
						System.out.print(st[i].subjects[j].name + "[" + st[i].subjects[j].score + "] ");
					}
				}
				System.out.println();
			}
			System.out.println("[1]학생 추가하기"); // 이름 입력받아 추가
			System.out.println("[2]과목 추가하기"); // 이름과 과목 입력받아 추가
			System.out.println("[3]성적 추가하기"); // 이름과 과목 그리고 성적 입력받아 추가

			int choice = sc.nextInt();
			int idx = 0;

			if (choice == 1) {
				if (count >= 3) {
					System.out.println("학생 수 초과");
					continue;
				}
				st[count] = new Student();
				System.out.print("학생 이름: ");
				String name = sc.next();
				st[count].name = name;
				count++;

			} else if (choice == 2) {
				System.out.println("몇 번째 학생?");
				for (int i = 0; i < count; i++) {
					System.out.println((i + 1) + ". " + st[i].name);
				}
				int stNum = sc.nextInt() - 1;
				System.out.print("추가할 과목명: ");
				String subject = sc.next();
				if (st[stNum].subjects == null) {
					st[stNum].subjects = new Subject[1];
					st[stNum].subjects[0] = new Subject();
					st[stNum].subjects[0].name = subject;
				} else {
					int size = st[stNum].subjects.length;

					Subject temp[] = st[stNum].subjects;
					st[stNum].subjects = new Subject[size + 1];
					st[stNum].subjects[size] = new Subject();

					for (int i = 0; i < size; i++) {
						st[stNum].subjects[i] = temp[i];
					}
					st[stNum].subjects[size].name = subject;

				}
			} else if (choice == 3) {
				for (int i = 0; i < count; i++) {
					System.out.println((i + 1) + ". " + st[i].name);
				}
				System.out.println("학생선택");
				int stNum = sc.nextInt() - 1;
				for (int i = 0; i < st[stNum].subjects.length; i++) {
					System.out.println((i + 1) + ". " + st[stNum].subjects[i].name);
				}
				System.out.println("점수입력할 과목은?");
				int subjNum = sc.nextInt() - 1;
				System.out.print("점수 입력: ");
				int score = sc.nextInt();
				st[stNum].subjects[subjNum].score = score;

			}

		}
	}
}