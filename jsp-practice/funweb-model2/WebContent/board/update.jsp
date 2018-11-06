<%@page import="net.board.db.BoardBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Model2 Practice</title>
</head>
<body>
	<%
		// 파라미터 가져오기
		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");
		
		// 데이터 가져오기
		BoardBean boardData = (BoardBean) request.getAttribute("board");
	%>
	<h1>board/update.jsp</h1>
	<h2>게시판 글수정</h2>
	<form action="./BoardUpdateAction.bo?pageNum=<%=pageNum %>" method="post">
		<input type="hidden" name="num" value="<%=boardData.getNum() %>" />
		<table border="1">
			<tr>
				<td>글쓴이</td>
				<td><input type="text" name="name" value="<%=boardData.getName() %>"/></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pass" /></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="subject" value="<%=boardData.getSubject() %>"/></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea name="content" cols="80" rows="50"><%=boardData.getContent() %></textarea></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="글수정" /><input type="reset" value="초기화" /></td>
			</tr>
		</table>
	</form>
</body>
</html>