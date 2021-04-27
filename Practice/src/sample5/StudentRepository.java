package sample5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class StudentRepository {
	ArrayList<Student> studentList = new ArrayList<Student>();

	public StudentRepository() {
		studentList.add(new Student("김태촌", 90, 90, 100));
		studentList.add(new Student("이나은", 80, 80, 20));
		studentList.add(new Student("권상우", 95, 40, 70));
		studentList.add(new Student("김연우", 70, 50, 33));
		studentList.add(new Student("박나래", 80, 70, 100));
		studentList.add(new Student("김호철", 100, 20, 20));
		studentList.add(new Student("강감찬", 40, 100, 40));
	}

	// 중복된 이름있을 시 이름 + 2,3
	public void addStudent(Student student) {
		int dupCnt = 1;
		for (Student duplicateCheck : studentList) {
			if (student.getName().equals(duplicateCheck.getName())) {
				dupCnt++;
			}
		}
		if (dupCnt == 1) {
			studentList.add(student);
		} else {
			studentList.add(
					new Student(student.getName() + dupCnt, student.getKor(), student.getEng(), student.getMath()));
		}
	}

	public void showStudentInform(Student student) {
		System.out.printf("이름: %-4s\t총점: %-4d\t평균: %-4d\n",
				student.getName(),
				student.getTotal(),
				student.getAverage());
	}

	public void showAllStudentInform() {
		for (Student student : studentList) {
			showStudentInform(student);
		}
	}

	public boolean showDetailsByName(String name) {
		boolean check = false;
		for (Student student : studentList) {
			if (student.getName().equals(name)) {
				check = true;
				showScoreDetail(student);
				break;
			}
		}
		return check;
	}

	public Student getStudentsByName(String name) {
		for (Student student : studentList) {
			if (student.getName().equals(name)) {
				return student;
			}
		}
		System.out.println("학생정보가 없습니다.");
		return null;
	}

	public void modifyStudentScore(String name, String subject, int score) {
		Student targetStd = getStudentsByName(name); // 리스트의 값을 바꿀것인가
		if (subject.equals("국어"))
			targetStd.setKor(score);
		else if (subject.equals("영어"))
			targetStd.setEng(score);
		else if (subject.equals("수학"))
			targetStd.setMath(score);
	}

	public void showScoreDetail(Student student) {
		System.out.printf("이름: %-5s 국어: %-3d 영어: %-3d 수학: %-3d 총점: %-4d 평균: %-3d\n",
				student.getName(),
				student.getKor(),
				student.getEng(),
				student.getMath(),
				student.getTotal(),
				student.getAverage());
	}

	// Comparable 사용
	public void ascendingBy() {
		Collections.sort(studentList);
	}

	// Comparator 사용
	public void descendingBy() {
		Collections.sort(studentList, new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				return -1 * (o1.getTotal() - o2.getTotal());
			}
		});
	}
}
