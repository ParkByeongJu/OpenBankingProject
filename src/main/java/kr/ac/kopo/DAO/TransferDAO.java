package kr.ac.kopo.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;

import kr.ac.kopo.VO.HistoryVO;
import kr.ac.kopo.common.JDBCUtil;

public class TransferDAO {
	
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	private CallableStatement cstmt;
	
	private static String TRANSFER_BANK = "{call TRANSFER_BANK(?, ?, ?, ?, ?, ?, ?, ?)}";
	
	public int transfer(HistoryVO vo) {
		int result = 0;
		try {
			conn = JDBCUtil.getConnnection();
			cstmt = conn.prepareCall(TRANSFER_BANK);
			cstmt.setString(1, vo.getAccountId());
			cstmt.setString(2, vo.getBankCode());
			cstmt.setString(3, vo.getSenderName());
			cstmt.setString(4, vo.getTransferAccount());
			cstmt.setString(5, vo.getTransferBank());
			cstmt.setString(6, vo.getReciverName());
			cstmt.setLong(7, vo.getBalance());
			cstmt.registerOutParameter(8, Types.INTEGER);
			cstmt.execute();
			
			result = cstmt.getInt(8);
			cstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(stmt, conn);
		}
		return result;
	}
	
	
	

}
