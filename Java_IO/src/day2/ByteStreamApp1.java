package day2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamApp1 {
	public static void main(String[] args) throws IOException {
		// src.txt를 읽어서 src_copy.txt로 저장하기
		// src.txt를 읽어오기
		// InputStream 중에서 FileInputStream 사용
		FileInputStream in = new FileInputStream("src/day2/src.jpg");

		// src)copy.txt로 저장하기
		FileOutputStream out = new FileOutputStream("src/day2/src_copy.jpg");

		// src_copy.txt로 저장하기
		// OutpuStream 중에서 FileOutputStream 사용

		// FileInputStream으로 파일의 데이터 읽기
		// fileOutPutStream으로 파일에 데이터 쓰기
		int value = 0;
		int cnt = 0;
		while ((value = in.read()) != -1) {	//값이 없으면 -1 반환
			System.out.println(value);
			cnt++;
			out.write(value);
		}
		System.out.println(cnt);

		in.close();
		out.close();
	}
}
