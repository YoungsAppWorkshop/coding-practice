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
		// 쿠키값 가져오기
		// 클라이언트에 저장된 모든 쿠키값 => http => request 저장
		Cookie cookies[] = request.getCookies();
		String name = "쿠키값 없음";
		for (int i = 0; i < cookies.length; i++) {
			if (cookies[i].getName().equals("name")) {
				name = cookies[i].getValue();
			}
		}
	%>
	<h1>jsp3/cookieTest.jsp</h1>
	쿠키값 :
	<%=name%><br>
	<br>
	<input type="button" onclick="location.href='cookieSet.jsp'"
		value="쿠키값 저장">
	<input type="button" onclick="location.href='cookieDel.jsp'"
		value="쿠키값 삭제">

</body>
</html>