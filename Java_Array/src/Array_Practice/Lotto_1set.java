package Array_Practice;

import java.util.Random;

public class Lotto_1set {
	public static void main(String[] args) {
		Random ran = new Random();

		final int SNSIZE = 5; // 복권 번호 (set number)
		final int LNSIZE = 7; // 당첨 번호 (lotto number)

		int[][] lottoSet = new int[SNSIZE][LNSIZE];

		int sn = 0;
		int ln = 0;

		/*
		 * 3번째 복권이 당첨복권
		  	sn이 3이면 3이 세번 연속 출력
		 	sn이 3이 아니면 3은 세번 연속 불가
		 	3이 아닐때 3이 연속으로 3번 못나오게 처리
		 	화면 출력시 sn을 무작위 순서로 재배치
		 */
		while (sn < SNSIZE)
		{
			// 미당첨 복권 (3번 제외한 복권)
			if (sn != 2) // 3번째 복권이 당첨복권
			{
				for (int i = 0; i < LNSIZE; i++)
				{
					int input = ran.nextInt(10);
					lottoSet[sn][i] = input;
				}
				for (int j = 0; j < LNSIZE - 2; j++) // j+2까지 검색해야하므로 LNSIZE-2
				{
					if (lottoSet[sn][j] == 3 && lottoSet[sn][j + 1] == 3 && lottoSet[sn][j + 2] == 3)
						lottoSet[sn][j + 2] += ran.nextInt(6) + 1; // (Q.) 3이 연속일 경우 마지막 3 강제 변환
				}
			}

			// 당첨복권 (3번째 당첨복권)
			else
			{
				int first3 = ran.nextInt(LNSIZE - 3); // 당첨 복권에서 3이 처음 시작하는 위치
				for (int i = 0; i < LNSIZE; i++)
					if (i != first3 && i != first3 + 1 && i != first3 + 2)
						lottoSet[sn][i] = ran.nextInt(10);
					else
						lottoSet[sn][i] = 3;
			}
			sn++;
		}
		// 윗 코드들 확인용
		for (int i = 0; i < SNSIZE; i++)
		{
			for (int j = 0; j < LNSIZE; j++)
				System.out.print(lottoSet[i][j] + " ");
			System.out.println();
		}
		System.out.println();

		// 로또 배열 출력 (중복안되게 sn 섞기 (당첨복권이 꼭 3번째 위치가 아니게 하기 위해))
		int count = 0;
		int[] order = new int[5];
		int check = 0;
		int num = 0;

		while (count < SNSIZE)
		{
			check = 1;
			num = ran.nextInt(SNSIZE);

			for (int i = 0; i < count; i++) //Q.count+1부터 무한루프 이유??
			{
				if (num == order[i])
				{
					check = -1;
					break;
				}
			}

			if (check == 1)
			{
				order[count] = num;
				count++;
			}

		}
		for (count = 0; count < SNSIZE; count++)
		{
			for (int j = 0; j < LNSIZE; j++)
				System.out.print(lottoSet[order[count]][j] + " ");
			System.out.println();
		}
	}
}

/*// 랜덤(lotto의 index)으로 로또를 출력
		int order[] = new int[5]; // 중복되지 않는 index를 저장
		int i=0;
		while(i<order.length) {
			int rIdx = ran.nextInt(5);
			
			int check = 1;
			for(int j=0; j<order.length; j++) {
				if(rIdx == order[j]) {
					check = -1;
				}
			}
			
			System.out.println("rIdx : " + rIdx);
			if(check == 1) {
				order[i] = rIdx;
				i += 1;
			} 
		}
		
		// 확인
		for(int k=0; k<order.length; k++) {
			System.out.println(order[k]);
		}*/