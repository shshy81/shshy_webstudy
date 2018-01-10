package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
	
	private static DBConnector single = null;

	private DBConnector() {
	}

	public static DBConnector getInstance() {
		if (single == null) {
			// ��ü �������� �ʰ� Ŭ���� �̸����� �����ϰ� / �ѹ��� �����ϰ�
			single = new DBConnector();
		}
		return single;
	}
	
	static{
		//DB����̹� �ε� // ��Ĺ ����ɶ� �ѹ��� ����ǰ�
		try {
			Class.forName("com.mysql.jdbc.Driver"); // lib�� �ִ� ���̺귯�� �� �ִ� Ŭ���� ������ Ŭ���� ������ ����ش�. (��ó�� Ŭ���� ������ص�)
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection(){
		Connection conn = null;
		
		//�����۾�
		String url = "jdbc:mysql://localhost:3306/world";
		String user = "root";
		String pwd = "0416";
		
		try {
			conn = DriverManager.getConnection(url, user, pwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;

	}
}