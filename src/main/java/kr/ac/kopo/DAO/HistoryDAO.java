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
	
	private static String INSERT_HISTORY = "insert into HISTORY(NO, BANK_CD, ACCOUNT_ID, DEPOSIT_HS, TR_BANK, TR_ACCOUNT, HISTORY_BL) "
										+ "(HISTORY_NO.NEXTVAL, ?, ?, ?, ?, ?, ?, ?)";
	
	public void insertHistory(HistoryVO vo) {
		
		try {
			conn = JDBCUtil.getConnnection();
			stmt = conn.prepareStatement(INSERT_HISTORY);
			stmt.setString(1, vo.getBankCode());
			stmt.setInt(2, vo.getAccountId());
			stmt.setString(3, vo.getSrHistory());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
