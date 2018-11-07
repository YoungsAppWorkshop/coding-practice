<%@page import="org.json.simple.JSONArray"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	// js4/json3.jsp
	String dbUrl = "jdbc:mysql://localhost:3306/jspdb"; // DB주소
	String dbUser = "jspid"; // DB유저명
	String dbPass = "jsppass"; // DB비밀번호
	JSONArray arr = new JSONArray();
	
	// 1단계 드라이버 로더
	Class.forName("com.mysql.jdbc.Driver");
	
	// 2단계 디비 연결
	Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPass); 
	
	// 3단계 : sql 	member 테이블 id, passwd, name
	String sql = "SELECT id, passwd, name FROM member;";
	PreparedStatement pstmt = connection.prepareStatement(sql);
	
	// 4단계 : 실행 => rs 결과 저장
	ResultSet rs = pstmt.executeQuery();
	
	// 5단계 : rs 데이터 있으면 자바빈 <= 한 사람 데이터 저장
	while (rs.next()) {
		// 자바빈 => 배열 한 칸 저장	
		// 자바빈 => JSONObject	.put()		배열 => JSONArray		.add()
		JSONObject obj = new JSONObject();
		obj.put("id", rs.getString("id"));	// 키, 값
		obj.put("passwd", rs.getString("passwd"));
		obj.put("name", rs.getString("name"));
		arr.add(obj);
	}
%>

<%=arr %>