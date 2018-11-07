<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Contact Us</title>
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
			<img src="../images/sub_img5.jpg" width="971" height="282">
		</div>
		<!-- 서브페이지 메인이미지 -->
		<!-- 왼쪽메뉴 -->
		<jsp:include page="../inc/subMenu.jsp"></jsp:include>
		<!-- 왼쪽메뉴 -->
		<!-- 내용 -->
		<article>
			<h1>Contact Us</h1>
			<figure class="ceo">
				<img src="../images/contactUs.jpg" width="200" height="200"
					alt="CEO">
			</figure>
			<br />
			<div class="policy">
				<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
					Pellentesque auctor varius massa, quis bibendum tellus dapibus at.
					Aenean efficitur, turpis in ullamcorper egestas, nunc ex ullamcorper
					nisi, a fermentum orci est sit amet ex. Class aptent taciti sociosqu
					ad litora torquent per conubia nostra, per inceptos himenaeos. Nam
					tincidunt faucibus ullamcorper. Quisque cursus risus a turpis
					porttitor semper. In tempor eget mauris posuere suscipit. Mauris
					ornare ultrices lectus sed varius. Praesent fringilla, dolor at
					pharetra pellentesque, ex nisl consequat nibh, facilisis auctor diam
					elit ac orci. Suspendisse eget consequat tellus, luctus consequat
					velit. Sed fermentum vitae ante eget tempor. Morbi vel molestie
					lacus, at suscipit justo.</p>
				<p>Morbi commodo, eros vitae finibus molestie, nunc eros interdum
					justo, vel condimentum nunc dui vel felis. Pellentesque dolor eros,
					commodo nec auctor nec, consectetur at elit. Etiam vestibulum
					vulputate tellus, interdum viverra nibh. Curabitur quam felis,
					tristique id suscipit ac, posuere in nisi. Nulla sit amet orci ante.
					Maecenas sollicitudin lectus ac eros congue elementum. Sed elementum
					enim et tortor condimentum, sodales porttitor lorem vulputate. Cras
					posuere faucibus mauris, non laoreet sapien volutpat nec. Lorem
					ipsum dolor sit amet, consectetur adipiscing elit. Nulla vestibulum
					neque eget purus pharetra, non interdum sem dapibus. Phasellus non
					ligula ac nisl sagittis consequat sit amet non lorem. Duis faucibus
					ipsum ut erat dictum feugiat. Nullam quis purus porta, congue lacus
					in, dapibus diam. Nullam posuere tempus sem, vel efficitur nulla
					volutpat sit amet.</p>
			</div>
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



