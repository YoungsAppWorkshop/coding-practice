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
		// 한글처리
		request.setCharacterEncoding("utf-8");
		// 액션태그 useBean 객체 생성 BoardBean bb
		// 액션태그 setProperty 폼 => 자바빈 저장
	%>
	<jsp:useBean id="bb" class="board.BoardBean"></jsp:useBean>
	<jsp:setProperty property="*" name="bb" />
	<%
		// ip주소 => setIp 호출 저장
		bb.setIp(request.getRemoteAddr());
		// DB작업파일 객체 생성 BoardDAO bdao
		BoardDAO bdao = new BoardDAO();	
		bdao.insertBoard(bb);
		response.sendRedirect("notice.jsp");
	%>
</body>
</html>