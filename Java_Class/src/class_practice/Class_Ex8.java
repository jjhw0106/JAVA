package class_practice;

/*
 * # 숫자이동[3단계] : 클래스 + 변수
 * 1. 숫자2는 캐릭터이다.
 * 2. 숫자1을 입력하면, 캐릭터가 왼쪽으로
 * 	    숫자2를 입력하면, 캐릭터가 오른쪽으로 이동한다.
 * 3. 숫자 1은 벽이다. 벽을 만나면 이동할 수 없다.
 * 4. 단, 숫자3을 입력하면, 벽을 격파할 수 있다.
 * 5. 좌우 끝에 도달해도 계속 반대편으로 이동이 가능하다.
 * 예) 
 *  0 0 0 0 0 0 0 2 
 *  왼쪽(1) 오른쪽(2) : 2
 *  
 *  2 0 0 0 0 0 0 0 
 */
import java.util.Scanner;

class Object {
	int map[] = { 0, 0, 1, 0, 0, 2, 0, 0, 1, 0 };

}

public class Class_Ex8 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Object game = new Object();
		int userPos = 0;
		int tempPos = 0;

		for (int i = 0; i < game.map.length; i++) {
			if (game.map[i] == 2)
				userPos = i;
		}

		int sel = 0;
		int dir = 2;
		while (true) {
			for (int i = 0; i < game.map.length; i++) {
				if (i == userPos)

					System.out.print(2 + " ");
				else
					System.out.print(game.map[i] + " ");
			}
			System.out.println("이동: ");
			sel = sc.nextInt();
			
			//이동
			if (sel == 2) {
				game.map[userPos] = 0;
				tempPos = userPos;	//이동 전 user위치 저장
				userPos++;
				dir = 2;	//벽 격파 방향을 위해 지정
			} 
			
			else if (sel == 1) {
				game.map[userPos] = 0;
				tempPos = userPos;
				userPos--;
				dir = 1;
			} 
			
			//벽 뿌시기
			else if (sel == 3) {
				if (dir == 2)	
					game.map[userPos + 1] = 0;
				else if (dir == 1)
					game.map[userPos - 1] = 0;
			}

			
			//
			if (userPos == -1)
				userPos = game.map.length - 1;
			if (userPos == game.map.length)
				userPos = 0;

			if (game.map[userPos] == 1) {
				userPos = tempPos;
				continue;
			}

		}

	}
}
