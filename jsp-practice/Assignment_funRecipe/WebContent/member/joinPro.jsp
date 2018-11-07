<%@page import="member.MemberDAO"%>
<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Join Pro</title>
</head>
<body>
	<!-- member/joinPro.jsp -->
	<%
		// 한글처리
		request.setCharacterEncoding("utf-8");

		// MemberBean 객체 생성 및 회원 정보 가져오기 
	%>
	<jsp:useBean id="mb" class="member.MemberBean"></jsp:useBean>
	<jsp:setProperty property="*" name="mb" />
	<%
		// 가입날짜 입력 
		Timestamp reg_date = new Timestamp(System.currentTimeMillis());
		mb.setReg_date(reg_date);

		// 회원 정보 DB에 추가 
		MemberDAO mdao = new MemberDAO();
		boolean isSuccess = mdao.insertMember(mb); 
		
		if(isSuccess) { // 회원정보 추가 성공한 경우, 메시지 출력 후 login.jsp로 이동
	%> 
	<script type="text/javascript">
		alert("회원가입 성공");
		location.href = "login.jsp";
	</script>
	<% 
		} else { // 회원정보 추가 실패한 경우, 에러메시지 출력 후 뒤로 이동
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