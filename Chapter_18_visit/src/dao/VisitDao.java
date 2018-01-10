package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DBConnector;
import vo.VisitVo;

public class VisitDao {
	
	private static VisitDao single = null;

	private VisitDao() {
	}

	public static VisitDao getInstance() {
		if (single == null) {
			// 객체 생성하지 않고 클래스 이름으로 접근하게 / 한번만 생성하게
			single = new VisitDao();
		}
		return single;
	}

	public List<VisitVo> selectList() {
		List<VisitVo> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String sql = "select * from visit";
		
		try {
			conn = DBConnector.getInstance().getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next()){
				VisitVo vo = new VisitVo();
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setContent(rs.getString("content"));
				vo.setIp(rs.getString("ip"));
				vo.setPwd(rs.getString("pwd"));
				vo.setRegdate(rs.getString("regdate"));
				
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return list;
	}
}
