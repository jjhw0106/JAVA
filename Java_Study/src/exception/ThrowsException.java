package exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ThrowsException {

	public Class loadClass(String fileName, String className) throws FileNotFoundException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream(fileName);
		Class c = Class.forName(className);
		return c;
	}

	public static void main(String[] args) {
		ThrowsException test = new ThrowsException();// 위에서 throws로 예외처리를 미뤘기 때문에 호출하는 쪽에서 try catch로 예외 처리를 구현해 줘야 한다.

		try {
			test.loadClass("a.txt", "java.lang.string");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		} catch (Exception e) {	// 최상위 익셉션이기 때문에 가장 마지막에 선언해줘야 한다.
			System.out.println(e);
		}

	}
}
