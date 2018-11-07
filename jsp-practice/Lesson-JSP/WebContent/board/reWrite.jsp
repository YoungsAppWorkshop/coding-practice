<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판 실습(답글쓰기 페이지) - 8/29</title>
</head>
<body>
	<%
		int num = Integer.parseInt(request.getParameter("num"));
		// re_ref, re_lev, re_seq
		int re_ref = Integer.parseInt(request.getParameter("re_ref"));
		int re_lev = Integer.parseInt(request.getParameter("re_lev"));
		int re_seq = Integer.parseInt(request.getParameter("re_seq"));
	%>
	<h1>board/reWrite.jsp</h1>
	<h2>게시판 답글쓰기</h2>
	<form action="reWritePro.jsp" method="post">
		<input type="hidden" name="num" value="<%=num%>" /> <input
			type="hidden" name="re_ref" value="<%=re_ref%>" /> <input
			type="hidden" name="re_lev" value="<%=re_lev%>" /> <input
			type="hidden" name="re_seq" value="<%=re_seq%>" />
		<table border="1">
			<tr>
				<td>글쓴이</td>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pass" /></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="subject" value="[답글]" /></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea name="content" cols="80" rows="50"></textarea></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="글쓰기" /><input
					type="reset" value="초기화" /></td>
			</tr>
		</table>
	</form>
</body>
</html>