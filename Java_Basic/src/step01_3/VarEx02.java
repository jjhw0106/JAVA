package step01_3;

public class VarEx02 {
	public static void main(String[] args) {
		
		//문제1
		System.out.println("문제1) 월급이 100원이다. 연봉은? (조건 : 세금 10% 제외)");
 		int mSalary = 100;
 		int tax = mSalary/10;
 		int ySalary = (mSalary - tax)*12;
		System.out.println(ySalary);
 		
		System.out.println("\n\n");

		//문제2
		System.out.println("문제2) 시험점수를 30, 50, 4점 을 받았다. 평균은?");
		int score1 = 30;
		int score2= 50;
		int score3 = 4;
		int average = score1+score2+score3 / 3;
		System.out.println("평균: " + average);
		
		System.out.println("\n\n");
		
		//문제3
		System.out.println("문제3) 가로가 3이고 세로가 6인 삼각형 넓이 출력");
		int width = 3;
		int height = 6;
		int area = width * height /2;
		System.out.println("넓이 : "+ area);

		System.out.println("\n\n");
		
		//문제 4
		System.out.println("문제4) 100초를 1분 40초로 출력");
		
		int minute = 100 / 60;
		int second = 100 % 60;
		System.out.println("100초는 " + minute + "분" + second + "초" ); 
		
		System.out.println("\n\n");
		
		//문제 5
		System.out.println("문제5) 800원에서 500원짜리 개수 , 100원짜리 개수 출력");
		int coin = 800;
		int coin500 = coin/500;
		int coin100 = coin%500/100;
		
		System.out.println("800원은 500원짜리 : " + coin500 + "개, " + "100원짜리 : " +coin100 +"개");
		
	
	}

}
