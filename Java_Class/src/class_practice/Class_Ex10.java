package class_practice;

/* 
 * # 틱택토
 * === 틱택토 ===
 * [X][X][O]
 * [ ][O][ ]
 * [ ][ ][ ]
 * [p1]인덱스 입력 : 6
 * === 틱택토 ===
 * [X][X][O]
 * [ ][O][ ]
 * [O][ ][ ]
 * [p1]승리
 * 
 */
import java.util.Scanner;

class Ex10 {
	int map[] = new int[9];
	int p1[];
	int p2[];

}

public class Class_Ex10 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Ex10 tic = new Ex10();
		int turn = 1;
		tic.p1 = new int[9];
		tic.p2 = new int[9];

		int end = -1;
		while (true) {
			if (end == 1)
				break;
			for (int i = 0; i < tic.map.length; i++) {
				if (tic.map[i] == 1)
					System.out.print("[X]" + " ");
				else if (tic.map[i] == 2)
					System.out.print("[O]" + " ");
				else
					System.out.print("[ ]" + " ");
				if (i % 3 == 2)
					System.out.println();
			}

			System.out.print("어디에 두시겠습니까: ");
			if (turn == 1) {
				int pos = sc.nextInt();
				if (tic.map[pos] != 0) {
					System.out.println("다시");
					continue;
				}
				tic.map[pos] = 1;
				turn = 2;
			} else if (turn == 2) {
				int pos = sc.nextInt();
				if (tic.map[pos] != 0) {
					System.out.println("다시");
					continue;
				}
				tic.map[pos] = 2;
				turn = 1;
			}

			// 승리조건
			for (int i = 0; i < 2; i++)
				if (tic.map[0 + 3 * i] != 0 && tic.map[0 + 3 * i] == tic.map[1 + 3 * i]
						&& tic.map[0 + 3 * i] == tic.map[2 + 3 * i])
					end = 1;

			for (int i = 0; i < 2; i++)
				if (tic.map[0 + i] != 0 && tic.map[0 + i] == tic.map[3 + i] && tic.map[0 + i] == tic.map[6 + i])
					end = 1;

			if (tic.map[0] != 0 && tic.map[0] == tic.map[4] && tic.map[0] == tic.map[8])
				end = 1;
			if (tic.map[2] != 0 && tic.map[2] == tic.map[4] && tic.map[2] == tic.map[6])
			System.out.println("end: " + end);
		}
		System.out.println(turn % 2 + 1 + " 승리");
	}
}
