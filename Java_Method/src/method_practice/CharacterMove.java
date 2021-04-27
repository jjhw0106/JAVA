package method_practice;

import java.util.Scanner;
import java.util.Random;

/*
 * # 숫자 이동하기 : 클래스 + 메서드
 * 1. 숫자 8은 캐릭터이다.
 * 2. 숫자 1을 입력하면, 캐릭터가 왼쪽으로 이동한다.
 * 3. 숫자 2를 입력하면, 캐릭터가 오른쪽으로이동한다.
 * 4. 좌우 끝에 도달했을 때 에러가 발생하지 않도록 예외처리를 해준다.
 */

class User {
	Scanner sc = new Scanner(System.in);
	Random ran = new Random();
	int show[] = new int[10];
	int uPos;

	void createChar() {
		uPos = ran.nextInt(show.length);
	}

	void move() {
		System.out.print("이동: ");
		int move = sc.nextInt();
		System.out.println();
		int tempPos = uPos;
		if (move == 1)
			tempPos--;
		else if (move == 2)
			tempPos++;

		if (tempPos < 0)
			tempPos++;
		else if (tempPos > show.length - 1)
			tempPos--;

		uPos = tempPos;
	}

	void getPos() { // 맵에 표시하기 위해
		for (int i = 0; i < show.length; i++) {
			if (i == uPos)
				show[i] = 8;
			else
				show[i] = 0;
		}
	}
	void run() {
		
	}
}


//q. 맵&캐릭터는 항상 출력되어야 하므로 메인에 
public class CharacterMove {
	public static void main(String[] args) {
		User user = new User();
		user.createChar();

		while (true) {
			user.getPos();
			for (int i = 0; i < user.show.length; i++) {
				System.out.print(user.show[i] + " ");
			}
			user.move();
		}
	}
}
