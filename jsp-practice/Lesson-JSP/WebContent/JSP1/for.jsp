<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>for문 - 7/25</title>
</head>
<body>
	<h1>jsp1/for,jsp</h1>
	<%
		// 자바 배열
		// 자료형[] []변수이름[] = {"jsp", "java", "xml"}
		String str[] = { "jsp", "java", "xml", "html" };
		for (int i = 0; i < str.length; i++) {
			out.println("str[" + i + "]의 값은 : " + str[i] + "<br>");
		}
		out.println("<hr>");
		for (int i = 0; i < str.length; i++) {
	%>str[<%=i%>]의 값은 :
	<%=str[i]%>
	<br>
	<%
		}
	%>
	<br>
	<table border="1">
		<tr>
			<td>글번호</td>
			<td>글제목</td>
			<td>글내용</td>
		</tr>
		<%
			for (int i = 1; i <= 5; i++) {
				out.println("<tr><td>" + i + "</td><td>제목" + i + "</td><td>내용" + i + "</td></tr>");
			}
		%>
	</table>
	<br>
	<table border="1">
		<tr>
			<td>글번호</td>
			<td>글제목</td>
			<td>글내용</td>
		</tr>
		<%
			for (int i = 1; i <= 5; i++) {
		%><tr>
			<td><%=i%></td>
			<td>제목<%=i%></td>
			<td>내용<%=i%></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>