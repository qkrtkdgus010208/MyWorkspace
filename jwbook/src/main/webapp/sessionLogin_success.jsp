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
    String id = request.getParameter("id");
    String pass = request.getParameter("passwd");

    if (id.equals("admin") && pass.equals("1234")) {
        session.setAttribute("id", id);
        response.sendRedirect("sessionLoginform.jsp");
    } else {
        out.println("<script>alert('아이디와 비밀번호가 틀렸습니다.'); history.back();</script>");
    }
%>
</body>
</html>