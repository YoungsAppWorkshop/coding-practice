<%@page import="member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update Pro - 8/11</title>
</head>
<body>
	<%
		// 세션값 가져오기 : 세션값이 없으면 login.jsp로 이동
		String id = (String) session.getAttribute("id");
		if (id == null) {
			response.sendRedirect("login.jsp");
		}
		// 한글처리 
		request.setCharacterEncoding("utf-8");
		
		// 회원정보 가져오기 
	%>
	<jsp:useBean id="mb" class="member.MemberBean"></jsp:useBean>
	<jsp:setProperty property="*" name="mb" />
	<%
		// 회원정보 수정 메소드 호출 
		MemberDAO mdao = new MemberDAO();
		boolean isSuccess = mdao.updateMember(mb); 
		
		if(isSuccess) { // 회원정보 수정 성공한 경우, 메시지 출력 후 myPage.jsp로 이동
	%> 
	<script type="text/javascript">
		alert("회원정보 수정 완료");
		location.href = "myPage.jsp";
	</script>
	<% 
		} else { // 회원정보 수정 실패한 경우, 에러메시지 출력 후 뒤로 이동
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