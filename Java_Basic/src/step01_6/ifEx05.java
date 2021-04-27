package step01_6;

import java.util.Scanner;

public class ifEx05 {

	public static void main(String[] args) {
	
		Scanner getNum = new Scanner(System.in);
		
		int dbId =0;
		int dbPw =0;
		
		System.out.println("회원 가입을 위한 id와 pw를 입력하세요");
		System.out.println("ID: ");
		dbId = getNum.nextInt();
		System.out.println("PW: ");
		dbPw = getNum.nextInt();
		
		
		int logId;
		int logPw;
		System.out.println("로그인하세요");
		
		System.out.println("ID: ");
		logId = getNum.nextInt();
		
		System.out.println("PW: ");
		logPw = getNum.nextInt();
		
		if (dbId == logId && dbPw == logPw)
			System.out.println("로그인 성공");
		else 
			System.out.println("로그인 실패");
		getNum.close();
	}
	
}
