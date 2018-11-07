<%@page import="bean.BeanTestDB"%>
<%@page import="bean.BeanTest3"%>
<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JAVA Bean - 8/9</title>
</head>
<body>
	<%
		// 한글 처리
		request.setCharacterEncoding("utf-8");
		// 파라미터 가져오기 ID, passwd, name, reg_date
		// 		String id = request.getParameter("id");
		// 		String passwd = request.getParameter("passwd");
		// 		String name = request.getParameter("name");
		Timestamp reg_date = new Timestamp(System.currentTimeMillis());

		// 		// 자바빈 파일만들기 패키지bean	BeanTest3
		// 		// 자바빈 객체 생성 b3
		// 		// 자바빈 메서드호출 멤버변수 저장
		// 		BeanTest3 b3 = new BeanTest3();
		// 		b3.setId(id);
		// 		b3.setPasswd(passwd);
		// 		b3.setName(name);
		// 		b3.setReg_date(reg_date);
	%>
	<jsp:useBean id="bt3" class="bean.BeanTest3"></jsp:useBean>
	<jsp:setProperty property="*" name="bt3" />
	<%
		bt3.setReg_date(reg_date);
		// 디비작업 파일만들기 패키지 bean BeanTestDB
		// 디비작업 파일객체 생성 bdb
		BeanTestDB bdb = new BeanTestDB();

		// 디비작업 파일 메서드 호출 insertMember(b3)
		bdb.insertMember(bt3);
	%>
	<h1>jsp6/beanPro3.jsp</h1>
	아이디 :
	<jsp:getProperty property="id" name="bt3" />
	<br /> 패스워드 :
	<jsp:getProperty property="passwd" name="bt3" /><br /> 이름 :
	<jsp:getProperty property="name" name="bt3" /><br /> 등록날짜 :
	<jsp:getProperty property="reg_date" name="bt3" /><br />
</body>
</html>