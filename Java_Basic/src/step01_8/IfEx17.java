package step01_8;

import java.util.Scanner;
import java.util.Random;

public class IfEx17 {
	

	public static void main(String[] args) {
		Random ran = new Random();
		int num = ran.nextInt(50); 
		int count = 0;
		
		System.out.println(num);
		
		if (num/10 == 3 ||num/10 == 6  ||num/10 == 9)
		{
			count += 1;
		}

		if(num%10 == 3 ||num%10 == 6 ||num%10 == 9)
		{
			count += 1;
		}
		
		if (count ==1)
			System.out.println(num + " ¦ ");
		
		if (count ==2)	
			System.out.println(num + " ¦¦");
		
		if (count ==0)	
			System.out.println(num);
		}
}
