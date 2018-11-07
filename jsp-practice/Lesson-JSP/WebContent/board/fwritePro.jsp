<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.multipart.FileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="board.BoardBean"%>
<%@page import="board.BoardDAO"%>
<%@page import="java.sql.Date"%>
<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판 만들기 실습 - 8/30</title>
</head>
<body>
	<h1>board/fwritePro.jsp</h1>
	<%
		// 한글 처리 불필요함(파일처리시 자동으로 처리됨)
		// 파일업로드 COS라이브러리 http://www.servlets.com
		// com.oreilly.servlet 다운로드
		// cos.jar >> WebContent-WEB-INF-lib 복사 붙여넣기
		// MultipartRequest 객체생성 multi
		// request정보, 파일을 올릴 물리적 경로, 파일최대크기, 한글처리, 
		// 파일 올린 폴더 안에 파일이름이 중복 => 이름을 자동으로 바꿔줌 FileRenamePolicy

		// WebContent - upload 폴더 만들기
		// upload 폴더 물리적 경로

		String realPath = request.getRealPath("/upload");
		System.out.println(realPath);
		int maxSize = 5 * 1024 * 1024; // 5M
		MultipartRequest multi = new MultipartRequest(request, realPath, maxSize, "utf-8", new DefaultFileRenamePolicy());

// 		System.out.println(request.getRealPath("/upload"));
// 		System.out.println("upload폴더가 올라간 파일 : "+ multi.getFilesystemName("file"));
// 		System.out.println("원본 파일 이름 : "+ multi.getOriginalFileName("file"));

		// 자바빈 패키지 board 파일이름 BoardBean
		BoardBean bb = new BoardBean();
		// 액션태그 사용할 수 없음
		bb.setName(multi.getParameter("name"));
		bb.setPass(multi.getParameter("pass"));
		bb.setSubject(multi.getParameter("subject"));
		bb.setFile(multi.getFilesystemName("file"));
		bb.setContent(multi.getParameter("content"));

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