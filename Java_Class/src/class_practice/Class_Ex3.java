package class_practice;

class Ex03 {
	int[] arr = { 87, 100, 11, 72, 92 };
}

public class Class_Ex3 {
	public static void main(String[] args) {

		// 문제 1) 전체 합 출력
		// 정답 1) 362
		int sum = 0;
		Ex03 e = new Ex03();
		for (int i = 0; i < e.arr.length; i++)
			sum += e.arr[i];
		System.out.println(sum);

		// 문제 2) 4의 배수의 합 출력
		// 정답 2) 264
		int four = 0;
		for (int i = 0; i < e.arr.length; i++) {
			if (e.arr[i] % 4 == 0)
				four += e.arr[i];
		}
		System.out.println(four);

		// 문제 3) 4의 배수의 개수 출력
		// 정답 3) 3
		int fourCnt = 0;

		for (int i = 0; i < e.arr.length; i++) {
			if (e.arr[i] % 4 == 0)
				fourCnt++;
		}
		System.out.println(fourCnt);
		// 문제 4) 짝수의 개수 출력
		// 정답 4) 3
		int evenCnt = 0;

		for (int i = 0; i < e.arr.length; i++) {
			if (e.arr[i] % 2 == 0)
				evenCnt++;
		}
		System.out.println(evenCnt);

	}
}