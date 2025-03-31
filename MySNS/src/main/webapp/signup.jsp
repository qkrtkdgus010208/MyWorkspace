<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
function checkNaN() {
	var f = document.loginform;
	
	if(!/^[a-zA-Z0-9]+@[a-zA-Z0-9]+/.test(f.id.value)) {
		alert("아이디는 이메일 형태로 입력해주세요");
        f.id.focus();
        return false;
	} else if (isNaN(f.password.value)) {
		alert("비밀번호는 숫자로만 입력해주세요");
		f.password.focus();
		return false;
	} else
		return true; 
}
</script>
</head>
<body>
<table align=center>
	<tr>
		<td colspan=2 align=center height=40><b>회원가입</b>
		</td>
	</tr>
	<form name="loginform" method="post" action="/jwbook/snsController?action=signup" enctype="multipart/form-data" onsubmit="return checkNaN()">
	<tr>
		<td align=right>아이디&nbsp;</td>
		<td><input type="text" name="id" placeholder="Email address"
			required></td>
	</tr>
	<tr>
		<td align=right>패스워드&nbsp;</td>
		<td><input type="password" name="password" required></td>
	</tr>
	<tr>
		<td align=right>이름&nbsp;</td>
		<td><input type="text" name="name" required></td>
	</tr>
	<tr>
		<td align=right>사진</td>
		<td><input type="file" name="img" required></td>
	</tr>	
	<tr>
		<td colspan=2 align=center height=50><input type="submit"
			value="회원가입하기"></td>
	</tr>
	</form>
</table>
</body>
</html>