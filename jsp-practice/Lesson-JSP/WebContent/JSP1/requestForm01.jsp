<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>내장객체-request(1) 7/20</title>
</head>
<body>
	<h1>JSP1/requestForm01.jsp</h1>
	<%
		//	원 자바 클래스 파일 javax.servlet.SevletRequest.java 	<= API
		//	객체 생성 ServletRequest request = new ServletRequest();
		//	내장 객체 request 
		//		=> 클라이언트 요청 => http 프로토콜 요청정보 저장 => 서버 요청 정보 저장
		// 	request = 기억장소 <= 클라이언트의 요청 정보를 저장하는 객체
	%>
	<form action="requestPro01.jsp" method="get" name="fr">
		아이디 : <input type="text" name="id"><br>
		좋아하는 숫자 : <input type="text" name="num"><br>
		<br> <input type="submit" value="전송">
	</form>
</body>
</html>