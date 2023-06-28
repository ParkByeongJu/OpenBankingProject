<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
<title>BjBanking : InsertAccount</title>
<link rel="stylesheet" href="/BjBanking/css/main.css">
<link rel="stylesheet" href="/BjBanking/fontawesome/css/all.css">
</head>
<body class="d-flex flex-column min-vh-100">

	<header>
		<div class="container-fluid">
		    
		    <div class="navb-logo">
		    	<img alt="" src="/BjBanking/image/logo.png">
		    </div>
		    
		    <div class="navb-items d-none d-xl-flex">
		    	
		    	<div class="item dropdown">
		    		<a class="dropdown" href="#" role="button" id="bankIntroductionDropdown" data-bs-toggle="dropdown" aria-expanded="false" data-bs-offset="-2,35">은행 소개</a>
		    		<ul class="dropdown-menu" aria-labelledby="bankIntroductionDropdown">
		    			<li><a class="dropdown-item mt-3 mb-3" href="#">인사말</a></li>
		    			<li><a class="dropdown-item mb-3" href="#">은행 소개</a></li>
		    			<li><a class="dropdown-item mb-3" href="#">찾아오시는 길</a></li>
		    		</ul>
		    	</div>
		    	
		    	<div class="item dropdown">
		    		<a class="dropdown" href="#" role="button" id="servicesDropdown" data-bs-toggle="dropdown" aria-expanded="false" data-bs-offset="-2,35">서비스</a>
		    		<ul class="dropdown-menu" aria-labelledby="servicesDropdown">
		    			<c:choose>
		    				<c:when test="${empty loginUser}">
				    			<li><a class="dropdown-item mt-3 mb-3" href="#">상품 찾기</a></li>
				    			<li><a class="dropdown-item mb-3" href="#">계좌 조회</a></li>
				    			<li><a class="dropdown-item mb-3" href="#">계좌 이체</a></li>
			    			</c:when>
			    			<c:otherwise>
			    				<li><a class="dropdown-item mt-3 mb-3" href="/BjBanking/ProductProcess.do">상품 찾기</a></li>
				    			<li><a class="dropdown-item mb-3" href="/BjBanking/accountCheck.do">계좌 조회</a></li>
				    			<li><a class="dropdown-item mb-3" href="#">계좌 이체</a></li>
			    			</c:otherwise>
		    			</c:choose>
		    		</ul>
		    	</div>
		    	
		    	<div class="item dropdown">
		    		<a class="dropdown" href="#" role="button" id="boardDropdown" data-bs-toggle="dropdown" aria-expanded="false" data-bs-offset="-2,35">게시판</a>
		    		<ul class="dropdown-menu" aria-labelledby="boardDropdown">
		    			<li><a class="dropdown-item mt-3 mb-3" href="#">자유게시판</a></li>
		    			<li><a class="dropdown-item mb-3" href="#">문의게시판</a></li>
		    		</ul>
		    	</div>
		    	
		    	<div class="item">
		    		<c:choose>
			    		<c:when test="${empty loginUser}">
			    			<a href="/BjBanking/login.do">로그인</a>
			    		</c:when>
			    		<c:otherwise>
			    			<div>${loginUser.name}님</div>
			    		</c:otherwise>
		    		</c:choose>
		    	</div>
		    	
		    	<div class="item">
		    		<c:choose>
			    		<c:when test="${empty loginUser}">
			    			<a href="#">회원가입</a>
			    		</c:when>
			    		<c:otherwise>
			    			<a href="/BjBanking/logout.do">로그아웃</a>
			    		</c:otherwise>
		    		</c:choose>
		    	</div>
		    </div>
		</div>
	</header>
	
	<section>
		<h2>
			<span class="tit">계좌 조회</span> 
		</h2>
		<h4>
			<span class = "tit3">총 계좌 잔액 : ${totalBalance }원</span>
		</h4>
		<div class="container1">
			<c:forEach var = "account" items = "${ accountList }">
				<div class="col">
				    <div class="accard">
				      <div class="card-body">
					       <div class="text-center acc">
					        <h3 class="card-title">${account.bankName}</h3>
					        <hr>
					        <p class="card-text">${account.productName} <br>${account.accountId }<br> <fmt:formatNumber value="${account.blance}" pattern="#,###" />원<br>${account.accountName}</p>
					        <hr>
					        <a href="/BjBanking/createAccount.do" class="btn btn-secondary acc1">이체하기</a>
					        <a href="/BjBanking/createAccount.do" class="btn btn-secondary acc2">상세조회하기</a>
					      </div>
				      </div>
			    </div>
		    </div>
		    </c:forEach>
        </div>
        
        <c:choose>
        <c:when test="${loginUser.status eq 'N' }">
	        <form action="/BjBanking/openBankingTerms.do" method="post">
	        	<input type="submit" value="오픈뱅킹 사용하기" class="btn btn-customs2" id="signupButton">
	        </form>
        </c:when>
        <c:otherwise>
       		<c:forEach var = "bbm" items = "${ bbm }">
				<div class="col">
				    <div class="accard">
				      <div class="card-body">
					       <div class="text-center acc">
					        <h3 class="card-title">${bbm.bankName}</h3>
					        <hr>
					        <p class="card-text">${bbm.productName} <br>${bbm.accountId }<br> <fmt:formatNumber value="${bbm.blance}" pattern="#,###" />원</p>
					        <hr>
					        <a href="/BjBanking/createAccount.do" class="btn btn-secondary acc1">이체하기</a>
					        <a href="/BjBanking/createAccount.do" class="btn btn-secondary acc2">상세조회하기</a>
					      </div>
				      </div>
			    </div>
		    </div>
		    </c:forEach>
        </c:otherwise>
        </c:choose>
	</section>
	
	<footer id="footer" class="py-3 mt-auto bg-dark text-light">
	  <div class="text-center p-3">
	    &copy; 2023 BjBank. All rights reserved.
	  </div>
	</footer>

</body>
</html>