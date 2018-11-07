<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>세션과 쿠키(1) - 7/27</title>
</head>
<body>
	<%
		//	세션값 삭제
		session.removeAttribute("name");
		//	이동 	"세션 삭제"		sessionTest.jsp
	%>
	<h1>jsp3/sessionDel.jsp</h1>
	<h2>세션값 삭제</h2>
	<script type="text/javascript">
		alert("세션 삭제");
		location.href = "sessionTest.jsp";
	</script>
</body>
</html>