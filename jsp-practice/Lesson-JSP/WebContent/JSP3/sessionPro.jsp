<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>세션/프로세스 - 7/27</title>
</head>
<body>
	<%
		String sid = request.getParameter("id");
		String spassword = request.getParameter("passwd");

		// 디비에 저장된 아이디 : kim, 비밀번호 k1234로 가정하고 실습 진행
		String dbId = "kim";
		String dbPass = "k1234";

		// 아이디 비교 같으면 비밀번호 비교 같으면 "로그인 인증" 틀리면 "비밀번호 틀림"
		// 아이디 비교 같으면 다르면 "아이디 없음" 출력
		// 문자열비교 메소드 : 문자열1.equals(문자열2)
		if (sid.equals(dbId)) {
			// 아이디 있음
			if (spassword.equals(dbPass)) {
				// 세션값 생성 이름 "id" 값 id
				session.setAttribute("id", sid);
				// 이동 sessionMain.jsp
				response.sendRedirect("sessionMain.jsp");
			} else {
	%><script>
		alert("비밀번호 틀림"); // 비밀번호 틀림
		// 		location.href="sessionForm.jsp";
		history.back();
	</script>
	<%
		}
		} else {
	%><script>
		alert("아이디 없음"); // 아이디 없음
		// 		location.href="sessionForm.jsp";
		history.back();
	</script>
	<%
		}
	%>
	<h2>jsp3/sessionPro.jsp</h2>
	id:
	<%=sid%><br> password:
	<%=spassword%><br>
</body>
</html>