package day2;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class ByteStreamApp2 {
	public static void main(String[] args) throws IOException {
		URL url = new URL("https://t1.daumcdn.net/movie/7097614d112f21bbf7ca3b59448a506c6f6632e4");
		InputStream in = url.openStream();	// 다음 서버에 있는 img파일과 스트림이 연결되었다.
		FileOutputStream out = new FileOutputStream("src/day2/서예지3.jpg");

		BufferedInputStream in2 = new BufferedInputStream(in);
		BufferedOutputStream out2 = new BufferedOutputStream(out);

		int value = 0;
		while ((value = in2.read()) != -1) {
			out2.write(value);
		}
		out.close();

	}
}
