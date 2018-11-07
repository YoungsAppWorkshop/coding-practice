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
		// 한글처리
		request.setCharacterEncoding("utf-8");

		// 세션값 가져오기 : 세션값 없으면 login페이지로 이동
		String sId = (String) session.getAttribute("id");
		if (sId == null) {
			response.sendRedirect("../member/login.jsp");
		}
		
		// 파라메터 가져오기
		String pageNum = request.getParameter("pageNum");	
			
		// 글 수정 내용 BoardBean에 저장
	%>
	<jsp:useBean id="bb" class="board.BoardBean"></jsp:useBean>
	<jsp:setProperty property="*" name="bb" />
	<%
		// DB에 글 수정 내용 업데이트 
		BoardDAO bdao = new BoardDAO();
		boolean isSuccess = bdao.updateBoard(bb); 

		if (isSuccess) { // DB에 업데이트 완료한 경우 메시지 출력 후, list.jsp 이동
	%>
	<script>
			alert("글을 성공적으로 수정하였습니다.");
			location.href="list.jsp?pageNum=<%=pageNum%>";
	</script>
	<%
		} else { // DB에 업데이트 실패한 경우 에러메시지 출력 후, 뒤로 이동
	%>
	<script>
			alert("서버와의 통신이 원활하지 않습니다.\n잠시 후에 다시 시도해 주시기 바랍니다.");
			history.back();
	</script>
	<%
		}
	%>
</body>
</html>