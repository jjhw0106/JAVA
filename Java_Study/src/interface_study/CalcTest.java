package interface_study;

import java.util.Scanner;

public class CalcTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Complete_Calculator cc = new Complete_Calculator();
//		Calculator cc = new Complete_Calculator();-> 타입이 Calculator이므로 
		// CompleteCal의 메서드는 사용 못함
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		System.out.println(cc.add(num1, num2));
		System.out.println(cc.divide(num1, num2));
		System.out.println(cc.substract(num1, num2));
		System.out.println(cc.times(num1, num2));
		cc.showInfo();

		cc.description();
		
		int[] arr = { 1, 2, 3, 4, 5 };
		System.out.println(Calc.total(arr));
	}
}
