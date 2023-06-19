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
<title>BjBanking : terms</title>
<link rel="stylesheet" href="/BjBanking/css/main.css">
<link rel="stylesheet" href="/BjBanking/fontawesome/css/all.css">
</head>
<body class="d-flex flex-column min-vh-100">
	
	<header>
	<div class="container-fluid d-flex justify-content-center align-items-center logo">
		    <div class="navb-logo">
		    	<img alt="" src="/BjBanking/image/logo.png">
		    </div>
		</div>   
	</header>
		
	<section>
		<h2>
			<span class="tit">ȸ������</span> 
		</h2>
		<div class="form-container1">
			<form action="#" method="post">
				<div class="form-check t1">
				  <input class="form-check-input" type="checkbox" value="" id="term1">
					  <label class="form-check-label" for="term1">
					    <span>(�ʼ�)�̿���</span>
					  </label>
				</div>
				<hr class="hr1">
				<div class="form-check t2">
				  <input class="form-check-input" type="checkbox" value="" id="term2">
					  <label class="form-check-label" for="term2">
					    <span>(�ʼ�)�������� ���� �� �̿� ����</span>
					  </label>
				</div>
				<div class="text-center mt-6"> <!-- ��ġ ������ ���� text-center Ŭ���� �߰� -->
			      <input type="submit" value="�����ϱ�" class="btn btn-customs"> <!-- ��ư ������ �����ϱ� ���� Ŭ������ btn btn-primary�� ���� -->
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