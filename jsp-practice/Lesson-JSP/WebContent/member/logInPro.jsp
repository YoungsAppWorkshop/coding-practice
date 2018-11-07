<%@page import="member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>자바빈 실습 - 8/11</title>
</head>
<body>
	<h1>member/logInPro.jsp</h1>
	<%
		// 한글처리
		request.setCharacterEncoding("utf-8");
		// 파라미터 가져오기
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");

		// MemberDAO 객체 생성 mdao
		MemberDAO mdao = new MemberDAO();
		//		= 메서드호출 userCheck(id, passwd)
		int check = mdao.checkUser(id, passwd);

		if (check == 1) { // check == 1	세션값 생성 "id" 이동 main.jsp
			session.setAttribute("id", id);
			response.sendRedirect("main.jsp");
		} else if (check == 0) { // check == 0 	"비밀번호틀림" 뒤로 이동
	%>
	<script type="text/javascript">
		alert("비밀번호 틀림");
		history.back();
	</script>
	<%
		} else if (check == -1) {//	check == -1 "아이디 없음" 뒤로 이동
	%>
	<script type="text/javascript">
		alert("아이디 없음");
		history.back();
	</script>
	<%
		}
	%>
</body>
</html>