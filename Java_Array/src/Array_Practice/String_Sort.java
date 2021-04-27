package Array_Practice;

import java.util.Scanner;

public class String_Sort {
	/*
	 * # 문자열[정렬]
	 * 1. compareTo() 메서드
	 * 2. 2개의 문자열을 비교해 int형 값을 반환하는 메서드
	 * 3. A.compareTo(B)
	 * 4. 결과
	 * 		A와 B가 같으면						0
	 *      A가 B보다 사전적으로 순서가 앞이면		음수
	 *      A보다 B가 사전적으로 순서가 앞이면		양수
	 *      요약-> A-B <> 0
	 */

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		// 문제 ) 사전 순으로 이름 정렬
		String[] names = { "서동요", "홍길동", "김유신", "자바킹", "마동석" };
		int nameIdx = 0;
		String temp;
		int compIdx = 0;

		// for (int i = 0; i < names.length; i++)
		// System.out.println(names[i]);
		while (nameIdx < names.length)
		{
			int compare = names[0].compareTo(names[1]);
			
			System.out.println("컴페어는 " + compare);
			for (int i = nameIdx; i < names.length; i++)
				if (compare < names[nameIdx].compareTo(names[i]))
				{
					compare = names[nameIdx].compareTo(names[i]);
					compIdx = i;

				}
			temp = names[nameIdx];
			names[nameIdx] = names[compIdx];
			names[compIdx] = temp;
			nameIdx++;

			for (int i = 0; i < 5; i++)
			{
				System.out.println(names[i]);

			}
			System.out.println();
		}

	}
}
