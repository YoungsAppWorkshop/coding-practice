package net.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.board.db.BoardBean;
import net.board.db.BoardDAO;

public class BoardContentAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		
		System.out.println("BoardContentAction execute()");

		// 파라미터 가져오기
		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");

		// DB에서 데이터 가져오기
		BoardDAO bdao = new BoardDAO();
		bdao.updateReadCount(num); // 조회수 1 증가
		BoardBean boardBean = bdao.getBoard(num);
		
		// request에 데이터 저장
		request.setAttribute("num", num);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("board", boardBean);

		// 이동 ActionForward true/false ./board/content.jsp
		forward.setRedirect(false);
		forward.setPath("./board/content.jsp");

		return forward;
	}

}
