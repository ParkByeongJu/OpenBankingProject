package kr.ac.kopo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AccountDAO {
	
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	private static String INSERT_ACCOUNT = "INSERT INTO ACCOUNT(ACCOUNT_ID, BANK_CD, ACCOUNT_BL, ACCOUNT_DATE, ACCOUNT_PW, MEMBER_ID, PRODECT_CD, PW_CNT, DORMANT_ACC, ACCOUNT_NM) VALUES (TO_CHAR(SYSDATE, 'YYYYMMDD') || LPAD(account_id_seq.NEXTVAL, 1, '0'), '001', '0', TO_CHAR(SYSDATE, 'YYYYMMDD'), ?, ?, '1', '0', '0', ?)";
	
	
}
