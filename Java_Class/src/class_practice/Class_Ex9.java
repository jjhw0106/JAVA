
package class_practice;

import java.util.Random;
import java.util.Scanner;

/*
 * # 기억력 게임 : 클래스 + 변수
 * 1. front 배열 카드 10장을 섞는다.
 * 2. front 배열에서 같은 카드를 골라 카드의 위치를 입력한다.
 * 3. 선택한 2장의 카드가 같은 카드이면, back 배열에 표시한다.
 * 4. 모든 카드가 뒤집히면(back배열의 0이 사라지면) 게임은 종료된다. 
 */

class Card {
	int card[] = { 1, 3, 2, 2, 5, 4, 4, 1, 3, 5 };

}

public class Class_Ex9 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random ran = new Random();
		Card game = new Card();

		int mix[] = new int[game.card.length];
		int rValue = 0;
		int cnt = 0;
		while (true) { // 숫자 섞기
			if (cnt == 10)
				break;
			rValue = ran.nextInt(10) + 1;
			mix[cnt] = rValue;
			for (int i = 0; i < cnt; i++)
				if (rValue == mix[i])
					cnt--;
			cnt++;
		}

		int front[] = new int[game.card.length];
		for (int i = 0; i < front.length; i++)
			front[i] = game.card[mix[i] - 1];
		int back[] = new int[game.card.length];

		while (true) {
			for (int i = 0; i < back.length; i++)
				if (back[i] == 0)
					System.out.print("■" + " ");
				else
					System.out.print(back[i] + " ");

			System.out.print("위치 입력1: ");
			int pos1 = sc.nextInt() - 1;
			System.out.println(front[pos1]);
			System.out.print("위치 입력2: ");
			int pos2 = sc.nextInt() - 1;
			System.out.println(front[pos2]);
			if (front[pos1] != front[pos2])
				System.out.println("숫자 다릅니다");
			else if (front[pos1] == front[pos2]) {
				back[pos1] = game.card[pos1];
				back[pos2] = game.card[pos2];
			}

			int backCnt = 0;
			for (int i = 0; i < back.length; i++)
				if (back[i] != 0)
					backCnt++;
			if (backCnt == 10) {
				System.out.println("게임 끝");
				break;
			}
		}

	}
}