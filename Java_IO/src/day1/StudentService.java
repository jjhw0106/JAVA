package day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class StudentService {

	private StudentRepository repository = new StudentRepository();

	// 모든 학생정보를 제공하는 서비스
	public ArrayList<Student> getAllStudentList() {
		return repository.getAllStudents();
	}

	// 이름으로 학생정보를 조회하는 서비스
	public Student findStudent(String name) {
		Student student = repository.searchStudent(name);
		if (student == null) {
			throw new StudentException("찾는 학생이 없습니다");
		}
		return student;
	}

	// 새로운 학생정보를 추가하는 서비스
	public void addNewStudent(Student student) {
		// 동일한 학생이 있는지 확인하고 예외발생시키기
		// 비즈니스 로직 상 맞지 않는 것들은 서비스에서 예외발생 시킨다.
		// =>Repository는 예외발생같은 것 안한다.
		// 없을 경우 repo.insertStudent(student)
		repository.insertStudent(student);
	}

	// 이름으로 학생정보를 삭제하는 서비스
	public void deleteStudent(String name) {
	}

	// 성적순으로 학생정보를 정렬해서 제공하는 서비스
	public void orderByScore(int score) {
	}

	// 모든 학생정보를 파일로 저장하는 서비스
	public void saveAllStudentsData() {
		repository.saveData();
	}

}
