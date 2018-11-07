<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>데이터베이스 연동 연습 - 8/3</title>
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
		// 1단계 드라이버로더
		Class.forName("com.mysql.jdbc.Driver");
		// 2단계 디비 연결
		String dbUrl = "jdbc:mysql://localhost:3306/jspdb"; // DB주소
		String dbUser = "jspid"; // DB유저명
		String dbPass = "jsppass"; // DB비밀번호
		Connection con = DriverManager.getConnection(dbUrl, dbUser, dbPass); // 연결정보 저장
		// 3단계 sql member테이블 모든 회원 정보 가져 오기
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM member ;";
		// pstmt = con.prepareStatement(sql);
		Statement stmt=con.createStatement();
		// 4단계 실행 => rs저장
		ResultSet rs = null;
		// rs = pstmt.executeQuery();
		rs = stmt.executeQuery(sql);
		// 5단계
	%>
	<h1>jsp5/list.jsp</h1>
	<h2>회원 목록</h2>
	<table border="1">
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>가입날짜</th>
		</tr>
		<%
			while (rs.next()) {
		%><tr>
			<td><%=rs.getString("id")%></td>
			<td><%=rs.getString("passwd")%></td>
			<td><%=rs.getString("name")%></td>
			<td><%=rs.getTimestamp("reg_date")%></td>
			<%
				}
			%>
		</tr>
	</table>
	<input type="button" value="이전 화면으로" onclick="history.back()" />
</body>
</html>