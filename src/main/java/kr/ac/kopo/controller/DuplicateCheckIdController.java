package kr.ac.kopo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.kopo.DAO.MemberDAO;

public class DuplicateCheckIdController implements Controller{
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		String id = request.getParameter("id");
		MemberDAO dao = new MemberDAO();
		boolean isDuplicate = dao.duplicateCheckId(id);
		
		String msg ="";
		if(isDuplicate) {
			msg = "Duplicate";
		} else {
			msg = "success";
		}
		
		request.setAttribute("msg", msg);
		return "/jsp/signup/duplicateProcess.jsp";
	}

}
