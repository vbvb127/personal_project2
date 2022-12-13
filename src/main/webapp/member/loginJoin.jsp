<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인/회원가입</title>
<link href="<%=request.getContextPath()%>/member/css/style.css" rel="stylesheet">
</head>
<body>
<div class="wrapper">
  <div class="container">
    <div class="sign-up-container">
      <form action="<%=request.getContextPath()%>/MemberCreate.do" method="post">
        <h1>계정 생성</h1>
        <span>정보를 입력하세요.</span>
        <input type="text" placeholder="Name" name="name">
        <input type="text" placeholder="Id" name="id">
        <input type="password" placeholder="Password" name="password">
        <input type="text"  placeholder="address" name="address"> 
        <input type="text" placeholder="Tel(010-0000-0000)" name="tel"  > 
        <button  type="submit" class="form_btn">Sign Up</button>
      </form>
    </div>
    <div class="sign-in-container">
      <form action="<%=request.getContextPath()%>/MemberLogin.do" method="post">
        <h1>로그인</h1>
        <span>아이디와 비밀번호를 입력해주세요</span>
        <input type="text" placeholder="Id" name="id">
        <input type="password" placeholder="Password" name="password">
        <button class="form_btn" type="submit">Sign In</button>
      </form>
    </div>
    <div class="overlay-container">
      <div class="overlay-left">
        <h1>안녕하세요.</h1>
        <p>로그인을 해주세요.</p>
        <button id="signIn" class="overlay_btn">Sign In</button>
      </div>
      <div class="overlay-right">
        <h1>안녕하세요.</h1>
        <p>회원가입 해주세요</p>
        <button id="signUp" class="overlay_btn">Sign Up</button>
      </div>
    </div>
  </div>
</div>
</body>
<script type="text/javascript" src="<%=request.getContextPath()%>/member/script/loginJoin.js"></script>
</html>
 