<%@page import="board.BoardBean"%>
<%@page import="board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판 실습(삭제 페이지) - 8/25</title>
</head>
<body>
	<%
		// int num 파라미터 가져오기
		int num = Integer.parseInt(request.getParameter("num"));
		// String pageNum 파라미터 가져오기
		String pageNum = request.getParameter("pageNum");
	%>
	<h1>board/update.jsp</h1>
	<h2>게시판 글수정</h2>
	<form action="deletePro.jsp?pageNum=<%=pageNum%>" method="post">
		<input type="hidden" name="num" value="<%=num%>" />
		<table border="1">
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pass" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="글삭제" /></td>
			</tr>
		</table>
	</form>
</body>
</html>