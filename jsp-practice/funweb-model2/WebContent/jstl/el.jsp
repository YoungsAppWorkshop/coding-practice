<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tag Library Practice</title>
</head>
<body>
	<h1>jstl/el.jsp</h1>
	<%--  EL(Expression Language) - 표현 언어 		--%>
	<%--  <% %> => ${ } 						--%>
	<%
		// 세션값 준비
		session.setAttribute("test", "session test");
	%>
	<form action="elPro.jsp" method="post">
		이름 : <input type="text" name="name" /> <br />
		<input type="submit" value="전송" />
	</form>
</body>
</html>