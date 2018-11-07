<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>메소드/전역변수 정의 - 7/26</title>
</head>
<body>
	<h1>jsp2/test.jsp</h1>
	<%
		String str = str2 + " Server Page";
	%>
	<%!
	String str2 = "Java";
	//	메소드 정의 : public 리턴할 형 prn() {}
	public String prn() {
		return str2 ;
	}
	%>
	출력 :
	<%=str%><br>
	메소드 호출: <%=prn() %><br>
</body>
</html>