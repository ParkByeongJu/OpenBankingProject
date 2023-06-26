package kr.ac.kopo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.ac.kopo.VO.AccountVO;
import kr.ac.kopo.commom.JDBCUtil;

public class AccountDAO {
	
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	private static String INSERT_ACCOUNT = "INSERT INTO ACCOUNT(ACCOUNT_ID, BANK_CD, ACCOUNT_BL, ACCOUNT_DATE, ACCOUNT_PW, MEMBER_ID, PRODUCT_CD, PW_CNT, DORMANT_ACC, ACCOUNT_NM) VALUES (TO_CHAR(SYSDATE, 'YYYYMMDD') || LPAD(account_id_seq.NEXTVAL, 1, '0'), '0413', '0', TO_CHAR(SYSDATE, 'YYYYMMDD'), ?, ?, ?, '0', '0', ?)";
	
	
	public void insertAccount(AccountVO vo) {
		
		try {
			conn = JDBCUtil.getConnnection();
			stmt = conn.prepareStatement(INSERT_ACCOUNT);
			stmt.setInt(1, vo.getAccountPassword());
			stmt.setString(2, vo.getId());
			stmt.setInt(3, vo.getProductCode());
			stmt.setString(4, vo.getAccountName());
			
			stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(stmt, conn);
		}
		
	}

	
}
