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
			Class.forName("com.mysql.jdbc.Driver"); // lib�� �ִ� ���̺귯�� �� �ִ� Ŭ���� ������ Ŭ���� ������ ����ش�. (��ó�� Ŭ���� ������ص�)
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String url = "jdbc:mysql://localhost:3306/world";
		String user = "root";
		String pwd = "0416";
		
		Connection conn = DriverManager.getConnection(url, user, pwd);
		
		if (conn != null){
			System.out.println("���Ἲ��");
		} else {
			System.out.println("�������");
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