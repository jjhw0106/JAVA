package megastudy_test4;

import java.util.Scanner;

//start 02:10 (로그인 로그아웃까지 15분)end 3:30
public class JangBasket {

	/*
	 * # 쇼핑몰 [장바구니]
	 * 1. 로그인 후 쇼핑 메뉴를 선택하면, 다음과 같이 상품목록을 보여준다.
	 * 	1) 사과
	 *  2) 바나나
	 *  3) 딸기
	 * 2. 번호를 선택해 상품을 장바구니에 담을 수 있다.
	 * 3. 로그인 회원의 인덱스 번호는 각 행의 첫번째 열에 저장한다.
	 * 4. 해당 회원이 구매한 상품의 인덱스 번호는 각 행의 두번째 열에 저장한다.
	 * 예)
	 * {
	 * 		{0, 1},				qwer회원 			> 사과구매
	 * 		{1, 2},				javaking회원 		> 바나나구매
	 * 		{2, 1},				abcd회원			> 사과구매
	 * 		{0, 3},				qwer회원			> 딸기구매
	 * 		...
	 * }
	 */

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String[] ids = { "qwer", "javaking", "abcd" };
		String[] pws = { "1111", "2222", "3333" };

		int MAX_SIZE = 100;
		int[][] jang = new int[MAX_SIZE][2];

		int count = 0;

		String[] items = { "사과", "바나나", "딸기" };

		int log = -1;

		int member = 0; // 로그인 상태확인

		while (true) {
			if (log == 1)
				System.out.println(ids[member] + "님 접송중");
			System.out.println("[MEGA MART]");
			System.out.println("[1]로 그 인");
			System.out.println("[2]로그아웃");
			System.out.println("[3]쇼     핑");
			System.out.println("[4]장바구니");
			System.out.println("[0]종     료");

			System.out.print("메뉴 선택 : ");
			int sel = sc.nextInt();

			if (sel == 1) {
				if (log == 1) {
					System.out.println("로그인 상태입니다");
					continue;
				}

				String getId = "";
				String getPw = "";
				int idx = 0;
				int idCheck = -1;
				int pwCheck = -1;

				// id check
				System.out.print("ID: ");
				getId = sc.next();
				for (int i = 0; i < ids.length; i++) {
					if (getId.equals(ids[i])) {
						idCheck = 1;
						idx = i;
						member = idx;
						continue;
					}
				}

				// pw check
				if (idCheck == 1) {
					System.out.print("PW: ");
					getPw = sc.next();
					if (getPw.equals(pws[idx])) {
						pwCheck = 1;

					}
				}

				// 로그인 확인
				if (idCheck == 1 && pwCheck == 1) {
					log = 1;
					System.out.println(ids[idx] + "님 환영합니다.");
				} else if (idCheck == 1 && pwCheck == -1)
					System.out.println("비밀번호가 틀렸습니다");
				else if (idCheck == -1)
					System.out.println("아이디가 틀렸습니다.");

			} else if (sel == 2) {
				if (log != 1) {
					System.out.println("이미 로그아웃 상태입니다");
					continue;
				}

				System.out.println("정말 로그아웃 하시겠습니까?\n" + "Y/N");
				String outCheck = sc.next();
				if (outCheck.equals("y")) {
					log = -1;
					System.out.println("로그아웃 되셨습니다");
				} else
					continue;

				// 상품담기
			} else if (sel == 3) {
				if (log != 1) {
					System.out.println("로그인 먼저 하세요");
					continue;
				}

				for (int i = 0; i < items.length; i++)
					System.out.println(i + 1 + ". " + items[i]);

				System.out.println("뭘 사시겠습니까?");
				int buy = sc.nextInt() - 1;

				jang[count][0] = member;
				jang[count][1] = buy;
				count++;

			}

//			로그인 회원 장바구니 검색
			else if (sel == 4) {
				int count1 = 0;
				int count2 = 0;
				int count3 = 0;

				System.out.println(ids[member] + "의 장바구니");
				for (int i = 0; i < count; i++)
					if (jang[i][0] == member)
						if (jang[i][1] == 0) {
							count1 += 1;
						} else if (jang[i][1] == 1) {
							count2 += 1;
						} else if (jang[i][1] == 2) {
							count3 += 1;
						}

				System.out.println("사과 " + count1 + "개");
				System.out.println("바나나 " + count2 + "개");
				System.out.println("딸기 " + count3 + "개");
				System.out.println();
				System.out.println();

			} else if (sel == 0) {
				System.out.println("프로그램 종료");
				break;
			}

		}
	}
}
