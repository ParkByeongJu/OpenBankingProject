package kr.ac.kopo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.ac.kopo.VO.HistoryVO;
import kr.ac.kopo.common.JDBCUtil;

public class HistoryDAO {
	
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	private static String INSERT_HISTORY = "INSERT INTO HISTORY (NO, BANK_CD, ACCOUNT_ID, DEPOSIT_HS, TR_BANK, TR_ACCOUNT, HISTORY_BL) VALUES (HISTORY_NO.NEXTVAL, ?, ?, ?, ?, ?, ?) ";
	

	public void insertHistory(HistoryVO vo) {
		
		try {
			conn = JDBCUtil.getConnnection();
			stmt = conn.prepareStatement(INSERT_HISTORY);
			stmt.setString(1, vo.getBankCode());//은행코드 
			stmt.setString(2, vo.getAccountId());//보내는계좌번호
			stmt.setString(3, vo.getSrHistory());//입출금내역
			stmt.setString(4, vo.getTransferBank());//받는 은행
			stmt.setString(5, vo.getTransferAccount());//거래 계좌
			stmt.setLong(6, vo.getBalance());//거래후 잔액
			
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
		
	}

}
