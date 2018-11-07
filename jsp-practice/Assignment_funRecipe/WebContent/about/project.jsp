<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>The Project</title>
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
		<!-- 헤더가 들어가는 곳 -->
		<jsp:include page="../inc/top.jsp"></jsp:include>
		<!-- 헤더가 들어가는 곳 -->

		<!-- 본문 들어가는 곳 -->
		<!-- 서브페이지 메인이미지 -->
		<div id="sub_img_center">
			<img src="../images/sub_img4.jpg" width="971" height="282">
		</div>
		<!-- 서브페이지 메인이미지 -->
		<!-- 왼쪽메뉴 -->
		<nav id="sub_menu">
			<ul>
				<li><a href="../index.jsp">Home</a></li>
				<li><a href="../about/welcome.jsp">About</a></li>
				<li><a href="../about/project.jsp">Project</a></li>
			</ul>
		</nav>
		<!-- 왼쪽메뉴 -->
		<!-- 내용 -->
		<article>
			<h1>The Project</h1>
			<br />
			<h2>프로젝트 개요</h2>
			<table>
				<tr>
					<td><b>프로젝트명</b></td>
					<td>
						<ul>
							<li>자바(JAVA) 소프트웨어 개발자 과정 애플리케이션 구현</li>
						</ul>
					</td>
				</tr>
				<tr>
					<td><b>내용</b></td>
					<td>
						<ul>
							<li>JSP 기반 서버프로그램 구현</li>
						</ul>
					</td>
				</tr>
				<tr>
					<td><b>수행기간</b></td>
					<td>
						<ul>
							<li>2016.9.13. ~ 2016.10.6.</li>
						</ul>
					</td>
				</tr>
				<tr>
					<td><b>개발환경</b></td>
					<td>
						<ul>
							<li>사용OS : OS X El Capitan</li>
							<li>언어 : HTML/CSS, JAVA. JSP, JavaScript</li>
							<li>개발도구 : Mysql, Apache Tomcat, Eclipse, JDK </li>
						</ul>
					</td>
				</tr>
				<tr>
					<td><b>구현내용</b></td>
					<td>
						<ul>
							<li>필수기술 구현과제 : 회원가입 / 로그인 / 회원정보수정 / 게시판 구현</li>
							<li>추가기술과제 : 자료실 / 댓글달기 / 우편번호 검색</li>
						</ul>
					</td>
				</tr>
			</table>
			<br /><br /><br /><br /><hr />
			<h2>데이터베이스 구조</h2>
			<a href="../images/db_structure.jpg" target="_blank">
				<img src="../images/db_structure.jpg" width="650">
			</a>
			<br /><br /><br /><br /><hr />
			<h2>파일 구조</h2><br />
			<a href="../images/file_tree1.jpg" target="_blank">
				<img src="../images/file_tree1.jpg" width="650">
			</a>
			<a href="../images/file_tree2.jpg" target="_blank">
				<img src="../images/file_tree2.jpg" width="650">
			</a>
		</article>
		<!-- 내용 -->
		<!-- 본문 들어가는 곳 -->
		<div class="clear"></div>
		<!-- 푸터 들어가는 곳 -->
		<jsp:include page="../inc/bottom.jsp"></jsp:include>
		<!-- 푸터 들어가는 곳 -->
	</div>
</body>
</html>



