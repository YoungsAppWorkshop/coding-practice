<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>데이터베이스 연동 연습 - 8/3</title>
</head>
<body>
	<h1>jsp5/insertForm.jsp</h1>
	<form action="insertPro.jsp" method="post">
		아이디 : <input type="text" name="id" /> <br />
		비밀번호 : <input type="password" name="passwd" /><br />
		이름 : <input type="text" name="name" /><br />
		<input type="submit" value="회원가입" />
	</form>
</body>
</html>