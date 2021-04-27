package day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class BridgeStreamApp {
	public static void main(String[] args) throws IOException {

		URL url = new URL("https://sample-videos.com/csv/Sample-Spreadsheet-100-rows.csv");
		// 1byte씩 읽어오는 스트림 획득
		InputStream is = url.openStream();
		// 1글자씩 읽어오는 스트림과 연결 , BufferedReader와 InputStream을 이어주기 위해선 반드시 Reader가 필요함
//		InputStreamReader isr = new InputStreamReader(is);

		// 1줄씩 읽어오는 스트림과 연결
		BufferedReader br = new BufferedReader(new InputStreamReader(is));	// BufferedReader는 Reader와만 연결이 가능하다.

		String text = null;
		while ((text = br.readLine()) != null) {
			System.out.println(text);
		}
		
		
	}
}
