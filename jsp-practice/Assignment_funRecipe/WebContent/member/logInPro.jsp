<%@page import="member.MemberBean"%>
<%@page import="member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Log In Pro Page</title>
</head>
<body>
	<!-- member/logInPro.jsp -->
	<%
		// 한글처리
		request.setCharacterEncoding("utf-8");

		// 파라미터 가져오기
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");

		// 회원 여부 확인 메소드 호출 
		MemberDAO mdao = new MemberDAO();
		boolean isUser = mdao.checkUser(id, passwd);

		if (isUser) { // 회원인 경우 세션값 생성(id, name) 및 index.jsp 페이지로 이동 
			MemberBean mb = mdao.getMember(id);
			session.setAttribute("id", id);
			session.setAttribute("name", mb.getName());
			
			response.sendRedirect("../index.jsp");
		} else { //	회원이 아닌 경우 경고메시지 출력 후 뒤로 가기
	%>
	<script type="text/javascript">
		alert("아이디 또는 비밀번호가 일치하지 않습니다.");
		history.back();
	</script>
	<%
		}
	%>
</body>
</html>