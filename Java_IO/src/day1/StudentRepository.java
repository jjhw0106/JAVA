package day1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class StudentRepository {

	private ArrayList<Student> studentList = new ArrayList<Student>();

	public StudentRepository() {
		loadData();
	}

	// 텍스트데이터를 읽어서 students가 참조하는 ArrayList객체에 저장한다.

	private void loadData() {		// 실행되면 무조건 불러오면 되니까 private
		try (FileReader fileReader = new FileReader("src/day1/students.txt");
				BufferedReader reader = new BufferedReader(fileReader)) {

			String text = null;
			while ((text = reader.readLine()) != null) {
				// 1. text변수에 저장된 문자열을 ,를 구분자로 자른다 -> String[] 획득
				// 2. String[] 배열의 0번째부터 3번째까지 값을 가져와서
				// 적절한 변수에 대입한다.
				// 3. 2번에서 획득한 이름, 국어, 영어, 수학점수를 Student객체를 생성해서 담는다.
				// 4. 학생성적정보가 들어있는 Student객체를 students 참조변수가 참조하는
				// ArrayList 객체에 추가한다.
				String[] getText = text.split(",");
				studentList.add(new Student(getText[0], Integer.parseInt(getText[1]),
						Integer.parseInt(getText[2]), Integer.parseInt(getText[3])));
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

	}

	// students가 참조하는 ArrayList객체에 저장된 학생정보를 파일로 저장한다.
	public void saveData() {
		try (PrintWriter writer = new PrintWriter("src/day1/students.txt");) {

			for (Student student : studentList) {
				StringBuilder sb = new StringBuilder();
				sb.append(student.getName())
						.append(",")
						.append(student.getKor())
						.append(",")
						.append(student.getEng())
						.append(",")
						.append(student.getMath());
				// StringBuilder 객체의 내부저장소에 추가된 값을 하나의 문자열로 획득한다.
				String text = sb.toString();
				// PrintWriter객체의 println() 메소드를 사용해서 text 변수에 저장된 문자열을
				// 파일로 보낸다.
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public Student searchStudent(String name) {
		for (Student student : studentList) {
			if (student.getName().equals(name)) {
				return student;
			}
		}
		return null;
	}

	// 모든 학생정보를 반환한다.
	public ArrayList<Student> getAllStudents() {
		return studentList;
	}

	public void insertStudent(Student student) {
		studentList.add(student);
	}
}
