package step01_4;

public class OpEx06 {

	public static void main(String[] args) {
		
		//문제1
		System.out.println("문제1) 3의 배수이면 true 출력");
		int score1 = 33;
		System.out.println(score1 %3 == 0);
		System.out.println("\n\n");
		
		
		System.out.println("문제2) 짝수이면 true 출력");
		int score2 = 33;
		System.out.println(score2%2 == 0);
		System.out.println("\n\n");
		
		
		System.out.println("문제3) 아래돈 중 1000원짜리 이상화폐를 제외한 1000원짜리가 3장 이상이면 true 출력");
		int money = 178600;
		
		System.out.println(money%5000/1000 >=3);
		
		
		
		
		
	}
	
}
