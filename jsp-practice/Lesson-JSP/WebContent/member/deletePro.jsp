<%@page import="member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Delete Pro - 8/18</title>
</head>
<body>
	<%
		// 세션값 가져오기
		String id = (String) session.getAttribute("id");
		// 세션값이 없으면(null이면) logInForm.jsp로 이동
		if (id == null) {
			response.sendRedirect("logInForm.jsp");
		}
		// 한글처리
		request.setCharacterEncoding("utf-8");
	%>
	<jsp:useBean id="mb" class="member.MemberBean"></jsp:useBean>
	<jsp:setProperty property="*" name="mb" />
	<%
		// 객체 생성 mdao
		// 메소드호출
		MemberDAO mdao = new MemberDAO();
		int check = mdao.checkUser(mb.getId(), mb.getPasswd());
		if (check == 1) {
			mdao.deleteMember(mb);
			session.invalidate();
	%><script type="text/javascript">
		alert("회원 삭제 성공");
		location.href = "main.jsp";
	</script>
	<%
		} else if (check == 0) {
	%><script type="text/javascript">
		alert("비밀번호 틀림");
		history.back();
	</script>
	<%
		} else {
	%><script type="text/javascript">
		alert("아이디 없음");
		history.back();
	</script>
	<%
		}
	%>
</body>
</html>