<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
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
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	function getAccountOwnerName() {
		var bank_cd = $("#bank_cd").val();
		var account_id = $("#reciverAccountId").val();
			$.ajax({
				url: '/BjBanking/checkAccountName.do',
				type: 'POST',
				data: {bank_cd: bank_cd, reciverAccountId: account_id},
				success: function (response) {
					console.log(response);
					if(response.trim()===""){
					$("#to_nm").text('');
					$("#to_nm").val('');
					}else{
					$("#to_nm").text(response);
					$("#to_nm").val(response);
					}
				},
				error: function(){
					$("#to_nm").text("���� Ȯ�� �� ������ �߻��߽��ϴ�.");	
				}
			});
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
			    		<a class="dropdown" href="#" role="button" id="bankIntroductionDropdown" data-bs-toggle="dropdown" aria-expanded="false" data-bs-offset="-2,35">���� �Ұ�</a>
			    		<ul class="dropdown-menu" aria-labelledby="bankIntroductionDropdown">
			    			<li><a class="dropdown-item mt-3 mb-3" href="#">�λ縻</a></li>
			    			<li><a class="dropdown-item mb-3" href="#">���� �Ұ�</a></li>
			    			<li><a class="dropdown-item mb-3" href="#">ã�ƿ��ô� ��</a></li>
			    		</ul>
			    	</div>
			    	
			    	<div class="item dropdown">
			    		<a class="dropdown" href="#" role="button" id="servicesDropdown" data-bs-toggle="dropdown" aria-expanded="false" data-bs-offset="-2,35">����</a>
			    		<ul class="dropdown-menu" aria-labelledby="servicesDropdown">
			    			<c:choose>
			    				<c:when test="${empty loginUser}">
					    			<li><a class="dropdown-item mt-3 mb-3" href="#">��ǰ ã��</a></li>
					    			<li><a class="dropdown-item mb-3" href="#">���� ��ȸ</a></li>
					    			<li><a class="dropdown-item mb-3" href="#">���� ��ü</a></li>
				    			</c:when>
				    			<c:otherwise>
				    				<li><a class="dropdown-item mt-3 mb-3" href="/BjBanking/ProductProcess.do">��ǰ ã��</a></li>
					    			<li><a class="dropdown-item mb-3" href="/BjBanking/accountCheck.do">���� ��ȸ</a></li>
					    			<li><a class="dropdown-item mb-3" href="#">���� ��ü</a></li>
				    			</c:otherwise>
			    			</c:choose>
			    		</ul>
			    	</div>
			    	
			    	<div class="item dropdown">
			    		<a class="dropdown" href="#" role="button" id="boardDropdown" data-bs-toggle="dropdown" aria-expanded="false" data-bs-offset="-2,35">�Խ���</a>
			    		<ul class="dropdown-menu" aria-labelledby="boardDropdown">
			    			<li><a class="dropdown-item mt-3 mb-3" href="#">�����Խ���</a></li>
			    			<li><a class="dropdown-item mb-3" href="#">���ǰԽ���</a></li>
			    		</ul>
			    	</div>
			    	
			    	<div class="item">
			    		<c:choose>
				    		<c:when test="${empty loginUser}">
				    			<a href="/BjBanking/login.do">�α���</a>
				    		</c:when>
				    		<c:otherwise>
				    			<div>${loginUser.name}��</div>
				    		</c:otherwise>
			    		</c:choose>
			    	</div>
			    	
			    	<div class="item">
			    		<c:choose>
				    		<c:when test="${empty loginUser}">
				    			<a href="#">ȸ������</a>
				    		</c:when>
				    		<c:otherwise>
				    			<a href="/BjBanking/logout.do">�α׾ƿ�</a>
				    		</c:otherwise>
			    		</c:choose>
			    	</div>
			    </div>
			</div>
		</header>
		
		<section>
			<h2>
				<span class="tit">���� ��ü[${loginUser.name}]</span>
			</h2>
			
			<div class="form-container">
			<form action="/BjBanking/transferProcess.do" method="post">
				
				<select id="bank_cd" class="form-select form-select-lg mb-3 form-select-custom" aria-label=".form-select-lg example" name="selectBankCode" onchange="getAccountOwnerName()">
					  <!-- �޴� �����ڵ� --> 
					  <option selected>���༱��</option>
					  <option value="0504">ezi����</option>
					  <option value="1003">BBM����</option>
					  <option value="0413">BjBank</option>
					  <option value="9999">KKP����</option>
				</select>
				
				<div>
					<!-- �޴� ���¹�ȣ -->
					<input type="text" onkeyup="getAccountOwnerName()" id="reciverAccountId" name="reciverAccountId" placeholder="���¹�ȣ�� �Է����ּ���" class="ac-border-type98">
				</div>
				<!-- ������ ���¹�ȣ -->
				<input type="hidden" class="form-control " name="senderAccountId" value = "${param.accountId }">
				<!-- ������ �����ڵ� -->
				<input type="hidden" class="form-control " name="bankId" value = "${bankCode }">
				<!-- ������ �̸� -->
				<input type="hidden" class="form-control " name="senderName" value = "${loginUser.name}">
				<!-- �޴� �̸� -->
				<input type="hidden" class="form-control " id="to_nm" name="reciverName">
				<div>
				<!-- ��ü �ݾ� -->
					<input type="text" id="amount" name="amount" placeholder="�۱��� �ݾ��� �Է����ּ���" class="ac-border-type99">
				</div>
				<div>
					<input type="password" id="accountPw" name="accountPw" placeholder="���� ��й�ȣ�� �Է����ּ���" class="ac-border-type3">
				</div>
				<div class="text-center"> <!-- ��ġ ������ ���� text-center Ŭ���� �߰� -->
			      <input type="submit" value="��ü�ϱ�" class="btn btn-customs" id="accountButton3"> <!-- ��ư ������ �����ϱ� ���� Ŭ������ btn btn-primary�� ���� -->
			    </div>
			</form>
			
		</div>
	</section>
	
	<footer class="py-3 mt-auto bg-dark text-light">
	  <div class="text-center p-3">
	    &copy; 2023 BjBank. All rights reserved.
	  </div>
	</footer>

</body>
</html>