package sample4;

import java.text.DecimalFormat;
import java.util.Scanner;

//1. 상품조회 
//	 -products 배열에 저장된 모든 상품 출력
//2. 상품구매
// 	-상품번호와 수량입력
// 	-상품번호에 해당하는 상품정보 조회
// 	-상품번호에 해당하는 상품 존재시, 구매정보객체에 상품정보와 구매수량 저장
//	-구매정보 배열에 구매정보객체 저장
//3. 구매내역조회
//	-구매정보 배열에 저장된 모든 구매정보 출력
//4. 총계조회
//	-구매정보 배열에 저장된 구매정보 사용해서, 총 주문금액, 총 적립포인트 출력
//	-총주문금액은 상품가격*구매수량의 총합
//	-총적립포인트는 상품포인트*구매수량의 총합이다.

// decimalFormat 활용해보기->1,000,000
// 상품 정보를 조회할 수 있다.
// 상품을 구매할 수 있다.
// 상품구매내역을 출력할 수 있다.
// 총 구매금액, 총 적립포인트를 출력할 수 있다.

public class App {
	static DecimalFormat df1 = new DecimalFormat("#,###");

	public static void main(String[] args) {

		ProductRepository repo = new ProductRepository();

		// 구매정보가 저장된 배열(무슨상품을 몇개?)
		Order[] orders = new Order[100];
		int position = 0;

		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("===========================================");
			System.out.println("1.상품조회  2.구매  3.구매내역조회  4.총계조회  0.종료");
			System.out.println("===========================================");
			System.out.print("메뉴 선택: ");
			int sel = sc.nextInt();
			if (sel == 1) {
				repo.showAllProduct();
			} else if (sel == 2) {
				System.out.print("상품 번호: ");
				int no = sc.nextInt();
				Product selectedOne = repo.selectProductByNo(no);
				if (selectedOne == null) {
					System.out.println("상품번호를 잘못 입력하셨습니다.");
					continue;
				}

				repo.showProduct(selectedOne);
				System.out.println("수량: ");
				int amount = sc.nextInt();
				orders[position++] = new Order(selectedOne, amount);

			} else if (sel == 3) {
				System.out.println("=============구매내역 조회=============");
				for (Order order : orders) {
					if (!isExist(order))
						break;
					System.out.println("(" + order.getItem().getNo() + ") " + order.getItem().getName() + ": " + order.getAmount() + "개");
				}
			} else if (sel == 4) {
				System.out.println("===================영수증===================");
				int totalSum = 0;
				int point = 0;
				for (Order order : orders) {
					if (!isExist(order))
						break;
					int sum = order.getItem().getPrice() * order.getAmount();
					point += order.getItem().getPoint() * order.getAmount();
					totalSum += sum;
					System.out.println(order.getItem().getName() + "(" + order.getAmount() + "개)\t" + df1.format(sum));
				}
				System.out.println("===========================================");
				System.out.println("총 금액: " + df1.format(totalSum) + "원");
				System.out.println("적립 포인트: " + df1.format(point) + "점");

			} else if (sel == 0) {
				System.out.println("프로그램 종료");
				break;
			}
		}

	}

	public static boolean isExist(Order order) {
		return order != null;
	}
}
