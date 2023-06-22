package kr.ac.kopo.controller;

import java.util.HashMap;
import java.util.Map;

public class HandlerMapping {

	private Map<String, Controller> mappings;

	public HandlerMapping(String propLoc) {
		mappings = new HashMap<>();
		
		mappings.put("/index.do", new IndexController());
		mappings.put("/login.do", new LoginController());
		mappings.put("/loginProcess.do", new LoginProcessController());
		mappings.put("/logout.do", new LogoutController());
		mappings.put("/terms.do", new TermsController());
		mappings.put("/signUp.do", new SignUpController());
		mappings.put("/signUpProcess.do", new SignUpProcessController());
		mappings.put("/duplicateCheckId.do", new DuplicateCheckIdController());
		mappings.put("/insertAccountTerms.do", new InsertAccountTermsController());
		mappings.put("/insertAccount.do", new InsertAccountController());
	}
	
	public Controller getController(String uri) {
		
		return mappings.get(uri);
		
	}
	
}




