package net.board.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.board.db.BoardDAO;

public class BoardDeleteAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		System.out.println("BoardDeleteAction execute()");

		// 한글 처리
		request.setCharacterEncoding("utf-8");

		// 파라미터 가져오기
		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");
		String pass = request.getParameter("pass");

		// 글 삭제하기
		BoardDAO bdao = new BoardDAO();
		int check = bdao.deleteBoard(num, pass);

		// 이동
		if (check == 1) { // check == 1 "수정성공" 이동
			// javaScript 출력 부분
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script type='text/javascript'>");
			out.println("alert('삭제 성공');");
			out.println("location.href='./BoardList.bo?pageNum=" + pageNum + "';");
			out.println("</script>");
			out.close();

		} else if (check == 0) { // check == 0 비밀번호 틀림
			// javaScript 출력 부분
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script type='text/javascript'>");
			out.println("alert('비밀번호 틀림');");
			out.println("history.back();");
			out.println("</script>");
			out.close();

		} else { // check == -1 num없음
			// javaScript 출력 부분
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script type='text/javascript'>");
			out.println("alert('번호 없음');");
			out.println("history.back();");
			out.println("</script>");
			out.close();

		}

		return forward;

	}
}
