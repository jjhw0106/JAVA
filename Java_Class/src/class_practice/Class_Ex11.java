package class_practice;

import java.util.Scanner;
import java.util.Random;

class Board {
	int size;
	int map[];
	int front[];
	int back[];
}

/* 
 * # 1 to 50[3단계] : 1 to 18
 * 1. 구글에서 1 to 50 이라고 검색한다.
 * 2. 1 to 50 순발력 게임을 선택해 게임을 실습해본다.
 * 3. 위 게임을 숫자범위를 좁혀 1 to 18로 직접 구현한다.
 * 4. 숫자 1~9는 front 배열에 저장하고,
 *    숫자 10~18은 back 배열에 저장한다.
 */
public class Class_Ex11 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random ran = new Random();
		Board game = new Board();

		game.size = 18;
		game.map = new int[game.size / 2];

		// front 들어갈 숫자
		int cnt = 0;
		int fNum[] = new int[game.size / 2];
		while (true) {
			if (cnt == game.size / 2)
				break;

			int rNum = ran.nextInt(game.size / 2) + 1;
			fNum[cnt] = rNum;
			for (int i = 0; i < cnt; i++)
				if (rNum == fNum[i])
					cnt--;
			cnt++;

		}

		// back 들어갈 숫자
		cnt = 0;
		int bNum[] = new int[game.size / 2];
		while (true) {
			if (cnt == game.size / 2)
				break;

			int rNum = ran.nextInt(game.size / 2) + (1 + game.size / 2);
			bNum[cnt] = rNum;
			for (int i = 0; i < cnt; i++)
				if (rNum == bNum[i])
					cnt--;
			cnt++;

		}

		// front, back에 넣기
		game.front = new int[game.size / 2];
		game.back = new int[game.size / 2];
		for (int i = 0; i < game.size / 2; i++) {
			game.front[i] = fNum[i];
			game.back[i] = bNum[i];
		}

		for (int i = 0; i < game.map.length; i++)
			game.map[i] = game.front[i];

		// 게임실행///////
		cnt = 1;
		while (true) {
			// 출력
			for (int i = 0; i < game.size / 2; i++) {
				System.out.print(game.map[i] + " ");
				if (i % 3 == 2)
					System.out.println();
			}

			int num = sc.nextInt() - 1;
			if (cnt <= game.size / 2) {
				if (game.map[num] == cnt) {
					game.map[num] = game.back[num];
					cnt++;
				} else {
					System.out.println("Game Over");
					break;
				}
			} else {
				if (game.map[num] == cnt) {
					game.map[num] = 0;
					cnt++;
				} else {
					System.out.println("Game Over");
					break;
				}
			}

		}
	}
}
