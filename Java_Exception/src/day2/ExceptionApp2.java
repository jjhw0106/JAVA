package day2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExceptionApp2 {
	public static void main(String[] args) {
		try {
			test1();
			Date day = strToDate("2021-04-20");
			System.out.println(day);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	throws: 떠넘기기
//	throw: 관계발생
	public static void test1() throws HTACheckedException {
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/day2/sample2.txt"));
			String text = br.readLine();
			System.out.println("파일내용: " + text);
			br.close();
		} catch (FileNotFoundException cause) { // cause는 에러의 원인이 되는 exception
			throw new HTACheckedException("파일경로가 올바르지 않습니다", cause);
		} catch (IOException cause) {
			throw new HTACheckedException("파일 읽기 실패", cause);
		}
	}

	public static Date strToDate(String dateString) throws HTACheckedException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return format.parse(dateString);
		} catch (ParseException cause) {
			throw new HTACheckedException("올바른 날짜 형식이 아닙니다", cause);
		}
	}

}
