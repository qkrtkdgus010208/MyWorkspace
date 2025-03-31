<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% if (session.getAttribute("id") == null) { %>
    <form method="post" action="sessionLogin_success.jsp">
        아이디 : <input type="text" name="id"><br>
        비밀번호 : <input type="password" name="passwd"><br>
        <input type="submit" value="로그인">
    </form>
<% } else { %>
    <form method="post" action="sessionLogout.jsp">
        <%= session.getAttribute("id") %>님 방문을 환영합니다
        <input type="submit" value="로그아웃">
    </form>
<% } %>
</body>
</html>