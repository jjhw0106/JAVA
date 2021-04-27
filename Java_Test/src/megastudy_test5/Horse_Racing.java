package megastudy_test5;

import java.util.Random;
import java.util.Scanner;

public class Horse_Racing {
	// # 경마 게임
	// 5마리의 말이 랜덤으로 한번에 일정거리 이동가능하다
	// 이동한거리의 합이 20이상이면 도착
	// 등수 출력
	// 조건) 단! 동시도착 예외처리
	public static void main(String[] args) {

		int horse[][] = new int[5][20]; // 말 찍기 위해
		Random ran = new Random();
		int max = 20;
		int rank[] = new int[5]; // 말의 랭킹
		int total[] = new int[5]; // 말의 위치

		final int HORSE = 9;

		// 말 출발선 위치
		for (int i = 0; i < horse.length; i++) {
			horse[i][0] = HORSE;
		}

		// 말 뛰기 출력
		int count = 1;
		int round = 0;
		while (true) {
			System.out.println("라운드 " + round);
			round++;

			for (int i = 0; i < horse.length; i++) {
				for (int j = 0; j < horse[i].length; j++) {
					if (horse[i][j] == HORSE)
						System.out.print("M");
					else
						System.out.print("▤");
				}
				System.out.println();
				System.out.println();
			}
		}
	}
}

////////////////////////1차 풀이/////////////////////////////////

//	public static void main(String[] args) {
//
//		final int HORSE = 9;
//		int horse[][] = new int[5][20]; // 말 찍기 위해
//		Random ran = new Random();
//		int max = 20;
//		int rank[] = new int[5]; // 말의 랭킹
//		int total[] = new int[5]; // 말의 위치
//
//		int count = 1;
//		int check = 0;
//
//		for (int i = 0; i < horse.length; i++)
//			horse[i][0] = HORSE;
//
//		int turn = 0;
//		while (true) {
//			turn++;
//			System.out.println("turn " + turn);
//			for (int i = 0; i < horse.length; i++) {
//				System.out.print(i + 1 + "번 말.[ ");
//
//				for (int j = 0; j < horse[0].length; j++) {
//					if (horse[i][j] == HORSE)
//						System.out.print("h ");
//					else
//						System.out.print("■ ");
//				}
//				System.out.println();
//				System.out.println();
//			}
//
//			if (count == 6)
//				break;
//
//			for (int i = 0; i < horse.length; i++) { // 1.말 발자취 지우기
//				if (total[i] != 0)
//					horse[i][total[i] - 1] = 0;
//				else if (total[i] == 0)
//					horse[i][total[i]] = 0;
//			}
//
//			int overCnt = 0;
//			for (int i = 0; i < horse.length; i++) { // 2.말 위치받기
//				int dis = ran.nextInt(4); //
//				total[i] += dis;
//				if (total[i] >= max) {
//					if (total[i] - dis != max) { // 이전에 도착한 말이 아니면...
//						total[i] = max;
//
//						if (overCnt >= 1) { // 2
//							total[i] -= dis;
//							i--;
//							continue;
//						}
//						overCnt++;
//						rank[i] = count;
//						count++;
//						System.out.println("카운트는" + count);
//
//					} else {
//						total[i] = max;
//					}
//				}
//			}
//
//			for (int i = 0; i < horse.length; i++) { // 3.말 위치 출력용
//				if (total[i] != 0)
//					horse[i][total[i] - 1] = HORSE;
//			}
//		}
//		for (int i = 0; i < total.length; i++)
//			System.out.println(i + 1 + "번 말 " + rank[i] + "등");
//	}
//}

//////////////////////////////////////////////////////////////////////