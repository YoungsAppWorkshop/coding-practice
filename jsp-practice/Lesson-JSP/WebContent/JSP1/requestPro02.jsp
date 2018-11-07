<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>내장객체-request(2) 7/20</title>
</head>
<body>
	<h1>JSP1/requestPro02.jsp</h1>
	<%
		//	request 한글set
		//	request.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		int age = Integer.parseInt(request.getParameter("age"));
	%>
	이름 :
	<%=request.getParameter("name")%>
	<br> 나이 :
	<%=age%>
	<br>
	<%
		if (age < 20) {
			out.println(age + " 나이는 미성년입니다.");
		} else {
			out.println(request.getParameter("name") + " 님의 " + age + " 나이는 20세 이상입니다.");
		}
	%>
</body>
</html>