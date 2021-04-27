package day3;

import java.io.FileWriter;
import java.io.IOException;

public class ExceptionApp2 {
	public static void main(String[] args) {
		try (FileWriter writer = new FileWriter("src/day3/sample.txt")) { // autoclose: finally가 없어도 자동으로 close()가 실행됨
			writer.write("자동자원해제"); 									// 자바7부터 지원
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
