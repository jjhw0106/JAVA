package sample5;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		/*
		 * 학생성적 관리 프로그램 1. 학생 성적정보 입력기능 - 이름, 국어, 영어, 수학점수를 입력받아서 ArrayList에 저장 2. 학생
		 * 성적정보 전체 조회 기능 - ArrayList에 저장된 학생들의 이름, 총점, 평균을 출력 3. 학생 성적정보 상세 조회 기능 -
		 * 학생이름을 입력받아서 그 학생의 이름, 국어, 영어, 수학, 총점, 평균을 출력 4. 학생 성적정보 변경 기능 5. 학생 성적정보 성적순
		 * 출력 기능(고득점 -> 저득점:총점기준) - Comparable<T> 혹은 Comparator<T>를 이용해서 총점이 높은 학생부터 낮은
		 * 학생순으로 출력
		 */

		StudentRepository repo = new StudentRepository();
		String subjectList = "국어 영어 수학";

		while (true) {
			System.out.println("================Student Manager================");
			System.out.println("1. 학생등록");
			System.out.println("2. 전체 조회");
			System.out.println("3. 학생정보 검색");
			System.out.println("4. 성적정보 변경");
			System.out.println("5. 석차 출력");
			System.out.println("0. 프로그램 종료");
			System.out.println("===============================================");
			System.out.print("메뉴 선택: ");
			int sel = sc.nextInt();

			if (sel == 1) {
				System.out.println("등록할 학생의 정보를 입력하세요.");
				System.out.print("이름: ");
				String name = sc.next();
				System.out.print("국어: ");
				int kor = sc.nextInt();
				System.out.print("영어: ");
				int eng = sc.nextInt();
				System.out.print("수학: ");
				int math = sc.nextInt();
				repo.addStudent(new Student(name, kor, eng, math));
			}

			else if (sel == 2) {
				System.out.println("전체 학생 조회");
				repo.showAllStudentInform();
			}

			else if (sel == 3) {
				System.out.print("검색하고자 하는 학생의 이름을 입력하세요: ");
				if (!repo.showDetailsByName(sc.next())) {
					System.out.println("학생정보가 없습니다.");
					continue;
				}
			}

			else if (sel == 4) {
				System.out.print("점수바꿀 학생: ");
				String name = sc.next();
				if (!repo.showDetailsByName(name)) {
					System.out.println("찾으시는 학생이 없습니다");
					continue;
				}
				System.out.print("점수를 바꾸려는 과목: ");
				String subject = sc.next();
				if (!subjectList.contains(subject)) {
					System.out.println("없는 과목명입니다.");
					continue;
				}
				System.out.print("바꿀 점수 입력: ");
				int score = sc.nextInt();

				repo.modifyStudentScore(name, subject, score);
			}

			else if (sel == 5) {
				System.out.println("석차 출력 (총점, 1. 오름차순 / 2. 내림차순)");
				int order = sc.nextInt();
				if (order == 1) {
					// 오름차순
					repo.ascendingBy();
					repo.showAllStudentInform();
				} else if (order == 2) {
					// 내림차순
					repo.descendingBy();
					repo.showAllStudentInform();
				} else {
					System.out.println("기본값(오름차순)으로 정렬합니다");
					// 오름차순
				}

			} else if (sel == 0) {
				System.out.println("프로그램 종료");
				break;
			}
			System.out.println();
			System.out.println();
		}
	}
}