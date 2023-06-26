package kr.ac.kopo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.kopo.DAO.ProductDAO;
import kr.ac.kopo.VO.ProductVO;

public class ProductProcessController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		ProductDAO dao = new ProductDAO();
		List<ProductVO> productList = dao.productList();
		
		request.setAttribute("productList", productList);
		
		return "/jsp/product/getProduct.jsp";
	}

}
