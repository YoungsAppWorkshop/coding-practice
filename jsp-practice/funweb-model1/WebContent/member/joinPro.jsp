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
		// 자바빈 패키지 member 파일이름 MemberBean
		// 액션태그 useBean 활용 : MemberBean 객체 생성 mb
		// 액션태그 setProperty 폼 => 자바빈 저장
	%>
	<jsp:useBean id="mb" class="member.MemberBean"></jsp:useBean>
	<jsp:setProperty property="*" name="mb" />
	<%
		// 가입날짜 reg_date set메서드 호출 new Timestamp()
		Timestamp reg_date = new Timestamp(System.currentTimeMillis());
		mb.setReg_date(reg_date);
		// 디비작업 파일 패키지 member 파일이름 MemberDAO
		// MemberDAO 객체 생성 mdao
		// 메서드 호출
		MemberDAO mdao = new MemberDAO();
		mdao.insertMember(mb);
		// "회원가입 성공"
		// login.jsp 페이지 이동
	%>
	<script type="text/javascript">
		alert("회원가입 성공");
		location.href = "login.jsp";
	</script>
</body>
</html>