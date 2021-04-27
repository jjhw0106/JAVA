package day3;

import java.io.FileWriter;
import java.io.IOException;

public class ExceptionApp1 {
	public static void main(String[] args) {
		FileWriter writer = null;
		try {
			writer = new FileWriter("Src/day3/sample1/txt");
			writer.write("finally 연습\n");
			writer.write("finally 연습\n");
			writer.write("finally 연습\n");
			writer.write("finally 연습\n");
			writer.write("finally 연습\n");

//			writer.close();// 위에서 에러발생 시 writer의 자원이 해제되지 않는다.

		} catch (IOException e) {
			e.printStackTrace();
//			writer.close();;// 오류발생시에만 자원을 해제하므로 적절하지 않다.
		} finally {
			//자원 반환
			try {
				if (writer != null) {	//처음 new FileWriter할 때 경로가 잘못되어 null이 날 수도 있음
					writer.close(); // close() 자체가 예외를 발생시킴
				}
			} catch (IOException e) {
				// 수행할 작업 없음
			}
		}
	}
}
