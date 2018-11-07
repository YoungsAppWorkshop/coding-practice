<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>내장객체-request(3) 7/21</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
	%>
	<h1>JSP1/requestPro03.jsp</h1>
	아이디 :
	<%=request.getParameter("id")%>
	<br> 비밀번호 :
	<%=request.getParameter("passwd")%>
	<br> 성별 :
	<%=request.getParameter("se")%>
	<br> 학년 :
	<%=request.getParameter("hak")%>
	<br> 메모 :
	<%=request.getParameter("memo")%>
	<br> 취미 :
	<%
		// 배열 변수에 저장 << getParameterValues
		// 자료형[] 변수이름 =
		// 자료형  []변수이름 =
		// 자료형 변수이름[] =
		String sho[] = request.getParameterValues("ho");
		if (sho != null) {
			for (int i = 0; i < sho.length; i++) {
				out.println(sho[i] + " ");
			}
		}
	%>
	<br>
</body>
</html>