// 장바구니 프로그램 작성하기
// - 상품을 선택해서 장바구니에 담을 수 있다.
// - 동일한 상품을 다시 장바구니에 담을 수 없다.
// - 장바구니에 저장된 상품을 확인할 수 있다.
// 1. 키보드 입력을 읽어오는 Scanner객체를 생성한다.
// 2. 반복문(while문)을 사용해서 아래의 작업을 반복 수행한다.
// 1. 메뉴제공 1.장바구니담기 2.장바구니조회 0.종료
// 2. 메뉴번호를 입력받는다.
// 3. 메뉴별 처리를 구현한다.
// - [장바구니 담기]는 상품번호를 입력받아서 해당 상품을 cart배열에 저장한다.
// cart배열에 동일한 상품번호의 상품이 저장되어 있으면 저장되지 않는다.
// - [장바구니 조회]는 현재 cart배열에 저장된 상품정보를 출력한다.
// - [종료]는 반복문을 탈출한다.
package sample3;

import java.util.Scanner;

public class App2 {

	public static void main(String[] args) {

		Product[] cart = new Product[100];
		ProductRepository repo = new ProductRepository();
		int cartInsertPosition = 0;

		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("================");
			System.out.println("1. 장바구니담기");
			System.out.println("2. 장바구니조회");
			System.out.println("0. 시스템 종료");
			System.out.println("================");
			System.out.print("메뉴선택 :");
			int sel = sc.nextInt();

			if (sel == 1) {
				System.out.println("장바구니에 담을 상품의 번호를 입력하세요");
				int no = sc.nextInt();
				boolean check = true;
				for (Product product : cart) {
					if (product == null)
						continue;
					if (no == product.getNo()) {
						System.out.println("이미 장바구니에 담은 물건입니다.");
						check = false;
					}
				}
				if (check) {
					Product item = repo.pickUp(no);
					if (item != null) {
						cart[cartInsertPosition++] = item;
					}
				}
			} else if (sel == 2) {
				if (cartInsertPosition == 0) {
					System.out.println("장바구니가 비어있습니다.");
					continue;
				}
				for (Product product : cart) {
					if (product == null)
						break;
					repo.showProductInform(product);
				}
			} else if (sel == 0) {
				System.out.println("프로그램 종료");
				break;
			}
		}
	}
}
