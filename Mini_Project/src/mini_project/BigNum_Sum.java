package mini_project;
//2:10 ~ 3:20

public class BigNum_Sum {
	public static void main(String[] args) {
		// 아주긴수는 변수에 저장할수없다. int 나 long 에 넣지않고 아래합구하기
		String data1 = "3333489729"; // q. 일치하지 않는 숫자 있는데 오차 발생 가능한지?
		String data2 = "5555";

		// 답: 212,345,678,012,344

		int d1End = data1.length() - 1;
		int d2End = data2.length() - 1;

		int sumEnd = 0;
		if (data1.length() >= data2.length())
			sumEnd = data1.length() - 1;
		else
			sumEnd = data2.length() - 1;

		String[] sum = new String[sumEnd + 1];
		int check = 0;
//		char st = '0';
//		int s = (int) st;
//		System.out.println(s);
		while (sumEnd >= 0) {
			int d1 = 0;
			int d2 = 0;
			if (d1End < 0)
				d1 = 0;
			else
				d1 = (int) (data1.charAt(d1End)) - 48; // asc코드 0 뺌

			if (d2End < 0)
				d2 = 0;
			else
				d2 = (int) data2.charAt(d2End) - 48;

			if (d1 + d2 >= 10) {
				if (check == 1) {
					sum[sumEnd] = String.valueOf(d1 + d2 - 10 + check);
				} else if (check == 0)
					sum[sumEnd] = String.valueOf(d1 + d2 - 10);
				check = 1;
			}

			else if (d1 + d2 < 10) {
				if (check == 1)
					sum[sumEnd] = String.valueOf(d1 + d2 + check);
				else if (check == 0)
					sum[sumEnd] = String.valueOf(d1 + d2);
				check = 0;
			}
			sumEnd--;
			d1End--;
			d2End--;
		}
//		
		for (int i = 0; i < sum.length; i++)
			System.out.print(sum[i]);
	}
}
/////////////////

////		자바 5-1 테스트 - 김지연 선생님 답
//
////		테스트 3
//
//	// 아주 긴 수는 변수에 저장할수없다. int 나 long 에 넣지않고 아래합구하기
//
//	String data1 = "123456789123456";
//
//	String data2 = "88888888888888";
//
//	// 위 수의 합을 구하시요 .
//
//	// 힌트 : 배열에 넣으세요~
//
//	// 답 : 212345678012344
//
//	String temp1[] = data1.split("");
//
//	String temp2[] = data2.split("");
//
//	// 자리수 일치 후, 연산 -> nums 배열에 임시저장
//
//	int size1 = temp1.length;
//
//	int size2 = temp2.length;
//
//	int gab = Math.abs(size1 - size2); // 절대값
//
//	int nums[] = new int[data1.length()];
//
//	for(
//	int i = 0;i<(size1>size2?size1:size2);i++)
//	{ // 더 큰 수까지 for문을 돌리겠다
//
//		int a = Integer.parseInt((size1 > size2 ? temp1 : temp2)[i]);
//
//		int b = 0;
//
//		if (i - gab >= 0) {
//
//			b = Integer.parseInt((size1 > size2 ? temp2 : temp1)[i - gab]);
//
//		}
//
//		nums[i] = a + b;
//
//	}
//
//	// nums 배열 1의 자리 남기고, 10으로 나눈 몫 넘겨주기
//
//	for(
//	int i = nums.length - 1;i>=0;i--)
//	{
//
//		if (i != 0) {
//
//			nums[i - 1] += nums[i] / 10;
//
//		}
//
//		nums[i] %= 10;
//
//	}
//
//	// 출력
//
//	String result = "";
//
//	for(
//	int i = 0;i<nums.length;i++)
//	{
//
//		result += nums[i];
//
//	}
//
//	System.out.println(result);
//
//}}
