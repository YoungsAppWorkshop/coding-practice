<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Delete Form - 8/18</title>
</head>
<body>
	<%
		// 세션값 가져오기
		String id = (String) session.getAttribute("id");
		// 세션값이 없으면(null이면) logInForm.jsp로 이동
		if (id == null) {
			response.sendRedirect("logInForm.jsp");
		}
	%>
	<h1>member/deleteForm.jsp</h1>
	<form action="deletePro.jsp" method="post">
		아이디 : <input type="text" name="id" value="<%=id%>" readonly /> <br />
		비밀번호 : <input type="password" name="passwd" /><br /> <input
			type="submit" value="전송" />
	</form> <input type="button" value="메인화면으로 이동" onclick="history.back()">
</body>
</html>