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
<title>BjBanking : SignUP</title>
<link rel="stylesheet" href="/BjBanking/css/main.css">
<link rel="stylesheet" href="/BjBanking/fontawesome/css/all.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<script type="text/javascript">
	
</script>

</head>
<script type="text/javascript">
	function inputPhoneNumber(obj) {
	    var number = obj.value.replace(/[^0-9]/g, "");
	    var phone = "";
	
	    if( number.length < 1 ) {
	        phone= "";
	    }else if(number.length < 4) {
	        return number;
	    } else if(number.length < 7) {
	        phone += number.substr(0, 3);
	        phone += "-";
	        phone += number.substr(3);
	    } else if(number.length < 11) {
	        phone += number.substr(0, 3);
	        phone += "-";
	        phone += number.substr(3, 3);
	        phone += "-";
	        phone += number.substr(6);
	    } else {
	        phone += number.substr(0, 3);
	        phone += "-";
	        phone += number.substr(3, 4);
	        phone += "-";
	        phone += number.substr(7);
	    }
	    obj.value = phone;
	}
</script>
<body class="d-flex flex-column min-vh-100">
	<header>
		<div class="container-fluid d-flex justify-content-center align-items-center logo">
		    <div class="navb-logo">
		    	<img alt="" src="/BjBanking/image/logo.png">
		    </div>
		</div> 
	</header>
	
	<section class="flex-grow-1" style="height: 100%;">
		<h2>
			<span class="tit">회원가입</span> 
		</h2>
	
		<div class="form-container box_form_split">
			<form action="#" method="post">
				<div class="signUpid">
					<input type="text" id="id" placeholder="아이디" class="border-type1">
					<button type="button" class="idbutton">중복확인</button>
					<div class="checkId alert alert-danger">아이디가 중복입니다.</div>
				</div>
				<div>
					<input type="password" id="passwordsignUp" placeholder="비밀번호" class="border-type1">
				</div>
				<div>
					<input type="password" id="repasswordsignUp" placeholder="비밀번호 재입력" class="border-type11">
				</div>
				<div class="signUpName">
					<input type="text" id="signUpname" placeholder="이름" class="border-type2">
				</div>

				<div class="signUpEmail">
					<input type="text" id="signUpEmail" placeholder="이메일" class="border-type3">
				</div>

				<div class="signUpBirth">
					<input type="text" id="signUpBirth" placeholder="생년월일(ex.19940827)" class="border-type4">
				</div>

				<div class="signUpPhone">
					<input type="text" id="signUpPhone" placeholder="휴대폰 번호" class="border-type5" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');" maxlength="13" onkeyup="inputPhoneNumber(this)">
				</div>

				<div class="signUpAddr">
					<input type="text" name="post" maxlength="5" readonly class="border-type6" id="post">
					<input type="button" value="우편번호 검색" id="postBtn" class="postbutton">
					<input type="text" name="addr1" readonly class="border-type7" id="addr1">
					<input type="text" name="addr2" placeholder="상세주소" class="border-type8" id="addr2">
				</div>
				
				<div class="text-center"> <!-- 위치 조정을 위해 text-center 클래스 추가 -->
			      <input type="submit" value="가입하기" class="btn btn-customs" id="signupButton2"> <!-- 버튼 색상을 변경하기 위해 클래스를 btn btn-primary로 수정 -->
			    </div>
			</form>
			<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
			<script>
				const btn = document.querySelector("#postBtn");
				btn.addEventListener("click", () => {
				    new daum.Postcode({
				        oncomplete: function(data) {
							console.log(data);
							let fullAddr = '';
							let extraAddr = '';
							
							if(data.userSelectedType == 'R'){
								fullAddr = data.roadAddress;
							} else {
								fullAddr = data.jibunAddress;
							}
							
							if(data.userSelectedType == 'R'){
								if(data.bname !== ''){
									extraAddr += data.bname;
								}
								if(data.buildingName !== ''){
									extraAddr += (extraAddr != '' ? ',' + data.buildingName : data.buildingName);
								}
								
								fullAddr += (extraAddr !== '' ? '(' + extraAddr + ')' : '');
							}
							
							document.querySelector('#addr1').value = fullAddr;
							document.querySelector("#post").value = data.zonecode;
				        }
				    }).open();
				});
			</script>
		</div>
	</section>
	<footer id="footer" class="py-3 mt-auto bg-dark text-light">
	  <div class="text-center p-3">
	    &copy; 2023 BjBank. All rights reserved.
	  </div>
	</footer>
	
	
	
</body>
</html>