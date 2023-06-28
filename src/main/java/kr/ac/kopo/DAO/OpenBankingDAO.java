package kr.ac.kopo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.VO.AccountVO;
import kr.ac.kopo.common.JDBCUtil;

public class OpenBankingDAO {
	
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	private static String BBM_BANK_ACCOUNT = "SELECT BK1.BANK_NM AS BANK_NM, AC1.PRODUCT_NAME AS PRODUCT_NM, AC1.ACC_NO AS ACCOUNT_ID, AC1.BALANCE AS ACCOUNT_BL "
										     + "FROM b_ACCOUNT @BBMBank AC1  "
										     + "JOIN BANK_INFO @BBMBank BK1 ON AC1.BANK_CD = BK1.BANK_CD "
										     + "WHERE AC1.USER_ID = ?";
	
	public List<AccountVO> accountList(String id){
			
			List<AccountVO> accountList = new ArrayList<>();
			AccountVO account = null;
			
			
			try {
				
				conn = JDBCUtil.getConnnection();
				stmt = conn.prepareStatement(BBM_BANK_ACCOUNT);
				stmt.setString(1, id);
				rs = stmt.executeQuery();
				
				while (rs.next()) {
					account = new AccountVO();
					account.setBankName(rs.getString("BANK_NM"));
					account.setProductName(rs.getString("PRODUCT_NM"));
					account.setAccountId(rs.getLong("ACCOUNT_ID"));
					account.setBlance(rs.getLong("ACCOUNT_BL"));
					
					accountList.add(account);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JDBCUtil.close(rs, stmt, conn);
			}
			return accountList;
		}
}
