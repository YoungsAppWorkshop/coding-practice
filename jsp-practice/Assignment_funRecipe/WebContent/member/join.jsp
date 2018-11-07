<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign Up Page</title>
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
<body onload="document.form.id.focus()">
	<div id="wrap">
		<!-- 헤더들어가는 곳 -->
		<jsp:include page="../inc/top.jsp"></jsp:include>
		<!-- 헤더들어가는 곳 -->

		<!-- 본문들어가는 곳 -->
		<!-- 본문메인이미지 -->
		<div id="sub_img_member"></div>
		<!-- 본문메인이미지 -->
		<!-- 왼쪽메뉴 -->
		<jsp:include page="../inc/memberSubMenu.jsp"></jsp:include>
		<!-- 왼쪽메뉴 -->
		<!-- 본문내용 -->
		<article>
			<h1>Join Us</h1>
			<form action="joinPro.jsp" id="join" method="post" name="form"
				onsubmit="return submitFun()">
				<input type="hidden" name="isIdChecked">
				<fieldset>
					<legend>Basic Info</legend>
					<table class="member">
						<tr>
							<td><label>User ID</label></td>
							<td>
								<input type="text" name="id" class="id" onclick="checkId()" readonly >
								<input type="button" name="idChkButton" value="중복체크" class="dup" onclick="checkId()">
							</td>
						</tr>
						<tr>
							<td><label>Password</label></td>
							<td><input type="password" name="passwd"></td>
						</tr>
						<tr>
							<td><label>Retype Password</label> </td>
							<td><input type="password" name="pwdConfirm"></td>
						</tr>
						<tr>
							<td><label>Name</label></td>
							<td><input type="text" name="name"></td>
						</tr>
						<tr>
							<td><label>E-Mail</label></td>
							<td><input type="email" name="email"></td>
						</tr>
					</table>
				</fieldset>

				<fieldset>
					<legend>Optional</legend>
					<table class="member">
						<tr>
							<td rowspan="3"><label>Address</label></td>
							<td>
								<input type="text" id="postCode" name="postCode" placeholder="우편번호">
								<input type="button" onclick="execDaumPostcode()" class="dup" value="우편번호 찾기">
							</td>
						</tr>
						<tr>
							<td>
								<input type="text" id="roadAddress" name="roadAddress" placeholder="도로명 주소">
								<input type="text" id="numberAddress" name="numberAddress" placeholder="지번 주소">
							</td>
						</tr>
						<tr>
							<td><input type="text" name="detailAddress" placeholder="상세 주소" class="detail"></td>
						</tr>
						<tr>
							<td><label>Phone Number</label></td>
							<td><input type="text" name="phone"></td>
						</tr>
						<tr>
							<td><label>Mobile Phone Number</label></td>
							<td><input type="text" name="mobile"></td>
						</tr>
					</table>
				</fieldset>
				<div class="clear"></div>
				<div id="buttons">
					<input type="submit" value="Submit" class="submit"> <input
						type="reset" value="Cancel" class="cancel">
				</div>
			</form>
		</article>
		<!-- 본문내용 -->
		<!-- 본문들어가는 곳 -->

		<div class="clear"></div>
		<!-- 푸터들어가는 곳 -->
		<jsp:include page="../inc/bottom.jsp"></jsp:include>
		<!-- 푸터들어가는 곳 -->
	</div>
</body>
<script type="text/javascript">
	function checkId() { // 아이디 중복체크 함수
		// id 상자의 value값
		userId = document.form.id.value;
		
		window.open("join_idcheck.jsp?userid=" + userId, "", "width=400, height=400");
		
	} // 함수종료 idcheck()

	function submitFun() { // submit제어 함수 - 필수입력사항 제어	
		if (document.form.isIdChecked.value != "true") {
			alert("회원ID 중복 여부를 확인하세요");
			document.form.idChkButton.focus();
			return false;
		}

		if (document.form.passwd.value.length < 1) {
			alert("비밀번호를 입력하세요");
			document.form.passwd.focus();
			return false;
		}
		if (document.form.passwd.value.length<4||document.form.passwd.value.length>10) {
			alert("비밀번호는 4~10자로 입력하세요");
			document.form.passwd.focus();
			return false;
		}
		if (document.form.passwd.value != document.form.pwdConfirm.value) {
			alert("비밀번호가 일치하지 않습니다");
			document.form.passwd.focus();
			return false;
		}

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