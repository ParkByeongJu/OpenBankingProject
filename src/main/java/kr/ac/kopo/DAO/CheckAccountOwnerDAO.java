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
	
	private static String checkAccountOwner = "select mem.member_nm from account acc join member mem on acc.member_id = mem.member_id "
			                                + "where acc.account_id = ? ";
	
	public String bankSelect(String selectBankCode, String reciverAccountId) {
		String returnVal = null;
		
		switch(selectBankCode) {
		
		case "0413" : returnVal = this.selectBJ(reciverAccountId);
		
		}
		return returnVal;
	}
	
	public String selectBJ(String reciverAccountId){
		String name = null;
		
		try {
			conn = JDBCUtil.getConnnection();
			stmt = conn.prepareStatement(checkAccountOwner);
			
			if(rs.next()) {
				name = rs.getString("member_nm");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return name;
	}
	
	
}
