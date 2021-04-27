package method_practice;

import java.util.Scanner;

/*
 * # 영화관 좌석예매 : 클래스 + 메서드
 * 1. 사용자로부터 좌석번호(index)를 입력받아 예매하는 시스템이다.
 * 2. 예매가 완료되면 해당 좌석 값을 1로 변경한다.
 * 3. 이미 예매가 완료된 좌석은 재구매할 수 없다.
 * 4. 한 좌석당 예매 가격은 12000원이다.
 * 5. 프로그램 종료 후, 해당 영화관의 총 매출액을 출력한다.
 * 예)
 * seat = 0 0 0 0 0 0 0
 * 
 * 좌석선택 : 1
 * seat = 0 1 0 0 0 0 0
 * 
 * 좌석선택 : 3
 * seat = 0 1 0 1 0 0 0
 * 
 * 좌석선택 : 3
 * seat = 0 1 0 1 0 0 0
 * 이미 예매가 완료된 자리입니다.
 * ----------------------
 * 매출액 : 24000원
 */
class TheaterFunc {
	Scanner sc = new Scanner(System.in);
	int seat[] = new int[10];
	int total = 0;
	int cnt = 0;

	void reserve() {
		for (int i = 0; i < seat.length; i++)
			System.out.print(seat[i] + " ");

		System.out.println();
		System.out.print("자리선택: ");
		int sel = sc.nextInt() - 1;
		if (seat[sel] == 0)
			seat[sel] = 1;
		else
			System.out.println("예매된 자리입니다.");
	}

	void totalMoney() {

		for (int i = 0; i < seat.length; i++)
			if (seat[i] == 1)
				cnt++;
		total = 12000 * cnt;

	}

	void run() {
		while (true) {
			for (int i = 0; i < seat.length; i++)
				System.out.print(seat[i] + " ");
			System.out.println();
			System.out.println("1. 예매하기");
			System.out.println("2. 종료");
			int sel = sc.nextInt();
			if (sel == 1)
				reserve();
			else if (sel == 2) {
				totalMoney();
				System.out.println("금일 매출액은 " + total + "원 입니다");
				break;
			}
		}
	}
}

public class MovieTheater {
	public static void main(String[] args) {
		System.out.println("영화관");
		TheaterFunc t = new TheaterFunc();
		t.run();

	}
}
