package step01_7;

import java.util.Random;
import java.util.Scanner;

public class RandomEx01 {

	public static void main(String[] args) {
		Random ran = new Random();
		Scanner getNum = new Scanner(System.in);
		
		
		int coin = ran.nextInt(2);
		
		System.out.println("������ �ո� : 0, ������ �޸� : 1");
		int me = getNum.nextInt();
		
		if (coin == me)
			System.out.println("����");
		else 
			System.out.println("����");
		

	
	}
}
