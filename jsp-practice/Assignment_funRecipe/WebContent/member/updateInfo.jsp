<%@page import="member.MemberBean"%>
<%@page import="member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Information</title>
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
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script src="../js/post.js" type="text/javascript"></script>
<%
	// 세션값 가져오기 : 세션값이 없으면 login.jsp로 이동 
	String sId = (String) session.getAttribute("id");
	if (sId == null) {
		response.sendRedirect("login.jsp");
	} else {
	
	// 회원 정보 가져오기 
	MemberDAO mdao = new MemberDAO(); 
	MemberBean mb = mdao.getMember(sId); 
	
	// 선택 정보가 null값인 경우 공백("")으로 치환
	String postCode = (mb.getPostCode()==null) ? "" : mb.getPostCode() ;
	String roadAddress = (mb.getRoadAddress()==null) ? "" : mb.getRoadAddress() ;
	String numberAddress = (mb.getNumberAddress()==null) ? "" : mb.getNumberAddress() ;
	String detailAddress = (mb.getDetailAddress()==null) ? "" : mb.getDetailAddress() ;
	String phone = (mb.getPhone()==null) ? "" : mb.getPhone() ;
	String mobile = (mb.getMobile()==null) ? "" : mb.getMobile() ;
%>
<body onload="document.form.name.focus()">
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
			<h1>Update Information</h1>
			<form action="updatePro.jsp" id="join" method="post" name="form"
				onsubmit="return submitFun()">
				<fieldset>
					<table class="member">
						<tr>
							<td><label>User ID</label></td>
							<td><input type="text" name="id" class="id" value="<%=mb.getId()%>" readonly></td>
						</tr>
						<tr>
							<td><label>Name</label></td>
							<td><input type="text" name="name" value="<%=mb.getName()%>"></td>
						</tr>
						<tr>
							<td><label>E-Mail</label></td>
							<td><input type="email" name="email" value="<%=mb.getEmail() %>"></td>
						</tr>
					</table>
				</fieldset>

				<fieldset>
					<legend>Optional</legend>
					<table class="member">
						<tr>
							<td rowspan="3"><label>Address</label></td>
							<td>
								<input type="text" id="postCode" name="postCode" value="<%=postCode %>">
								<input type="button" onclick="execDaumPostcode()" value="우편번호 찾기">
							</td>
						</tr>
						<tr>
							<td>
								<input type="text" id="roadAddress" name="roadAddress" value="<%=roadAddress %>">
								<input type="text" id="numberAddress" name="numberAddress" value="<%=numberAddress %>">
							</td>
						</tr>
						<tr>
							<td><input type="text" name="detailAddress" value="<%=detailAddress %>" class="detail"></td>
						</tr>
						<tr>
							<td><label>Phone Number</label></td>
							<td><input type="text" name="phone" value="<%=phone%>"></td>
						</tr>
						<tr>
							<td><label>Mobile Phone Number</label></td>
							<td><input type="text" name="mobile" value="<%=mobile%>"></td>
						</tr>
					</table>
				</fieldset>
				<div class="clear"></div>
				<div id="buttons">
					<input type="submit" value="회원정보 수정" class="submit"> <input
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
		if (document.form.name.value.length < 1) {
			alert("이름을 입력하세요");
			document.form.name.focus();
			return false;
		}

		if (document.form.email.value.length < 1) {
			alert("이메일을 입력하세요");
			document.form.email.focus();
			return false;
		}

	} // 함수종료 submitFun()
</script>
</html>