<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>About Fun Recipe</title>
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
			<h1>About Fun Recipe</h1>
			<figure class="ceo">
				<img src="../images/company/CEO.jpg" width="200" height="252"
					alt="CEO">
				<figcaption>Fun Recipe CEO Pikachu</figcaption>
			</figure>
			<br />
			<h2>CEO 인사말</h2>
			<p>
				피카? 피카피카!!피카피카피? 피카츄!!!!!! <br />
				피? 피피? 피카츄! 피카피카 피카츄츄!!!!! 츄츄츄!!!!<br />
				피카피카!! 피카!!!!! 피카츄? 피 피카?? 피카? <br />
				피카피카 피카츄!!!!!!!! 피카 피카피~ 피카츄!!!피카?<br />
				피카피카!!피카피카피? 피카츄!!!!!! 피? 피피? 피카츄! <br />
				피카피카 피카츄츄!!!!! 츄츄츄!!!! 피카피카!!
			</p>
			<p>	
				피카!!!!! 피카츄? 피 피카?? 피카? 피카피카 피카츄!!!!!!!! <br />
				피카 피카피~ 피카츄!!!피카?<br />
				피카피카!!피카피카피? 피카츄!!!!!! 피? 피피? 피카츄! <br />
				피카피카 피카츄츄!!!!! 츄츄츄!!!! 피카피카!!<br />
				피카!!!!! 피카츄? 피 피카?? 피카? 피카피카 피카츄!!!!!!!! <br />
				피카 피카피~ 피카츄!!! 
			</p>
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



