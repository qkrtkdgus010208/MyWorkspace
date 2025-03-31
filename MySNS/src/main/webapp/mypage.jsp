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
	session.setAttribute("from_page", "mypage");
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
			<form method="post" action="/jwbook/snsController?action=logout">
				<td colspan=2 align=right height=40>
				<input type="submit" value="로그아웃"></td>
			</form>
			<form method="post" action="/jwbook/snsController?action=back">
				<td colspan=2 align=right height=40>
				<input type="submit" value="돌아가기"></td>
			</form>
			<form method="post" action="/jwbook/snsController?action=withdraw">
    			<td colspan=2 align=right height=40>
    			<input type="submit" value="회원탈퇴"></td>
			</form>
		</tr>
		<!-- feedlist에서 login_id와 일치하는 게시글만 필터링 -->
		<c:forEach var="feeds" items="${feedlist}" varStatus="status">
			<c:if test="${feeds.id == login_id}">
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
				<tr>
					<td colspan=4 align=right>
						<form method="post" action="/jwbook/snsController?action=delete">
							<input type="hidden" name="id" value="${feeds.id}">
							<input type="hidden" name="ts" value="${feeds.ts}">
							<input type="submit" value="삭제"></td>
						</form>
					</td>
				</tr>
			</c:if>
		</c:forEach>
	</table>
</body>
</html>