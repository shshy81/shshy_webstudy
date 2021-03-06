package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.DBConnector;
import util.DBConnectorJNDI;

/**
 * Servlet implementation class JdbcServlet
 */
@WebServlet("/jdbc.do")
public class JdbcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			//DBConnector connector = new DBConnector(); 
			//DBConnector connector = DBConnector.getInstance(); // 객체 생성하지 않고 클래스 이름으로 접근하게 
			DBConnectorJNDI connector = DBConnectorJNDI.getInstance();
			
			//연결획득
			Connection conn = connector.getConnection();
			
			if (conn != null){
				System.out.println("연결성공");
			} else {
				System.out.println("연결실패");
			}
			
			Statement stmt = conn.createStatement();
			
			String sql = "select * from city";
			
			ResultSet rs = stmt.executeQuery(sql);
			
			PrintWriter out = response.getWriter();
			
			while (rs.next()){
				int city_id = rs.getInt("id");
				out.println(city_id + "//");
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		
	}

}
