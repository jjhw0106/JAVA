package megastudy_practice;
//

public class Sukcha_Test {
	public static void main(String[] args) {
		final int SIZE = 5;
		String[] name = { "홍길동", "김영", "자바킹", "민병철", "메가맨" };
		int[] score = { 87, 42, 100, 11, 98 };

//		1. max로 score돌면서 최대값 get
//		2. max의 값과 score의 idx 저장
//		3. sukcha[i] = score [idx], name[idx]
//		4. loop

		int idx = 0;
		int cnt = 0;
		int max = 0;

		int[] stemp = new int[SIZE];
		String[] ntemp = new String[SIZE];

		while (cnt < SIZE)
		{

			max = 0;
			for (int i = cnt; i < SIZE; i++)
			{
				if (max < score[i])
				{
					max = score[i];
					idx = i;

				}
			}

			stemp[cnt] = score[idx];
			ntemp[cnt] = name[idx];

			score[idx] = score[cnt];
			name[idx] = name[cnt];

			score[cnt] = stemp[cnt];
			name[cnt] = ntemp[cnt];
			cnt++;
		}
		
		
		for (int i = 0; i < SIZE; i++)
			System.out.println(stemp[i]);
		score = stemp;
		name = ntemp;
		for (int i = 0; i < SIZE; i++)
			System.out.println(name[i] + " " + score[i]);
	}
}