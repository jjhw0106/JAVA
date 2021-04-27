package practice;

import java.util.Random;

class Lotto {
	int[] data = new int[8];
	boolean win = false;

	void print() {
		for (int i = 0; i < data.length; i++)
			System.out.print(data[i] + " ");
	}
}

public class Ex6_LottoSet {
	public static void main(String[] args) {
		Random ran = new Random();
		Lotto[] lotto = new Lotto[5];
		for (int i = 0; i < lotto.length; i++)
			lotto[i] = new Lotto();

		boolean check = false;

		int n = 0;
		int cnt = 0;
		while (true) {
			if (n == lotto.length - 1)
				break;
			for (int i = 0; i < lotto[n].data.length; i++) {
				int rNum = ran.nextInt(2);
				if (rNum == 0) {
					lotto[n].data[i] = 0;
				} else
					lotto[n].data[i] = 3;
			}

			for (int i = 0; i < lotto[n].data.length; i++) {
				if (lotto[n].data[i] == 3) {
					cnt++;
					if (cnt == 3) {
						lotto[n].win = true;
						break;
					}
				} else
					cnt = 0;
			}
			if (check == false && lotto[n].win == true) {
				check = true;
				n++;
			} else if (check == true && lotto[n].win == false)
				n++;

		}
		for (int i = 0; i < 5; i++)
			lotto[i].print();
	}
}