package net.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.board.db.BoardBean;
import net.board.db.BoardDAO;

public class BoardUpdate implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("BoardUpdate execute()");
		
		// 파라미터 가져오기
		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");

		// 데이터 가져오기
		BoardDAO bdao = new BoardDAO();
		BoardBean boardBean = bdao.getBoard(num);

		// request에 데이터 저장
		request.setAttribute("num", num);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("board", boardBean);

		// 이동 
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./board/update.jsp");
		return forward;
	}

}
