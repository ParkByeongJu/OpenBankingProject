package kr.ac.kopo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginProcessController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

		request.setAttribute("msg", "로그인성공");
		
		return "redirect:" + request.getContextPath();
		
		//return "/jsp/login/loginProcess.jsp"; //forward
		
	}

}