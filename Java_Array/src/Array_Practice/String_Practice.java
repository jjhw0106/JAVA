package Array_Practice;
/*
 * # 문자열 [입력받기]
 * . 숫자나 영어단어 입력 시 커서를 옮길 필요가 없다.
 * . 단, 한글 입력 시 반드시 커서를 끝으로 옮긴 후 작성해야 한다.
 */

import java.util.Scanner;

public class String_Practice {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		String name = "홍길동";
		
		System.out.print("이름을 입력: ");
		String myName = scan.next();
		if(name == myName) {
			System.out.println("연산자 : 일치");
		}
		else
			System.out.println("연산자 : 불일치");
		
		if(name.equals(myName));
		scan.close();
				
	}

}
