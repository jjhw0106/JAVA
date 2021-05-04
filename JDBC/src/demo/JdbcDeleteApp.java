package demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcDeleteApp {
	public static void main(String[] args) {
		String driverClassName = "oracle.jdbc.OracleDriver"
				+ "";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String password = "zxcv1234";

		String sql = "delete from sample_books where book_no = ?";

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName(driverClassName);
			con = DriverManager.getConnection(url, user, password);
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, 102);

			int rowCount = pstmt.executeUpdate();// 실제 삭제된 행의 갯수
			System.out.println(rowCount + "개의 행이 삭제되었습니다.");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
