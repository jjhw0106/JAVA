package day2;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class WriterApp1 {
	public static void main(String[] args) throws IOException {

		PrintWriter pw = new PrintWriter("src/day2/sample.txt");// 지 혼자도 읽기/쓰기 되고,

		/**
		 * PrintWriter - 출력전용 문자스트림 클래스. 
		 * 		- 직접 텍스트 데이터 쓰기 가능 
		 * 		- 직접 텍스트 데이터 읽기 가능
		 * 
		 * OutputStream, Writer 스트림에 추가기능을 제공하는 보조스트림으로 사용 가능 
		 * 		- 추가기능 
		 * 		- 줄바꿈문자를 자동으로 추가하는
		 * 
		 *  출력 메소드를 제공한다. 
		 *  	-println(데이터) 
		 *  	- auto-flush 기능을 제공한다. 
		 *  - 주요 메소드 
		 *  void write void
		 * println 추가기능
		 * 
		 * 
		 */

		PrintWriter writer = new PrintWriter("src/day2/sample.txt"); // 지 혼자도 읽기/쓰기 되고,
																	 // 보조스트림으로도 쓰인다

		// 줄바꿈 안됨
		writer.write("김유신,100,100,100");
		writer.write("김유신,100,100,100");
		writer.write("김유신,100,100,100");
		writer.write("김유신,100,100,100");

		writer.println();

		// 파일에 기록한 데이터가 줄바꿈됨
		writer.println("김유신,100,100,100");
		writer.println("김유신,100,100,100");
		writer.println("김유신,100,100,100");
		writer.println("김유신,100,100,100");

		writer.close();
	}
}
