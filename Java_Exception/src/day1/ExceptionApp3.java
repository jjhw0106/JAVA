package day1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ExceptionApp3 {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void writeText1(String path, String text) {

		try {
			PrintWriter writer = new PrintWriter(path);
			writer.write(text);
			writer.close();
		} catch (FileNotFoundException e) {
			System.out.println("파일경로가 올바르지 않습니다.");
		}
	}

	//예외가 발생되는 메소드 사용
	//throws 키워드를 사용해서 메소드를 호출하는 측에게 예외처리를 위임 
	public static void writeText2(String path, String text) throws FileNotFoundException {
		PrintWriter writer = new PrintWriter(path);
		writer.write(text);
		writer.close();
	}

	public static void main(String[] args) {
		//예외를 직접처리하는 메소드를 사용하는 경우 => 예외처리 부담이 없다
		//예외처리를 매번 해줘야 하고, 수정 시 다 바꿔야한다.
		writeText1("src/day1/샘플2.txt", "try~catch구문으로 직접 예외처리 하는 메소드");

		//예외를 직접 처리하지 않고 떠넘기는 메소드를 사용하면,
		//그 메소드를 호출(사용, 실행)하는 곳에서 예외를 대신 처리해야 한다.
		//한 곳에 모아서 예외처리를 해줄 수 있다. 보통 이 방식으로 예외처리를 함
		//만약 최종 호출장소에서 try catch 없이 throws로 집어던지면 프로그램이 그냥 죽어버린다.
		try {
			writeText2("src/day2/샘플3.txt", "throws 키워드로 예외처리를 떠넘기는 메소드");
		} catch (FileNotFoundException e) {
			System.out.println("경로가 올바르지 않습니다.");
			e.printStackTrace();
		}
	}

}
