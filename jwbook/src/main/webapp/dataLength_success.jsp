<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
Home > 아이디와 비밀번호 입력 성공 <hr>
<%
	String id = request.getParameter("id");
	String passwd = request.getParameter("passwd");
%>
<p> 아이디 : <%= id %>
<p> 비밀번호 : <%= passwd %>
</body>
</html>