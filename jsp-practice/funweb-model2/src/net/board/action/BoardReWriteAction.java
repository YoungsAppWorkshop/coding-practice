package net.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.board.db.BoardBean;
import net.board.db.BoardDAO;

public class BoardReWriteAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		
		System.out.println("BoardReWriteAction execute()");
		
		// 한글 처리
		request.setCharacterEncoding("utf-8");
		
		// 자바빈 객체 생성 및 정보 저장
		BoardBean bb = new BoardBean();

		bb.setNum(Integer.parseInt(request.getParameter("num")));
		bb.setName(request.getParameter("name"));
		bb.setPass(request.getParameter("pass"));
		bb.setSubject(request.getParameter("subject"));
		bb.setContent(request.getParameter("content"));
		bb.setIp(request.getRemoteAddr());
		bb.setRe_ref(Integer.parseInt(request.getParameter("re_ref")));
		bb.setRe_lev(Integer.parseInt(request.getParameter("re_lev")));
		bb.setRe_seq(Integer.parseInt(request.getParameter("re_seq")));
		
		// DB작업 객체 생성 및 정보 DB에 저장
		BoardDAO bdao = new BoardDAO();
		bdao.reInsertBoard(bb);

		// 이동 ./BoardList.bo
		forward.setRedirect(true); // data를 forward할 필요 없음(이미 DB작업 완료) > sendRedirect로 이동
		forward.setPath("./BoardList.bo");
		
		return forward;
	}

}
