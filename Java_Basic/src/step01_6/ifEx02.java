package step01_6;

import java.util.Scanner;

public class ifEx02 {

	public static void main(String [] args)
	{
		int com =8;
		int me;

		Scanner getNum = new Scanner(System.in);
		
		System.out.println("값을 입력하세요");
		me = getNum.nextInt();
		
		if (me < com)
			System.out.println("up!");
		if (me == com)
			System.out.println("Bingo!");
		if (me > com)
			System.out.println("Down!");

		getNum.close();
		
	}
}
