package step01_5;

import java.util.Scanner; //java util ��Ű�� ���� Scanner Ŭ���� ������ �ҷ���

public class input {
	public static void main(String[] args) {
		Scanner getNum = new Scanner(System.in);

		/*
		System.out.println("���� 1) �� ���� ����?");
 		int num1;
		int num2;
		
		System.out.println("num1�� �Է¹�������");
		num1 = getNum.nextInt();
		
		System.out.println("num2�� �Է¹�������");
		num2 = getNum.nextInt();
		
		int sum = num1 + num2;
		System.out.println("num1�� num2�� ���� " + sum);
			
	
		System.out.println("���� 2) ���� 1�� �޾Ƽ� Ȧ���� true ���");
		System.out.println("���ڸ� �Է��ϼ���");
		int num = getNum.nextInt();
		System.out.println(num%2==1);
		*/
		
		System.out.println("���� 3) �����ް� 60�̻� 100���� true���");
		System.out.println("������ �Է��ϼ���");
		int grade = getNum.nextInt();
		System.out.println(grade >= 60 && grade<=100);	
		getNum.close();
	}

}
