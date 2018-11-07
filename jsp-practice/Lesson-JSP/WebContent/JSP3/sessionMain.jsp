<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>세션/메인 - 7/27</title>
</head>
<body>
	<%
	// 세션값 String id 저장
	String id = (String)session.getAttribute("id");
	// 세션값이 없으면 이동 : sessionForm.jsp
	if ( id == null ) {
		response.sendRedirect("sessionForm.jsp");
	}
	%>
	<h1>jsp3/sessionMain.jsp</h1>
	<%=id %> 님 로그인 하셨습니다. <br><br>
	<input type="button" value="로그아웃" onclick="location.href='sessionLogout.jsp'">
</body>
</html>