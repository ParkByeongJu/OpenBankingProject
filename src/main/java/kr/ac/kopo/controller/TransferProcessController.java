package kr.ac.kopo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.kopo.DAO.TransferDAO;
import kr.ac.kopo.VO.TransferVO;

public class TransferProcessController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

		String bankCode = request.getParameter("bankCode");
		String selectBankCode = request.getParameter("selectBankCode");
		String senderAccountId = request.getParameter("senderAccountId");
		String reciverAccountId = request.getParameter("reciverAccountId");
		Long amount = Long.parseLong(request.getParameter("amount"));
		
		TransferVO vo = new TransferVO();
		vo.setBankCode(bankCode);
		vo.setSelectBankCode(selectBankCode);
		vo.setSenderAccountId(senderAccountId);
		vo.setRecieverAccountId(reciverAccountId);
		vo.setAmount(amount);
		
		TransferDAO dao = new TransferDAO();
		
		try {
			dao.bankSelect(selectBankCode, senderAccountId, reciverAccountId, amount);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "/index.jsp";
	}

}
