package kr.ac.kopo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TransferController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

		String accountId = request.getParameter("accountId");
		
		request.setAttribute("accountId", accountId);
		System.out.println(accountId);
		
		return "/jsp/transfer/transfer.jsp";
	}

}
