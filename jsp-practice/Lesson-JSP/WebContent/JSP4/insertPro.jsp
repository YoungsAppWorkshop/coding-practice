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
	<%
		// 한글 처리
		request.setCharacterEncoding("utf-8");

		// num, name 파라미터 변수 저장
		int num = Integer.parseInt(request.getParameter("num"));
		String sname = new String();
		sname = request.getParameter("name");
		out.println(num + " " + sname);

		String dbUrl = "jdbc:mysql://localhost:3306/jspdb";// DB주소
		String dbUser = "jspid"; // DB유저명
		String dbPass = "jsppass"; // DB비밀번호
		Connection con = null; // 연결 정보 저장 객체
		// JDBC프로그램 설치
		// 1단계 드라이버 로더
		Class.forName("com.mysql.jdbc.Driver");
		// 2단계 디비연결 및 연결 정보 저장
		con = DriverManager.getConnection(dbUrl, dbUser, dbPass);
		// 3단계 SQL 사용할 객체 생성
		//	String sql = "INSERT INTO student(num, name) VALUES (" + snum + ",'" + sname + "');";
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO student(num, name) VALUES (?,?);";
		pstmt = con.prepareStatement(sql);
		//	pstmt.setInt(parameterIndex, x)(); // 물음표번호 1,2,~
		// 	첫번째 물음표에 num값 정수형 바꾸어서 넣기
		pstmt.setInt(1, num);
		//	두번째 물음표에 sname문자열 넣기
		pstmt.setString(2, sname);
		pstmt.executeUpdate();
	%>
	<h1>jsp4/insertForm.jsp</h1>
</body>
</html>