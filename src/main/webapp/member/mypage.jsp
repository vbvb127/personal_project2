<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<meta charset="UTF-8">
<title>MyPage</title>
<link href="<%=request.getContextPath()%>/member/css/style.css" rel="stylesheet">
</head>
<body>
<div class="wrapper">
  <div class="container">
      <form action="<%=request.getContextPath()%>/MemberUpdate.do" method="post">
        <h3 style="margin-top: 5px;">계정 정보 업데이트</h3>
        <span>수정 정보를 입력하세요.</span>
        <!-- disabled="disabled"는 post로 보낼 때 값을 가져올 수 없다.! readonly로 바꿔줌-->
        <input type="text" placeholder="Name" name="name">
        <input type="text" placeholder="Id" name="id"  readonly="readonly" value="${id}">
        <input type="password" placeholder="Password" name="password">
        <input type="text"  placeholder="address" name="address"> 
        <input type="text" placeholder="Tel(010-0000-0000)" name="tel"  > 
        <button  type="submit" class="form_btn">Edit</button>
      </form>
  </div>
</div>
</body>
</html>