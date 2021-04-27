package io_practice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReaderApp1 {
	public static void main(String[] args) {
		try (FileReader fr = new FileReader("src/day1/students.txt");
				BufferedReader br = new BufferedReader(fr);) {

			// 데이터가 없으면 null을 반환한다.
			String text1 = br.readLine();
			String text2 = br.readLine();
			String text3 = br.readLine();
			String text4 = br.readLine();
			String text5 = br.readLine();
			String text6 = br.readLine();

			System.out.println(text1);
			System.out.println(text2);
			System.out.println(text3);
			System.out.println(text4);
			System.out.println(text5);
			System.out.println(text6);
		} catch (IOException e) {
			e.printStackTrace();
		}

//		FileReader fr = new FileReader("src/day1/students/txt");
//		BufferedReader br = new BufferedReader(null); // BufferedReader는 보조스트림이기 때문에 입력못받고 에러난다.
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	}
}
