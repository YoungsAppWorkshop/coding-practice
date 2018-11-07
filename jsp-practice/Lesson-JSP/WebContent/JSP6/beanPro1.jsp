<%@page import="bean.BeanTest1"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JAVA Bean - 8/8</title>
</head>
<body>
	<%
		// 한글 처리
		request.setCharacterEncoding("utf-8");
		// 파라미터 가져오기 ID
		String id= request.getParameter("id");
	
		// 자바빈 파일 만들기
		
		// 자바빈 객체 생성 => 기억장소 할당
		// BeanTest1 클래스를 참조하는 변수 b 선언
		// new 기억공간 새로 만듦. BeanTest1 안의 멤버변수, 메소드 기억공간을 만듦
		BeanTest1 b = new BeanTest1(); 
		// ID => 자바빈 저장
		// b주소가 참조하는 id 변수 = 파라미터값을 받은 String 변수 치환
		b.setId(id);
		out.println(b.getId());
		// DB작업 => JAVA 파일
		// ID 자바파일로 보내기
		// 자바빈을 자바파일로 보내기
	%>
	<h1>jsp6/beanPro1.jsp</h1>
	<jsp:useBean id="bt1" class="bean.BeanTest1"></jsp:useBean>
	<jsp:setProperty property="id" name="bt1" param="id"/>
	아이디 : <jsp:getProperty property="id" name="bt1"/> <br />
</body>
</html>