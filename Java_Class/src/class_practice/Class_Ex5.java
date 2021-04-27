package class_practice;

import java.util.Scanner;

class Ex05 {
	String name = "";

	int[] arHakbun = { 1001, 1002, 1003, 1004, 1005 };
	int[] arScore = { 92, 38, 87, 100, 11 };

}

public class Class_Ex5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Ex05 mega = new Ex05();

		mega.name = "홍길동";
		System.out.println("=== " + mega.name + "===");
		while (true) {

			System.out.println("1.전교생 성적확인");
			System.out.println("2.1등학생 성적확인");
			System.out.println("3.꼴등학생 성적확인");
			System.out.println("4.성적확인하기");
			System.out.println("5.종료하기");
			int sel = sc.nextInt();

			if (sel == 1) {
				for (int i = 0; i < mega.arScore.length; i++) {
					System.out.println(mega.arHakbun[i] + " : " + mega.arScore[i]);
				}
			}

			else if (sel == 2) {
				int high = mega.arScore[0];
				int highIdx = 0;
				for (int i = 0; i < mega.arScore.length; i++)
					if (high < mega.arScore[i]) {
						high = mega.arScore[i];
						highIdx = i;
					}
				System.out.println("1등: " + mega.arHakbun[highIdx] + " : " + mega.arScore[highIdx]);
			}

			else if (sel == 3) {
				int low = mega.arScore[0];
				int lowIdx = 0;
				for (int i = 0; i < mega.arScore.length; i++)
					if (low > mega.arScore[i]) {
						low = mega.arScore[i];
						lowIdx = i;

					}
				System.out.println("꼴등: " + mega.arHakbun[lowIdx] + " : " + mega.arScore[lowIdx]);
			} else if (sel == 4) {
				System.out.println("학번 입력: ");
				int hakbun = sc.nextInt();
				for (int i = 0; i < mega.arHakbun.length; i++) {
					if (hakbun == mega.arHakbun[i]) {
						System.out.println(mega.arScore[i] + "점");
						break;
					}
				}
			}
		}
	}
}
