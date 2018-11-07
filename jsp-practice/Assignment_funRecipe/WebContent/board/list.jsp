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
<title>Board</title>
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
		<div id="sub_img_center">
			<img src="../images/sub_img1.jpg" width="971" height="282">
		</div>
		<!-- 메인이미지 -->

		<!-- 왼쪽메뉴 -->
		<jsp:include page="../inc/subMenu.jsp"></jsp:include>
		<!-- 왼쪽메뉴 -->

		<!-- 게시판 -->
		<%
			final int PAGE_SIZE = 5; // 한 페이지에 보여줄 글 수 설정 
			final int PAGE_BLOCK = 5; // 한 화면에 보여줄 페이지 수 설정 
			
			List<BoardBean> boardList = null; // 게시판 글 목록 리스트 객체
			BoardDAO bdao = new BoardDAO(); // 데이터베이스 연결 객체
			
			int boardCount; // 검색된 전체 글의 개수 
			int startRow; // 첫번째 글의 행 번호
			int endRow; // 마지막 글의 행 번호
			int currentPage; // 현재 페이지 번호
			
			int pageCount; // 전체 페이지 수
			int startPage; // 화면에 보여주는 시작페이지 번호
			int endPage; // 화면에 보여주는 끝페이지 번호 
			
			int prevPage; // [Prev] 클릭 시 이동할 페이지 번호  
			int nextPage; // [Next] 클릭 시 이동할 페이지 번호  
			
			// 한글처리
			request.setCharacterEncoding("utf-8");
			
			// 세션값 및 파라미터값 가져오기 : "pageNum" 파라미터값이 null이면 1로 설정
			String sId = (String) session.getAttribute("id");
			String pageNum = (request.getParameter("pageNum") == null) ? "1" : request.getParameter("pageNum");
			String keyword = (request.getParameter("keyword") == null) ? "" : request.getParameter("keyword");
			
			// 글 제목(h1)
			String heading = (keyword.equals("")) ? "Board" : "Search Result";
			
			// 검색된 글의 개수 
			boardCount = bdao.getBoardCount(keyword); 
			
			// 현재 페이지 번호 구하기   
			currentPage = Integer.parseInt(pageNum); 
			
			// 페이지 첫 행번호 및 페이지 끝 행 번호 구하기 
			startRow = (currentPage - 1) * PAGE_SIZE + 1;
			endRow = currentPage * PAGE_SIZE;
			
			// 전체 페이지 수, 시작페이지 번호, 끝페이지 번호 구하기 
			pageCount = boardCount / PAGE_SIZE + (boardCount % PAGE_SIZE == 0 ? 0 : 1);	
			startPage = (currentPage / PAGE_BLOCK - (currentPage % PAGE_BLOCK == 0 ? 1 : 0)) * PAGE_BLOCK + 1;
			endPage = ((startPage + PAGE_BLOCK - 1) > pageCount) ? pageCount : (startPage + PAGE_BLOCK - 1);
			
			prevPage = startPage - PAGE_BLOCK;
			nextPage = startPage + PAGE_BLOCK;
			
		%>
		<article>
			<h1><%=heading %></h1>
			<table id="notice">
				<tr>
					<th class="tno">No.</th>
					<th class="ttitle">Title</th>
					<th class="twrite">Writer</th>
					<th class="tdate">Date</th>
					<th class="tread">Read</th>
				</tr>
		<%
			if (boardCount > 0) { // 검색된 글이 있으면 페이지에 해당하는 게시판 글 가져오기
				boardList = bdao.getBoardList(keyword, startRow, PAGE_SIZE); 
				
				// 게시판 글 출력 부분
				for (int i = 0; i < boardList.size(); i++) {
					BoardBean bb = (BoardBean) boardList.get(i);
					// 날짜 형식 변환 
					String date = new java.text.SimpleDateFormat("yyyy/MM/dd").format(new Date(bb.getDate().getTime()));
		%>
				<tr onclick="location.href='content.jsp?num=<%=bb.getNum()%>&pageNum=<%=pageNum%>&keyword=<%=keyword%>'">
					<td><%=bb.getNum()%></td>
					<td class="left">
		<%
					// 답글 이미지(re) 출력 부분
					if (bb.getRe_lev() > 0) {
						int wid = 10 * bb.getRe_lev();
		%>
						<img src="../images/level.gif" width="<%=wid%>"/><img src="../images/re.gif"/>
		<%
					} // close if
		%>			
						<%=bb.getSubject()%>
					</td>
					<td><%=bb.getName()%></td>
					<td><%=date%></td>
					<td><%=bb.getReadcount()%></td>
				</tr>
		<%
				} // for{} 종료 : 게시판 글 출력 종료

			} else { // 게시판 글이 없으면 글 없음 출력 
		%>
				<tr>
					<td colspan="5">검색된 글 없음</td>
				</tr>
		<%
			} // if-esle 종료 
		%>
			</table>
		<%
			// 세션값이 있으면 글쓰기 버튼 표시		
			if (sId != null) {
		%>
			<div id="table_search">
				<input type="button" value="글쓰기" class="btn" onclick="location.href='write.jsp'">
			</div>
		<%
			} // if{} 종료 : 글쓰기 버튼 출력 종료 
		%>
			<div id="table_search">
				<form action="list.jsp" method="post">
					<input type="text" name="keyword" class="input_box" value="<%=keyword%>"> 
					<input type="submit" value="검색" class="btn">
				</form>
			</div>
			<div class="clear"></div>

			<div id="page_control">
		<%
			if (boardCount > 0) { // 게시판에 글이 있으면 페이지 인덱스 출력 
				if (startPage != 1) { // 첫페이지가 아니면 [Prev] 출력 
					
		%>
			<a href="list.jsp?pageNum=<%=prevPage%>&keyword=<%=keyword%>">[Prev]</a>
		<%
				} // close if
				// 페이지 인덱스 : [1]~[10] 출력 부분 
				for (int pageIdx = startPage; pageIdx <= endPage; pageIdx++) {
					if(pageIdx == currentPage) { // 현재 페이지는 bold처리 
						%><b><%
					} // close if
					
		%>
			<a href="list.jsp?pageNum=<%=pageIdx%>&keyword=<%=keyword%>">[<%=pageIdx%>]</a>
		<%
					if(pageIdx == currentPage) { // 현재 페이지는 bold처리 
						%></b><%
					} // close if
		
				} // for 종료 : 페이지 인덱스 출력 종료 
				if (endPage < pageCount) { // 마지막 페이지가 아니면 [Next] 출력 
		%>
			<a href="list.jsp?pageNum=<%=nextPage%>&keyword=<%=keyword%>">[Next]</a>
		<%
				} // close if
			} // if 종료 : 페이지 인덱스 출력 종료 
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