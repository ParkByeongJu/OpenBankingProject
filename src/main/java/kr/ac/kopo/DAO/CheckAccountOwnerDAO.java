package kr.ac.kopo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.ac.kopo.VO.TransferVO;
import kr.ac.kopo.common.JDBCUtil;

public class CheckAccountOwnerDAO {

	
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	
	public String checkAccount(String account_id, String bank_cd) {
		
		String name ="";
		StringBuilder sql = new StringBuilder();
		
		
		
		switch(bank_cd) {
		case "0413":
			sql.append("select mem.member_nm from account acc join member mem on acc.member_id = mem.member_id ");
			sql.append("where acc.account_id = ? ");
			break;
		case "1003":
			sql.append("select mem.user_name from b_account @BBMBank acc join b_user_info @BBMBank mem on acc.user_id = mem.user_id ");
			sql.append("where acc.acc_no = ? ");
			break;
		case "9999":
			sql.append("select mem.name from Account @KKPBank acc join user_info @KKPBank mem on acc.user_id = mem.user_id ");
			sql.append("where acc.ac_number = ? ");
			break;
		case "0504":
			sql.append("select mem.name from Account @eziBank acc join user_info @KKPBank mem on acc.user_id = mem.user_id ");
			sql.append("where acc.user_id = ? ");
			break;
		}
		try {
			conn = JDBCUtil.getConnnection();
			stmt = conn.prepareStatement(sql.toString());
			stmt.setString(1, account_id);
			rs = stmt.executeQuery();
			if(rs.next()) {
				name = rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		
		return name;
	}
	
	
}
