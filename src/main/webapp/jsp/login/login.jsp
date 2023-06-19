<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
<title>BjBanking : login</title>
<link rel="stylesheet" href="/BjBanking/css/main.css">
<link rel="stylesheet" href="/BjBanking/fontawesome/css/all.css">
<script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js" charset="utf-8"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
</head>

<body class="d-flex flex-column min-vh-100">
<script src="https://developer.kakao.com/sdk/js/kakao.js"></script>
<script type="text/javascript">
	window.Kakao.init("b694c0f91492f827d18a01bdebc8180f");
	
	function kakaoLogin() {
		window.Kakao.Auth.login({
			scope:'profile_nickname, account_email, gender, birthday',
			success: function(authObj) {
				console.log(authObj);
				window.Kakao.API.request({
					url:'/v2/user/me',
					success: res => {
						const kakao_account = res.kakao_account;
						console.log(kakao_account);
					}
				});
			}
		})
	}
</script>
	<header>
		<div class="container-fluid d-flex justify-content-center align-items-center logo">
		    <div class="navb-logo">
		    	<img alt="" src="/BjBanking/image/logo.png">
		    </div>
		</div>    
	</header>
	
	<section>
		<div class="form-container">
		<form action="#" method="post">
			<div>
				<label for="id" class="form-label"></label>
				<input type="text" id="id" name="id" class="form-control" placeholder="아아디" />
			</div>
			<div class="mb-5">
				<label for="password" class="form-label"></label>
				<input type="password" id="password" name="password" class="form-control" placeholder="비밀번호" />
			</div>
			<div class="mb-3">
				<input type="submit" value="로그인" class="w-btn-dark" />
			</div>
		</form>
		
		<c:choose>
	        <c:when test="${not empty error}">
	            <div class="alert alert-danger" role="alert">
	                ${error}
	            </div>
	        </c:when>
	    </c:choose>
		<div class="sign-up">
			<a href="terms.do">회원가입</a>
		</div>
		<div class="search-pw">
			<a href="insertUser.do">비밀번호를 잊어버리셨나요?</a>
		</div>
		<div>
			<a href="javascript:kakaoLogin();"><img src="/BjBanking/image/kakaoLogin.png" class="kakaoLogin"></a>
		</div>
		
		<div id="naver_id_login" class="naverLogin"></div>
		
		<script type="text/javascript">
        var naver_id_login = new naver_id_login("8upP7sTs5f6T7JBpee_P", "http://localhost:8080/BjBanking/login.do");
        var state = naver_id_login.getUniqState();
        naver_id_login.setButton("green", 3,50);
        naver_id_login.setDomain("YOUR_SERVICE_URL");
        naver_id_login.setState(state);
        naver_id_login.setPopup();
        naver_id_login.init_naver_id_login();
    </script>
	
	</div>
		
	</section>
	
	<footer class="py-3 mt-auto bg-dark text-light">
	  <div class="text-center p-3">
	    &copy; 2023 BjBank. All rights reserved.
	  </div>
	</footer>
</body>
</html>