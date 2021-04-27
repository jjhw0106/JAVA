package method_practice;

/*
 * # 영수증 출력하기 : 클래스[변수]
 * 1. 햄버거 주문을 받아 영수증을 출력한다.
 * 2. 출력내용은 각 메뉴의 주문 수량과 총 금액 및 잔돈을 표시한다.
 */
import java.util.Scanner;

class BurgerShop {
	Scanner sc = new Scanner(System.in);
	String shopName = "KFC";

	int[] price = { 1500, 2500, 3500, 4000 };
	String[] menu = { "콜라", "치즈버거", "치킨버거", "치즈버거세트" };
	int[] menuCnt = new int[menu.length];

	int total = 0;
	int bCnt = 0;
	int sales = 0;

	void showMenu() {
		for (int i = 0; i < menu.length; i++) {
			System.out.println((i + 1) + ". " + menu[i] + " : " + price[i] + "원");
		}
		System.out.println((menu.length + 1) + ". 계산하기");
	}

	void foodOrder() {
		while (true) {
			int order = sc.nextInt() - 1;
			if (order < menu.length)
				menuCnt[order]++;
			else if (order == menu.length)
				break;
		}
	}

	void bills() {
		int billsTotal = 0;
		System.out.println("========영수증========");
		for (int i = 0; i < menu.length; i++) {
			if (menuCnt[i] != 0) {
				billsTotal += price[i] * menuCnt[i];
				System.out.println(menu[i] + ": " + menuCnt[i] + "개 " + "\t" + price[i] * menuCnt[i] + "원");
			}
		}
		System.out.println("---------------------");
		System.out.println("총 합계: \t\t" + billsTotal + "원");
		System.out.println();
	}

	void SalesRecord() {
		for (int i = 0; i < menu.length; i++) {
			total += price[i] * menuCnt[i];
		}
	}

	void orderInit() {
		for (int i = 0; i < menuCnt.length; i++)
			menuCnt[i] = 0;
	}

	void run() {
		while (true) {
			System.out.println("=========" + shopName + "=========");
			System.out.println("1. 주문넣기");
			System.out.println("2. 매출 확인");
			System.out.println("3. 종료");
			int sel = sc.nextInt();
			if (sel == 1) {
				showMenu();
				System.out.println("메뉴를 고르세요.");
				foodOrder();
				SalesRecord();
				bills();
			} else if (sel == 2) {
				System.out.print("총 매출액: ");
				System.out.println(total + "원");
			} else if (sel == 3) {
				break;
			}
			orderInit();
		}
	}
}

public class BillPrint {
	public static void main(String[] args) {
		BurgerShop bs = new BurgerShop();
		bs.run();
//		화면 출력
//		주문
//		영수증
//		매출액 증가
	}

}
