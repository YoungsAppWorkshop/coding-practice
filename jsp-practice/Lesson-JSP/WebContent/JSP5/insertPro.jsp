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
<title>데이터베이스 연동 연습 - 8/3</title>
</head>
<body>
	<h1>jsp5/insertPro.jsp</h1>
	<%
		// 한글처리
		request.setCharacterEncoding("utf-8");
		// 파라미터 가져오기
		String id = request.getParameter("id");
		String password = request.getParameter("passwd");
		String name = request.getParameter("name");
		// 현시스템의 날짜 가져오기
		Timestamp reg_date = new Timestamp(System.currentTimeMillis());
		// 1단계 드라이버 로더
		Class.forName("com.mysql.jdbc.Driver");
		// 2단계 디비 연결
		String dbUrl = "jdbc:mysql://localhost:3306/jspdb"; // DB주소
		String dbUser = "jspid"; // DB유저명
		String dbPass = "jsppass"; // DB비밀번호
		Connection con = DriverManager.getConnection(dbUrl, dbUser, dbPass); // 연결정보 저장
		// 3단계 sql 준비 객체 생성
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO member(id, passwd, name, reg_date) VALUES (?,?,?,?);";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.setString(2, password);
		pstmt.setString(3, name);
		pstmt.setTimestamp(4, reg_date);
		// 4단계 실행
		pstmt.executeUpdate();
		// "회원가입 성공" 출력 >> 이동 logInForm.jsp
	%>
	<script>
	alert("회원가입 성공");
	location.href = "logInForm.jsp";
	</script>
</body>
</html>