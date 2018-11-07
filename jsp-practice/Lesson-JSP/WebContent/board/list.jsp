<%@page import="board.BoardBean"%>
<%@page import="java.util.List"%>
<%@page import="board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판 만들기 실습 - 8/22</title>
</head>
<body>
	<%
		int count; // 게시판 전체 글 개수
		// BoardDAO 객체 생성 bdao
		BoardDAO bdao = new BoardDAO();
		// int count = 메소드 호출 getBoardCount()
		count = bdao.getBoardCount();
		// 한 페이지에 보여줄 글 수 설정
		int pageSize = 10; // 한 페이지 10개 글 보여주기 설정		
		// 현 페이지 번호 가져오기 (없으면 1페이지)
		String pageNum = request.getParameter("pageNum");
		if (pageNum == null) {
			pageNum = "1";
		}
		// 페이지 번호를 정수형 변환
		int currentPage = Integer.parseInt(pageNum);
		// 시작할 행 번호 구하기
		int startRow = (currentPage - 1) * pageSize + 1;
		// 끝행 구하기
		int endRow = currentPage * pageSize;

		List<BoardBean> boardList = null;
	%>

	<h1>board/list.jsp</h1>
	<h2>
		글 목록[글 개수 :
		<%=count%>
		]
	</h2>
	<h4>
		<a href="write.jsp">글쓰기</a>
	</h4>
	<table border="1">
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>작성자</td>
			<td>날짜</td>
			<td>조회수</td>
		</tr>
		<%
			// 게시판 글이 있으면 페이지에 해당하는 게시판 글 가져오기
			if (count != 0) {
				boardList = bdao.getBoardList(startRow, pageSize);
				// 게시판 전체 글 가져오기 정렬 첫번째 기준 re_ref 내림차순, re_seq 오름차순
				// limit 첫 행-1, 페이지 사이즈

				for (int i = 0; i < boardList.size(); i++) {
					BoardBean bb = (BoardBean) boardList.get(i);
		%><tr>
			<td><%=bb.getNum()%></td>
			<td>
				<%
					if (bb.getRe_lev() > 0) {
								int wid = 10 * bb.getRe_lev();

				%><img src="level.gif" width="<%=wid%>"/><img src="re.gif"/>
				<%
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
	<hr />
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
	<a href="list.jsp?pageNum=<%=prevPage%>">[이전]</a>
	<%
		}
			// [1]~[10]
			for (int pageIdx = startPage; pageIdx <= endPage; pageIdx++) {
	%><a href="list.jsp?pageNum=<%=pageIdx%>">[<%=pageIdx%>]
	</a>
	<%
		}
			// [다음]
			if (endPage < pageCount) {
				int nextPage = startPage + pageBlock;
	%><a href="list.jsp?pageNum=<%=nextPage%>">[다음]</a>
	<%
		}
		}
	%>

</body>
</html>