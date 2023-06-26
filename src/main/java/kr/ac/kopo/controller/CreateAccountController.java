package kr.ac.kopo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.kopo.DAO.ProductDAO;
import kr.ac.kopo.VO.ProductVO;

public class CreateAccountController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		int productCode = Integer.parseInt(request.getParameter("productCode"));
		ProductVO product = new ProductDAO().getProduct(productCode);
		
		request.setAttribute("productCode", product);
				
		
		return "/jsp/account/insertAccountTerms.jsp";
	}

}
