package app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import exception.BookStoreException;
import repository.BookRepository;
import repository.UserRepository;
import service.BookStoreService;
import vo.Book;
import vo.Order;
import vo.User;

public class BookApp {

	private BookStoreService service = new BookStoreService();
	private Scanner sc = new Scanner(System.in);

	// 생성되자마자 로드되게
	//
	public void menu() {
		while (true) {
			try {
				boolean isLogined = service.isLogined();

				if (!isLogined) {
					System.out.println("-----------------------------------------------------------------------");
					System.out.println("1.도서목록  2.로그인  3.회원가입  0.종료");
					System.out.println("-----------------------------------------------------------------------");

					System.out.print("메뉴 선택 > ");
					int menuNo = sc.nextInt();
					System.out.println();

					if (menuNo == 1) {
						displayAllBooks();
					} else if (menuNo == 2) {
						login();
					} else if (menuNo == 3) {
						register();
					} else if (menuNo == 0) {
						exit();
					}

				} else {
					System.out.println(service.getMyInfo().getName() + "님 접속중입니다.");
					System.out.println("-----------------------------------------------------------------------");
					System.out.println("1.도서목록  2.검색  3.주문  4.내정보  5.주문내역 6.로그아웃  0.종료");
					System.out.println("-----------------------------------------------------------------------");

					System.out.print("메뉴 선택 > ");
					int menuNo = sc.nextInt();
					System.out.println();

					if (menuNo == 1) {
						displayAllBooks();
					} else if (menuNo == 2) {
						searchBook();
					} else if (menuNo == 3) {
						orderBook();
					} else if (menuNo == 4) {
						displayMyInfo();
					} else if (menuNo == 5) {
						displayMyOrderHistory();
					} else if (menuNo == 6) {
						logout();
					} else if (menuNo == 0) {
						exit();
					}
				}
			} catch (InputMismatchException e) {
				System.out.println("[Scanner 입력오류]");
				// Scanner를 close하지말고 새로운 scanner로 덮어씌우면 프로그램 죽지 않고 돌 수 있음
				sc = new Scanner(System.in);
			} catch (BookStoreException e) {
				System.out.println("[오류] " + e.getMessage());
			} catch (Exception e) {
				e.printStackTrace();
			}

			System.out.println();
			System.out.println();
			System.out.println();
			menu();
		}
	}

	/**
	 * 모든 책 정보 출력하기.
	 */
	private void displayAllBooks() {

		System.out.println("책번호\t가격\t할인가격\t재고\t제목");
		for (Book book : service.getAllBookList()) {
			System.out.println(book.getNo() + "\t" + book.getPrice() + "\t" + book.getDiscountPrice() + "\t"
					+ book.getStock() + "\t" + book.getTitle());
		}
	}

	/**
	 * 로그인하기
	 */
	private void login() {
		System.out.print("아이디: ");
		String id = sc.next();
		System.out.print("패스워드:	");
		String pw = sc.next();
		service.login(id, pw);
	}

	/**
	 * 회원가입하기 아이디 중복체크 실패시 전부 다시 입력해야함->서비스에 user받아오기 없음
	 */
	private void register() {
		System.out.println("회원가입");
		System.out.print("아이디: ");
		String id = sc.next();
		System.out.print("비밀번호: ");
		String pw = sc.next();
		System.out.print("이름:");
		String name = sc.next();
		System.out.print("point: ");
		int point = sc.nextInt();
		System.out.print("grade: ");
		String grade;
		if (point >= 5000000) {
			grade = "플래티넘";
		} else if (point >= 1000000) {
			grade = "골드";
		} else if (point >= 100000) {
			grade = "실버";
		} else {
			grade = "일반";
		}
		System.out.println(grade);
		service.addNewUser(new User(id, name, pw, point, grade));
	}

	/**
	 * 도서 검색
	 * 
	 * @throws IOException
	 */
	private void searchBook() {
		while (true) {
			System.out.println("-----------------------------------------------------------------------");
			System.out.println("1.제목검색  2.카테고리검색  3.가격검색  0.종료");
			System.out.println("-----------------------------------------------------------------------");

			System.out.print("검색 메뉴 선택 > ");
			int searchMenuNo = sc.nextInt();
			sc.nextLine();
			System.out.println();

			if (searchMenuNo == 1) {
				System.out.print("책 제목: ");
				String title = sc.nextLine();
				for (Book book : service.searchBooksByTitle(title)) {
					System.out.println(book.getNo() + ". [" + book.getTitle() + "]" + "  작가: " + book.getWriter()
							+ "  가격: " + book.getPrice() + "  수량: " + book.getStock());
				}
			} else if (searchMenuNo == 2) {
				System.out.print("카테고리: ");
				String category = sc.nextLine();
				for (Book book : service.searchBooksByCategory(category)) {
					System.out.println(book.getNo()
							+ ". [" + book.getTitle() + "]"
							+ "  작가: " + book.getWriter()
							+ "  가격: " + book.getPrice()
							+ "  수량: " + book.getStock());
				}
			} else if (searchMenuNo == 3) {
				System.out.print("최저가: ");
				int minPrice = sc.nextInt();
				System.out.print("최고가: ");
				int maxPrice = sc.nextInt();

				for (Book book : service.searchBooksByPrice(minPrice, maxPrice)) {
					System.out.println(book.getNo()
							+ "\t" + book.getPrice()
							+ "\t" + book.getDiscountPrice()
							+ "\t" + book.getStock()
							+ "\t" + book.getTitle());
				}

			} else if (searchMenuNo == 0) {
				break;
			}
			System.out.println();

		}
	}

	/**
	 * 책 주문하기
	 * 
	 * @throws IOException
	 */
	private void orderBook() {
		System.out.println("[구매]");
		System.out.print("구매할 책의 번호: ");
		int bookNo = sc.nextInt(); // =>service.findBook으로 바꿀것
		System.out.print("구매 권수: ");
		int amount = sc.nextInt();
		service.orderBook(bookNo, amount);
		System.out.println("선택하신 도서의 구매가 완료되었습니다.");
	}

	/**
	 * 내 정보 보기
	 */
	private void displayMyInfo() {
		User user = service.getMyInfo();
		System.out.println("ID: " + user.getId()
				+ "  이름: " + user.getName()
				+ "  등급: " + user.getGrade()
				+ "  잔여포인트: " + user.getPoint());
	}

	/**
	 * 내주문내역 보기
	 */
	private void displayMyOrderHistory() {
		System.out.println("[내 주문내역 보기]");
		List<Map<String, Object>> orderList = service.getMyOrderList();

		Iterator<Map<String, Object>> iter = orderList.iterator();
		int idx = 1;
		while (iter.hasNext()) {
			System.out.println("주문번호 " + (idx++) + ". " + iter.next().entrySet());
		}
	}

	/**
	 * 로그아웃하기
	 */
	private void logout() {
		System.out.println("[로그아웃]");
		service.logout();
	}

	/**
	 * 종료하기
	 */
	private void exit() {
		System.out.println("[프로그램 종료]");
		service.restore();
		System.exit(0);
	}

	public static void main(String[] args) {
		new BookApp().menu();
	}
}
