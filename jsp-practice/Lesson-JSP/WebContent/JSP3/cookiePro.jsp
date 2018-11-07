<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>쿠키 실습 - 7/28</title>
</head>
<body>
	<%
		// 쿠키값 생성 "language"	값 cookieForm에서 받은 파라미터값
		// 24시간 60*60*24
		// 클라이언트 저장
		Cookie cookie = new Cookie("language", request.getParameter("lang"));
		cookie.setMaxAge(24 * 60 * 60);
		response.addCookie(cookie);
		// 이동 cookieForm.jsp
		// response.sendRedirect("cookieForm.jsp");
	%>
	<h1>jsp3/cookiePro.jsp</h1>
	<script type="text/javascript">
		alert("<%= request.getParameter("lang") %>"+" 언어 설정");
		location.href = "cookieForm.jsp";
	</script>
</body>
</html>