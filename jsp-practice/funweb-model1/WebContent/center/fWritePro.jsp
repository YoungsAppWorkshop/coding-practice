<%@page import="board.BoardBean"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		// 세션값 가져오기
		String id = (String) session.getAttribute("id");
		// 세션값 없으면 login페이지로 이동
		if (id == null) {
			response.sendRedirect("../member/login.jsp");
		}

		// 업로드할 프로그램 설치 /WEB-INF/lib/cos.jar
		// 업로드할 폴더 만들기 /WebContents/upload

		String realPath = request.getRealPath("/upload");
		// System.out.println(realPath);
		int maxSize = 5 * 1024 * 1024; // 5M
		MultipartRequest multi = new MultipartRequest(request, realPath, maxSize, "utf-8",
				new DefaultFileRenamePolicy());

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
		response.sendRedirect("fnotice.jsp");
	%>
</body>
</html>