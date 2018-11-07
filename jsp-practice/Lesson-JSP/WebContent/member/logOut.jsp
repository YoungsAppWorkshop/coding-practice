<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Log Out - 8/11</title>
</head>
<body>
	<%
		// 세션값 초기화
		session.invalidate();
	%>
	<h1>member/logOut.jsp</h1>
	<script type="text/javascript">
		// 로그아웃 및 이동
		alert("로그아웃하셨습니다.");
		location.href = "main.jsp";
	</script>
</body>
</html>