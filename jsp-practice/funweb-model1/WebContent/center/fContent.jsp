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
			// num pageNum 파라미터 가져오기
			int num = Integer.parseInt(request.getParameter("num"));
			int pageNum = Integer.parseInt(request.getParameter("pageNum"));
			// 패키지 board 파일이름 BoardDAO
			BoardDAO bdao = new BoardDAO();
			// 조회수 1증가 메소드 호출 updateReadCount(num)
			bdao.updateReadCount(num);
			// 게시판 번호에 해당하는 글 가져오기
			BoardBean bb = bdao.getBoard(num);
			// String API 메서드 .replace(찾는 값, 바꿀 값) \r\n => "<br>"
			String content = bb.getContent();
			if (content == null) {
				content = "";
			} else {
				content = content.replace("\r\n", "<br>");
			}
		%>
		<article>
			<h1>Notice Content</h1>
			<table id="notice">
				<tr>
					<td>글번호</td>
					<td><%=bb.getNum()%></td>
					<td>조회수</td>
					<td><%=bb.getReadcount()%></td>
				</tr>
				<tr>
					<td>작성자</td>
					<td><%=bb.getName()%></td>
					<td>작성일</td>
					<td><%=bb.getDate()%></td>
				</tr>
				<tr>
					<td>글제목</td>
					<td colspan="3"><%=bb.getSubject()%></td>
				</tr>
				<tr>
					<td>첨부파일</td>
					<td colspan="3">
						<a href="../upload/<%=bb.getFile()%>"><%=bb.getFile()%></a>
						<a href="file_down.jsp?file_name=<%=bb.getFile()%>">다운로드</a>
						<img src="../upload/<%=bb.getFile()%>" alt="업로드된 파일" width="50" height="30"/>
					</td>
				</tr>
				<tr>
					<td>글내용</td>
					<td colspan="3"><%=content%></td>
				</tr>
			</table>
			<div id="table_search">
				<%
					// 세션값 가져오기
					String id = (String) session.getAttribute("id");
					// 세션값 있으면 글쓰기 버튼
					if (id != null) {
						// 세션 id와 글쓴이가 같으면 글수정/글삭제 가능
						if(id.equals(bb.getName())) {
				%>
				<input type="button" value="글수정" class="btn" onclick="location.href='fUpdate.jsp?num=<%=num%>&pageNum=<%=pageNum%>'"> 
				<input type="button" value="글삭제" class="btn" onclick="location.href='fDelete.jsp?num=<%=num%>&pageNum=<%=pageNum%>'"> 
				<%		
						} 				
				%>
				<input type="button" value="답글쓰기" class="btn" onclick="location.href='reWrite.jsp?num=<%=num%>&re_ref=<%=bb.getRe_ref()%>&re_lev=<%=bb.getRe_lev()%>&re_seq=<%=bb.getRe_seq()%>&pageNum=<%=pageNum%>'">
				<%
					}
				%>
				<input type="button" value="글목록" class="btn"
					onclick="location.href='fnotice.jsp?pageNum=<%=pageNum%>'">
			</div>
			<div class="clear"></div>

			<div id="page_control"></div>
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