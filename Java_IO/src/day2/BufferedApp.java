
package day2;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedApp {
	public static void main(String[] args) throws IOException {
		System.out.println("버퍼를 사용하지 않고 읽고쓰기 시작");

		long startTime = System.currentTimeMillis();
		FileInputStream fis1 = new FileInputStream("src/day2/src2.ttc");	// 파일이름을 똑같이 해놓고 실행할 경우 파일을 다시 받아야 한다.
		FileOutputStream fos1 = new FileOutputStream("src/day2/src2_copy.ttc");

		int value = 0;
		while ((value = fis1.read()) != -1) {
			fos1.write(value);
		}
		fis1.close();
		fos1.close();

		long endTime = System.currentTimeMillis();

		System.out.println("버퍼를 사용하지 않고 읽고쓰기 종료");
		System.out.println("걸린시간 " + (endTime - startTime));

		System.out.println("버퍼를 사용해서 파일 복사하기 시작");
		startTime = System.currentTimeMillis();

		// 파일의 복사는 항상 아래와 같다
		FileInputStream fis2 = new FileInputStream("src/day2/src2.ttc");	// 파일이름을 똑같이 해놓고 실행할 경우 파일을 다시 받아야 한다.
		FileOutputStream fos2 = new FileOutputStream("src/day2/src2_copy2.ttc");

		BufferedInputStream in = new BufferedInputStream(fis2);
		BufferedOutputStream out = new BufferedOutputStream(fos2);

		int value2 = 0;
		while ((value2 = in.read()) != -1) {
			out.write(value2);
		}
		in.close();
		out.close();
		////////////////////////////////////////////////////////////////////
		endTime = System.currentTimeMillis();
		System.out.println("버퍼를 사용해서 파일 복사하기 종료");
		System.out.println("걸린시간 " + (endTime - startTime));
	}
}
