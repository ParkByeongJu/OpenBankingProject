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
		mappings.put("/insertAccountProcess.do", new InsertAccountProcessController());
		mappings.put("/getProduct.do", new GetProductController());
		mappings.put("/ProductProcess.do", new ProductProcessController());
		mappings.put("/createAccount.do", new CreateAccountController());
		mappings.put("/accountCheck.do", new AccountCheckController());
		mappings.put("/openBankingTerms.do", new OpenBankingTermsController());
		mappings.put("/openBankingProcess.do", new OpenBankingProcessController());
	}
	
	public Controller getController(String uri) {
		
		return mappings.get(uri);
		
	}
	
}




