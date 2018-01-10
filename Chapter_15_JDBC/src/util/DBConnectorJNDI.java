package util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBConnectorJNDI {
	
	DataSource ds;
	
	private static DBConnectorJNDI single = null;

	private DBConnectorJNDI() {
		try {
			InitialContext ic = new InitialContext();
			Context ctx = (Context)ic.lookup("java:comp/env");
			ds = (DataSource)ctx.lookup("jdbc/mysql_world");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static DBConnectorJNDI getInstance() {
		if (single == null) {
			// ��ü �������� �ʰ� Ŭ���� �̸����� �����ϰ� / �ѹ��� �����ϰ�
			single = new DBConnectorJNDI();
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