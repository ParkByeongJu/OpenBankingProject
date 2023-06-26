<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
<title>BjBanking : 상품조회</title>
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
				    			<li><a class="dropdown-item mb-3" href="#">계좌 개설</a></li>
				    			<li><a class="dropdown-item mb-3" href="#">계좌 조회</a></li>
				    			<li><a class="dropdown-item mb-3" href="#">계좌 이체</a></li>
			    			</c:when>
			    			<c:otherwise>
			    				<li><a class="dropdown-item mt-3 mb-3" href="#">상품 찾기</a></li>
				    			<li><a class="dropdown-item mb-3" href="/BjBanking/insertAccountTerms.do">계좌 개설</a></li>
				    			<li><a class="dropdown-item mb-3" href="#">계좌 조회</a></li>
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
			<span class="tit2">온라인 상품</span> 
		</h2>
		<div class="container">
					<div class="row">
						<c:forEach var = "product" items = "${ productList }">
						<div class="col">
						    <div class="card">
						      <img src="/BjBanking/image/product.png" class="card-img-top">
						      <div class="card-body">
							       <div class="text-center">
							        <h3 class="card-title">${product.productName }</h3>
							        <hr>
							        <p class="card-text">${product.productContent}</p>
							        <hr>
							        <a href="/BjBanking/createAccount.do?productCode=${product.productcd }" class="btn btn-secondary">가입하러 가기</a>
							      </div>
						      </div>
					    </div>
				    </div>
		    		</c:forEach>
		        </div>
			</div>
	</section>
	<footer class="py-3 mt-auto bg-dark text-light">
		<div class="text-center p-3">
	    	&copy; 2023 BjBank. All rights reserved.
	 	</div>
	</footer>

</body>
</html>