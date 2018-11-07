<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JDBC 테스트 - 8/1</title>
</head>
<body>
	<%
		String dbUrl = "jdbc:mysql://localhost:3306/jspdb"; // DB주소
		String dbUser = "jspid"; // DB유저명
		String dbPass = "jsppass"; // DB비밀번호

		// JDBC	: Java DataBase Connectivity 설치
		// 경로 :	C:\Program Files (x86)\MySQL\Connector.J 5.1\mysql-connector-java-5.1.38-bin.jar
		// 이클립스 > 프로젝트 > WebContent > WEB-INF > lib > 파일 붙여넣기

		// JSP(JAVA) => MySQL 접속 단계
		// 1단계 	: mysql-connector-java-5.1.38-bin.jar 안에 설치된 프로그램 중 드라이버(압축파일내 /com/mysql/jdbc/Driver.class) 프로그램 로더
		Class.forName("com.mysql.jdbc.Driver");
		// 2단계	: DataBase 연결 (DB주소/유저명/비밀번호) 객체 : java.sql.DriverManager
		//		=> 연결정보 저장 => 연결정보 저장 객체 : java.sql.Connection
		// 		DriverManager.getConnection(DB주소,DB유저,비밀번호);
		Connection con = DriverManager.getConnection(dbUrl, dbUser, dbPass);
		out.println("연결성공");
		// 3단계 	: SQL 만들기 => SQL 저장 실행할 수 있는 정보 저장 => Statement, PreparedStatement, CallableStatement 객체 이용
		// 4단계 	: SQL 실행 OK(INSERT, UPDATE, DELETE) => 실행 결과 => 실행 결과 저장하는 객체(ResultSet)
		// 5단계	: SELECT 실행결과 => 출력, 저장, 처리
	%>
	<h1>jsp4/jdbcTest.jsp</h1>
</body>
</html>