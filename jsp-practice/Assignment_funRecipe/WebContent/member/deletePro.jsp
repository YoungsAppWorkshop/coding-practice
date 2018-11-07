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
		if (id == null) { // 세션값이 없으면 login.jsp로 이동
			response.sendRedirect("login.jsp");
		} else { // 세션값이 있으면
			// 파라미터값 가져오기
			String passwd = request.getParameter("passwd");

			// 비밀번호 일치 여부 확인
			MemberDAO mdao = new MemberDAO();
			boolean isPasswordCorrect = mdao.checkUser(id, passwd);

			// 비밀번호가 일치하면 회원정보 삭제(탈퇴 처리)
			if (isPasswordCorrect) {
				boolean isSuccess = mdao.deleteMember(id, passwd); 
				if(isSuccess) { // 회원정보 삭제(탈퇴) 처리가 완료된 경우, 
					// 세션값 초기화 후 index.jsp로 이동
					session.invalidate();
					%>
					<script type="text/javascript">
						alert("정상적으로 탈퇴처리가 이뤄졌습니다.");
						location.href = "../index.jsp";
					</script>
					<%			
				} else { // 회원정보 삭제(탈퇴) 처리가 완료되지 않은 경우,
					%> 
					<script type="text/javascript">
						alert("서버가 응답하지 않습니다. 잠시 후에 다시 시도바랍니다.");
						history.back();
					</script>
					<% 
				}

			} else { // 비밀번호가 일치하지 않은 경우 에러메시지 출력 후, 뒤로 이동
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