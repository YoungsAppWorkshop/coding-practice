<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>내장객체-session 7/25</title>
</head>
<body>
	<h1>jsp1/session.jsp</h1>
	<%
		// 	javax.servlet.http.HttpSession => 객체 생성 session
		//	session : 세션(연결) 정보를 저장하는 객체
		//	session.멤버변수
		//	session.메소드()
	%>
	세션ID :
	<%=session.getId()%><br> 세션생성시간 :
	<%=session.getCreationTime()%><br> 세션 최근접근시간 :
	<%=session.getLastAccessedTime()%><br>
	<!-- 세션유지시간 30분 -->
	세션 유지시간 :
	<%=session.getMaxInactiveInterval()%>초
	<br>
	<%
		session.setMaxInactiveInterval(3600);
	%>
	세션 유지시간 :
	<%=session.getMaxInactiveInterval()%>초
	<br>
	<hr>
	<%
		// 	세션값 생성(추가)
		session.setAttribute("id", "kim"); //이름, 값
		out.println("세션값 : " + session.getAttribute("id") + "<br>");
		//	추가한 세션값 삭제
		session.removeAttribute("id");
		out.println("추가한 세션값 삭제 : " + session.getAttribute("id") + "<br>");
		//	세션 초기화 로그아웃
		session.invalidate();
		out.println("<hr><br>");
		// 	out 객체
		// 	javax.servlet.jsp.Jspwriter	=> 객체 생성	=> out
		//	out	응답정보를 출력하는 객체, 출력 정보 저장
		out.println("출력정보 저장 출력하는 메소드<br>");
		out.println("버퍼 크기 : " + out.getBufferSize() + "바이트<br>");
		out.println("남은 크기 : " + out.getRemaining() + "바이트<br>");
		//	.clear() 내용버림		.clearBuffer() 저장되어 있는 버퍼만 버림
		//	.flush() 버퍼 내용 클라이언트로 보내고 버퍼 버림
		//	.close()
		out.println("<hr><br>");
		// 	application
		//	웹애플리케이션 동작하면 계속 기억하는 객체
		//	방문횟수 카운터
		//	javax.servlet.ServletContext => 객체생성 application
		//	.getServerInfo()	.getRealPath()
		out.println("서버 정보 : " + application.getServerInfo() + "<br>");
		out.println("물리적 정보 : " + application.getRealPath("/") + "<br>");
		out.println("<hr><br>");
		//	pageContext	=> 현페이지 정보 기억하는 객체
		//	javax.servlet.jsp.PageContext 객체 생성	=> pageContext
		out.println("<hr><br>");
	%>
</body>
</html>