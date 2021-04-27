package day2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExceptionApp3 {
	public static void main(String[] args) {
		test1();
		Date day = strToDate("2010-01-01");
		System.out.println(day);
	}

	public static void test1() throws HTAUncheckedException {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("src/day2/sample1.txt"));
			String text = reader.readLine();
			System.out.println("파일내용: " + text);
			reader.close();
		} catch (FileNotFoundException e) {
			throw new HTAUncheckedException("파일경로가 올바르지 않습니다.", e); // 런타임 익셉션이기 때문에 예외처리를 강제하지 않아 throws명시하지 않아도 된다
		} catch (IOException e) { // 그러나 보통 throws를 적어주긴 한다.
			/* throw new HTACheckedException("파일읽기 오류가 발생했습니다.", e); */ // 예외처리를 강제하기 때문에 반드시 throws를 명시해야 한다.
			throw new HTAUncheckedException("파일읽기 오류가 발생했습니다.", e);
		}

	}

	// HTAUncheckedException은 런타임익셉션이기 때문에 내부에서 오류가 있더라도 throws를 생략할 수 있다.
	public static Date strToDate(String dateString) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			return sdf.parse(dateString);
		} catch (ParseException cause) {
			throw new HTAUncheckedException("올바른 날짜 형식이 아닙니다.", cause);
		}
	}
}
