package kr.ac.kopo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.kopo.DAO.CheckAccountOwnerDAO;
import kr.ac.kopo.VO.TransferVO;

public class CheckAccountNameController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

		String selectBankCode = request.getParameter("selectBankCode");//받는 은행 코드
		String reciverAccountId = request.getParameter("reciverAccountId");//받는 계좌
		TransferVO vo = new TransferVO();
		
		vo.setRecieverAccountId(reciverAccountId);
		
		CheckAccountOwnerDAO dao = new CheckAccountOwnerDAO();
		 
		String name =  dao.bankSelect(selectBankCode, reciverAccountId);
		
		request.setAttribute("receiverName", name);
		
		return "/jsp/tranfer/transfer.jsp";
	}

}
