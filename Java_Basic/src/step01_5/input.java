package step01_5;

import java.util.Scanner; //java util 패키지 안의 Scanner 클래스 파일을 불러옴

public class input {
	public static void main(String[] args) {
		Scanner getNum = new Scanner(System.in);

		/*
		System.out.println("문제 1) 두 숫자 합은?");
 		int num1;
		int num2;
		
		System.out.println("num1을 입력받으세요");
		num1 = getNum.nextInt();
		
		System.out.println("num2을 입력받으세요");
		num2 = getNum.nextInt();
		
		int sum = num1 + num2;
		System.out.println("num1과 num2의 합은 " + sum);
			
	
		System.out.println("문제 2) 숫자 1개 받아서 홀수면 true 출력");
		System.out.println("숫자를 입력하세요");
		int num = getNum.nextInt();
		System.out.println(num%2==1);
		*/
		
		System.out.println("문제 3) 성적받고 60이상 100이하 true출력");
		System.out.println("성적을 입력하세요");
		int grade = getNum.nextInt();
		System.out.println(grade >= 60 && grade<=100);	
		getNum.close();
	}

}
