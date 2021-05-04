package demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookApp {
	static String driverClassName = "oracle.jdbc.OracleDriver";
	static String url = "jdbc:oracle:thin:@localhost:1521:xe";
	static String username = "hr";
	static String password = "zxcv1234";

	public static void deleteBook(int bookNo) {
		String sql = "delete from sample_books "
				+ "where book_no = ?";
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DriverManager.getConnection(BookApp.url, BookApp.username, BookApp.password);
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bookNo);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[오류코드]" + e.getErrorCode());
			System.out.println("[오류메시지]" + e.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
			}
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
	}

	public static void updateBook(Book book) {
	}

	// 반환값이 null일 수도 있다. 조회된 데이터가 없으면 null반환
	public static Book selectBookByNo(int bookNo) {	// 책 한권만 검색할 때
		String sql = "select book_no, book_title, book_writer, book_price, "
				+ "			 book_discount_price, book_stock, book_created_date "
				+ "from sample_books "
				+ "where book_no = ? ";

		Book book = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DriverManager.getConnection(url, username, password);
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bookNo);	// sql에 ?가 있으면 무조건 그 갯수만큼 set해야된다고 생각하기
			rs = pstmt.executeQuery();

			// rs.next()의 실행결과가 true면 조회된 행이 있는경우
			// rs.next()의 실행결과가 false면 조회된 행이 없는 경우
			if (rs.next()) {
				book = new Book();
				book.setNo(rs.getInt("book_no"));
				book.setTitle(rs.getString("book_title"));
				book.setWriter(rs.getString("book_writer"));
				book.setPrice(rs.getInt("book_price"));
				book.setDiscountPrice(rs.getInt("book_discount_price"));
				book.setCreatedDate(rs.getDate("book_created_date"));
			}
		} catch (SQLException e) {
			System.out.println("[오류코드]" + e.getErrorCode());
			System.out.println("[오류메세지]" + e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
			}
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
			}
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
			}
		}
		return book;
	}

	// 반환값이 언제나 null이 아니다
	public static List<Book> selectAllBooks() {	// 여러 책을 검색할 때
		String sql = "select book_no, book_title, book_writer, book_price, "
				+ "			 book_discount_price, book_stock, book_created_date "
				+ "from sample_books "
				+ "order by book_no desc ";
		List<Book> books = new ArrayList<Book>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DriverManager.getConnection(url, username, password);
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Book book = new Book();
				book.setNo(rs.getInt("book_no"));
				book.setTitle(rs.getString("book_title"));
				book.setWriter(rs.getString("book_writer"));
				book.setPrice(rs.getInt("book_price"));
				book.setDiscountPrice(rs.getInt("book_discount_price"));
				book.setStock(rs.getInt("book_stock"));
				book.setCreatedDate(rs.getDate("book_created_date"));

				books.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return books;
	}

	public static void insertBook(Book book) {
		String sql = "insert into sample_books "
				+ "(book_no, book_title, book_writer, book_price, book_discount_price, book_stock)"
				+ "values "
				+ "(?,?,?,?,?,?)";		// ?가 아니고 변수명으로 위치를 선정할 경우
		// sql 인젝션 공격을 당할 수 있음으로 무조건 ?로 값을 받아온다
		// ex) id뒤에 --를 담아서 sql을 보내면 패스워드가 주석처리 돼버린다.

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DriverManager.getConnection(BookApp.url, BookApp.username, BookApp.password);
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, book.getNo());
			pstmt.setString(2, book.getTitle());
			pstmt.setString(3, book.getWriter());
			pstmt.setInt(4, book.getPrice());
			pstmt.setInt(5, book.getDiscountPrice());
			pstmt.setInt(6, book.getStock());

			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[오류코드]" + e.getErrorCode());
			System.out.println("[오류메세지]" + e.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
			}
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("=====================================");
			System.out.println("1. 조회  2. 등록  3. 수정  4. 삭제  0. 종료");
			System.out.println("=====================================");

			System.out.println("메뉴선택 > ");
			int menuNo = sc.nextInt();
			sc.nextLine();

			if (menuNo == 1) {
				System.out.println("[전체 도서 조회]");
				List<Book> books = BookApp.selectAllBooks();
				if (books.isEmpty()) {
					System.out.println("조회된 정보가 없습니다");
				} else {
					System.out.println("---------------------------");
					for (Book book : books) {
						System.out.println("번호: " + book.getNo());
						System.out.println("제목: " + book.getTitle());
						System.out.println("가격: " + book.getPrice());
						System.out.println();
					}
					System.out.println("---------------------------");
				}
			} else if (menuNo == 2) {
				System.out.println("[새 도서 등록]");
				System.out.println("번호 > ");
				int no = sc.nextInt();
				sc.nextLine();
				System.out.println("제목 > ");
				String title = sc.nextLine();
				System.out.println("저자 > ");
				String writer = sc.nextLine();
				System.out.println("가격 > ");
				int price = sc.nextInt();
				System.out.println("할인가 > ");
				int discountPrice = sc.nextInt();
				System.out.println("재고량 > ");
				int stock = sc.nextInt();

				Book book = new Book();
				book.setNo(no);
				book.setTitle(title);
				book.setWriter(writer);
				book.setPrice(price);
				book.setDiscountPrice(discountPrice);
				book.setStock(stock);

				insertBook(book);

			} else if (menuNo == 3) {
				System.out.println("[도서 정보 수정]");
			} else if (menuNo == 4) {
				System.out.println("[도서 정보 삭제]");
			} else if (menuNo == 0) {
				System.out.println("프로그램 종료");
			}

			System.out.println();
			System.out.println();
			System.out.println();
		}
//		String sql = "insert into sample_books values(?,?,?,?,?,?,sysdate)";
//
//		Class.forName(driverClassName);// 메모리에 로딩
//		Connection connection = DriverManager.getConnection(url, username, password);// 디비연결
//		PreparedStatement pstmt = connection.prepareStatement(sql);// 쿼리전송 획득
//
//		System.out.println("[책 등록하기]");
//		System.out.println("번호를 입력하세요");
//		int no = sc.nextInt();
//		sc.nextLine();
//		System.out.println("제목을 입력하세요.");
//		String title = sc.nextLine();
//		System.out.println("저자를 입력하세요.");
//		String writer = sc.nextLine();
//		System.out.println("가격을 입력하세요.");
//		int price = sc.nextInt();
//		System.out.println("할인가격을 입력하세요.");
//		int discountPrice = sc.nextInt();
//		System.out.println("재고를 입력하세요.");
//		int stock = sc.nextInt();
//
//		pstmt.setInt(1, no);	//안의 숫자는 물음표의 순서대로다. 앞에 다른 값이 있더라도 물음표의 순서만 계산함
//		pstmt.setString(2, title);
//		pstmt.setString(3, writer);
//		pstmt.setInt(4, price);
//		pstmt.setInt(5, discountPrice);
//		pstmt.setInt(6, stock);
//
//		int rowCount = pstmt.executeUpdate();
//		System.out.println(rowCount + "개의 행이 추가되었습니다.");
//
//		pstmt.close();
//		connection.close();

	}

}
