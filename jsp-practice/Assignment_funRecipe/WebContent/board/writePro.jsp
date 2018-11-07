<%@page import="java.sql.Timestamp"%>
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
		
		// 한글처리
		request.setCharacterEncoding("utf-8");
		
		// BoardBean 객체 생성 및 값 저장
	%>
	<jsp:useBean id="bb" class="board.BoardBean"></jsp:useBean>
	<jsp:setProperty property="*" name="bb" />
	<%
		// ip주소 및 작성시간 입력 
		bb.setIp(request.getRemoteAddr());
		bb.setDate(new Timestamp(System.currentTimeMillis()));

		// DB에 저장 
		BoardDAO bdao = new BoardDAO();	
		boolean isSuccess = bdao.insertBoard(bb);
		
		if(isSuccess) { // DB 저장 성공한 경우, 메시지 출력 후 list.jsp로 이동
	%> 
	<script type="text/javascript">
		alert("글이 성공적으로 저장되었습니다.");
		location.href = "list.jsp";
	</script>
	<% 
		} else { // DB 저장 실패한 경우, 에러메시지 출력 후 뒤로 이동
	%> 
	<script type="text/javascript">
		alert("서버가 응답하지 않습니다. 잠시 후에 다시 시도바랍니다.");
		history.back();
	</script>
	<% 	
		}
	%>
</body>
</html>