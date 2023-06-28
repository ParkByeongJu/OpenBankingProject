package kr.ac.kopo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.VO.AccountVO;
import kr.ac.kopo.common.JDBCUtil;

public class AccountDAO {
	
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	private static String INSERT_ACCOUNT = "INSERT INTO ACCOUNT(ACCOUNT_ID, BANK_CD, ACCOUNT_BL, ACCOUNT_DATE, ACCOUNT_PW, MEMBER_ID, PRODUCT_CD, PW_CNT, DORMANT_ACC, ACCOUNT_NM) VALUES (TO_CHAR(SYSDATE, 'YYYYMMDD') || LPAD(account_id_seq.NEXTVAL, 4, '0'), '0413', '0', TO_CHAR(SYSDATE, 'YYYYMMDD'), ?, ?, ?, '0', '0', ?)";
	private static String TOTAL_BALANCE = "SELECT SUM(ACCOUNT_BL) AS TOTAL_BALANCE FROM ACCOUNT WHERE MEMBER_ID = ?";
	private static String ACCOUNT_INFO = "SELECT BK1.BANK_NM AS BANK_NM, PD1.PRODUCT_NM AS PRODUCT_NM, AC1.ACCOUNT_ID AS ACCOUNT_ID, AC1.ACCOUNT_BL AS ACCOUNT_BL, AC1.ACCOUNT_NM AS ACCOUNT_NM "
									     + "FROM ACCOUNT AC1 "
									     + "JOIN BANK_INFO BK1 ON AC1.BANK_CD = BK1.BANK_CD "
									     + "JOIN PRODUCT PD1 ON AC1.PRODUCT_CD = PD1.PRODUCT_CD "
									     + "WHERE AC1.MEMBER_ID = ?";
	private static String BBM_BANK_ACCOUNT = "SELECT * FROM B_ACCOUNT @BBMBANK WHERE USER_ID = ?";
	
	
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
	public int totalBalance(String id) {
		
		int totalBalance = 0;
		
		try {
			
			conn = JDBCUtil.getConnnection();
			stmt = conn.prepareStatement(TOTAL_BALANCE);
			stmt.setString(1, id);
			
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				totalBalance = rs.getInt("TOTAL_BALANCE");
			}
			
		} catch (Exception e) {
			
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return totalBalance;
	}
	
	public List<AccountVO> accountList(String id){
		
		List<AccountVO> accountList = new ArrayList<>();
		AccountVO account = null;
		
		
		try {
			
			conn = JDBCUtil.getConnnection();
			stmt = conn.prepareStatement(ACCOUNT_INFO);
			stmt.setString(1, id);
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				account = new AccountVO();
				account.setBankName(rs.getString("BANK_NM"));
				account.setProductName(rs.getString("PRODUCT_NM"));
				account.setAccountId(rs.getLong("ACCOUNT_ID"));
				account.setBlance(rs.getLong("ACCOUNT_BL"));
				account.setAccountName(rs.getString("ACCOUNT_NM"));
				
				accountList.add(account);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return accountList;
	}

//	public List<AccountVO> bbmAccountList(String id){
//			
//			List<AccountVO> accountList = new ArrayList<>();
//			AccountVO account = null;
//			
//			
//			try {
//				
//				conn = JDBCUtil.getConnnection();
//				stmt = conn.prepareStatement(ACCOUNT_INFO);
//				stmt.setString(1, id);
//				rs = stmt.executeQuery();
//				
//				while (rs.next()) {
//					account = new AccountVO();
//					account.setBankName(rs.getString("BANK_NM"));
//					account.setProductName(rs.getString("PRODUCT_NM"));
//					account.setAccountId(rs.getLong("ACCOUNT_ID"));
//					account.setBlance(rs.getLong("ACCOUNT_BL"));
//					account.setAccountName(rs.getString("ACCOUNT_NM"));
//					
//					accountList.add(account);
//				}
//				
//			} catch (Exception e) {
//				e.printStackTrace();
//			} finally {
//				JDBCUtil.close(rs, stmt, conn);
//			}
//			return accountList;
//		}
	
}
