<%@page import="board.BoardBean"%>
<%@page import="board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판 실습(업데이트 페이지) - 8/25</title>
</head>
<body>
	<%
		// int num 파라미터 가져오기
		int num = Integer.parseInt(request.getParameter("num"));
		// String pageNum 파라미터 가져오기
		String pageNum = request.getParameter("pageNum");
		// DB작업 객체 생성 BoardDAO bdao
		BoardDAO bdao = new BoardDAO();
		// 자바빈 BoardBean bb = 메서드호출.getBoard(num)
		BoardBean bb = bdao.getBoard(num);	
	%>
	<h1>board/update.jsp</h1>
	<h2>게시판 글수정</h2>
	<form action="updatePro.jsp?pageNum=<%=pageNum %>" method="post">
		<input type="hidden" name="num" value="<%=bb.getNum() %>" />
		<table border="1">
			<tr>
				<td>글쓴이</td>
				<td><input type="text" name="name" value="<%=bb.getName() %>"/></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pass" /></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="subject" value="<%=bb.getSubject() %>"/></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea name="content" cols="80" rows="50"><%=bb.getContent() %></textarea></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="글수정" /><input type="reset" value="초기화" /></td>
			</tr>
		</table>
	</form>
</body>
</html>