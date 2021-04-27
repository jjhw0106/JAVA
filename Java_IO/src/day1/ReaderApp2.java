package day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReaderApp2 {
	public static void main(String[] args) {
		try (FileReader fr = new FileReader("src/day1/students.txt");
				BufferedReader br = new BufferedReader(fr)) {

			String text = null;
			while ((text = br.readLine()) != null) {// 변수에 값 담음과 동시에 조건 검사가능

				String[] values = text.split(",");
				String name = values[0];
				int kor = Integer.parseInt(values[1]);
				int eng = Integer.parseInt(values[2]);
				int math = Integer.parseInt(values[3]);
				int total = kor + eng + math;
				int average = total / 3;

				System.out.println("학생이름: " + name);
				System.out.println("국어점수: " + kor);
				System.out.println("영어점수: " + eng);
				System.out.println("수학점수: " + math);
				System.out.println("총    합: " + total);
				System.out.println("평    균: " + average);
				System.out.println("------------------------------");

			}

//			while (br.readLine() != null) {		//값을 못담을 뿐 아니라 여기서 한 줄 읽어버림
//				System.out.println(br.readLine());
//			}
//			br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
