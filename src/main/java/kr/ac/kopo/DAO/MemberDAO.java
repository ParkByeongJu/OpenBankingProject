package kr.ac.kopo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.ac.kopo.commom.JDBCUtil;

public class MemberDAO {
	
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	private static String DUPLICATE_CHECK_ID = "Select MEMBER_ID from member";
	private static String LOGIN = "Select PASSWO_PW from member where MEMBER_ID = ?";
	
	public boolean duplicateCheckId(String id) {
		String checkid = null;
		try {
			conn = JDBCUtil.getConnnection();
			stmt = conn.prepareStatement(DUPLICATE_CHECK_ID);
			rs = stmt.executeQuery(); {
				while(rs.next()) {
					checkid = rs.getString("id");
					if(checkid.equals(id)) {
						return true;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt ,conn);
		}
		return false;
	}
	
	public int login(String id, String password) {
		
		try {
			conn = JDBCUtil.getConnnection();
			stmt = conn.prepareStatement(LOGIN);
			stmt.setString(1, id);
			rs = stmt.executeQuery();
			if(rs.next()) {
				if(rs.getString(1).equals(password)) {
					return 1;//�α��� ����
				}
			} else {
				return 0; //��й�ȣ ����ġ
			}
			return -1;//���̵� ����
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(stmt, conn);
		}
		return -2;//DB����
	}
}

	


