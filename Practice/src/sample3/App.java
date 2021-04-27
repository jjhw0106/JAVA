// 1. 키보드 입력을 읽어오는 Scanner객체를 생성한다.
// 2. 반복문(while문)을 사용해서 아래의 작업을 반복 수행한다.
// 1. 메뉴제공 1.전체조회 2.카테고리별조회 3.상품명조회 4.가격조회 0.종료
// 2. 메뉴번호를 입력받는다.
// 3. 메뉴별 처리를 구현한다.
// - 전체조회는 모든 상품정보를 표시한다.
// - 카테고리조회는 카테고리를 입력받아서 카테고리가 일치하는 상품만 출력한다.
// - 상품명조회는 상품명을 입력받아서 그 문자열을 포함하고 있는 상품만 출력한다.
// - 가격조회는 최소가격, 최대가격을 입력받아서 해당 범위에 속하는 상품만 출력한다.
// - 종료는 반복문을 탈출한다.
package sample3;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {

		ProductRepository repo = new ProductRepository();

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("================");
			System.out.println("1. 전체조회");
			System.out.println("2. 카테고리별 조회");
			System.out.println("3. 상품명 조회");
			System.out.println("4. 가격조회");
			System.out.println("0. 시스템 종료");
			System.out.println("================");
			System.out.print("메뉴선택 :");
			int sel = sc.nextInt();

			if (sel == 1) {
				repo.showAllProduct();
			} else if (sel == 2) {
				if (!repo.showByCategory(sc.next())) {
					System.out.println("없는 카테고리입니다.");
				}
			} else if (sel == 3) {
				if (!repo.showByName(sc.next())) {
					System.out.println("찾으시는 제품이 없습니다.");
				}
			} else if (sel == 4) {
				System.out.print("최소가: ");
				int minimum = sc.nextInt();
				System.out.print("최대가: ");
				int maximum = sc.nextInt();

				if (!repo.showByPrice(minimum, maximum)) {
					System.out.println("검색하신 금액대의 상품이 없습니다.");
				}
			} else if (sel == 0) {
				System.out.println("시스템 종료");
				break;
			}
		}

	}
}
