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
		// 파라메터 가져오기
		String pageNum = request.getParameter("pageNum");		
		// 액션태그 useBean 객체 생성 BoardBean bb
		// 액션태그 setProperty 폼 => 자바빈 저장
	%>
	<jsp:useBean id="bb" class="board.BoardBean"></jsp:useBean>
	<jsp:setProperty property="*" name="bb" />
	<%
		// DB작업파일 객체 생성 BoardDAO bdao
		BoardDAO bdao = new BoardDAO();
		// int check = updateBoard(bb) 메서드 호출
		int check = bdao.updateBoard(bb);
		System.out.println(check);
		if (check == 1) { // check == 1 "수정성공" notice.jsp?pageNum이동
	%>
	<script>
			alert("수정성공");
			location.href="notice.jsp?pageNum=<%=pageNum%>";
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