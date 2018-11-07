<%@page import="member.MemberBean"%>
<%@page import="java.util.List"%>
<%@page import="member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List - 8/18</title>
</head>
<body>
	<%
		// 세션값 가져오기
		String id = (String) session.getAttribute("id");
		// 세션값이 없으면, 세션값이 admin이 아니면
		// main.jsp
		if (id == null || !id.equals("admin")) {
			response.sendRedirect("main.jsp");
		}
		// 한글처리
		request.setCharacterEncoding("utf-8");
		// 디비작업 객체 생성 MemberDAO mdao
		MemberDAO mdao = new MemberDAO();
		// List memberList = 변수 = 메소드호출 getMembers()
		// List : java.util.list 배열과 유사한 객체 .size() : 배열의 크기를 가져오는 메소드
		List<MemberBean> memberList = mdao.getMembers();
	%>
	<h1>member/list.jsp</h1>
	<h2>
		회원 목록[<%=memberList.size()%>명]
	</h2>
	<table border="1">
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>가입날짜</th>
			<th>나이</th>
			<th>성별</th>
			<th>이메일</th>
		</tr>
		<%
			for (int i = 0; i < memberList.size(); i++) {
				MemberBean mb = (MemberBean) memberList.get(i);
		%><tr>
			<td><%=mb.getId()%></td>
			<td><%=mb.getPasswd()%></td>
			<td><%=mb.getName()%></td>
			<td><%=mb.getReg_date()%></td>
			<td><%=mb.getAge()%></td>
			<td><%=mb.getGender()%></td>
			<td><%=mb.getEmail()%></td>
			<%
				}
			%>
		</tr>
	</table>
	<input type="button" value="이전 화면으로" onclick="history.back()" />
</body>
</html>