<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 등록</title>
<link href="<%=request.getContextPath()%>/shopping/css/insert_item.css" rel="stylesheet">
</head>
<body>
<%@include file="./fix/navigation.jsp" %>
<div class ="bg-danger p-2" style="--bs-bg-opacity: .1; ">
	<div class="align-item-center">
		<form class ="row-cols-6" action="<%=request.getContextPath()%>/InsertItem.do" method="post" enctype="multipart/form-data">
			<div>
				<strong>상품명</strong>
				<input type="text" name="title"> 
			</div>
			<div>
				<strong>상품가격</strong>
				<input type="text" name="item_price"> 
			</div>
			<div>
				<strong>상품재고</strong>
				<input type="text" name="item_cnt"> 
			</div>
			<div>
				<strong>상품 설명</strong>
				<textarea name="content"> </textarea> 
			</div>
			<div>
				<strong>이미지 파일 등록</strong>
				<input type="file" name="item_image" id="item_image">  
			</div>
			<div class="m-3">
			<button class= "btn btn-outline-dark mt-auto"  type="submit" >상품 등록</button>
			</div>
		</form>
	</div>
</div>
<%@include file="./fix/footer.jsp" %>
</body>
</html>