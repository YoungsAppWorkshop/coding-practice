<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<header>
	<%
		// 세션값 가져오기
		String id = (String) session.getAttribute("id");
		String name = (String) session.getAttribute("name");
		// 세션값 있으면 "..님 환영합니다. | 마이페이지 | 로그아웃" 출력 
		if (id != null) {
	%>
	<div id="login">
		<%=name%>님 환영합니다. | 
		<a href="../member/myPage.jsp">마이페이지</a> |
		<a href="../member/logOut.jsp">로그아웃</a>
	</div>
	<%
		} else { // 세션값 없으면 "로그인 | 회원 가입" 출력 
	%>
	<div id="login">
		<a href="../member/login.jsp">로그인</a> | <a href="../member/join.jsp">회원 가입</a>
	</div>
	<%
		} // if-else 종료
	%>
	<div class="clear"></div>
	<!-- 로고들어가는 곳 -->
	<div id="logo">
		<a href="../index.jsp">
		<img src="../images/logo.png" width="265" height="62" alt="Fun Web">
		</a>
	</div>
	<!-- 로고들어가는 곳 -->
	<nav id="top_menu">
		<ul>
			<li><a href="../index.jsp">HOME</a></li>
			<li><a href="../about/welcome.jsp">ABOUT</a></li>
			<li><a href="../board/list.jsp">BOARD</a></li>
			<li><a href="../download/fileList.jsp">DOWNLOAD</a></li>
			<li><a href="../contact/contact.jsp">CONTACT US</a></li>
		</ul>
	</nav>
</header>