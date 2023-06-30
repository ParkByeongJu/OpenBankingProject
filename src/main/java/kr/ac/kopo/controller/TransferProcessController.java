package kr.ac.kopo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.kopo.DAO.CheckAccountOwnerDAO;
import kr.ac.kopo.VO.TransferVO;

public class TransferProcessController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

		String bankCode = request.getParameter("bankId");//보내는 은행 코드
		String selectBankCode = request.getParameter("selectBankCode");//받는 은행 코드
		String senderAccountId = request.getParameter("senderAccountId");//보내는 계좌
		String senderName = request.getParameter("senderName");//보내는 계좌
		String reciverAccountId = request.getParameter("reciverAccountId");//받는 계좌
		Long amount = Long.parseLong(request.getParameter("amount"));//보내는 금액

	
		TransferVO vo = new TransferVO();
		
		vo.setRecieverAccountId(reciverAccountId);
		
		CheckAccountOwnerDAO dao = new CheckAccountOwnerDAO();
		 
		String name =  dao.bankSelect(selectBankCode, reciverAccountId);
		
		request.setAttribute("receiverName", name);
		
//		TransferVO vo = new TransferVO();
//		vo.setBankCode(bankCode);
//		vo.setSelectBankCode(selectBankCode);
//		vo.setSenderAccountId(senderAccountId);
//		vo.setRecieverAccountId(reciverAccountId);
//		vo.setAmount(amount);
//		
//		HistoryDAO hdao = new HistoryDAO();
//		hdao.insertHistory(svo);
//		
//		TransferDAO dao = new TransferDAO();
//		try {
//			dao.bankSelect(selectBankCode, senderAccountId, reciverAccountId, amount);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

		return "/index.jsp";
	}

}
