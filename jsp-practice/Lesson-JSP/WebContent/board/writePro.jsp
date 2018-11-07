<%@page import="board.BoardDAO"%>
<%@page import="java.sql.Date"%>
<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판 만들기 실습 - 8/22</title>
</head>
<body>
	<h1>board/writePro.jsp</h1>
	<%
		// 한글 처리
		request.setCharacterEncoding("utf-8");
		// 자바빈 패키지 board 파일이름 BoardBean
		// 액션태그 useBean BoardBean 객체 생성 bb
		// 액션태그 setProperty 폼 => 자바빈 멤버변수 저장
	%>
	<jsp:useBean id="bb" class="board.BoardBean"></jsp:useBean>
	<jsp:setProperty property="*" name="bb" />
	<%
		// set메소드 호출 : ip request.getRemoteAddr()
		bb.setIp(request.getRemoteAddr());
		// date java.sql.Date

		// DB작업파일 패키지 board 파일이름 BoardDAO
		// BoardDAO 객체 생성 bdao
		BoardDAO bdao = new BoardDAO();
		// 메소드 호출 insertBoard(bb)
		bdao.insertBoard(bb);
		response.sendRedirect("list.jsp");
	%>
</body>
</html>