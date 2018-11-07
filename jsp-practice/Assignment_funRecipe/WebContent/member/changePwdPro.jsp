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
		} else { // 세션값이 있으면
			// 파라미터값 가져오기
			String oldPasswd = request.getParameter("passwd");
			String newPasswd = request.getParameter("newPwd");

			// 비밀번호 일치 여부 확인
			MemberDAO mdao = new MemberDAO();
			boolean isPasswordCorrect = mdao.checkUser(id, oldPasswd);

			// 비밀번호가 일치하면 비밀번호 변경 
			if (isPasswordCorrect) {
				boolean isSuccess = mdao.updatePassword(id, newPasswd); 
				if(isSuccess) { // 비밀번호변경 완료 시 메시지 출력 후 myPage.jsp로 이동
					%>
					<script type="text/javascript">
						alert("비밀번호 변경 완료");
						location.href = "myPage.jsp";
					</script>
					<%
				} else { // 비밀번호변경 실패 시 에러메시지 출력 후 뒤로 이동
					%>
					<script type="text/javascript">
						alert("서버가 응답하지 않습니다. 잠시 후에 다시 시도바랍니다.");
						history.back();
					</script>
					<%
				}
	
			} else { // 비밀번호가 일치하지 않으면 에러메시지 출력 후 뒤로 이동 
				%>
				<script type="text/javascript">
					alert("비밀번호가 일치하지 않습니다.");
					history.back();
				</script>
				<%
			}
		}
	%>

</body>
</html>