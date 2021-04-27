package method_practice;

/*
 * # 기억력 게임 : 클래스 + 메서드
 * 1. front 배열 카드 10장을 섞는다.
 * 2. front 배열에서 같은 카드를 골라 카드의 위치를 입력한다.
 * 3. 선택한 2장의 카드가 같은 카드이면, back 배열에 표시한다.
 * 4. 모든 카드가 뒤집히면(back배열의 0이 사라지면) 게임은 종료된다. 
 */
import java.util.Scanner;
import java.util.Random;

class MemoryFunc {
	Scanner sc = new Scanner(System.in);
	Random ran = new Random();

	int[] front;
	int[] back;
	int size = 10;
	int idx1;
	int idx2;

	void initiate() {
		front = new int[size];
		back = new int[size];
		for (int i = 0; i < size / 2; i++) {
			int getNum = ran.nextInt(20);
			front[2 * i] = getNum;
			front[2 * i + 1] = getNum;
			for (int j = 0; j < i; j++)
				if (front[2 * j] == getNum)
					i--;
		}
	}

	void mix() {
		for (int i = 0; i < 50; i++) {
			int mixNum = ran.nextInt(front.length);
			int temp = front[0];
			front[0] = front[mixNum];
			front[mixNum] = temp;
		}
	}

	void show() {
		for (int i = 0; i < front.length; i++) {
			if (back[i] == 0)
				System.out.print("■" + " ");
			else
				System.out.print(back[i] + " ");
		}
	}

	void selectNum() {
		System.out.println("1번 카드: ");
		idx1 = sc.nextInt()-1;
		System.out.println(front[idx1]);
		System.out.println("2번 카드: ");
		idx2 = sc.nextInt()-1;
		System.out.println(front[idx2]);

	}

	void compare() {
		if (front[idx1] == front[idx2]) {
			back[idx1] = front[idx1];
			back[idx2] = front[idx2];
		} else
			System.out.println("다른 카드입니다");
	}

	void run() {
		initiate();
		mix();

		while (true) {
			int check = 1;
			show();
			System.out.println();
			selectNum();
			compare();
			for (int i = 0; i < back.length; i++)
				if (back[i] == 0) {
					check = -1;
				}
			if (check == 1) {
				System.out.println("모두 맞혔습니다");
				break;
			}
		}
	}
}

public class MemoryGame {
	public static void main(String[] args) {
		MemoryFunc test = new MemoryFunc();
		test.run();
	}
}
