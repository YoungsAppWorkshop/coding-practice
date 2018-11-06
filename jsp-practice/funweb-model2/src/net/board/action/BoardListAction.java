package net.board.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.board.db.BoardBean;
import net.board.db.BoardDAO;

public class BoardListAction implements Action {

	// 메소드 오버라이딩 alt shift s v
	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		System.out.println("BoardListAction execute()");
		// DB객체 생성 BoardDAO bdao
		BoardDAO bdao = new BoardDAO();
		// 전체 글의 개수 int count = getBoardCount()
		int count = bdao.getBoardCount();
		// pageSize 설정 한페이지에 보여줄 글 수
		int pageSize = 10;
		// pageNum 파라미터 가져오기 pageNum 비어 있으면 "1"
		String pageNum = (request.getParameter("pageNum") == null) ? "1" : request.getParameter("pageNum");

		// currentPage = <= 정수형 pageNum
		int currentPage = Integer.parseInt(pageNum);
		// startRow 구하기
		int startRow = (currentPage - 1) * pageSize + 1;
		// 끝행 구하기
		int endRow = currentPage * pageSize;

		// List boardList = null;
		List<BoardBean> boardList = null;
		// count 0이 아니면 boardList = 메소드 호출 getBoardList(startRow, pageSize)
		if (count != 0) {
			boardList = bdao.getBoardList(startRow, pageSize);
		}

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
		
		// request 정보저장 count	pageNum	boardList	pageCount
		// pageBlock	startPage	endPage
		// 모든 클래스형 저장 가능 => Object형 업캐스팅 형변환 저장
		request.setAttribute("boardList", boardList);
		request.setAttribute("count", count);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("pageBlock", pageBlock);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		
		// 이동 ActionForward		true/false ./board/list.jsp
		ActionForward forward = new ActionForward();
		forward.setRedirect(false); 
		forward.setPath("./board/list.jsp");

		return forward;
	}

}
