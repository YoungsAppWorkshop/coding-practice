<%@page import="net.board.db.BoardBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Model2 Practice</title>
</head>
<body>
	<%
		List<BoardBean> boardList = (List<BoardBean>) request.getAttribute("boardList");
		String pageNum = (String) request.getAttribute("pageNum");
		int count = ((Integer) request.getAttribute("count")).intValue();
		int pageCount = ((Integer) request.getAttribute("pageCount")).intValue();
		int pageBlock = ((Integer) request.getAttribute("pageBlock")).intValue();
		int startPage = ((Integer) request.getAttribute("startPage")).intValue();
		int endPage = ((Integer) request.getAttribute("endPage")).intValue();
	%>

	<h1>board/list.jsp</h1>
	<h2>글 목록[글 개수 :<%=count%>]</h2>
	<h4><a href="./BoardWrite.bo">글쓰기</a></h4>
	<table border="1">
		<tr>
			<td>번호</td>	<td>제목</td>	<td>작성자</td><td>날짜</td><td>조회수</td>
		</tr>
	<%
		// 게시판 글이 있으면 페이지에 해당하는 게시판 글 가져오기
		if (count != 0) {

			for (int i = 0; i < boardList.size(); i++) {
				BoardBean bb = (BoardBean) boardList.get(i);
	%>
		<tr>
			<td><%=bb.getNum()%></td>
			<td>
	<%
				if (bb.getRe_lev() > 0) {
					int wid = 10 * bb.getRe_lev();
	%>
				<img src="./images/level.gif" width="<%=wid%>" /><img src="./images/re.gif" /> 
	<%
 				}
 	%>
 				<a href="./BoardContent.bo?num=<%=bb.getNum()%>&pageNum=<%=pageNum%>"><%=bb.getSubject()%></a>
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
	<hr />
	<%
		if (count > 0) {

			if (endPage > pageCount) {
				endPage = pageCount;
			}
			// [이전]
			if (startPage != 1) {
				int prevPage = startPage - pageBlock;
	%>
		<a href="list.jsp?pageNum=<%=prevPage%>">[이전]</a>
	<%
			}
			// [1]~[10]
			for (int pageIdx = startPage; pageIdx <= endPage; pageIdx++) {
	%>
		<a href="list.jsp?pageNum=<%=pageIdx%>">[<%=pageIdx%>]</a>
	<%
		}
			// [다음]
			if (endPage < pageCount) {
				int nextPage = startPage + pageBlock;
	%>
		<a href="list.jsp?pageNum=<%=nextPage%>">[다음]</a>
	<%
			}
		}
	%>

</body>
</html>