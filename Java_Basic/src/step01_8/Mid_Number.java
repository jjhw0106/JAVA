package step01_8;

import java.util.Scanner;
import java.util.Random;

public class Mid_Number {

	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		Random ran = new Random();
		int rnum = ran.nextInt(101) + 150;
		
		int digit1 = rnum % 10;
		int digit10 = (rnum % 100)/10;
		
		
		System.out.println("���� ���ڴ� "+ rnum);
		System.out.println("��� ���ڴ� "+ digit10);

		
	}
	
}
