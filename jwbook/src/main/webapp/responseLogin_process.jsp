<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
Home > 리다이렉션 <hr>
<%
	String u_id = request.getParameter("id");
	String u_pw = request.getParameter("passwd");
	
	if (u_id.equals("admin") && u_pw.equals("1234")) {
		response.sendRedirect("responseLogin_success.jsp");
	} else {
		response.sendRedirect("responseLogin_failure.jsp");
	}
%>
</body>
</html>