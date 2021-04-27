package Array_Practice;

public class Grade_Ranking {
	public static void main(String[] args) {
		final int SIZE = 5;
		String[] name = { "홍길동", "김영", "자바킹", "민병철", "메가맨" };
		int[] score = { 87, 42, 100, 11, 98 };
		int cnt = 0;
		int max = 0;
		int idx = 0;

		while (cnt<SIZE)
		{
			max = 0;
			for (int i = cnt; i < SIZE; i++)
				if (max <= score[i])
				{
					max = score[i];
					idx = i;
				}

			int temp = score[cnt];
			String ntemp = name[cnt];

			score[cnt] = score[idx];
			name[cnt] = name[idx];

			score[idx] = temp;
			name[idx] = ntemp;

			cnt++;
		}
		
		for (int i = 0; i < SIZE; i++)
			{
			System.out.print(i+1+"등");
			System.out.print(" "+ name[i]);
			System.out.println(" " + score[i]);
			}

	

	}
}
