<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
	if (session.getAttribute("login_id") == null)
		session.setAttribute("login_id", request.getParameter("id"));
	session.setAttribute("from_page", "feedlist");
	%>
	<table align=center>
		<tr>
			<td><img src="${pageContext.request.contextPath}/${userimg}"></td>
		</tr>	
		<tr>
		<td><b> ${login_id} 님 ${count} 번째 방문을 환영합니다 </b></td>
		</tr>
		<tr>
			<td colspan=2 align=left height=40><b>작성글 리스트</b></td>
			<form method="post" action="/jwbook/write.jsp">
				<td colspan=2 align=right height=40>
				<input type="submit" value="글쓰기"></td>
			</form>
			<form method="post" action="/jwbook/snsController?action=myinfo">
    			<td colspan=2 align=right height=40>
    			<input type="submit" value="내정보"></td>
			</form>
			<form method="post" action="/jwbook/snsController?action=logout">
				<td colspan=2 align=right height=40>
				<input type="submit" value="로그아웃"></td>
			</form>
		</tr>
		<c:forEach var="feeds" items="${feedlist}" varStatus="status">
			<tr>
				<td colspan=2 align=left height=40>${feeds.id}</td>
				<td colspan=2 align=right height=40>${feeds.ts}</td>
			</tr>
			<tr>
				<td><img src="${pageContext.request.contextPath}/${feeds.img}"></td>
			</tr>
			<tr>
				<td><b>${feeds.content}</b></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>