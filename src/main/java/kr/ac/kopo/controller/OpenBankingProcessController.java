package kr.ac.kopo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.kopo.DAO.MemberDAO;
import kr.ac.kopo.VO.MemberVO;

public class OpenBankingProcessController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String id = ((MemberVO)session.getAttribute("loginUser")).getId();
		MemberVO vo = new MemberVO();
		vo.setId(id);
		
		MemberDAO dao = new MemberDAO();
		dao.updateStatus(vo);
		
		return "accountCheck.do";
	}

}
