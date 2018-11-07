<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="color.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>액션태그 Include - 7/26</title>
</head>
<body bgcolor="<%=color2 %>">
	<%@ include file="scopeForm.jsp"%>
	<h1>jsp2/include.jsp</h1>
	<table border="1" width="600">
		<tr>
			<td colspan="2" height="100"><jsp:include page="top.jsp">
					<jsp:param value="kim" name="id" /></jsp:include></td>
		</tr>
		<tr>
			<td width="100" height="400"><jsp:include page="left.jsp" /></td>
			<td>본문</td>
		</tr>
		<tr>
			<td colspan="2" height="100"><jsp:include page="bottom.jsp" /></td>
		</tr>
	</table>
</body>
</html>