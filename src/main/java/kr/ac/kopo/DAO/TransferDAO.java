package kr.ac.kopo.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.ac.kopo.common.JDBCUtil;

public class TransferDAO {
	
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	private CallableStatement cstmt;
	
	private static String TRANSFERBJ = "{call transferJY(?, ?, ?)}";
	
	

	
	public int transferBJ(String senderAccountId, String reciverAccountId, long amount) throws SQLException {
		
		try {
			
			conn = JDBCUtil.getConnnection();
			conn.setAutoCommit(false);
			cstmt = conn.prepareCall(TRANSFERBJ);
			
			cstmt.setString(1, senderAccountId);
			cstmt.setString(2, reciverAccountId);
			cstmt.setLong(3, amount);
			
			cstmt.executeUpdate();
			conn.commit();
			
			return 1;
			
		} catch (SQLException e) {
			conn.rollback();
			return 0;
		} finally {
			if (cstmt != null) {
				cstmt.close();
			}
			if(conn != null) {
				conn.close();
			}
		}
	}
	
	
	

}
