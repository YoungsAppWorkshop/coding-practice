<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP문법(1)-07/20</title>
</head>
<body>
	<h1>jsp1/test01.jsp</h1>
	<!-- html태그 주석 -->
	<%
		// java 코드
		System.out.println("자바명령");
		// jsp 코드
		out.println("<h1>jsp출력문</h1>");
		// java 한 줄 주석
		/*
		java 여러줄 주석
		*/
	%>
	<%-- <% jsp주석 %> --%>
	<table border="1">
		<tr>
			<td><%="1행 1열" %></td>
			<td><%="1행 2열" %></td>
		</tr>
		<tr>
			<td><%="2행 1열" %></td>
			<td><%="2행 2열" %></td>
		</tr>
	</table>
</body>
</html>