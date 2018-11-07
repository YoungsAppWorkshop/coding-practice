<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>내장객체-response 7/25</title>
</head>
<body>
	<%
		//	response 내장객체
		// 	javax.servlet.ServletResponse	=> 객체 생성 response
		//	response 서버 응답 정보 저장	=> 클라이언트 보냄
		//	response.멤버변수
		//	response.메소드()
		//			.setHeader()	.addCookie()	.setContentType(String url)
		
		// 	jsp 이동
		response.sendRedirect("request4.jsp");
	%>
</body>
</html>