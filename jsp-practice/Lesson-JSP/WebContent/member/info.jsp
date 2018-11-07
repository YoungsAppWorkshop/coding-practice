<%@page import="member.MemberBean"%>
<%@page import="member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Info - 8/11</title>
</head>
<body>
	<%
		// 세션값 가져오기
		String id = (String) session.getAttribute("id");
		// 세션값이 없으면(null이면) logInForm.jsp로 이동
		if (id == null) {
			response.sendRedirect("logInForm.jsp");
		}
		// MemberDAO 객체 생성 mdao
		MemberDAO mdao = new MemberDAO();
		// MemberBean mb = 메소드호츨 .getMember(id)
		MemberBean mb = mdao.getMember(id);
	%>
	<h1>member/info.jsp</h1>
	<h2>회원정보 조회</h2>
	<table border="1">
		<tr>
			<th>아이디</th>
			<td><%=mb.getId()%></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><%=mb.getPasswd()%></td>
		</tr>
		<tr>
			<th>이름</th>
			<td><%=mb.getName()%></td>
		</tr>
		<tr>
			<th>등록일자</th>
			<td><%=mb.getReg_date()%></td>
		</tr>
		<tr>
			<th>나이</th>
			<td><%=mb.getAge()%></td>
		</tr>
		<tr>
			<th>성별</th>
			<td><%=mb.getGender()%></td>
		</tr>
		<tr>
			<th>이메일</th>
			<td><%=mb.getEmail()%></td>
		</tr>
	</table><br>
	<input type="button" value="메인화면으로 이동" onclick="history.back()">

</body>
</html>