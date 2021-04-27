package io_practice;

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
		try (FileReader fr = new FileReader("src/io_practice/students.txt");
				BufferedReader br = new BufferedReader(fr);) {
			String text = null;
			while ((text = br.readLine()) != null) {
				String getText[] = text.split(",");
				String name = getText[0];
				String kor = getText[1];
				String eng = getText[2];
				String math = getText[3];

				studentList.add(new Student(name, Integer.parseInt(kor), Integer.parseInt(eng), Integer.parseInt(math)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// students가 참조하는 ArrayList객체에 저장된 학생정보를 파일로 저장한다.
	public void saveData() {
		try (PrintWriter writer = new PrintWriter("src/day1/io_practice/students.txt")) {
			StringBuilder sb = new StringBuilder();
			for (Student student : studentList) {
				sb.append(student.getName()).append(",")
						.append(student.getKor()).append(",")
						.append(student.getEng()).append(",")
						.append(student.getMath());
			}
			writer.append(sb);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	// 모든 학생정보를 반환한다.
	public ArrayList<Student> getAllStudents() {
		return studentList;
	}

	public void insertStudent(Student student) {
		studentList.add(student);
	}
}
