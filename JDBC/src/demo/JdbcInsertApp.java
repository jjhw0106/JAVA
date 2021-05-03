package demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcInsertApp {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		// DBMS 연결할 때 사용되는 JDBC 드라이버 클래스 이름
		String driverClassName = "oracle.jdbc.OracleDriver";

		// 우리가 접속할 데이터베이스가 어디에 있는지를 알려줌
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		// jdbc드라이버의 버전 타입4의 jdbc드라이버 이름 = thin
		// => Oracle과 연결할 4버젼의 jdbc드라이버

		// 데이터베이스 연결 계정이름
		String username = "hr";

		// 데이터베이스 연결 비밀번호
		String password = "zxcv1234";
		// db연결준비 끝

		// 1. jdbc드라이버를 메모리에 로딩하기
		// Class.forName("패키지경로를 포함하는 클래스이름") - 지정된 클래스를 메모리에 로딩한다.
		Class.forName(driverClassName);

		// 2. DBMS와 연결하고, Connection구현객체 획득하기
		// DriverManager는 데이터베이스 연결에 필요한 드라이버 클래스를 선택해서
		// 지정된 URL에 해당하는 DBMS에 연결을 시도하고, 연결이 완료되면
		// Connection 객체 (SQL을 실행시키고, 실행결과를 획득하는데 필요한 객체)를 반환한다.
		Connection connection = DriverManager.getConnection(url, username, password);
		// 연결이 완료되면 connection객체를 던져줌

		// 3. PreparedStatement 구현객체 획득하기
		// Connection객체는 데이터베이스에 파라미터처리된(쌩으로 값 넣지 않는다) SQL을 전달하는
		// PreparedStatement 구현객체를 생성한다.
		String sql = "insert into sample_books values(?,?,?,?,?,?,sysdate)";	//디폴트로 지정되어 있더라도, sql에서 sysdate전까지 컬럼을 명시적으로
																//설정해 놓지 않았다면, 모든 컬럼에 대해 값을 적어줘야한다.
		PreparedStatement pstmt = connection.prepareStatement(sql);

		// 4. ?에 값 바인딩하기
		pstmt.setInt(1, 101);
		pstmt.setString(2, "자바의 정석");
		pstmt.setString(3, "남궁성");
		pstmt.setInt(4, 35000);
		pstmt.setInt(5, 32000);
		pstmt.setInt(6, 50);

		// 5. SQL 구문을 DBMS로 보내기
		int rowCount = pstmt.executeUpdate();
		System.out.println(rowCount + "개의 행이 추가되었습니다.");

		// 6. DBMS와 연결에 사용했던 모든 자원에 대한 점유 해제하기
		pstmt.close();
		connection.close();

	}
}
