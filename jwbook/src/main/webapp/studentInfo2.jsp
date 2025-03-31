<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>학생 정보 관리</h1>
	<hr>
	<h3>회원가입</h3>
	<form action="StudentController2?action=signup" method="post" enctype="multipart/form-data">
		<label>이름</label> <input type="text" name="username"><br>
		<label>비밀번호</label> <input type="text" name="password"><br>
		<label for="file">이미지 선택 :</label> <input type="file" name="imageFile"><br>
		<br> <input type="submit" value="Signup">
	</form>
	<hr>
	<h3>로그인</h3>
	<form action="StudentController2?action=login" method="post">
		<label>이름</label> <input type="text" name="username"><br>
		<label>비밀번호</label> <input type="text" name="password"><br>
		<input type="submit" value="Login">
	</form>
</body>
</html>