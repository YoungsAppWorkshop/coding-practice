<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>자바문법 &lt;% %&gt; - 7/27</title>
</head>
<body>
	<h1>jsp2/test2.jsp</h1>
	<%
		// 자바 API - 폴더 구분 파일 정리
		// java폴더 - lang폴더 - System, String 파일 존재
		// java.lang.System		java.lang.String
		// java.lang => 기본위치
		// 객체 생성하지 않고 빠르게 사용
		// System.out.println("콘솔 출력");
		// 문자열 객체 생성
		String str = "문자열";
		// 날짜 객체 생성
		Date d = new Date();
		// 날짜 모양 수정 => 문자열 객체 생성 //
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
	%>
	<%=d %><br>
	<%=sd.format(d) %><br>
</body>
</html>