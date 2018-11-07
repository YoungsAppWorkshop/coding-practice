<%@page import="java.util.Date"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="board.BoardBean"%>
<%@page import="java.util.List"%>
<%@page import="board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head> 
<meta charset="UTF-8">
<title>Content</title>
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
			// 세션값 가져오기
			String sId = (String) session.getAttribute("id");
			String sName = (String) session.getAttribute("name");
			
			// 파라미터 가져오기 : 글번호(num), 페이지번호(pageNum), 검색키워드(keyword)
			int num = Integer.parseInt(request.getParameter("num"));
			int pageNum = Integer.parseInt(request.getParameter("pageNum"));
			String keyword = (request.getParameter("keyword") == null) ? "" : request.getParameter("keyword");

			// BoardDAO 객체 생성 및 조회 수 1 증가 
			BoardDAO bdao = new BoardDAO();
			bdao.updateReadCount(num);
			
			// 게시판 번호에 해당하는 글 가져오기
			BoardBean bb = bdao.getBoard(num);
			
			// 날짜 형식 변환 
			String date = new java.text.SimpleDateFormat("yyyy/MM/dd").format(new Date(bb.getDate().getTime()));
			
			// 글 내용 엔터키 입력 처리 : \r\n => "<br>"
			String content = bb.getContent();
			if (content == null) {
				content = "";
			} else {
				content = content.replace("\r\n", "<br>");
			}
		%>
		<article>
			<h1>Content</h1>
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
					<td><%=date%></td>
				</tr>
				<tr>
					<td>글제목</td>
					<td colspan="3"><%=bb.getSubject()%></td>
				</tr>
				<tr>					
					<td colspan="4" class="content"><%=content%></td>
				</tr>
			</table>
			<div id="table_search">
		<%
			
			// 세션값 있으면 답글쓰기 버튼 표시 
			if (sId != null) {
				// 세션 id와 글쓴이가 같으면 글수정/글삭제 가능
				if(sId.equals(bb.getId())) {
		%>
				<input type="button" value="글수정" class="btn" onclick="location.href='update.jsp?num=<%=num%>&pageNum=<%=pageNum%>'"> 
				<input type="button" value="글삭제" class="btn" onclick="deleteConfirm('<%=num%>', '<%=pageNum%>')"> 
		<%		
				} // close inner if	
		%>
		<!-- 답글버튼 삽입 부분  -->
				<input type="button" value="답글쓰기" class="btn" onclick="location.href='reWrite.jsp?num=<%=num%>&pageNum=<%=pageNum%>&re_ref=<%=bb.getRe_ref()%>&re_lev=<%=bb.getRe_lev()%>&re_seq=<%=bb.getRe_seq()%>'"> 
		<!-- 답글버튼 삽입 부분  -->
		<%
			} // close outer if
		%>
				<input type="button" value="글 목록" class="btn" onclick="location.href='list.jsp?num=<%=num%>&pageNum=<%=pageNum%>&keyword=<%=keyword%>'">
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
<script type="text/javascript">
	function deleteConfirm(num, pageNum) { // 글 삭제 재확인 함수
		var destination = "deletePro.jsp?num=" + num + "&pageNum=" + pageNum;
		var isConfirmed = confirm("글을 삭제하시겠습니까?\n삭제 후에는 되돌릴 수 없습니다.");
		if(isConfirmed) {
			location.href = destination;
		}
	}

</script>
</html>