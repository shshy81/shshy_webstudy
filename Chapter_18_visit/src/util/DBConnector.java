package util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBConnector {
	
	private static DBConnector single = null;
	DataSource ds;

	private DBConnector() {
		
		try {
			InitialContext ic = new InitialContext();
			Context ctx = (Context) ic.lookup("java:comp/env");
			ds = (DataSource) ctx.lookup("jdbc/mysql_web_programing");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static DBConnector getInstance() {
		if (single == null) {
			// 객체 생성하지 않고 클래스 이름으로 접근하게 / 한번만 생성하게
			single = new DBConnector();
		}
		return single;
	}
	
	public Connection getConnection(){
		Connection conn = null;
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
