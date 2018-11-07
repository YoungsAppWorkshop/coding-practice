<%@page import="java.util.Date"%>
<%@page import="board.BoardBean"%>
<%@page import="java.util.List"%>
<%@page import="board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Fun Recipe Home</title>
<link href="css/default.css" rel="stylesheet" type="text/css">
<link href="css/front.css" rel="stylesheet" type="text/css">

<!--[if lt IE 9]>
<script src="http://ie7-js.googlecode.com/svn/version/2.1(beta4)/IE9.js" type="text/javascript"></script>
<script src="http://ie7-js.googlecode.com/svn/version/2.1(beta4)/ie7-squish.js" type="text/javascript"></script>
<script src="http://html5shim.googlecode.com/svn/trunk/html5.js" type="text/javascript"></script>
<![endif]-->

<!--[if IE 6]>
 <script src="script/DD_belatedPNG_0.0.8a.js"></script>
 <script>
   /* EXAMPLE */
   DD_belatedPNG.fix('#wrap');
   DD_belatedPNG.fix('#main_img');   

 </script>
 <![endif]-->


</head>
<body>
	<div id="wrap">
		<!-- 헤더파일들어가는 곳 -->
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
				<a href="member/myPage.jsp">마이페이지</a> |
				<a href="member/logOut.jsp">로그아웃</a>
			</div>
			<%
				} else { // 세션값 없으면 "로그인 | 회원 가입" 출력
			%>
			<div id="login">
				<a href="member/login.jsp">로그인</a> | <a href="member/join.jsp">회원 가입</a>
			</div>
			<%
				}
			%>
			<div class="clear"></div>
			<!-- 로고들어가는 곳 -->
			<div id="logo">
				<img src="images/logo.png" width="265" height="62" alt="Fun Web">
			</div>
			<!-- 로고들어가는 곳 -->
			<nav id="top_menu">
				<ul>
					<li><a href="index.jsp">HOME</a></li>
					<li><a href="about/welcome.jsp">ABOUT</a></li>
					<li><a href="board/list.jsp">BOARD</a></li>
					<li><a href="download/fileList.jsp">DOWNLOAD</a></li>
					<li><a href="contact/contact.jsp">CONTACT US</a></li>
				</ul>
			</nav>
		</header>
		<!-- 헤더파일들어가는 곳 -->
		<!-- 메인이미지 들어가는곳 -->
		<div class="clear"></div>
		<div id="main_img">
			<img src="images/main_img.jpg" width="971" height="282">
		</div>
		<!-- 메인이미지 들어가는곳 -->
		<!-- 메인 콘텐츠 들어가는 곳 -->
		<article id="front">
			<div id="solution">
				<div id="hosting">
					<h3>쉽고 친근하게!!</h3>
					<p>어려운 레시피는 가라!! <br />
						마트에서 구할 수 있는 쉬운 재료를 사용하여,
						재료 분량, 손질법부터 불 세기까지... 
						요리 초보도 쉽게 따라할 수 있는 정확한 레시피를 담았습니다.</p>
				</div>
				<div id="security">
					<h3>맛도 영양도 만점!!</h3>
					<p>칼로리는 낮게, 영양은 균형있게...  <br />
				 	   맛도 챙기고, 다이어트도 챙기는... <br />
				 	   남녀노소 누구나 즐기며 맛있게 먹을 수 있는 레시피를 담았습니다</p>
				</div>
				<div id="payment">
					<h3>다양한 보너스 레시피까지!!</h3>
					<p>고혈압, 당뇨, 비만 등 생활습관병 예방과 완화에 도움이 되는 스무디 레시피부터..
					1인 1닭 시대를 사는 당신을 위한 소문난 치킨 맛집 레시피까지.. <br />
					다양한 레시피를 담았습니다.					
					</p>
				</div>
			</div>
			<div class="clear"></div>
			<div id="sec_news">
				<h3>
					<span class="orange">Recipe</span> News
				</h3>
				<dl>
					<dt>밥도둑 간장게장 레시피 업로드 완료</dt>
					<dd>별미 중의 별미, 온 국민의 밥도둑 간장게장을 집에서도 간단하게 요리하세요!! 
					Fun Recipe 대표주방장 '집밖박선생'이 추천합니다.</dd>
				</dl>
				<dl>
					<dt>이번 주말에는 전복죽이 어때요?</dt>
					<dd>진시황의 불로초라는 전복죽을 허세프가 요리합니다. 환절기 몸보양식으로 그만이죠.
					누구나 간단하게 요리할 수 있습니다.</dd>
				</dl>
			</div>
			<div id="news_notice">
				<h3 class="brown">게시판 최신글</h3>
				<table>
			<%
				int pageSize = 5; 	
				int currentPage = 1;						
				int startRow = (currentPage - 1) * pageSize + 1;
				int endRow = currentPage * pageSize;
						
				BoardDAO bdao = new BoardDAO();
				int count = bdao.getBoardCount();
						
				List<BoardBean> boardList = null;

				// 게시판 글이 있으면 페이지에 해당하는 게시판 글 가져오기
				if (count != 0) {
					boardList = bdao.getBoardList(startRow, pageSize);	

					for (int i = 0; i < boardList.size(); i++) {
						BoardBean bb = (BoardBean) boardList.get(i);
						String date = new java.text.SimpleDateFormat("yyyy/MM/dd").format(new Date(bb.getDate().getTime()));
			%>
					<tr onclick="location.href='board/content.jsp?num=<%=bb.getNum()%>&pageNum=1'">
						<td class="contxt">
			<%
						// 답글 이미지(re) 출력 부분
						if (bb.getRe_lev() > 0) {
							int wid = 10 * bb.getRe_lev();
			%>
						<img src="images/level.gif" width="<%=wid%>"/><img src="images/re.gif"/>
			<%
						} // close if
			%>				
							<%=bb.getSubject()%>
						</td>
						<td><%=date%></td>
					</tr>
			<%
					} // close loop

				} else {
			%>
					<tr>
						<td colspan="5">게시판 글 없음</td>
					</tr>
			<%
				} // close if-else
			%>
				</table>
			</div>
		</article>
		<!-- 메인 콘텐츠 들어가는 곳 -->
		<div class="clear"></div>
		<!-- 푸터 들어가는 곳 -->
		<footer>
			<hr>
			<div id="copy">
				All contents Copyright 2016 FunRecipe 2016 FunRecipe Inc. all rights
				reserved<br> Contact mail:funrecipe@funcook.com Tel +82 64 123
				4315 Fax +82 64 123 4321
			</div>
			<div id="social">
				<img src="images/facebook.gif" width="33" height="33" alt="Facebook">
				<img src="images/twitter.gif" width="34" height="34" alt="Twitter">
			</div>
		</footer>
		<!-- 푸터 들어가는 곳 -->
	</div>
</body>
</html>