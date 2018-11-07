<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>내장객체-request(2) 7/20</title>
</head>
<body>
	<h1>JSP1/requestPro01.jsp</h1>
	<%
	//	requestForm01.jsp에서 보낸 id값을 가져오기
	// 	request에 요청정보 id정보 저장	=> 문자열형으로 저장
	//	request.멤버변수		<= 속성
	//	request.메소드()
	//	request.getParameter("태그의 파라미터 이름")
	String snum = request.getParameter("num");
	// 	문자열 => 정수형으로 변환
	int n = Integer.parseInt(snum);
	%>
	아이디 :
	<%=request.getParameter("id") %><br> 좋아하는 숫자 :
	<%=request.getParameter("num") %><br>
	좋아하는 숫자 더하기:
	<%=n + 100 %><br>
	<%
	if(n>10){
		out.println("10보다 크다");
	} else {
		out.println("10보다 크지 않다");
	}
	%>
</body>
</html>