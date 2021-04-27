package day1;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class ExceptionApp2 {
	public static void main(String[] args) {
		try {
			System.out.println("샘플1.txt 파일에 내용 기록하기");
			FileWriter writer = new FileWriter("src/day2/샘플1.txt");
			System.out.println("샘플1.txt파일에 내용을 기록하는 FileWriter객체 생성하기");

			writer.write("파일쓰기 연습");
			System.out.println("샘플1.txt파일에 텍스트 기록");
			writer.close();
			System.out.println("컴퓨터의 입출력 장치와의 연결해제");
		}
		/*catch (FileNotFoundException e) {
			System.out.println(e);
			System.out.println("샘플1.txt파일 내용을 기록할 경로를 찾을 수 없습니다.");
			}*/
		catch (IOException e) {
			// IOException 타입의 객체 혹은 그 하위 타입의 객체가 들어있다.
			// 예외객체는 예외가 발생한 원인 및 예외가 발생한 코드에 대한 정보를 가지고 있다.
			// 주요메소드
			// 		String e.getMessage()
			//			발생한 예외에 대한 상세한 정보(에러메세지, 발생원인)을 반환한다.
			//		void printStackTrace()
			//			예외클래스명 : 에러메세지 및 예외가 발생한
			//			실행문을 실행순서대로 화면에 출력한다.
			System.out.println("try블록에서 발생한 예외객체");
			System.out.println("1.." + e);
			System.out.println("2.." + e.getMessage());
			e.printStackTrace();
			System.out.println("샘플1.txt파일 내용 기록하기 도중 오류가 발생하였습니다.");
		}
	}
}
