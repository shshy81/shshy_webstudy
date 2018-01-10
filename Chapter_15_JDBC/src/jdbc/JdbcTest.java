package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTest {

	public static void main(String[] args) throws SQLException {
		/*try {
			Driver driver = new Driver();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
		try {
			Class.forName("com.mysql.jdbc.Driver"); // lib에 있는 라이브러리 에 있는 클래스 정보를 클래스 영역에 담아준다. (위처럼 클래스 선언안해도)
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String url = "jdbc:mysql://localhost:3306/world";
		String user = "root";
		String pwd = "0416";
		
		Connection conn = DriverManager.getConnection(url, user, pwd);
		
		if (conn != null){
			System.out.println("연결성공");
		} else {
			System.out.println("연결실패");
		}
		
		Statement stmt = conn.createStatement();
		
		String sql = "select * from city";
		
		ResultSet rs = stmt.executeQuery(sql);
		
		while (rs.next()){
			int city_id = rs.getInt("id");
			System.out.println(city_id + "//");
		}
		rs.close();
		stmt.close();
		conn.close();

	}

}
