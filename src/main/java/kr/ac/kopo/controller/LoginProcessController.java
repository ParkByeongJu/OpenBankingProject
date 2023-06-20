package kr.ac.kopo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.kopo.DAO.MemberDAO;
import kr.ac.kopo.VO.MemberVO;

public class LoginProcessController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response){

		String id = request.getParameter("id");
		String password = request.getParameter("password");
		System.out.printf("%s %s", id, password);
		
		MemberVO vo = new MemberVO();
		vo.setId(id);
		vo.setPassword(password);
		
		MemberDAO dao = new MemberDAO();
		MemberVO user = dao.login(vo);
		
		if(user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", user);
			return "/index.do";
		} else if (id != null && password != null) {
			request.setAttribute("error", "아이디 또는 비밀번호를 잘못 입력했습니다. 입력하신 내용을 다시 확인해주세요.");
			return "/login.do";
		} else {
			return "/login.do";
		}
	}

}
