<%@page import="member.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>바로 구매</title>
</head>
<!-- Favicon-->
<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
<!-- Bootstrap icons-->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
<link href="<%=request.getContextPath()%>/purchase/css/orderSheet.css" rel="stylesheet">
<body>
<div class="wrapper">
<div class="container">
<form action="" method="post">
<div class="member">
<a> <strong>${name}</strong>님, 주문결제 페이지 </a><br>
<a> tel : ${member.tel} </a> <br>
<a> ${member.address}</a>
</div>


</form>
</div>
</div>
</body>
</html>