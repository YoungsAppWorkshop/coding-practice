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
<title>MySQL과 JAVA연결 - 8/2</title>
</head>
<body>
	<h1>jsp4\select.jsp</h1>
	<table border="1">
		<tr>
			<td>학번</td>
			<td>이름</td>
		</tr>
		<%
			// 1단계 드라이버 로더
			Class.forName("com.mysql.jdbc.Driver");
			// 2단계 디비 연결
			String dbUrl = "jdbc:mysql://localhost:3306/jspdb"; // DB주소
			String dbUser = "jspid";
			String dbPass = "jsppass";
			Connection con = DriverManager.getConnection(dbUrl, dbUser, dbPass);
			// 3단계 SQL
			PreparedStatement pstmt = null;
			String sql = "SELECT * FROM student;";
			pstmt = con.prepareStatement(sql);
			// 4단계 실행 => 결과 저장
			ResultSet rs = null;
			rs = pstmt.executeQuery();
			// 5단계 저장 => 출력
			while (rs.next()) { // 첫번째행 true, false // 두번째행 true, false
				// true 실행문
				// rs.getInt("num") ; // columnIndex 열번호 1열 , columnLabel 열이름(필드명) "num"
		%>
		<tr>
			<td><%=rs.getInt("num")%></td>
			<td><%=rs.getString("name")%></td>
		</tr>
		<%
			}
			// false while 빠져나옴
		%>
	</table>
</body>
</html>