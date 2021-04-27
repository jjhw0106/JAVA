package megastudy_test7;

import java.util.Random;

class Lotto {
	int[] data = new int[8];
	boolean win = false;

	void print() {
		for (int i = 0; i < 8; i++) {
			System.out.print(data[i]);
		}
		System.out.println();
	}
}

class LottoPick {
	Random ran = new Random();
	Lotto lot[] = new Lotto[5];

	void lotInit() {
		for (int i = 0; i < lot.length; i++) {
			lot[i] = new Lotto();
		}
	}

	void lotPick() {
		int cnt = 0;
		int winCheck = 0;
		int winIdx = -1;
		while (true) {
			//다 돌았을 때 당첨 복권 있는 경우
			if (winIdx != -1 && cnt == 5) {
				break;
			}
			//복권 다 돌았는데 당첨 복권x인 경우
			else if (winIdx == -1 && cnt == 5) {	
				cnt = 0;
			}
			//lot 데이터 초기화  
			for (int i = 0; i < 8; i++) {
				lot[cnt].data[i] = ran.nextInt(9) + 1;
			}
			
			for (int i = 0; i < 8; i++) {
				if (lot[cnt].data[i] == 3) {
					winCheck++;
					if (winCheck == 3) {
						break;
					}
				} else if (lot[cnt].data[i] != 3) {
					winCheck = 0;
				}
			}
			if (winCheck >= 3 && winIdx == -1) {
				lot[cnt].win = true;
				winIdx = cnt;
			} else if (winCheck >= 3 && winIdx != -1) {
				cnt--;
			}
			cnt++;
			winCheck = 0;

		}
		for (int i = 0; i < 5; i++) {
			if (lot[i].win == true)
				System.out.println("당첨: " + (i + 1));
		}

	}

	void run() {
		lotInit();
		lotPick();
		for (int i = 0; i < 5; i++) {
			lot[i].print();
		}
	}
}

public class Solution6_LottoSet {

	public static void main(String[] args) {
		LottoPick lp = new LottoPick();
		lp.run();
	}
}


//메가스터디 로또 구현부 정답
//로또 1셋트 (1)
		// 1개는 당첨 4개는 꽝 인 랜덤복권
//		Random ran = new Random();
//		Lotto[] lotto = new Lotto[5];
//		boolean check = false;
//		int n = 0;
//		while (n < 5) {
//			lotto[n] = new Lotto();
//			for (int i = 0; i < 8; i++) {
//				int r = ran.nextInt(2);
//				if (r == 0) {
//					lotto[n].data[i] = 0;
//				} else {
//					lotto[n].data[i] = 3;
//				}
//			}
//			int count = 0;
//			for (int i = 0; i < 8; i++) {
//				if (lotto[n].data[i] == 3) {
//					count += 1;
//					if (count == 3) {
//						lotto[n].win = true;
//						break;
//					}
//				} else {
//					count = 0;
//				}
//			}
//			if (check == false && lotto[n].win == true) {
//				check = true;
//				
//				n += 1;
//			} else if (check == true && lotto[n].win == false) {
//				
//				n += 1;
//			}
//		}
//		
//		for(int i = 0; i < 1000; i++) {
//			int r = ran.nextInt(5);
//			Lotto temp = lotto[0];
//			lotto[0] = lotto[r];
//			lotto[r] = temp;
//		}
//		
//		for(int i = 0; i < 5; i++) {
//			lotto[i].print();
//		}
//		
//	}
//}
