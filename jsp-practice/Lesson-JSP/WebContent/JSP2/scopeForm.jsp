<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>영역 객체와 속성 - 7/26</title>
</head>
<body>
	<h1>jsp2/scopeForm.jsp</h1>
	<%
		// 	영역				영역객체			범위
		// 	page			pageContext		해당 페이지 범위
		// 	request			request			요청되는 범위
		// 	session			session			세션(연결)이 유지되는 범위
		// 	application		application		웹어플리케이션 실행되는 동안
	%>
	<form action="scopePro.jsp" method="get">
	아이디 : <input type="text" name="id"><br>
	<input type="submit" value="전송">
	</form>
</body>
</html>