package step01_8;

import java.util.Scanner;

public class ATM_Level1 {
	public static void main(String[] arags) {
		Scanner getNum = new Scanner(System.in);
		
		
		int myAcc = 1234;
		int myMoney = 8700;
		
		int yourAcc = 4321;
		int yourMoney = 12000;
		
		int accAddress;
		int howMuch;
	
		
		System.out.print("���� ������ �Է��ϼ���: ");
		accAddress = getNum.nextInt();
		
		if (accAddress == yourAcc)
			{			
				System.out.print("�󸶸� �����ðڽ��ϱ�?: ");
				howMuch = getNum.nextInt();
					if(howMuch<=myMoney)
					{
						myMoney -= howMuch;
						yourMoney +=howMuch;
					}
					else
					{
						System.out.println("�ܾ��� �����մϴ�");
						System.out.println("��ü�Ұ�");
					}

			}
		
		
		else
			{
				System.out.println("���¹�ȣ�� Ȯ���ϼ���");
				System.out.println("��ü�Ұ�");
			}
		
		
		
		System.out.println("myMoney =" + myMoney + "��");
		System.out.println("yourMoney =" + yourMoney + "��");
		
		getNum.close();
		
	}
	
}
