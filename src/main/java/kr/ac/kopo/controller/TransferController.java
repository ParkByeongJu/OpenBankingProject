package kr.ac.kopo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TransferController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

		String accountId = request.getParameter("accountId");
		String bankCode = request.getParameter("bankId");
		
		request.setAttribute("accountId", accountId);
		request.setAttribute("bankCode", bankCode);
		System.out.println(accountId);
		System.out.println(bankCode);
		
		return "/jsp/transfer/transfer.jsp";
	}

}
