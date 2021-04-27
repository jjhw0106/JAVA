	package day3;

import java.io.InputStream;
import java.io.PrintStream;

public class StandardIOApp {
	public static void main(String[] args) {
		InputStream in = System.in;
		PrintStream out = System.out;
		PrintStream err = System.err;
		
		System.out.println("표준입력 스트림: "+in);
		System.out.println("표준입력 스트림: "+out);
		System.out.println("표준입력 스트림: "+err);
	}
}
