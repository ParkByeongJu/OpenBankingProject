package kr.ac.kopo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.VO.ProductVO;
import kr.ac.kopo.commom.JDBCUtil;

public class ProductDAO {
	
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	private static String PRODUCT_SALE = "SELECT * FROM PRODUCT WHERE PRODUCT_STAT = 1";
	private static String GET_PRODUCT = "SELECT * FROM PRODUCT WHERE PRODUCT_CD = ?";
	
	public List<ProductVO> productList() {
		
		List<ProductVO> productList = new ArrayList<>();
		ProductVO product = null;
		
		try {
			conn = JDBCUtil.getConnnection();
			stmt = conn.prepareStatement(PRODUCT_SALE);
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				product = new ProductVO();
				product.setProductcd(rs.getInt("PRODUCT_CD"));
				product.setProductContent(rs.getString("PRODUCT_CT"));
				product.setProductRate(rs.getInt("PRODUCT_RATE"));
				product.setProductName(rs.getString("PRODUCT_NM"));
				product.setProductClassification(rs.getString("PRODUCT_CL"));
				product.setProductStat(rs.getInt("PRODUCT_STAT"));
				
				productList.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return productList;
	}
	
	public ProductVO getProduct(int productCode) {
		
		ProductVO product = null;
		
		try {
			conn = JDBCUtil.getConnnection();
			stmt = conn.prepareStatement(GET_PRODUCT);
			stmt.setInt(1, productCode);
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				product = new ProductVO();
				product.setProductcd(rs.getInt("PRODUCT_CD"));
				product.setProductContent(rs.getString("PRODUCT_CT"));
				product.setProductRate(rs.getInt("PRODUCT_RATE"));
				product.setProductName(rs.getString("PRODUCT_NM"));
				product.setProductClassification(rs.getString("PRODUCT_CL"));
				product.setProductStat(rs.getInt("PRODUCT_STAT"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		
		return product;
	}

}
