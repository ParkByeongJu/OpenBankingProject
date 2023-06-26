<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<script type="text/javascript">
	function checkPassword() {
	    var password = document.getElementById("acpw").value;
	    var regex = /^[0-9]+$/; // 숫자로만 구성되는지 확인하는 정규식
	
	    if (!regex.test(password)) {
	    	$('.okacpw').css("display", "none");
            $('.erroracpw').css("display", "inline-block");
        } else {
        	$('.okacpw').css("display", "inline-block");
            $('.erroracpw').css("display", "none");
        }
	  }	
	
	function checkRePassword(){
		var password = document.getElementById("acpw").value;
        var repassword = document.getElementById("acrepw").value;
        if (password === repassword) {
        	$('.okreacpw').css("display", "inline-block");
            $('.errorreacpw').css("display", "none");
        } else {
        	$('.okreacpw').css("display", "none");
            $('.errorreacpw').css("display", "inline-block");
        }
	}
</script>
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
			<span class="tit">계좌 개설 </span> 
		</h2>
	
		<div class="form-container">
			<form action="/BjBanking/insertAccountProcess.do" method="post">
				<div id="acid">
					${loginUser.id}
				</div>
				<input type="hidden" class="form-control " name="productCode" value = "${param.productCode }">
				<div>
					<input type="password" id="acpw" name="password" placeholder="계좌 비밀번호 숫자 4자리 입력" class="ac-border-type1" oninput="checkPassword()">
					<div class="erroracpw">숫자로만 입력해주세요!</div>
					<div class=okacpw>사용가능한 비밀번호 입니다.</div>
				</div>

				<div>
					<input type="password" id="acrepw" name="repassword" placeholder="계좌 비밀번호 4자리 재입력" class="ac-border-type2" oninput="checkRePassword()">
					<div class="errorreacpw">비밀번호가 일치하지 않습니다.</div>
					<div class=okreacpw>비밀번호가 일치합니다.</div>
				</div>
				<div>
					<input type="text" id="acnm" name="name" placeholder="계좌별칭을 입력" class="ac-border-type3">
				</div>
				<div class="text-center"> <!-- 위치 조정을 위해 text-center 클래스 추가 -->
			      <input type="submit" value="가입하기" class="btn btn-customs" id="accountButton3"> <!-- 버튼 색상을 변경하기 위해 클래스를 btn btn-primary로 수정 -->
			    </div>
			</form>
			
		</div>
	</section>
	
	<footer id="footer" class="py-3 mt-auto bg-dark text-light">
	  <div class="text-center p-3">
	    &copy; 2023 BjBank. All rights reserved.
	  </div>
	</footer>
	
</body>
</html>