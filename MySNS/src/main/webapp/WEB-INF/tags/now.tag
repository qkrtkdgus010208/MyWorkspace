<%@ tag language="java" pageEncoding="EUC-KR"%>
<%@ tag body-content="empty" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ tag import="java.util.Calendar" %>

<%
	Calendar cal = Calendar.getInstance();
%>

<%= cal.get(Calendar.YEAR) %> ��
<%= cal.get(Calendar.MONTH) + 1 %> ��
<%= cal.get(Calendar.DATE) %> ��
