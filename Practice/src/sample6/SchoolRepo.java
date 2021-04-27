package sample6;

import java.util.ArrayList;
import java.util.Iterator;

public class SchoolRepo {
	private ArrayList<Student> studentList = new ArrayList<Student>();
	private ArrayList<Course> courseList = new ArrayList<Course>();
	private ArrayList<Registration> registrationList = new ArrayList<Registration>();

	public SchoolRepo() {
		// 기본 DB
		studentList.add(new Student(1, "김태촌", "컴퓨터공학과", 2));
		studentList.add(new Student(2, "김유신", "경영학과", 3));
		studentList.add(new Student(3, "김성광", "산업공학과", 1));
		studentList.add(new Student(4, "고두심", "전자공학과", 4));
		studentList.add(new Student(5, "이순재", "회계학과", 4));

		courseList.add(new Course(11, "컴퓨터개론", 1));
		courseList.add(new Course(21, "경영학개론", 40));
		courseList.add(new Course(31, "건축학개론", 20));
	}

	// 학생 등록 기능
	// 학생정보를 전달받아서 studentList에 저장하는 기능
	public void addStudent(Student student) {
		for (Student search : studentList) {
			if (student.equals(search)) {
				System.out.println("이미 있는 학생번호입니다.");
				return;
			}
		}
		studentList.add(student);
	}

	// 과정 등록 기능
	// 과정정보를 전달받아서 courseList에 저장하는 기능
	public void addCourse(Course course) {
		for (Course search : courseList) {
			if (course.equals(search)) {
				System.out.println("중복된 과목번호입니다.");
				return;
			}
		}
		courseList.add(course);
	}

	// 전체 학생 조회
	public void displayAllStudent() {
		for (Student std : studentList) {
			System.out.println(std.getNo() + " " + std.getName());
		}
	}

	// 과정 조회 기능
	public void displayAllCourse() {
		for (Course course : courseList) {
			System.out.println(course.getCourseNo() + " " + course.getCourseName());
		}
	}

	// 과정 신청하기
	public void addRegistration(int courseNo, int studentNo) {
//		 1. 학생번호에 해당하는 학생이 그 과정을 신청했는지 확인
//		 2. 그 과정에 정원이 충분한지 확인
//		 3. registrations가 참조하는 ArrayList에 등록정보 추가하기

		// 재학생인지 확인
		boolean studentCheck = false;
		for (Student student : studentList) {
			if (student.getNo() == studentNo) {
				studentCheck = true;
				break;
			}
		}
		if (studentCheck == false) {
			System.out.println("학번을 확인하세요");
			return;
		}

		// 과정등록여부 확인
		for (Registration reg : registrationList) {
			if (studentNo == reg.getStudentNo() && courseNo == reg.getCourseNo()) {
				System.out.println("이미 등록한 과목입니다.");
				return;
			}
		}

		// 과정 여석확인
		for (Course course : courseList) {
			if (course.getCourseNo() == courseNo) {
				if (course.getQuota() <= course.getRegisteredCount()) {
					System.out.println("정원이 가득 찼습니다");
					return;
				} else {
					registrationList.add(new Registration(courseNo, studentNo));
					course.setRegisteredCount(course.getRegisteredCount() + 1);
					System.out.println("등록학생수:" + course.getRegisteredCount());// check
					return;
				}
			}
		}
		System.out.println("과목번호를 확인하세요");
	}

	// 신청 취소하기
	public void cancelRegistration(int studentNo, int courseNo) {
		Iterator<Registration> iter = registrationList.iterator();
		while (iter.hasNext()) {
			if (iter.next().getStudentNo() == studentNo && iter.next().getCourseNo() == courseNo) {
				System.out.println(iter);
				iter.remove();
				System.out.println("수강 철회성공");
				return;
			}
		}
		System.out.println("학생번호 또는 과목번호를 확인하세요");
	}

	// 신청과정 조회하기
	public void displayRegistration(int studentNo) {
		for (Registration reg : registrationList) {
			if (reg.getStudentNo() == studentNo)
				System.out.println("학번: " + reg.getStudentNo() + " " + "과목번호: " + reg.getCourseNo());
		}
	}
}
