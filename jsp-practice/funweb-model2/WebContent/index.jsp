<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Model2 Practice</title>
</head>
<body>
	<h1>index.jsp</h1>
	<%
		// http://localhost:8080/Model2/
		// response.sendRedirect("./BoardList.bo");
		// response.sendRedirect("./MemberJoin.me");
		// response.sendRedirect("./MemberLogin.me");
		// response.sendRedirect("./GoodsAdd.ag");
		// response.sendRedirect("./GoodsList.ag");
		// response.sendRedirect("./GoodsList.go");
		response.sendRedirect("./AdminOrderList.ao");
	%>
</body>
</html>
