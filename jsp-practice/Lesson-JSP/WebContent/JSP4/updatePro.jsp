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
		request.setCharacterEncoding("utf-8");
		int num = Integer.parseInt(request.getParameter("num"));
		String name = request.getParameter("name");
		Class.forName("com.mysql.jdbc.Driver");
		String dbUrl = "jdbc:mysql://localhost:3306/jspdb";
		String dbUser = "jspid";
		String dbPass = "jsppass";
		Connection con = DriverManager.getConnection(dbUrl, dbUser, dbPass);
		PreparedStatement pstmt =null;
		String sql = "UPDATE student SET name = ? WHERE num = ?;";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,name);
		pstmt.setInt(2,num);
		pstmt.executeUpdate();
		response.sendRedirect("select.jsp");
	%>
	<h1>jsp/updatePro.jsp</h1>
</body>
</html>