<%@page import="board.BoardBean"%>
<%@page import="java.util.List"%>
<%@page import="board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Notice</title>
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
		<!-- 상대경로 (현재폴더 : . 상위 폴더 : ..) -->
		<jsp:include page="../inc/top.jsp"></jsp:include>
		<!-- 헤더들어가는 곳 -->

		<!-- 본문들어가는 곳 -->
		<!-- 메인이미지 -->
		<div id="sub_img_center"></div>
		<!-- 메인이미지 -->

		<!-- 왼쪽메뉴 -->
		<nav id="sub_menu">
			<ul>
				<li><a href="#">Notice</a></li>
				<li><a href="#">Public News</a></li>
				<li><a href="fnotice.jsp">Driver Download</a></li>
				<li><a href="#">Service Policy</a></li>
			</ul>
		</nav>
		<!-- 왼쪽메뉴 -->

		<!-- 게시판 -->
		<%
			// 패키지 board 파일이름 BoardDAO
			BoardDAO bdao = new BoardDAO();
			// 게시판 전체 글의 개수 int count = getBoardCount()
			int count = bdao.getBoardCount();
			// 한 페이지에 보여줄 글 수 15개	int pageSize
			int pageSize = 5; // 한 페이지 15개 글 보여주기 설정		
			// 현 페이지 번호 가져오기 "pageNum" 파라미터 가져오기
			String pageNum = request.getParameter("pageNum");
			if (pageNum == null) {
				pageNum = "1"; // 파라미터 없을 경우 "1"페이지 설정
			}
			int currentPage = Integer.parseInt(pageNum);
			// 페이지 첫 행을 구하기 int startRow
			int startRow = (currentPage - 1) * pageSize + 1;
			int endRow = currentPage * pageSize;
			// 게시판 글이 있으면 메서드 호출 getBoardList(int startRow, int pageSize)
			List<BoardBean> boardList = null;
		%>
		<article>
			<h1>Notice</h1>
			<table id="notice">
				<tr>
					<th class="tno">No.</th>
					<th class="ttitle">Title</th>
					<th class="twrite">Writer</th>
					<th class="tdate">Date</th>
					<th class="tread">Read</th>
				</tr>
				<%
					// 게시판 글이 있으면 페이지에 해당하는 게시판 글 가져오기
					if (count != 0) {
						boardList = bdao.getBoardList(startRow, pageSize);
						// 게시판 전체 글 가져오기 정렬 첫번째 기준 re_ref 내림차순, re_seq 오름차순
						// limit 첫 행-1, 페이지 사이즈

						for (int i = 0; i < boardList.size(); i++) {
							BoardBean bb = (BoardBean) boardList.get(i);
				%>
				<tr onclick="location.href='content.jsp?num=<%=bb.getNum()%>&pageNum=<%=pageNum%>'">
					<td><%=bb.getNum()%></td>
					<td class="left">
						<%
							if (bb.getRe_lev() > 0) {
										int wid = 10 * bb.getRe_lev();
						%><img src="../images/center/level.gif" width="<%=wid%>"/><img
						src="../images/center/re.gif" /> <%
 	}
 %><a href="content.jsp?num=<%=bb.getNum()%>&pageNum=<%=pageNum%>"><%=bb.getSubject()%></a>
					</td>
					<td><%=bb.getName()%></td>
					<td><%=bb.getDate()%></td>
					<td><%=bb.getReadcount()%></td>
				</tr>
				<%
					}

					} else {
				%>
				<tr>
					<td colspan="5">게시판 글 없음</td>
				</tr>
				<%
					}
				%>
			</table>
			<%
				// 세션값 가져오기
				String id = (String) session.getAttribute("id");
				// 세션값 있으면 글쓰기 버튼
				if (id != null) {
			%>
			<div id="table_search">
				<input type="button" value="글쓰기" class="btn" onclick="location.href='write.jsp'">
			</div>
			<%
				}
			%>
			<div id="table_search">
				<form action="noticeSearch.jsp" method="post">
					<input type="text" name="search" class="input_box"> <input
						type="submit" value="search" class="btn">
				</form>
			</div>
			<div class="clear"></div>

			<div id="page_control">
				<%
					if (count > 0) {
						// 전체 페이지 수 구하기 // 전체 글 개수 50 한 화면에 보여줄 글 개수 10
						int pageCount = count / pageSize + (count % pageSize == 0 ? 0 : 1);
						// 한 화면에 보여줄 페이지 수 설정
						int pageBlock = 5;
						// 화면에 보여주는 시작페이지 번호 구하기
						int startPage = (currentPage / pageBlock - (currentPage % pageBlock == 0 ? 1 : 0)) * pageBlock + 1;
						// 화면에 보여주는 끝페이지 번호 구하기
						int endPage = startPage + pageBlock - 1;
						if (endPage > pageCount) {
							endPage = pageCount;
						}
						// [이전]
						if (startPage != 1) {
							int prevPage = startPage - pageBlock;
				%>
				<a href="notice.jsp?pageNum=<%=prevPage%>">Prev</a>
				<%
						}
						// [1]~[10]
						for (int pageIdx = startPage; pageIdx <= endPage; pageIdx++) {
							if(pageIdx == currentPage) {
								%><b><%
							}
							
				%>
				<a href="notice.jsp?pageNum=<%=pageIdx%>">[<%=pageIdx%>]</a>
				<%
							if(pageIdx == currentPage) {
								%></b><%
							}
				
						}
						// [다음]
						if (endPage < pageCount) {
							int nextPage = startPage + pageBlock;
				%>
				<a href="notice.jsp?pageNum=<%=nextPage%>">Next</a>
				<%
						}
					}
				%>
			</div>
		</article>
		<!-- 게시판 -->
		<!-- 본문들어가는 곳 -->
		<div class="clear"></div>
		<!-- 푸터들어가는 곳 -->
		<jsp:include page="../inc/bottom.jsp"></jsp:include>
		<!-- 푸터들어가는 곳 -->
	</div>
</body>
</html>