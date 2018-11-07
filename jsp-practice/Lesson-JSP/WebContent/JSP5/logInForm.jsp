<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>데이터베이스 연동 연습 - 8/3</title>
</head>
<body>
	<h1>jsp5/logInForm.jsp</h1>
	<form action="logInPro.jsp" method="post">
		아이디 : <input type="text" name="id" /> <br /> 비밀번호 : <input
			type="password" name="passwd" /><br /> <input type="submit"
			value="로그인" />	<input type="button" value="회원 가입"
		onclick="location.href='insertForm.jsp'" />
	</form>

</body>
</html>