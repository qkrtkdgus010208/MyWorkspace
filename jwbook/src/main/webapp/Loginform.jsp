<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
Home > 로그인 폼 화면 <hr>
<form name="loginForm" action="responseLogin_process.jsp" method="post">
	아이디 : <input type="text" name="id"><br>
	비밀번호 : <input type="password" name="passwd"><br>
	<input type="submit" value="로그인">
</form>
</body>
</html>