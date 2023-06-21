package kr.ac.kopo.controller;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.kopo.DAO.MemberDAO;
import kr.ac.kopo.VO.MemberVO;

public class SignUpProcessController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String birthString = request.getParameter("birth");
		String phone = request.getParameter("phone");
		String postString = request.getParameter("post");
		String fullAddr = request.getParameter("addr1");
		String extraAddr = request.getParameter("addr2");
		
		Date birth = null;
			try {
			    SimpleDateFormat dateFormat = new SimpleDateFormat("YYYYMMDD");
			    birth = new Date(dateFormat.parse(birthString).getTime());
			} catch (ParseException DP) {
			    DP.printStackTrace();
			    // birth 파싱 오류 처리
			}
		int post = Integer.parseInt(postString);
		
		MemberVO vo = new MemberVO();
		
		vo.setId(id);
		vo.setPassword(password);
		vo.setName(name);
		vo.setEmail(email);
		vo.setBirth(birth);
		vo.setPhone(phone);
		vo.setPost(post);
		vo.setFullAddr(fullAddr);
		vo.setExtraAddr(extraAddr);
		
		MemberDAO dao = new MemberDAO();
		dao.signUp(vo);
		
		return "/index.jsp";
	}

}
