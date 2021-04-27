package megastudy_test4;

// 1)left , 2)right

//문제1)번호를 입력받고 각방향으로 숫자를모으시요.
//조건) 만약에 같은숫자2개가 붙었을경우는 서로 더해진다.
// 아래 2단계출력 
//예) left 
//      1단계 :  {2,2,8,4,0,0,0,0,0}; 
//      2단계 :  {4,8,4,0,0,0,0,0,0}; 2가 2개붙었으니 4가된다.

//start 6:17
import java.util.Scanner;

public class Test3_Arr {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		final int LEFT = 1;
		final int RIGHT = 2;

//		int game[] = { 2, 0, 1, 3, 2, 2, 0, 4, 0 };

//		숫자 입력
//		방향 입력
//		숫자 몰아서 정렬
//		같으면 합

		// 숫자입력
		int[] game = new int[8];
		int input = 0;
		for (int i = 0; i < game.length; i++) {
			input = sc.nextInt();
			game[i] = input;
		}

		// 숫자정렬
		System.out.println("정렬방향: ");
		int way = sc.nextInt();

		// 왼쪽으로 보내기
		if (way == LEFT) {
			for (int i = 0; i < game.length; i++)
				for (int j = i; j < game.length; j++) {
					if (game[j] != 0) {
						int temp = game[i];
						game[i] = game[j];
						game[j] = temp;
						break;
					}
				}

			boolean run = true;
			while (run) // 합쳐진 숫자 다시 체크하기 위해(더이상 정렬할게 없으면 break)
			{
				run = false;
				for (int i = 0; i < game.length; i++)
					if (game[i] != 0 && game[i] == game[i + 1]) {
						run = true;
						break;
					}

				int check = 1;
				int temp = 0;
				int[] tempArr = new int[game.length];

				int idx = 0;
				for (int i = 0; i < game.length; i++) {
					if (i == 0)
						temp = game[0];
					if (i > 0) {
						if (temp != 0 && temp == game[i]) {
							check++;
							game[i] = 0;
						} else if (temp != 0 && temp != game[i]) {
							tempArr[idx] = temp * check;
							check = 1;
							temp = game[i];
							idx++;

						}
					}

				}
				game = tempArr;
			}

			// 오른쪽으로 보내기
		} else if (way == RIGHT) {
			for (int i = 0; i < game.length; i++)
				for (int j = game.length - 1 - i; j > -1; j--) {
					if (game[j] != 0) {
						int temp = game[game.length - 1 - i];
						game[game.length - 1 - i] = game[j];
						game[j] = temp;
						break;

					}

				}

			boolean run = true;
			while (run == true) // 합쳐진 숫자 다시 체크하기 위해
			{
				run = false;
				for (int i = game.length - 1; i > -1; i--)
					if (game[i] != 0 && game[i] == game[i - 1]) {
						run = true;
						break;
					}

				int check = 1;
				int temp = 0;
				int[] tempArr = new int[game.length];

				int idx = game.length - 1;
				for (int i = game.length - 1; i > -1; i--) {
					if (i == game.length - 1)
						temp = game[game.length - 1];
					if (i < game.length - 1) {
						if (temp != 0 && temp == game[i]) {
							check++;
							game[i] = 0;
						} else if (temp != 0 && temp != game[i]) {
							tempArr[idx] = temp * check;
							check = 1;
							temp = game[i];
							idx--;

						}
					}

				}
				game = tempArr;
			}

		}

		for (int i = 0; i < game.length; i++)
			System.out.print(game[i] + " ");

	}
}
