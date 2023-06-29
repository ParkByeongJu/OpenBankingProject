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
	
	private static String TRANSFERJY = "{call transferJY(?, ?, ?)}";
	private static String TRANSFERMY = "{call transferMY(?, ?, ?)}";
	private static String TRANSFERBJ = "{call transferBJ(?, ?, ?)}";
	private static String TRANSFERKP = "{call transferKP(?, ?, ?)}";
	
	public int bankSelect(String bankCode, String senderAccountId, String reciverAccountId, long amount) throws SQLException {
		
		int returnVal = 0;
		
		switch(bankCode) {
//		case "0504" : returnVal = this.transferJY(senderAccountId, reciverAccountId, amount);
//			break;
		case "1003" : returnVal = this.transferMY(senderAccountId, reciverAccountId, amount);
			break;
		case "0413" : returnVal = this.transferBJ(senderAccountId, reciverAccountId, amount);
			break;
//		case "9999" : returnVal = this.transferKP(senderAccountId, reciverAccountId, amount);
//			break;
		}
		return returnVal;
	}
	
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
	
	public int transferMY(String senderAccountId, String reciverAccountId, long amount) throws SQLException {
		
		try {
			
			conn = JDBCUtil.getConnnection();
			conn.setAutoCommit(false);
			cstmt = conn.prepareCall(TRANSFERMY);
			
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
