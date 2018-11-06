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
		// 파라메터 가져오기
		String pageNum = request.getParameter("pageNum");
		String realPath = request.getRealPath("/upload");
		// System.out.println(realPath);
		int maxSize = 5 * 1024 * 1024; // 5M
		MultipartRequest multi = new MultipartRequest(request, realPath, maxSize, "utf-8",
				new DefaultFileRenamePolicy());

		// 자바빈 패키지 board 파일이름 BoardBean
		BoardBean bb = new BoardBean();
		// 액션태그 사용할 수 없음
		bb.setNum(Integer.parseInt(multi.getParameter("num")));
		bb.setName(multi.getParameter("name"));
		bb.setPass(multi.getParameter("pass"));
		bb.setSubject(multi.getParameter("subject"));
		bb.setContent(multi.getParameter("content"));

		// 첨부파일이 있으면 file, 첨부파일이 없으면 기존의 파일이름 file2
		if (multi.getFilesystemName("file") != null) {
			bb.setFile(multi.getFilesystemName("file"));
		} else {
			bb.setFile(multi.getParameter("file2"));
		}

		// set메소드 호출 : ip request.getRemoteAddr()
		bb.setIp(request.getRemoteAddr());
		// date java.sql.Date

		// DB작업파일 패키지 board 파일이름 BoardDAO
		// BoardDAO 객체 생성 bdao
		BoardDAO bdao = new BoardDAO();
		// int check = updateBoard(bb) 메서드 호출
		int check = bdao.fUpdateBoard(bb);
		if (check == 1) { // check == 1 "수정성공" notice.jsp?pageNum이동
	%>
	<script>
			alert("수정성공");
			location.href="fnotice.jsp?pageNum=<%=pageNum%>
		";
	</script>
	<%
		} else { // else 수정권한 없음 => 뒤로 이동
	%>
	<script>
		alert("수정권한 없음");
		history.back();
	</script>
	<%
		}
	%>
</body>
</html>