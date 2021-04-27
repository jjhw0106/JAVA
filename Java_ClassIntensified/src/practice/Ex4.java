package practice;

import java.util.Scanner;

class Seat {
	boolean check;

	void showData() {
		if (check == true)
			System.out.print("■ ");
		else
			System.out.print("□ ");
	}
}

public class Ex4 {
	public static void main(String[] args) {
		Seat[] s = new Seat[8];

		for (int i = 0; i < s.length; i++) {
			s[i] = new Seat();
		}
		Scanner sc = new Scanner(System.in);

		while (true) {
			for (int i = 0; i < s.length; i++)
				s[i].showData();
			System.out.print("자리를 선택하세요: ");
			int sel = sc.nextInt();
			if (s[sel].check == false) {
				s[sel].check = true;
			} else {
				System.out.println("예매된 자리입니다.");
			}
		}
	}
}