<%@page import="member.MemberBean"%>
<%@page import="member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Change Password</title>
<link href="../css/default.css" rel="stylesheet" type="text/css">
<link href="../css/subpage.css" rel="stylesheet" type="text/css">
<!--[if lt IE 9]>
<script src="http://ie7-js.googlecode.com/svn/version/2.1(beta4)/IE9.js" type="text/javascript"></script>
<script src="http://ie7-js.googlecode.com/svn/version/2.1(beta4)/ie7-squish.js" type="text/javascript"></script>
<script src="http://html5shim.googlecode.com/svn/trunk/html5.js" type="text/javascript"></script>
<![endif]-->
<!--[if IE 6]>
 <script src="../script/DD_belatedPNG_0.0.8a.js"></script>
 <script>
   /* EXAMPLE */
   DD_belatedPNG.fix('#wrap');
   DD_belatedPNG.fix('#main_img');   

 </script>
 <![endif]-->
</head>
<%
	// 세션값 가져오기 : 세션값이 없으면 login.jsp로 이동 
	String sId = (String) session.getAttribute("id");
	if (sId == null) {
		response.sendRedirect("login.jsp");
	} else {
%>
<body onload="document.form.passwd.focus()">
	<div id="wrap">
		<!-- 헤더들어가는 곳 -->
		<jsp:include page="../inc/top.jsp"></jsp:include>
		<!-- 헤더들어가는 곳 -->

		<!-- 본문들어가는 곳 -->
		<!-- 본문메인이미지 -->
		<div id="sub_img_member"></div>
		<!-- 본문메인이미지 -->
		<!-- 왼쪽메뉴 -->
		<jsp:include page="../inc/myPageSubMenu.jsp"></jsp:include>
		<!-- 왼쪽메뉴 -->
		<!-- 본문내용 -->
		<article>
			<h1>Change Password</h1>
			<form action="changePwdPro.jsp" id="join" method="post" name="form"
				onsubmit="return submitFun()">
				<fieldset>
					<legend>비밀번호 확인</legend>
					<p><label>변경전 비밀번호</label> <input type="password" name="passwd"></p>
				</fieldset>

				<fieldset>
					<legend>새로운 비밀번호</legend>
					<p><label>변경후 비밀번호</label> <input type="password" name="newPwd"></p>
					<p><label>비밀번호 확인</label> <input type="password" name="pwdConfirm"></p>
				</fieldset>
				<div class="clear"></div>
				<div id="buttons">
					<input type="submit" value="비밀번호 변경" class="submit"> <input
						type="reset" value="취소" class="cancel" onclick="location.href='myPage.jsp'">
				</div>
			</form>
		</article>
		<!-- 본문내용 -->
		<!-- 본문들어가는 곳 -->
		<%
	}
		%>

		<div class="clear"></div>
		<!-- 푸터들어가는 곳 -->
		<jsp:include page="../inc/bottom.jsp"></jsp:include>
		<!-- 푸터들어가는 곳 -->
	</div>
</body>
<script type="text/javascript">
	function submitFun() {
		if (document.form.passwd.value.length < 1) {
			alert("비밀번호를 입력하세요");
			document.form.passwd.focus();
			return false;
		}
		if (document.form.newPwd.value.length<4||document.form.newPwd.value.length>10) {
			alert("비밀번호는 4~10자로 입력하세요");
			document.form.newPwd.focus();
			return false;
		}
		if (document.form.newPwd.value != document.form.pwdConfirm.value) {
			alert("비밀번호가 일치하지 않습니다");
			document.form.newPwd.focus();
			return false;
		}

	} // 함수종료 submitFun()
</script>
</html>