package kr.ac.kopo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.jsp.tagext.TryCatchFinally;

import kr.ac.kopo.VO.MemberVO;
import kr.ac.kopo.commom.JDBCUtil;

public class MemberDAO {
	
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	private static String DUPLICATE_CHECK_ID = "Select MEMBER_ID from member";
	private static String LOGIN = "SELECT * FROM MEMBER where MEMBER_ID = ? AND PASSWO_PW = ?";
	private static String INSERT_MEMBER = "INSERT INTO MEMBER (MEMBER_ID, PASSWO_PW, MEMBER_NM, MEMBER_EM, MEMBER_BIR, MEMBER_PH, MEMBER_POST, MEMBER_FULLADDR, MEMBER_EXTRAADDR, MEMBER_ROLE) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, 'user')";
	
	public boolean duplicateCheckId(String id) {
		String checkid = null;
		try {
			conn = JDBCUtil.getConnnection();
			stmt = conn.prepareStatement(DUPLICATE_CHECK_ID);
			rs = stmt.executeQuery(); {
				while(rs.next()) {
					checkid = rs.getString("MEMBER_ID");
					if(checkid.equals(id)) {
						return true;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt ,conn);
		}
		return false;
	}
	
	public MemberVO login(MemberVO vo) {
		
		MemberVO user = null;
		
		try {
			conn = JDBCUtil.getConnnection();
			
			stmt = conn.prepareStatement(LOGIN);
			stmt.setString(1, vo.getId());
			stmt.setString(2, vo.getPassword());
			
			System.out.println("\ndao id : " + vo.getId());
			System.out.println("dao pw : " + vo.getPassword());
			
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				user = new MemberVO();
				user.setId(rs.getString("MEMBER_ID"));
				user.setPassword(rs.getString("PASSWO_PW"));
				user.setName(rs.getString("MEMBER_NM"));
				user.setEmail(rs.getString("MEMBER_EM"));
				user.setBirth(rs.getDate("MEMBER_BIR"));
				user.setPhone(rs.getString("MEMBER_PH"));
				user.setPost(rs.getInt("MEMBER_POST"));
				user.setFullAddr(rs.getString("MEMBER_FULLADDR"));
				user.setExtraAddr(rs.getString("MEMBER_EXTRAADDR"));
				user.setRole(rs.getString("MEMBER_ROLE"));
				}
			
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				JDBCUtil.close(rs, stmt, conn);
			}
			return user;
		}
	
	public void signUp(MemberVO vo) {
		
		try {
			
			conn = JDBCUtil.getConnnection();
			stmt = conn.prepareStatement(INSERT_MEMBER);
			stmt.setString(1, vo.getId());
			stmt.setString(2, vo.getPassword());
			stmt.setString(3, vo.getName());
			stmt.setString(4, vo.getEmail());
			stmt.setDate(5, vo.getBirth());
			stmt.setString(6, vo.getPhone());
			stmt.setInt(7, vo.getPost());
			stmt.setString(8, vo.getFullAddr());
			stmt.setString(9, vo.getExtraAddr());
			
			stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(stmt, conn);
		}
		
	}

}



	


