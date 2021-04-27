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
		System.out.println(num + "번째 학생의 점수: " + grade);
	
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
	
	System.out.println("학생들의 총점은: " + total);
	System.out.printf("학생들의 평균은: %.1f ", avg);
	System.out.println("합격자 수는: " + passNum);
	System.out.printf("1등 학생의 번호와 점수는: %d, %d ", topNum, topScore);
	
	}

}
