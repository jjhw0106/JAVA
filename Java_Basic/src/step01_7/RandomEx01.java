package step01_7;

import java.util.Random;
import java.util.Scanner;

public class RandomEx01 {

	public static void main(String[] args) {
		Random ran = new Random();
		Scanner getNum = new Scanner(System.in);
		
		
		int coin = ran.nextInt(2);
		
		System.out.println("동전의 앞면 : 0, 동전의 뒷면 : 1");
		int me = getNum.nextInt();
		
		if (coin == me)
			System.out.println("정답");
		else 
			System.out.println("오답");
		

	
	}
}
