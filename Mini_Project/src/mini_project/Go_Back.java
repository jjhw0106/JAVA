package mini_project;

import java.util.Scanner;

//	//문제1) 0 이 플레이어이다 
//	// 1) left 2)right 3)up 4)down 5)되감기
//	//번호를 입력받고 해당위치로 이동 ==> 이동할때 값을 서로 교환한다. 
//	// 예) 1 ==> 
//	/*
//	    {1,2,3,4},
//		{5,6,7,8},
//		{9,10,11,12},
//		{13,14,0,15}		
//	 */
//	
//	//문제2) 심화  ==> 한칸한칸이동할때마다 yx 에 배열에 이동한경로를 저장했다가 
//	// 5번입력시 ==> 왔던길로 되돌아가기 한다. 
public class Go_Back {
	public static void main(String[] args) {

//		이동->게임배열 체크(0이면 check= 1 아니면 0)
//		check가 1이면 xpos,ypos 받아서 yx에[ypos][xpos];

		Scanner sc = new Scanner(System.in);

		int game[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 0 } };
		int sero = game.length;
		int garo = game[0].length;
		int check[][] = new int[game.length][game.length];
		int yx[][] = new int[10000][2];

		int yPos = 0;
		int xPos = 0;
		boolean run = true;
		int cnt = 0;
		int sel = 0;

		while (run) {
			for (int i = 0; i < game.length; i++) {
				for (int j = 0; j < game[0].length; j++) {
					System.out.print(game[i][j] + "\t");
				}
				System.out.println();
			}

			// 경로저장
			for (int i = 0; i < game.length; i++) {
				for (int j = 0; j < game[0].length; j++) {
					if (game[i][j] == 0) {
						check[i][j] = 1;
						yPos = i;
						xPos = j;
						yx[cnt][0] = j;
						yx[cnt][1] = i;
					}
				}
			}

			System.out.println("1) left 2)right 3)up 4)down 5)되감기");
			sel = sc.nextInt();
			if (sel == 1) {
				if (xPos == 0)
					continue;
				int temp = game[yPos][xPos - 1];
				game[yPos][xPos - 1] = game[yPos][xPos];
				game[yPos][xPos] = temp;

			} else if (sel == 2) {
				if (xPos == garo - 1)
					continue;
				int temp = game[yPos][xPos + 1];
				game[yPos][xPos + 1] = game[yPos][xPos];
				game[yPos][xPos] = temp;
			} else if (sel == 3) {
				if (yPos == 0)
					continue;
				int temp = game[yPos - 1][xPos];
				game[yPos - 1][xPos] = game[yPos][xPos];
				game[yPos][xPos] = temp;

			} else if (sel == 4) {
				if (yPos == sero - 1)
					continue;
				int temp = game[yPos + 1][xPos];
				game[yPos + 1][xPos] = game[yPos][xPos];
				game[yPos][xPos] = temp;

			} else if (sel == 5) {
				if (cnt < 1)
					continue;
				int tempX = yx[cnt - 1][0];
				int tempY = yx[cnt - 1][1];
				int temp = game[yPos][xPos];
				game[yPos][xPos] = game[tempY][tempX];
				game[tempY][tempX] = temp;
				cnt--;
			} else if (sel == 6)
				break;

			if (sel != 5)
				cnt++; // if문의 continue에 걸려서 cnt가 안올라감 ***

			System.out.println("경로: ");
			for (int i = 0; i < cnt; i++) {
				System.out.println("(" + yx[i][0] + " , " + yx[i][1] + ")" + " ");
			}

		}
	}
}