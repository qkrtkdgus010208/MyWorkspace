<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
Home > 쿠키 생성 및 로그인 성공 <hr>
<%
	String u_id = request.getParameter("id");
	String u_pw = request.getParameter("passwd");
	
	if (u_id.equals("admin") && u_pw.equals("1234")) {
		Cookie cookies[] = request.getCookies();
		Cookie visitedCookie = null;
		
		for (int i=0; i<cookies.length; i++) {
			if (cookies[i].getName().equals("visited")) {
				visitedCookie = cookies[i];
				break;
			}
		}
		
		if (visitedCookie != null) {
			int count = Integer.parseInt(visitedCookie.getValue()) +1;
			out.print("<p>[ " + u_id + "] 님의 " + count + "번째 방문입니다. </p>");
			visitedCookie.setValue(count + "");
			response.addCookie(visitedCookie);
		} else {
			Cookie cooks_id = new Cookie("userID", "u_id");
			Cookie cooks_pw = new Cookie("userPW", "u_pw");
			Cookie cooks_count = new Cookie("visited", "1");
			response.addCookie(cooks_id);
			response.addCookie(cooks_pw);
			response.addCookie(cooks_count);
			out.print("쿠키를 생성하였습니다. <br>");
			out.print("<p>[ " + u_id + " ] 님의 첫 번째 방문입니다. </p>");
		}
	} else {
		response.sendRedirect("cookieLogin_failure.jsp");
	}
%>
</body>
</html>