<%@page import="board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판 실습(삭제 페이지) - 8/25</title>
</head>
<body>
	<h1>board/deletePro.jsp</h1>
	<%
		// 한글 처리
		request.setCharacterEncoding("utf-8");
		// 파라미터 가져오기
		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");
		String pass = request.getParameter("pass");
		
		// DB작업파일 패키지 board 파일이름 BoardDAO
		// BoardDAO 객체 생성 bdao
		BoardDAO bdao = new BoardDAO();
		// 메소드 호출 updateBoard(bb)
		int check = bdao.deleteBoard(num, pass);			
		if (check == 1) { // check == 1 수정 성공 list.jsp 이동
	%>
	<script>
			alert("삭제 성공");
			location.href="list.jsp?pageNum=<%=pageNum%>";
	</script>
	<%
		} else if (check == 0) { // check == 0 "비밀번호 틀림" 뒤로 이동
	%>
	<script>
		alert("비밀번호 틀림");
		history.back();
	</script>
	<%
		} else { // check == -1 "번호없음" 뒤로 이동
	%>
	<script>
		alert("비밀번호 없음");
		history.back();
	</script>
	<%
		}
	%>


</body>
</html>