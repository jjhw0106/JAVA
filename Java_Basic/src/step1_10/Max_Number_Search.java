package step1_10;

import java.util.Scanner;

public class Max_Number_Search {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int i = 0;
		int max = 0;
		
		// ���� �Է�
		while (i++ < 3)
		{
			System.out.print( i + "��° ���ڸ� �Է��ϼ���: ");
			int num = scan.nextInt();
			
			if(num > max)
				max = num;
					
		}
	
		System.out.println("�ִ밪�� " + max);		
	}
}
