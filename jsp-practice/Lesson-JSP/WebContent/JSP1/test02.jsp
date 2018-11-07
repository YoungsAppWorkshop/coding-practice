<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP문법(2)-07/20</title>
</head>
<body>
	<h1>jsp1/test02.jsp</h1>
	<%
		// 자바 변수 선언
		// 문자열 	id	passwd	정수형 age
		// id변수 "test"	passwd변수 "testpass"	age변수 20
		String id = "test";
		String passwd = "testpass";
		int age = 20;

		// 출력
		out.println(id + "님의<br>");
		out.println("비밀번호는 " + passwd + "이고, 나이는 " + age + "입니다.");
	%>
	<br>
	<br>
	<%-- <%= %>이용 --%>
	&lt;%-- &lt;%= %&gt;이용 --%&gt;
	<br>
	<%=id%>님의
	<br>비밀번호는
	<%=passwd%>이고, 나이는
	<%=age%>입니다.
</body>
</html>