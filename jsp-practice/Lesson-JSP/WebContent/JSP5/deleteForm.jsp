<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>데이터베이스 연동 연습 - 8/4</title>
</head>
<body>
	<%
		// 세션값 가져오기
		String id = (String) session.getAttribute("id");
		// 세션값이 없으면(null이면) logInForm.jsp로 이동
		if (id == null) {
			response.sendRedirect("logInForm.jsp");
		}
		// 		String passwd = new String();
		// 		String name = new String();
		// 		Timestamp reg_date = null;

		// 		// 1단계 : 드라이버 로드
		// 		Class.forName("com.mysql.jdbc.Driver");
		// 		// 2단계 : DB 접속
		// 		String dbUrl = "jdbc:mysql://localhost:3306/jspdb"; // DB주소
		// 		String dbUser = "jspid"; // DB유저명
		// 		String dbPass = "jsppass"; // DB비밀번호
		// 		Connection con = DriverManager.getConnection(dbUrl, dbUser, dbPass); // 연결정보 저장
		// 		// 3단계 SQL 객체생성, 조건ID에 해당하는 회원정보 가져오기
		// 		PreparedStatement pstmt = null;
		// 		String sql = "SELECT * FROM member WHERE id = ?;";
		// 		pstmt = con.prepareStatement(sql);
		// 		pstmt.setString(1, id);
		// 		// 4단계 실행 ResultSet에 저장
		// 		ResultSet rs = null;
		// 		rs = pstmt.executeQuery();
		// 		// 5단계 ResultSet의 데이터를 passwd, name, reg_date에 저장
		// 		if (rs.next()) {
		// 			passwd = rs.getString("passwd");
		// 			name = rs.getString("name");
		// 			reg_date = rs.getTimestamp("reg_date");
		// 		}
	%>
	<h1>jsp5/deleteForm.jsp</h1>
	<form action="deletePro.jsp" method="post">
		아이디 : <input type="text" name="id" value="<%=id%>" readonly /> <br />
		비밀번호 : <input type="password" name="passwd" /><br /> <input
			type="submit" value="전송" />
	</form>
</body>
</html>