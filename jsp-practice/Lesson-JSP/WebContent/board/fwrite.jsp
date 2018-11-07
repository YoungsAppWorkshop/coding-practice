<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판 만들기 실습 - 8/30</title>
</head>
<body>
	<h1>board/fwrite.jsp</h1>
	<h2>파일 게시판 글쓰기</h2>
	<!-- 파일전송 폼 만들 때 : form태그 속성 enctype="multipart/form-data" 삽입 필요 -->
	<!-- 파일 첨부하지 않을 때는 삽입하면 안됨 -->
	<form action="fwritePro.jsp" method="post" enctype="multipart/form-data">
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
				<td><input type="text" name="subject" /></td>
			</tr>
			<tr>
				<td>파일</td>
				<td><input type="file" name="file" /></td>
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