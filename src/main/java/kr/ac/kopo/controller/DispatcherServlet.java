package kr.ac.kopo.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatcherServlet extends HttpServlet {

	private HandlerMapping mappings; 
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		
		String propLoc = config.getInitParameter("propLoc");
		
		mappings = new HandlerMapping(propLoc);
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {

			String uri = request.getRequestURI();
			System.out.println("uri : " + uri);
			uri = uri.substring(request.getContextPath().length());
			System.out.println("context : " + request.getContextPath());
			System.out.println("uri : " + uri);

			Controller ctrl = mappings.getController(uri);
			System.out.println("ctrl : " + ctrl.getClass());

			String callPage = ctrl.handleRequest(request, response);
			System.out.println("callPage : " + callPage);
			if (callPage != null) {
				RequestDispatcher dispatcher = request.getRequestDispatcher(callPage);
				dispatcher.forward(request, response);
			}
		} catch (Exception e) {
			throw new IOException(e);
		}
	}

}
