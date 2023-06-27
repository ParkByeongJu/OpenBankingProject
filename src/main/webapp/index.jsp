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
<title>BjBanking : Main</title>
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
		<div class="container">
			<div class="row">
				<div class="col">
				    <div class="card">
				      <img src="/BjBanking/image/product.png" class="card-img-top">
				      <div class="card-body">
					       <div class="text-center">
					        <h3 class="card-title">��ü ��ǰ</h3>
					        <hr>
					        <p class="card-text">�ű� ��ǰ �� ���Ե鿡�� <br>���� ����� ���� ��ǰ�� Ȯ���غ�����.</p>
					        <hr>
					        <a href="#" class="btn btn-secondary">��ǰ ��������</a>
					      </div>
				      </div>
			    </div>
		    </div>
		    
		    	<div class="col">
				    <div class="card">
				      <img src="/BjBanking/image/product.png" class="card-img-top">
				      <div class="card-body">
					       <div class="text-center">
					        <h3 class="card-title">���� ��ȸ</h3>
					        <hr>
					        <p class="card-text custom-bg"> ���� ������<br>���� ���� ���¸� Ȯ���غ�����.</p>
					        <hr>
					        <a href="#" class="btn btn-secondary">���� ��ȸ�ϱ�</a>
					      </div>
				      </div>
				    </div>
			    </div>
			    
			    <div class="col">
				    <div class="card">
				      <img src="/BjBanking/image/product.png" class="card-img-top">
				      <div class="card-body">
					       <div class="text-center">
					        <h3 class="card-title">���� ��ü</h3>
					        <hr>
					        <p class="card-text custom-bg">���� ������ ������ �ݾ���<br>�ٸ� �п��� �۱��غ�����.</p>
					        <hr>
					        <a href="#" class="btn btn-secondary">���� ��ü�ϱ�</a>
					      </div>
				      </div>
				    </div>
			    </div>
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
