<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>세션/로그아웃 - 7/27</title>
</head>
<body>
	<%
	session.invalidate();
	%>
	<h2>jsp3/sessionLogout.jsp</h2>
	<script type="text/javascript">
		alert("로그아웃합니다.");
		location.href="sessionMain.jsp";
	</script>
</body>
</html>