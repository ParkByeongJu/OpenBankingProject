package kr.ac.kopo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.kopo.DAO.TransferDAO;
import kr.ac.kopo.VO.HistoryVO;

public class TransferProcessController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		try {
            request.setCharacterEncoding("UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }

		String bankCode = request.getParameter("bankId");//보내는 은행 코드
		String selectBankCode = request.getParameter("selectBankCode");//받는 은행 코드
		String senderAccountId = request.getParameter("senderAccountId");//보내는 계좌
		String senderName = request.getParameter("senderName");//보내는 이름
		String reciverName = request.getParameter("reciverName");//보내는 이름
		String reciverAccountId = request.getParameter("reciverAccountId");//받는 계좌
		Long amount = Long.parseLong(request.getParameter("amount"));//보내는 금액

	
		HistoryVO vo = new HistoryVO();
		
		vo.setBankCode(bankCode);
		vo.setAccountId(senderAccountId);
		vo.setTransferBank(selectBankCode);
		vo.setTransferAccount(reciverAccountId);
		vo.setBalance(amount);
		vo.setSenderName(senderName);
		vo.setReciverName(reciverName);
		
		int result = new TransferDAO().transfer(vo);
		
		String msg = "";
		if (result == 1) {
			return "accountCheck.do";
		} else {
			return "/index.jsp";
		}

	}

}
