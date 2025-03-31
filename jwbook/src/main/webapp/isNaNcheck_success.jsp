<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
Home > 닉네임과 비밀번호 입력 성공 <hr>
<%
	String sname = request.getParameter("sname");
	String passwd = request.getParameter("passwd");
%>
<p> 아이디 : <%= sname %>
<p> 비밀번호 : <%= passwd %>
</body>
</html>