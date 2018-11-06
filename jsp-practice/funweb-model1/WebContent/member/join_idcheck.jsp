<%@page import="member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>아이디 중복체크</title>
</head>
<body>
	<!-- member/join_idcheck.jsp -->
	<%
		// String id = userid 파라미터 가져오기
		String id = request.getParameter("userid");
		// MemberDAO 객체 생성 mdao
		MemberDAO mdao = new MemberDAO();
		// int check = 메서드호출 checkIdDuplication(id)
		int check = mdao.checkIdDuplication(id);
	%>

	<form action="join_idcheck.jsp" method="post" name="idCheckForm">
		<table border="1">
			<tr>
				<td>아이디</td>
				<td><input type="text" name="userid" value="<%=id%>" /></td>
			</tr>
			<tr>
				<td colspan="2">
					<%
						if (check == 0) { // check==0 아이디 없음 : 아이디 중복아님 "사용 가능한 아이디입니다.""
					%><span style="color: blue">사용 가능한 아이디입니다.</span> 
					<%
 						} else { // check == 1 아이디 있음 : 아이디 중복 "사용 중인 아이디입니다.""
 					%><span style="color: red">사용 중인 아이디입니다.</span> <%
 						}
 					%>
				</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="중복확인" />
					<%
						if (check == 0) { // check==0 아이디 없음 : 아이디 중복아님 "사용 가능한 아이디입니다.""
					%>
					<input type="button" value="사용하기" onclick="result()"/>
					<%
						}
					%>
				</td>
			</tr>
		</table>
	</form>

</body>
<script type="text/javascript">
	function result() {
		// join페이지 id상자에 찾은 아이디
		opener.document.form.id.value = document.idCheckForm.userid.value;
		window.close();
	}
</script>
</html>