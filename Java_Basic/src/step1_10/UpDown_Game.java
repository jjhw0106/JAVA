package step1_10;

import java.util.Random;
import java.util.Scanner;


public class UpDown_Game {

	public static void main(String[] args)
	{
		int round = 0;
		int score = 100;
		Scanner scan = new Scanner(System.in);
		Random ran = new Random();
		
		int cpuValue;
		cpuValue = ran.nextInt(50) + 1;
		System.out.println("정답은: "+cpuValue);
		
		int myAnswer;
		
		System.out.print("정답을 입력하세요: ");
		myAnswer = scan.nextInt();
		
		while (myAnswer!=cpuValue)
		{
			score -= 5;
			myAnswer = scan.nextInt();
		}
		
		System.out.print("정답! 당신의 점수는 : " + score + "점");
		
	}
	
}
