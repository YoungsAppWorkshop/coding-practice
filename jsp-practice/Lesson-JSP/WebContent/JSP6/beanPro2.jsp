<%@page import="bean.BeanTest2"%>
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
		// 파라미터 가져오기 ID, passwd, num
// 		String id = request.getParameter("id");
// 		String passwd = request.getParameter("passwd");
// 		int num = Integer.parseInt(request.getParameter("num"));

// 		// 객체 생성 기억장소 할당 변수 이름 b2
// 		// 자바빈 메서드 호출 멤버변수 값 저장
// 		BeanTest2 b2 = new BeanTest2();
// 		b2.setId(id);
// 		b2.setPasswd(passwd);
// 		b2.setNum(num);
	%>
	<h1>jsp6/beanPro2.jsp</h1>
<!-- 	<ul> -->
<%-- 		<li>아이디 : <%=b2.getId()%></li> --%>
<%-- 		<li>패스워드 : <%=b2.getPasswd()%></li> --%>
<%-- 		<li>좋아하는 숫자 : <%=b2.getNum()%></li> --%>
<!-- 	</ul> -->
	<jsp:useBean id="bt1" class="bean.BeanTest2"></jsp:useBean>
	<%-- 	<jsp:setProperty property="id" name="bt1" /> --%>
	<%-- 	<jsp:setProperty property="passwd" name="bt1" /> --%>
	<%-- 	<jsp:setProperty property="num" name="bt1" /> --%>
	<jsp:setProperty property="*" name="bt1" />
	아이디 : 
	<jsp:getProperty property="id" name="bt1" />
	<br /> 패스워드 :
	<jsp:getProperty property="passwd" name="bt1" />
	<br /> 좋아하는 숫자 :
	<jsp:getProperty property="num" name="bt1" />
	<br />

</body>
</html>