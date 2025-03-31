<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="jwbook.LoginBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p> 로그인에 성공했습니다.
<hr>
<p> <%
		LoginBean bean = (LoginBean) request.getAttribute("bean");
		out.print("아이디 : " + bean.getId());
	%>
</body>
</html>