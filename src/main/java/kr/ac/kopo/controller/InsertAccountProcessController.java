package kr.ac.kopo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.kopo.DAO.AccountDAO;
import kr.ac.kopo.VO.AccountVO;
import kr.ac.kopo.VO.MemberVO;
import kr.ac.kopo.VO.ProductVO;

public class InsertAccountProcessController implements Controller {
	
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String passwordString = request.getParameter("password");
		String id = ((MemberVO)session.getAttribute("loginUser")).getId();
		int prouductCode = (Integer.parseInt(request.getParameter("productCode")));
		String accountName = request.getParameter("name");
		
		int password = Integer.parseInt(passwordString);
		
		AccountVO vo = new AccountVO();
		
		vo.setAccountPassword(password);
		vo.setId(id);
		vo.setProductCode(prouductCode);
		vo.setAccountName(accountName);
		
		AccountDAO dao = new AccountDAO();
		dao.insertAccount(vo);
		
		return "/index.jsp";
	}
	
}
