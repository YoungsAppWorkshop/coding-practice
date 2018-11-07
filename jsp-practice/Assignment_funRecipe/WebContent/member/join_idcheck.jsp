<%@page import="member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>아이디 중복체크</title>
</head>
<body onload="document.idCheckForm.userid.focus()">
	<!-- member/join_idcheck.jsp -->
	<%
		final int USABLE = 0; // 사용가능한 아이디
		final int INVALID = 1; // 사용불가능한 아이디 : 대소문자 영문 또는 숫자만 사용 / 길이 4~10자 이내 / 첫글자는 대소문자 영문자만 허용  
		final int DUPLICATE = 2; // 사용불가능한 아이디 : 중복된 아이디
		final int NEW = 3; // 창을 새로 열었을 때 
		int idStatus; // 아이디 사용가능 여부 
		
		// 한글처리
		request.setCharacterEncoding("utf-8");
		
		// 파라미터 가져오기 및 객체 생성
		String id = request.getParameter("userid");
		MemberDAO mdao = new MemberDAO();
		
		if(id.length() < 1) {
			id = "";
			idStatus = NEW;
		} else {
			idStatus = mdao.checkId(id);
		}
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
					if (idStatus == USABLE) { 
				%><span style="color: blue">사용 가능한 아이디입니다.</span> <%
 					} else if(idStatus == DUPLICATE) { 
 				%><span style="color: red">사용 중인 아이디입니다.</span> <%
 					} else if(idStatus == INVALID) {
				%><span style="color: red">사용 불가능한 아이디입니다.</span> <%		
 					} else {
				%><span style="color: green">아이디 입력 규칙</span> <%
 					}
				%>
					<ul>
						<li>영문 대소문자 및 숫자만 입력 가능</li>
						<li>첫 글자는 영문 대소문자만 가능</li>
						<li>길이는 4자 이상 10자 이하</li>
					</ul>		
				</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="중복확인" /> 
				<%
 					if (idStatus == USABLE) { 
 				%> <input type="button" value="사용하기" onclick="result()" /> 
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
		opener.document.form.isIdChecked.value = "true";
		window.close();
	}
</script>
</html>