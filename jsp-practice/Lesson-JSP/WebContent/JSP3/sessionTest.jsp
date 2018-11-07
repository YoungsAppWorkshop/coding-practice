<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>세션과 쿠키(1) - 7/27</title>
</head>
<body>
	<%
		// 	세션: 연결 정보 서버 저장, 페이지 상관 없이 기억
		// 	쿠키: 페이지 상관 없이 클라이언트 기억
		//	세션값 생성
		// 		session.setAttribute("이름", "값");
		// 		// 	세션 가져오기
		// 		session.getAttribute("이름");
		// 		//	하나의 세션 삭제
		// 		session.removeAttribute("이름");
		// 		//	세션 모두 삭제, 세션 초기화
		// 		session.invalidate();
		// 	세션값 가져오기
		String sname = (String) session.getAttribute("name");
		//	세션값 없으면(null이면) "세션값 없음"
		if (sname == null) {
			sname = "세션값 없음";
		}
	%>
	<h1>jsp3/sessionTest.jsp</h1>
	<input type="button" onclick="location.href='sessionSet.jsp'"
		value="세션값 저장">
	<input type="button" onclick="location.href='sessionDel.jsp'"
		value="세션값 삭제">
	<input type="button" onclick="location.href='sessionInv.jsp'"
		value="세션 초기화">
	<br>
	<br> 세션값 :
	<%=sname%>
</body>
</html>