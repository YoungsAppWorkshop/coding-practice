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
		// 	쿠키값 삭제하기
		// 	클라이언트에 저장된 모든 쿠키값 => http => request 저장
		//	클라이언트 쿠키 가져오기
		//	찾은 쿠키값 시간 0
		// 	찾은 쿠키값 클라이언트 저장
		Cookie cookies[] = request.getCookies();
		for (int i = 0; i < cookies.length; i++) {
			if (cookies[i].getName().equals("name")) {
				cookies[i].setMaxAge(0);
				response.addCookie(cookies[i]);
			}
		}
	%>
	<h1>jsp3/cookieDel.jsp</h1>
	<script type="text/javascript">
		alert("쿠키 삭제");
		location.href = "cookieTest.jsp";
	</script>
</body>
</html>