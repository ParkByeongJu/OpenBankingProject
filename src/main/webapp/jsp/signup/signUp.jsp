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
<title>BjBanking : SignUp</title>
<link rel="stylesheet" href="/BjBanking/css/main.css">
<link rel="stylesheet" href="/BjBanking/fontawesome/css/all.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<script type="text/javascript">

		function checkId() {
			var id = $('#id').val();
			var idRegex = /^[a-zA-Z0-9]+$/;
			console.log('duplicate check start...')
			if (id.length > 0 && id.match(idRegex)) {
	        $.ajax({
	            url: '/BjBanking/duplicateCheckId.do',
	            type: 'post',
	            data: {id: id},
	            success: function (response) {
	                response = response.trim();
	                if (response === "success") {
	                    $('.okId').css("display", "inline-block");
	                    $('.alreadyId').css("display", "none");
	                } else if (response === "Duplicate") {
	                    $('.okId').css("display", "none");
	                    $('.alreadyId').css("display", "inline-block");
	                } else {
	                    $('.okId').css("display", "none");
	                    $('.alreadyId').css("display", "none");
	                }
	            },
	            error: function (request, error) {
	                alert("에러");
	            	}
	        	});
		    } else {
		        $('.okId').css("display", "none");
		        $('.alreadyId').css("display", "none");
		    }
		};
		
		// 비밀번호 유효성 검사
		function checkPassword() {
	        var password = document.getElementById("passwordsignUp").value;
	        var passwordRegex = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,}$/;
	        if (password.match(passwordRegex)) {
	        	$('.okpw').css("display", "inline-block");
	            $('.alreadypw').css("display", "none");
	        } else {
	        	$('.okpw').css("display", "none");
	            $('.alreadypw').css("display", "inline-block");
	        }
	    }
		
		// 비밀번호 확인
	    function checkRePassword() {
	        var password = document.getElementById("passwordsignUp").value;
	        var repassword = document.getElementById("repasswordsignUp").value;
	        if (password === repassword) {
	        	$('.okpwre').css("display", "inline-block");
	            $('.alreadypwre').css("display", "none");
	        } else {
	        	$('.okpwre').css("display", "none");
	            $('.alreadypwre').css("display", "inline-block");
	        }
	    }
		
	 	// 이름 유효성 검사
	    function checkName() {
	        var name = document.getElementById("signUpname").value;
	        var nameRegex = /^[가-힣a-zA-Z]+$/;
	        if (name.match(nameRegex)) {
	        	$('.oknm').css("display", "inline-block");
	            $('.alreadynm').css("display", "none");
	        } else {
	        	$('.oknm').css("display", "none");
	            $('.alreadynm').css("display", "inline-block");
	        }
	    }
	 	
	 	// 이메일 유효성 검사
	    function checkEmail() {
	        var email = document.getElementById("signUpEmail").value;
	        var emailRegex = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
	        if (email.match(emailRegex)) {
	        	$('.okem').css("display", "inline-block");
	            $('.alreadyem').css("display", "none");
	        } else {
	        	$('.okem').css("display", "none");
	            $('.alreadyem').css("display", "inline-block");
	        }
	    }
	 
	 	// 생년월일 유효성 검사
	    function checkBirth() {
	        var birth = document.getElementById("signUpBirth").value;
	        var birthRegex = /^\d{8}$/;
	        if (birth.match(birthRegex)) {
	        	$('.alreadybir').css("display", "none");
	        } else {
	        	$('.alreadybir').css("display", "inline-block");
	        }
	    }
	 	
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
	    
	    function validateForm() {
	        var isValid = true; // 기본적으로 true로 설정
	        
	        // 각 필드의 유효성 검사를 수행하고, 유효하지 않을 경우 isValid 값을 false로 설정
	        if (!checkId()) {
	            isValid = false;
	        }
	        if (!checkPassword()) {
	            isValid = false;
	        }
	        if (!checkrePassword()) {
	            isValid = false;
	        }
	        if (!checkEmail()) {
	            isValid = false;
	        }
	        if (!inputPhoneNumber()) {
	            isValid = false;
	        }
	        
	        return isValid; // isValid 값을 반환
	    }
	    
</script>

</head>
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
			<form action="/BjBanking/signUpProcess.do" method="post">
				<div class="signUpid">
					<input type="text" id="id" name="id" placeholder="아이디" class="border-type1" oninput = "checkId()">
					<div class="okId">사용가능한 아이디 입니다.</div>
					<div class="alreadyId">중복된 아이디 입니다. 다른 아이디를 입력해주세요.</div>
				</div>
				<div>
					<input type="password" id="passwordsignUp" name="password" placeholder="비밀번호" class="border-type1" oninput = "checkPassword()" >
					<div class="okpw">사용가능한 비밀번호 입니다.</div>
					<div class="alreadypw">알맞지 않은 비밀번호 입니다. 다른 비밀번호를 입력해주세요.</div>
				</div>
				<div>
					<input type="password" id="repasswordsignUp" name="repassword" placeholder="비밀번호 확인" class="border-type11" oninput = "checkRePassword()">
					<div class="okpwre">비밀번호가 일치합니다.</div>
					<div class="alreadypwre">비밀번호가 일치하지 않습니다.</div>
				</div>
				<div class="signUpName">
					<input type="text" id="signUpname" name="name" placeholder="이름" class="border-type2" oninput = "checkName()">
					<div class="alreadynm">정상적이지 않은 이름입니다. 이름을 확인해주세요.</div>
				</div>

				<div class="signUpEmail">
					<input type="text" id="signUpEmail" name="email" placeholder="이메일" class="border-type3" oninput = "checkEmail()">
					<div class="okem">사용가능한 이메일 입니다.</div>
					<div class="alreadyem">사용불가능한 이메일 입니다. 다른 이메일을 입력해주세요.</div>
				</div>

				<div class="signUpBirth">
					<input type="text" id="signUpBirth" name="birth" placeholder="생년월일(ex.19940827)" class="border-type4" oninput = "checkBirth()" maxlength = "8">
					<div class="alreadybir">비정상적인 생년월일 입니다. 생년월일을 확인 해주세요.</div>
				</div>

				<div class="signUpPhone">
					<input type="text" id="signUpPhone" name="phone" placeholder="휴대폰 번호" class="border-type5" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');" maxlength="13" onkeyup="inputPhoneNumber(this)">
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