<%@page import="member.MemberDAO"%>
<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>자바빈 실습 - 8/10</title>
</head>
<body>
	<%
		// 한글처리
		request.setCharacterEncoding("utf-8");
		// 자바빈 파일 만들기 패키지member 파일이름 MemberBean
		// 액션태그 useBean 객체생성 mb
		// 액션태그 setProperty 폼 => 자바빈 멤버변수 저장
	%>
	<jsp:useBean id="mb" class="member.MemberBean"></jsp:useBean>
	<jsp:setProperty property="*" name="mb" />
	<%
		Timestamp reg_date = new Timestamp(System.currentTimeMillis());
		mb.setReg_date(reg_date);
		// 디비파일 만들기 패키지 member 파일이름 MemberDAO
		// 객체 생성 mdao
		// 메소드호출
		MemberDAO mdao = new MemberDAO();
		mdao.insertMember(mb);
	%>
	<h1>member/insertPro.jsp</h1>
	<script type="text/javascript">
		alert("회원가입 성공");
		location.href = "logInForm.jsp";
	</script>
</body>
</html>