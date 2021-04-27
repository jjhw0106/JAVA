package megastudy_test4;

import java.util.Scanner;

//start 1:25 end 1:45
public class Admin {
	/*
	 * # 쇼핑몰 [관리자]
	 * 1. 카테고리와 아이템을 입력받아 아래의 예시와 같이 저장한다.
	 * 2. 카테고리는 각 행의 첫번째 열에 저장한다.
	 * 3. 아이템은 각 행의 두번째 열에 저장한다.
	 *    단, 아이템은 여러개를 추가할 수 있도록 슬러시(/)를 구분자로 연결해준다.
	 * 예)
	 * {
	 * 		{"과일", "사과/포도/"},
	 * 		{"과자", "홈런볼/쪼리퐁/"},
	 * 		{"음료", "콜라/"},
	 * 		{"육류", "소고기/"}
	 * 		...
	 * } 
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String[][] items = new String[100][2];
		for (int i = 0; i < items.length; i++) {
			items[i][0] = "";
			items[i][1] = "";
		}

		int itemCount = 0;

		while (true) {

			System.out.println("[관리자 모드]");
			System.out.println("[1]카테고리 관리");
			System.out.println("[2]아 이 템  관리");
			System.out.println("[3]전체품목 출력");
			System.out.print(": ");
			int sel = sc.nextInt();
			System.out.println();
			if (sel == 1) {
				System.out.print("추가할 카테고리는? :");
				items[itemCount][0] = sc.next();
				itemCount++;
			}

			else if (sel == 2) {
				System.out.print("카테고리: ");
				int num = sc.nextInt() - 1;

				String product = sc.next();

				if (num < itemCount) {
					items[num][1] = product + "/" + items[num][1];
				}
			}

			else if (sel == 3) {
				for (int i = 0; i < itemCount; i++) {
					System.out.print(items[i][0] + " " + items[i][1]);
					System.out.println();
				}
			}

		}
	}
}
