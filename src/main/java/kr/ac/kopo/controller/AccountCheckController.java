package kr.ac.kopo.controller;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.kopo.DAO.AccountDAO;
import kr.ac.kopo.DAO.OpenBankingDAO;
import kr.ac.kopo.VO.AccountVO;
import kr.ac.kopo.VO.MemberVO;

public class AccountCheckController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String id = ((MemberVO)session.getAttribute("loginUser")).getId();
		AccountVO vo = new AccountVO();
		vo.setId(id);
		
		AccountDAO dao = new AccountDAO();
		dao.totalBalance(id);
		List<AccountVO> accountList = dao.accountList(id);
		
		OpenBankingDAO opdao = new OpenBankingDAO();
		opdao.accountList(id);
		List<AccountVO> bbmAccountList = opdao.accountList(id);
		
	    NumberFormat currencyFormatKorea = NumberFormat.getInstance(Locale.KOREA);
	    String formattedAmountKorea = currencyFormatKorea.format(dao.totalBalance(id));
		
		request.setAttribute("totalBalance", formattedAmountKorea);
		request.setAttribute("accountList", accountList);
		request.setAttribute("BBM", bbmAccountList);

		return "/jsp/account/accountCheck.jsp";
	}

}
