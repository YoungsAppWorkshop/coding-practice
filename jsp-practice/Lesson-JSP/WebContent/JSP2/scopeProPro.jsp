<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>영역 객체와 속성 - 7/26</title>
</head>
<body>
	<h1>jsp2/scopeProPro.jsp</h1>
	아이디 :
	<%=request.getParameter("id")%><br> 패스워드 :
	<%=request.getParameter("passwd")%><br> pageContext :
	<%=pageContext.getAttribute("page")%><br> request :
	<%=request.getAttribute("req")%><br> session :
	<%=session.getAttribute("sess")%><br> application :
	<%=application.getAttribute("app")%><br>
</body>
</html>