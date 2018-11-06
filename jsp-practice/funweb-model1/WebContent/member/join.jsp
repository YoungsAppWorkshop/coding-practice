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
		<nav id="sub_menu">
			<ul>
				<li><a href="#">Join us</a></li>
				<li><a href="#">Privacy policy</a></li>
			</ul>
		</nav>
		<!-- 왼쪽메뉴 -->
		<!-- 본문내용 -->
		<article>
			<h1>Join Us</h1>
			<form action="joinPro.jsp" id="join" method="post" name="form"
				onsubmit="return submitFun()">
				<fieldset>
					<legend>Basic Info</legend>
					<label>User ID</label> <input type="text" name="id" class="id">
					<input type="button" value="dup. check" class="dup"
						onclick="checkId()"><br> <label>Password</label> <input
						type="password" name="passwd"><br> <label>Retype
						Password</label> <input type="password" name="pwdConfirm"><br>
					<label>Name</label> <input type="text" name="name"><br>
					<label>E-Mail</label> <input type="email" name="email"><br>
					<label>Retype E-Mail</label> <input type="email"
						name="emailConfirm"><br>
				</fieldset>

				<fieldset>
					<legend>Optional</legend>
					<label>Address</label> <input type="text" name="address"><br>
					<label>Phone Number</label> <input type="text" name="phone"><br>
					<label>Mobile Phone Number</label> <input type="text" name="mobile"><br>
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
		// id 상자 비어 있으면 "아이디 입력하세요" >> id 포커스
		if (userId.length < 1) {
			alert("회원ID를 입력하세요");
			document.form.id.focus();
		} else if (userId.length<4||userId.length>10) {
			alert("회원ID는 4~10자로 입력하세요");
			document.form.id.focus();
		} else {
			window.open("join_idcheck.jsp?userid=" + userId, "",
					"width=400, height=200");
		}
	} // 함수종료 idcheck()

	function submitFun() { // submit제어 함수 - 필수입력사항 제어	
		if (document.form.id.value.length < 1) {
			alert("회원ID를 입력하세요");
			document.form.id.focus();
			return false;
		}
		if (document.form.id.value.length<4||document.form.id.value.length>10) {
			alert("회원ID는 4~10자로 입력하세요");
			document.form.id.focus();
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
		if (document.form.email.value != document.form.emailConfirm.value) {
			alert("이메일이 일치하지 않습니다");
			document.form.email.focus();
			return false;
		}

	} // 함수종료 submitFun()
</script>
</html>