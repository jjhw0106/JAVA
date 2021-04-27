package megastudy_test4;

import java.util.Scanner;

public class Test1_Arr {
	/* start 5:20 ~ end 5:35
	 * # 석차 출력
	 * . 성적 순으로 이름 출력
	 */
	// 숫자를 5개 입력받고 arr 배열안에 입력한값이 있을때마다
	// b배열안에 해당 값의 인덱스를 차례대로 저장할려고 한다.
	// 조건) 만약에 입력한 숫자가 arr 에 없으면 인덱스 대신 -1 저장

	// 예) 10, 20, 10, 1, 50
	// b ={0,1,0,-1,4}

	// 예) 30, 40, 1, 10, 2

	// b = {2,3,-1,0,-1}

	public static void main(String[] args) {
		int arr[] = { 10, 20, 30, 40, 50 };
		int b[] = new int[5];
		int count = 0;
		Scanner sc = new Scanner(System.in);

		
		while (count<5) {
			boolean check = false;
			System.out.print("숫자 입력: ");
			int input = sc.nextInt();

			if (input == 0)
				break;

			int temp = 0;

			for (int i = 0; i < arr.length; i++) {
				if (input == arr[i]) {
					temp = i;
					check = true;
					break;
				}
			}

			if (check == false) {
				b[count] = -1;
				count++;
			} else {
				b[count] = temp;
				count++;
			}
		}

		for (int i = 0; i < arr.length; i++)
			System.out.println(b[i]);
	}
}
