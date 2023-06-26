package kr.ac.kopo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertAccountController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		int productCode = Integer.parseInt(request.getParameter("productCode"));
		
		request.setAttribute("productCode", productCode);
		System.out.println(productCode);
		return "/jsp/account/insertAccount.jsp";
	}

}
