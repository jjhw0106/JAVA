package step1_10;

import java.util.Scanner;

public class Baskin31 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		boolean turn = false;

		int p1 = 0;
		int p2 = 0;
		int br = 0;

		
		while (br < 31) 
		{
	
			if (turn == false) 
			{
				System.out.print("p1 차례입니다 : ");
				p1 = scan.nextInt();
				turn = true;
				br += p1;
				System.out.println("br은? " + br);
			}
			
			else if (turn == true) 
			{
				System.out.print("p2 차례입니다 : ");
				p2 = scan.nextInt();
				turn = false;
				br += p2;
				System.out.println("br은? " + br);
			}
		}
		
		if (turn == false)
			System.out.println("p1이 승리하였습니다.");
		else if (turn == true)
			System.out.println("p2가 승리하였습니다.");
		
	}
}
