package step1_10;

import java.util.Random;

public class Random_Student {

	public static void main(String[] args) {
		
	Random ran = new Random();
	
	int num = 0; 
	int total =0;
	float avg = 0;
	
	int passNum=0;
	int topNum=0;
	int topScore =0;
	
	
	while(num++ < 10)
	{
		int grade = ran.nextInt(100);
		System.out.println(num + "��° �л��� ����: " + grade);
	
		total += grade;
		avg = total/num;
		
		if( grade >= 60)
			passNum++;
		
		if( grade > topScore)
		{
			topScore = grade;
			topNum = num;
		}
		
		
	}
	
	System.out.println("�л����� ������: " + total);
	System.out.printf("�л����� �����: %.1f ", avg);
	System.out.println("�հ��� ����: " + passNum);
	System.out.printf("1�� �л��� ��ȣ�� ������: %d, %d ", topNum, topScore);
	
	}

}
