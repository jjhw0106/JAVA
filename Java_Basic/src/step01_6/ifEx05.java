package step01_6;

import java.util.Scanner;

public class ifEx05 {

	public static void main(String[] args) {
	
		Scanner getNum = new Scanner(System.in);
		
		int dbId =0;
		int dbPw =0;
		
		System.out.println("ȸ�� ������ ���� id�� pw�� �Է��ϼ���");
		System.out.println("ID: ");
		dbId = getNum.nextInt();
		System.out.println("PW: ");
		dbPw = getNum.nextInt();
		
		
		int logId;
		int logPw;
		System.out.println("�α����ϼ���");
		
		System.out.println("ID: ");
		logId = getNum.nextInt();
		
		System.out.println("PW: ");
		logPw = getNum.nextInt();
		
		if (dbId == logId && dbPw == logPw)
			System.out.println("�α��� ����");
		else 
			System.out.println("�α��� ����");
		getNum.close();
	}
	
}
