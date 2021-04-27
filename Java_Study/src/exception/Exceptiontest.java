package exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Exceptiontest {
	public static void main(String[] args) {

		FileInputStream fis = null;
		try {
			fis = new FileInputStream("a.txt");
		} catch (FileNotFoundException e) {
			System.out.println(e);
			return;
		} finally { // finally는 무조건 수행되며, finally에 close를 안할 경우 try~catch의 매 분기마다 close를 해줘야 한다.
			try {
				fis.close();
			} catch (Exception e) {
				System.out.println("finally");	//finally는 위에 리턴이 선언되어 있더라도 수행이 된다.
				System.out.println(e);
			}
		}
		System.out.println("end");
	}
}
