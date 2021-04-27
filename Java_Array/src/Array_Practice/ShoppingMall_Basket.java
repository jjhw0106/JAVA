package Array_Practice;

import java.util.Scanner;

public class ShoppingMall_Basket {
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

		Scanner scan = new Scanner(System.in);

		String[] ids = { "qwer", "javaking", "abcd" };
		String[] pws = { "1111", "2222", "3333" };

		int MAX_SIZE = 100;
		int[][] jang = new int[MAX_SIZE][2];

		int count = 0;

		String[] items = { "사과", "바나나", "딸기" };
		
		int log = -1;

		int idIdx = 0;
		

		while (true)
		{

			if (log != -1)
			{
				System.out.println(ids[log] + "님 환영합니다!");
			}

			System.out.println("[MEGA MART]");
			System.out.println("[1]로 그 인");
			// 로그인 -> id입력 id인덱스 0부터 탐색,pw입력 후 id 인덱스랑 pw인덱스 비교
			System.out.println("[2]로그아웃");
			// 로그아웃-> 로그인 후 log 1로 설정돼있던거 -1로 변경
			System.out.println("[3]쇼     핑");
			// items에서 탐색 후 있으면 해당 과일의 cnt++
			System.out.println("[4]장바구니");
			// jang[idIdx][0] 에는 회원아이디, jang[idIdx][
			System.out.println("[0]종     료");

			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt();

			// 로그인
			
			if (sel == 1)
			{
				if(log !=-1)
				{
					System.out.println("이미 로그인 되어있습니다.");
					continue;
				}
				System.out.print("ID: ");
				String inputId = "";
				inputId = scan.next();
				String inputPw = "";

				for (int i = 0; i < 3; i++)
				{
					if (ids[i].compareTo(inputId) == 0)
					{

						idIdx = i;
						System.out.print("PW: ");
						inputPw = scan.next();
						if (pws[i].compareTo(inputPw) == 0)
						{
							System.out.println(ids[idIdx] + "로 로그인 되셨습니다.");
							log = i;
						}
					}
				}
				if (log == -1)
					System.out.println("없는 ID입니다.");

			}

			// 로그아웃
			else if (sel == 2)
			{
				log = -1;
			}

			// 장바구니에 담기
			else if (sel == 3)
			{
				if (log == -1)
				{
					System.out.println("로그인을 해야합니다.");
					continue;
				}

				for (int i = 0; i < items.length; i++)
				{
					System.out.println((i + 1) + ". " + items[i]);
				}
				System.out.println("4. 뒤로가기");

				while (true)
				{
					System.out.print("선택: ");
					int choice = scan.nextInt();

					if (choice == 4)
						break;

					jang[count][0] = log;
					jang[count][1] = choice;
					count++;
				}

			}

			else if (sel == 4)
			{
				if (log == -1)
				{
					System.out.println("로그인을 해야합니다");
					continue;
				}
				int apple = 0;
				int banana = 0;
				int berry = 0;
				for (int i = 0; i < count; i++)
					if (jang[i][0] == log)
					{
						if (jang[i][1] == 1)
							apple += 1;
						else if (jang[i][1] == 2)
							banana += 1;
						else if (jang[i][1] == 3)
							berry += 1;
					}
				System.out.println(ids[log] + "회원의 구매목록");
				System.out.println("사과: " + apple + "개");
				System.out.println("바나나: " + banana + "개");
				System.out.println("딸기: " + berry + "개");

			}

			else if (sel == 0)
			{
				System.out.println("프로그램 종료");
				break;
			}

		}
	}
}