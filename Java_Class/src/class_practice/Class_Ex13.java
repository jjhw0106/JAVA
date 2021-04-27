package class_practice;

import java.util.Scanner;
import java.util.Random;

/*
 * # 더하기 게임
 * 1. 1부터 10 사이의 랜덤한 값을 중복 없이 game 배열에 6개 저장한다.
 * 2. 6개의 배열의 인덱스를 0부터 5사이의 랜덤 값 3개를 중복 없이 선택해 
       그 인덱스의 값 의 합을 출력한다. 
 * 3. 사용자는 중복없이 3개의 인덱스를 골라 그 합을 맞추는 게임이다.
*  예)  4, 7, 5, 3, 2, 9  //   문제:  14   ==> 인덱스 3개를 골라서 합을 맞추면된다.  
    정답)  3,4,5 (여러가지 경우의 수가 나올수는있다)
 */
class Ex15 {
	int game[] = new int[6];
	int cpu[] = new int[3];
	int choice[] = new int[3];
	int total = 0;

}

public class Class_Ex13 {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		Random ran = new Random();

		Ex15 e = new Ex15();

		for (int i = 0; i < e.game.length; i++) {
			int r = ran.nextInt(10) + 1;

			int check = 1;
			for (int j = 0; j < i; j++) {
				if (e.game[j] == r) {
					check = -1;
				}
			}

			if (check == 1) {
				e.game[i] = r;
			} else {
				i -= 1;
			}
		}

		System.out.print("보기판:  ");
		for (int i = 0; i < e.game.length; i++) {
			System.out.print(e.game[i] + " ");
		}
		System.out.println();

		for (int i = 0; i < e.cpu.length; i++) {
			int r = ran.nextInt(e.game.length);

			int check = 1;
			for (int j = 0; j < i; j++) {
				if (e.cpu[j] == r) {
					check = -1;
				}
			}

			if (check == 1) {
				e.cpu[i] = r;
				e.total += e.game[r];
			} else {
				i -= 1;
			}
		}
		System.out.print("cpu:  ");
		for (int i = 0; i < e.cpu.length; i++) {
			System.out.print(e.cpu[i] + " ");
		}
		System.out.println();

		System.out.println("cpu 합: " + e.total);

		while (true) {

			int total = 0;
			for (int i = 0; i < e.choice.length; i++) {
				System.out.print((i + 1) + ".인덱스 입력 : ");
				int idx = scan.nextInt();

				int check = 1;
				for (int j = 0; j < i; j++) {
					if (e.choice[j] == idx) {
						check = -1;
					}
				}

				if (check == 1) {
					e.choice[i] = idx;
					total += e.game[idx];
				} else {
					i -= 1;
				}
			}

			if (e.total == total) {
				System.out.println("정답!");
				break;
			} else {
				System.out.println("땡!");
			}

		}

	}
}