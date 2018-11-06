<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Model2 Practice</title>
</head>
<body>
	<%
		// 세션값 가져오기
		String id = (String) session.getAttribute("id");
		// 세션값이 없으면(null이면) logInForm.jsp로 이동
		if (id == null) {
			response.sendRedirect("./MemberLogin.me");
		}
	%>
	<h1>member/main.jsp</h1>
	<%=id%>님 로그인 하셨습니다.
	<br />
	<input type="button" value="로그아웃"
		onclick="location.href='./MemberLogout.me'" />
	<br />
	<a href="info.jsp">회원정보 조회</a>
	<a href="./MemberUpdate.me">회원정보 수정</a>
	<a href="deleteForm.jsp">회원정보 삭제</a>
	<a href="./GoodsList.go">사용자 쇼핑몰 상품목록</a>
	<%
		// 관리자 아이디 : "admin" 가정
		if (id != null) {
			if (id.equals("admin")) {
	%>
	<a href="list.jsp">회원목록</a> 
	<a href="./GoodsList.ag">관리자 쇼핑몰 상품목록</a>
	<%
			}
		}
	%>
</body>
</html>