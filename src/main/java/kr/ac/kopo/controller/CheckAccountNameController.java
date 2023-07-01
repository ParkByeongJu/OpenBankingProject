package kr.ac.kopo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.kopo.DAO.CheckAccountOwnerDAO;

public class CheckAccountNameController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

		String bank_cd = request.getParameter("bank_cd");//받는 은행 코드
		String account_id = request.getParameter("reciverAccountId");//받는 계좌
		
		System.out.println(bank_cd);
		System.out.println(account_id);
		
		String result = new CheckAccountOwnerDAO().checkAccount(account_id, bank_cd);
		
		System.out.println("나오긴함?" + result);
		request.setAttribute("result", result);
		
		return "/jsp/account/ajax.jsp";
	}

}
