<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>영역 객체와 속성 - 7/26</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		// 	영역				영역객체			범위
		// 	page			pageContext		해당 페이지 범위
		// 	request			request			요청되는 범위
		// 	session			session			세션(연결)이 유지되는 범위
		// 	application		application		웹어플리케이션 실행되는 동안

		//	내장 객체 속성값 저장
		//	값 저장 : 내장객체.setAttribute("이름", 값)
		//	값 가져오기 : 내장객체.getAttribute("이름")
		//	값 하나 삭제 : 내장객체.removeAttribute("이름")
		pageContext.setAttribute("page", "pageContext Value");
		request.setAttribute("req", "request Value");
		session.setAttribute("sess", "session Value");
		application.setAttribute("app", "application Value");
	%>
	<h1>jsp2/scopePro.jsp</h1>
	아이디 :
	<%=request.getParameter("id")%><br> pageContext :
	<%=pageContext.getAttribute("page")%><br> request :
	<%=request.getAttribute("req")%><br> session :
	<%=session.getAttribute("sess")%><br> application :
	<%=application.getAttribute("app")%><br>
	<a
		href="scopeProPro.jsp?id=<%=request.getParameter("id")%>&passwd=pass123">
		scopeProPro.jsp페이지로 이동</a>
	<br>
	<script type="text/javascript">
// 		alert("scopeProPro.jsp 페이지로 이동합니다.");
<%-- 		location.href = "scopeProPro.jsp?id=<%=request.getParameter("id")%>&passwd=pass123"; --%>
	</script>
	<%
		// 	jsp 이동
// 		response.sendRedirect("scopeProPro.jsp?id="+request.getParameter("id")+"&passwd=pass123");

		//	jsp foward 이동
		//	현페이지의 모든 정보 request 정보를 가지고 다음 페이지 이동
		//	주소줄 현페이지 주소(주소값은 변화 없음) / 실행내용 다음 페이지
		//	MVC 패턴에서 주소창에 jsp 페이지 노출하지 않기 위해 활용

		//	액션 태그	foward		include		useBean		setAttribute
	%>
		<jsp:forward page="scopeProPro.jsp">
			<jsp:param value="pass123" name="passwd" />
		</jsp:forward>
</body>
</html>