<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>jstl/fmt.jsp</h1>
	<fmt:setLocale value="en_US"/>
	<br />
	<fmt:formatNumber value="50000" type="currency"></fmt:formatNumber>
	<br />
	<fmt:formatNumber value="0.15" type="percent"></fmt:formatNumber>
	<br />
	<fmt:formatNumber value="5000000" pattern="###,###,###"></fmt:formatNumber>
	<br />
	<jsp:useBean id="date" class="java.util.Date"></jsp:useBean>
	<fmt:formatDate value="${date }" type="date"/><br />	
	<fmt:formatDate value="${date }" type="time"/><br />	
	<fmt:formatDate value="${date }" type="both"/><br />	
	<fmt:formatDate value="${date }" type="both" timeStyle="short" dateStyle="short"/><br />	
	<fmt:formatDate value="${date }" type="both" timeStyle="long" dateStyle="long"/><br />	
</body>
</html>