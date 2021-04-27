package class_practice;

import java.util.Scanner;
import java.util.Random;

/*
 * # 사다리 게임
 * 1. 0을 만나면 아래로 내려간다.
 * 2. 1일 때에는 좌우를 검사해 1인 쪽으로 이동 후 아래로 내려간다.
 * 3. x의 위치를 입력받고 사다리를 표현한다.

 */
class Ex12 {
	int ladder[][] = { { 0, 0, 0, 0, 0 }, { 1, 1, 0, 1, 1 }, { 0, 0, 0, 0, 0 }, { 0, 0, 1, 1, 0 }, { 1, 1, 0, 1, 1 },
			{ 0, 1, 1, 0, 0 }, { 0, 0, 1, 1, 0 }, { 0, 0, 0, 1, 1 }, { 0, 0, 0, 0, 0 } };

	int x = 0;
	int y = 0;
	String[] menu = { "죠스떡볶이", "CU편의점", "마라탕", "김밥천국", "명인만두" };
}

public class Class_Ex12 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Ex12 sadari = new Ex12();

		for (int i = 0; i < sadari.menu.length; i++) {
			System.out.println(sadari.menu[i]);
		}

		for (int i = 0; i < sadari.ladder[0].length; i++) {
			System.out.print(" " + (i + 1) + " ");
		}
		System.out.println();
		for (int j = 0; j < sadari.ladder.length; j++) {
			for (int k = 0; k < sadari.ladder[j].length; k++) {
				if (sadari.ladder[j][k] == 0) {
					System.out.print(" │ ");
				} else if (k != 0 && sadari.ladder[j][k] == 1 && sadari.ladder[j][k - 1] == 1) {
					System.out.print("─┤ ");
				} else if (k != sadari.ladder[j].length - 1 && sadari.ladder[j][k] == 1
						&& sadari.ladder[j][k + 1] == 1) {
					System.out.print(" ├─");
				}
			}
			System.out.println();
		}
		System.out.println();

		System.out.print("번호 선택[1~5] : ");
		sadari.x = scan.nextInt();
		sadari.x -= 1;

		for (int i = 0; i < sadari.ladder.length; i++) {

			if (sadari.x != sadari.ladder[0].length - 1 && sadari.ladder[sadari.y][sadari.x] == 1
					&& sadari.ladder[sadari.y][sadari.x + 1] == 1) {
				sadari.x += 1;

			} else if (sadari.x != 0 && sadari.ladder[sadari.y][sadari.x] == 1
					&& sadari.ladder[sadari.y][sadari.x - 1] == 1) {
				sadari.x -= 1;
			}
			sadari.y += 1;
		}

		System.out.println(sadari.menu[sadari.x] + "당첨");

	}
}