package day2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExceptionApp {

	public static void test1() throws FileNotFoundException, IOException {
		BufferedReader br = new BufferedReader(new FileReader("src/day2/sample1.txt"));
		String text = br.readLine();
		System.out.println(text);

	}

	public static Date strToDate(String dateString) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy,MM,dd"); // 이 포맷으로 들어온 날짜를
		return sdf.parse(dateString); // parse한다
	}

	public static void main(String[] args) {
		// 메인 메소드에서 실행하는 모든 메소드가 다양한 메소드에 대한 예외처리를
		// 메인 메소드에게 예외처리를 위임하고 있음

		try {
			System.out.println("파일내용 읽기");
			test1();

			System.out.println("날짜형식의 문자열을 Date로 반환하기");
			System.out.println(strToDate("2020,12,25"));
		}

		
		//=> 캐치가 너무 길어지면 복잡함 => 사용자정의 Exception
		catch (FileNotFoundException e) {
			System.out.println("경로에 일치하는 파일명이 없습니다.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("입력이 잘못되었습니다.");
			e.printStackTrace();
		} catch (ParseException e) {
			System.out.println("날짜 형식이 잘못되었습니다");
			e.printStackTrace();
		}
	}
}
