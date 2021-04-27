package file_practice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Ex00 {
	public static void main(String[] args) {

		// File IO
		// 파일관련 객체(class) 사용시, try-catch 구문 사용

		File file = new File("test.txt");

//		// 파일 쓰기
//		String data = "정호원";
//		FileWriter fw; // filewriter 클래스를 담을 준비 (비어있는 변수)
//		
//		try {
//			// 시도
//			fw = new FileWriter(file);
//			fw.write(data);
//			fw.close();
//			System.out.println("저장완료");
//		} catch (Exception e) {
//			// 시도한 결과값이 에러 혹은 null 일때, 처리 
//			e.printStackTrace();
//		}

		// 파일 읽기
		// 주의. 예외처리를 반드시 해주자

		// try문에서 br.readline()은 올라가면 끝
		if (file.exists()) {
			try {
				FileReader fr = new FileReader(file);
				BufferedReader br = new BufferedReader(fr);

				int cnt = Integer.parseInt(br.readLine()); // *** 한 줄 읽어오기 (반환값 문자열)
//				System.out.println("로드데이터 : " + db);

				for (int i = 0; i < cnt; i++) {
					String db = br.readLine();
					System.out.println(i + 1 + ")" + db);
				}

				fr.close();
				br.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		} else {
			System.out.println("파일을 찾을 수 없습니다.");
		}

	}

}
