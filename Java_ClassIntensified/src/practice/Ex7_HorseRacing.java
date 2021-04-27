package practice;

import java.util.Scanner;
import java.util.Random;

class Horse {
	int num = 0;
	int pos = 0;
	int rank = 0;
}

class Racing {
	Random ran = new Random();
	int horseCnt = 5;
	Horse[] h = new Horse[horseCnt];
	int lineLength = 20;
	int getRank = 1;
//	int line[][] = new int[horseCnt][lineLength];

	void run() {
		for (int i = 0; i < 5; i++) {
			h[i] = new Horse();
			h[i].num = i + 1;
		}
		int arvCnt = 0;
		int rankCnt = 1;
		while (true) {
			show();
			if (arvCnt >= 5)
				break;
			getPos();
			rank();
			for (int i = 0; i < horseCnt; i++) {
				if (h[i].rank == rankCnt && h[i].pos == lineLength - 1) {
					arvCnt++;
					rankCnt++;
				}
			}
			try {
				Thread.sleep(500);
			} catch (Exception e) {
			}

		}
		for (int i = 0; i < horseCnt; i++) {
			System.out.println(i + 1 + "번 말:" + h[i].rank + "등");// test
		}
	}

	void show() {
		for (int i = 0; i < horseCnt; i++) {
			for (int j = 0; j < lineLength; j++) {
				if (j == h[i].pos)
					System.out.print("[" + h[i].num + "]");
				else
					System.out.print("[ ]");
			}
			System.out.println();
		}
		System.out.println();
	}

	void getPos() {
		int arvCnt = 0;
		for (int i = 0; i < horseCnt; i++) {
			if (h[i].pos != lineLength - 1) {
				int temp = h[i].pos;
				temp += ran.nextInt(4);
				if (temp >= lineLength - 1) {
					temp = lineLength - 1;
					arvCnt++;
				}
				if (arvCnt > 1) {
					continue;
				}
				h[i].pos = temp;
			}
		}
	}

	void rank() {
		for (int i = 0; i < horseCnt; i++)
			if (h[i].rank == 0 && h[i].pos == lineLength - 1) {
				h[i].rank = this.getRank;
				getRank++;
			}

	}
}

public class Ex7_HorseRacing {
	public static void main(String[] args) {
		Horse h = new Horse();
		Racing r = new Racing();
		r.run();
	}
}
