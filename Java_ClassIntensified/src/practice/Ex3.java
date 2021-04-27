package practice;

import java.util.Random;

class RanNum {
	int num;
	boolean check;

}

public class Ex3 {
	public static void main(String[] args) {
		Random ran = new Random();

		RanNum[] arr = new RanNum[5];

		for (int i = 0; i < 5; i++) {
			arr[i] = new RanNum();
		}
		for (int i = 0; i < 5; i++) {
			int rNum = ran.nextInt(5);
			if (arr[rNum].check == false) {
				arr[rNum].check = true;
				arr[rNum].num = i + 1;
			} else
				i--;
		}
		for (int i = 0; i < 5; i++) {
			System.out.println(arr[i].num);
		}
	}
}
