package demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class BookApp {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);

		String driverClassName = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "hr";
		String password = "zxcv1234";
		String sql = "insert into sample_books values(?,?,?,?,?,?,sysdate)";

		Class.forName(driverClassName);// 메모리에 로딩
		Connection connection = DriverManager.getConnection(url, username, password);// 디비연결
		PreparedStatement pstmt = connection.prepareStatement(sql);// 쿼리전송 획득

		System.out.println("[책 등록하기]");
		System.out.println("번호를 입력하세요");
		int no = sc.nextInt();
		sc.nextLine();
		System.out.println("제목을 입력하세요.");
		String title = sc.nextLine();
		System.out.println("저자를 입력하세요.");
		String writer = sc.nextLine();
		System.out.println("가격을 입력하세요.");
		int price = sc.nextInt();
		System.out.println("할인가격을 입력하세요.");
		int discountPrice = sc.nextInt();
		System.out.println("재고를 입력하세요.");
		int stock = sc.nextInt();

		pstmt.setInt(1, no);	//안의 숫자는 물음표의 순서대로다. 앞에 다른 값이 있더라도 물음표의 순서만 계산함
		pstmt.setString(2, title);
		pstmt.setString(3, writer);
		pstmt.setInt(4, price);
		pstmt.setInt(5, discountPrice);
		pstmt.setInt(6, stock);

		int rowCount = pstmt.executeUpdate();
		System.out.println(rowCount + "개의 행이 추가되었습니다.");

		pstmt.close();
		connection.close();

	}

}
