<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>쿠키(cookie) - 7/28</title>
</head>
<body>
	<%
		// 쿠키값 생성
		Cookie cookie = new Cookie("name", "Cookie Value");
		// 쿠키값 사용기간 지정
		cookie.setMaxAge(600);
		// 클라이언트 저장
		response.addCookie(cookie);
	%>
	<h1>jsp3/cookieSet.jsp</h1>
	<script type="text/javascript">
		alert("쿠키 생성");
		location.href="cookieTest.jsp";
	</script>
</body>
</html>