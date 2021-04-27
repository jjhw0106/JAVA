package step01_8;

import java.util.Scanner;

public class ifEx {
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
	
		int station = scan.nextInt();
		int fare=500;
		int count;
		
		if (station <= 5)
		{
			System.out.println(fare);
		}
		
		else if (station <= 10)
		{
			fare += 100;
			System.out.println(fare);
		}
		
		else if (station > 10)
		{
												//System.out.println("1");->뻑이 어디서 났는지 확인 tip
			if((station - 10)%2 == 1)
			{
												//System.out.println("2");
				count = ((station - 10)/2)+1;
				fare += (100 + 50*count);
			}
			
			else if((station-10)%2 == 0)
			{
												//System.out.println("3");
				count = (station - 10)/2;
				fare += (100 + 50*count);
			}
												//System.out.println("4");
			System.out.println(fare);
		}
	}
}
