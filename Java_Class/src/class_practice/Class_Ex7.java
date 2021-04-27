package class_practice;

/*
 * # 영화관 좌석예매 : 클래스 + 변수
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
import java.util.Scanner;

class Ex07 {
	int seat[] = new int[7];
	int total = 0;
}

public class Class_Ex7 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Ex07 reserve = new Ex07();

		while (true) {

			System.out.println("[MEGA MOVIE]");
			System.out.println("[1]좌석예매");
			System.out.println("[2]종료하기");
			for (int i = 0; i < reserve.seat.length; i++)
				System.out.print(reserve.seat[i] + " ");
			System.out.println();
			System.out.println("총 매출액: " + reserve.total);
			System.out.println();
			System.out.print("메뉴 선택 : ");

			int sel = sc.nextInt();

			if (sel == 1) {
				System.out.println("좌석을 선택하세요 ");
				int choose = sc.nextInt() - 1;
				if (reserve.seat[choose] != 0) {
					System.out.println("예매 완료 자리입니다");
					continue;
				}
				reserve.seat[choose] = 1;
				reserve.total += 12000;

			} else if (sel == 2) {
				break;
			}
		}

	}

}
