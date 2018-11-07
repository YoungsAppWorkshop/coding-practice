<%@page import="member.MemberBean"%>
<%@page import="member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Page</title>
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
	} else { // 세션값이 있으면

		// 회원 정보 가져오기 
		MemberDAO mdao = new MemberDAO();
		MemberBean mb = mdao.getMember(sId);

		// 선택 정보가 null값인 경우 공백("")으로 치환
		String postCode = (mb.getPostCode()==null) ? "" : mb.getPostCode() ;
		String roadAddress = (mb.getRoadAddress()==null) ? "" : mb.getRoadAddress() ;
		String numberAddress = (mb.getNumberAddress()==null) ? "" : mb.getNumberAddress() ;
		String detailAddress = (mb.getDetailAddress()==null) ? "" : mb.getDetailAddress() ;
		String phone = (mb.getPhone() == null) ? "" : mb.getPhone();
		String mobile = (mb.getMobile() == null) ? "" : mb.getMobile();
%>
<body>
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
			<h1>My Page</h1>

			<input type="hidden" name="isIdChecked">
			<fieldset>
				<legend>Basic Info</legend>
				<table class="myPage">
					<tr>
						<th><label>User ID</label></th>
						<td><%=mb.getId()%></td>
					</tr>
					<tr>
						<th><label>Name</label></th>
						<td><%=mb.getName()%></td>
					</tr>
					<tr>
						<th><label>E-Mail</label></th>
						<td><%=mb.getEmail()%></td>
					</tr>
				</table>
			</fieldset>

			<fieldset>
				<legend>Optional</legend>
				<table class="myPage">
					<tr>
						<th><label>Post-Code</label></th>
						<td><%=postCode%></td>
					</tr>
					<tr>
						<th><label>도로명 주소</label></th>
						<td><%=roadAddress%></td>
					</tr>
					<tr>
						<th><label>지번 주소</label></th>
						<td><%=numberAddress%></td>
					</tr>
					<tr>
						<th><label>상세 주소</label></th>
						<td><%=detailAddress%></td>
					</tr>
					<tr>
						<th><label>Phone Number</label></th>
						<td><%=phone%></td>
					</tr>
					<tr>
						<th><label>Mobile Phone Number</label></th>
						<td><%=mobile%></td>
					</tr>
				</table>
			</fieldset>
			<div class="clear"></div>
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
</html>