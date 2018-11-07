<%@page import="member.MemberBean"%>
<%@page import="member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
function submitControl() {
	if (document.form1.passwd.value == "") {
		// if (document.getElementById("idd").value=="") {}
		alert("패스워드를 입력하세요");
		document.form1.passwd.focus();
		return false;
	}
}
</script>
<title>Update Form - 8/11</title>
</head>
<body>
	<%
		// 세션값 가져오기
		String id = (String) session.getAttribute("id");
		// 세션값이 없으면(null이면) logInForm.jsp로 이동
		if (id == null) {
			response.sendRedirect("logInForm.jsp");
		}
		// MemberDAO 객체 생성 mdao
		MemberDAO mdao = new MemberDAO();
		// MemberBean mb = 메소드호출 .getMember(id)
		MemberBean mb = mdao.getMember(id);
		String gender = mb.getGender();
		if (gender == null) {
			gender = "남";
		}
	%>
	<h1>member/updateForm.jsp</h1>
	<form name="form1" action="updatePro.jsp" method="post" onsubmit="return submitControl()">
		아이디 : <input type="text" name="id" value="<%=mb.getId()%>" readonly />
		<br /> 비밀번호 : <input type="password" name="passwd" /><br /> 이름 : <input
			type="text" name="name" value="<%=mb.getName()%>" /><br /> 나이 : <input
			type="text" name="age" value="<%=mb.getAge()%>" /> <br /> 성별 : <input
			type="radio" name="gender" value="남" <%if (gender.equals("남")) {%>
			checked <%}%> />남 <input type="radio" name="gender" value="여"
			<%if (gender.equals("여")) {%> checked <%}%> />여 <br /> 이메일 : <input
			type="text" name="email" value="<%=mb.getEmail()%>" /> <br /> <input
			type="submit" value="전송" />
	</form><input type="button" value="메인화면으로 이동" onclick="history.back()">
</body>
</html>