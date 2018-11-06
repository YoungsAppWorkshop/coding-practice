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
		// 한글 처리
		request.setCharacterEncoding("utf-8");
		String pageNum = request.getParameter("pageNum");
		// 자바빈 액션태그 객체 생성 BoardBean bb
		// 액션태그 폼 => 자바빈 멤버변수 저장
	%>
	<jsp:useBean id="bb" class="board.BoardBean"></jsp:useBean>
	<jsp:setProperty property="*" name="bb" />
	<%
		// ip => 멤버변수 ip저장
		bb.setIp(request.getRemoteAddr());
		// 디비파일 객체 생성 BoardDAO bdao
		BoardDAO bdao = new BoardDAO();
		// 메서드 호출 reInsertBoard(bb)
		bdao.reInsertBoard(bb);
		// "답글쓰기 성공" list.jsp 이동
		response.sendRedirect("notice.jsp?pageNum=" + pageNum);
	%>

</body>
</html>