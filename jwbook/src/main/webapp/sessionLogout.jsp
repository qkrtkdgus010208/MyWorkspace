<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	session.invalidate();
	out.println("<script>alert('로그아웃되었습니다.');</script>");
	response.sendRedirect("sessionLoginform.jsp");
	//session.invalidate();
	//out.println("<script>alert('로그아웃되었습니다.'); window.location='sessionLoginform.jsp';</script>");
%>
</body>
</html>