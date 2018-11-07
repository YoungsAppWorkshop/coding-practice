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
		// 세션값 가져오기 : 세션값 없으면 login페이지로 이동
		String sId = (String) session.getAttribute("id");
		if (sId == null) {
			response.sendRedirect("../member/login.jsp");
		}
		
		// 파라미터 가져오기
		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");
		
		// 한글 처리
		request.setCharacterEncoding("utf-8");

		// DB 작업 : 게시판 글 삭제 메소드 호출
		BoardDAO bdao = new BoardDAO();
		boolean isSuccess = bdao.deleteBoard(sId, num);
		if (isSuccess) { // 삭제 완료한 경우 메시지 출력 후 list.jsp로 이동 
	%>
	<script>
			alert("글을 삭제하였습니다.");
			location.href="list.jsp?pageNum=<%=pageNum%>";
	</script>
	<%
		} else { // 삭제 실패한 경우 오류메시지 출력 후 뒤로 이동 
	%>
	<script>
			alert("서버와의 접속이 원활하지 않습니다.\n잠시 후에 다시 시도해 주시기 바랍니다.");
			history.back();
	</script>
	<%
		}
	%>
</body>
</html>