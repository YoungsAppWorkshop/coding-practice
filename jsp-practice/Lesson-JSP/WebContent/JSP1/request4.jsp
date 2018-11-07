<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>내장객체-request(4) 7/25</title>
</head>
<body>
	<h1>jsp1/request4.jsp</h1>
	<!-- 서버 정보, 클라이언트 정보, 파라미터 정보 저장 -->
	서버 도메인정보: <%= request.getServerName() %> <br>
	서버 포트 번호: <%= request.getServerPort() %> <br>
	요청 URL: <%= request.getRequestURL() %> <br>
	<!-- 서버 이름, 포트번호 뺀 나머지 주소 -->
	요청 URI: <%= request.getRequestURI() %> <br>	
	클라이언트 호스트명:<%= request.getRemoteHost() %> <br>	
	클라이언트 IP주소:<%= request.getRemoteAddr() %> <br>	
	프로토콜:<%= request.getProtocol() %> <br>	
	전송방식:<%= request.getMethod() %> <br>	
	컨텍스트 경로 : <%= request.getContextPath() %> <br>	
<%-- 	물리적 경로 : <%= request.getRealPath("/") %> <br>	 --%>
	세션 정보 :<%= request.getSession() %> <br>
	http헤더 정보 :<%= request.getHeader("host") %> <br>
</body>
</html>